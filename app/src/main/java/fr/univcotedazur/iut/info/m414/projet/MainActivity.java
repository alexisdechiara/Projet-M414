package fr.univcotedazur.iut.info.m414.projet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.univcotedazur.iut.info.m414.projet.exercices.ExercicesActivity;
import fr.univcotedazur.iut.info.m414.projet.lessons.LessonsActivity;

public class MainActivity extends AppCompatActivity {

    Button lessons;
    Button exercices;
    ImageButton settings;


    public static int[] checkResult(String[] calcul) {
        String query = "http://api.mathjs.org/v4/";

        try {
            URL obj = new URL(query);
            HttpURLConnection postConnection = null;
            postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/json");
            StringBuilder POST_PARAMS = new StringBuilder("{" + "\"expr\": [");
            for (int i = 0; i < calcul.length; i++) {
                calcul[i] = calcul[i].replaceAll("\\s+", "");
                POST_PARAMS.append("\"").append(calcul[i]).append("\"");
                if (i != calcul.length - 1) {
                    POST_PARAMS.append(", ");
                }
            }
            POST_PARAMS.append("]}");

            postConnection.setDoOutput(true);
            OutputStream os = postConnection.getOutputStream();
            os.write(POST_PARAMS.toString().getBytes());
            os.flush();
            os.close();

            int responseCode = postConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String test = response.toString();
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(test);
                JSONArray jsonArray = (JSONArray) jsonObject.get("result");
                int[] finalResult = new int[10];
                for (int i = 0; i < jsonArray.size(); i++) {
                    String number = (String) jsonArray.get(i);
                    if (!number.contains("."))
                        finalResult[i] = Integer.parseInt(number);
                    else {
                        double cast = Double.parseDouble(number);
                        finalResult[i] = (int) cast;
                    }
                }
                return finalResult;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean isValid(String calcul) {
        calcul = calcul.replaceAll("\\s+", "");
        final String regex = "^\\d+([+-\\/%*]\\d+)+$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(calcul);
        while (matcher.find()) if (Objects.equals(matcher.group(0), calcul)) return true;
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lessons = findViewById(R.id.lessons_button);
        exercices = findViewById(R.id.exercices_button);
        settings = findViewById(R.id.settings);

        Intent lessonsActivity = new Intent(MainActivity.this, LessonsActivity.class);
        Intent exercicesActivity = new Intent(MainActivity.this, ExercicesActivity.class);
        Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);

        lessons.setOnClickListener(v -> startActivity(lessonsActivity));
        exercices.setOnClickListener(v -> startActivity(exercicesActivity));
        settings.setOnClickListener(v -> startActivity(settingsActivity));

    }
}
