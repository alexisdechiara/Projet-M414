package fr.univcotedazur.iut.info.m414.projet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.univcotedazur.iut.info.m414.projet.exercices.ExercicesActivity;
import fr.univcotedazur.iut.info.m414.projet.lessons.LessonsActivity;

public class MainActivity extends AppCompatActivity {

    Button lessons;
    Button exercices;

//    public static boolean isValid(String format) {
//        String query = "https://api.mathjs.org/v4/?expr=" + format.replaceAll("\\s+", "").replace("+", "%2B");
//        if (format.contains("+") || format.contains("-") || format.contains("/") || format.contains("*") || format.contains("%")) {
//            try {
//                URL urlForGetRequest = new URL(query);
//                String readLine;
//                HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
//                connection.setRequestMethod("GET");
//                int responseCode = connection.getResponseCode();
//                if (responseCode == HttpURLConnection.HTTP_OK) {
//                    BufferedReader in = new BufferedReader(
//                            new InputStreamReader(connection.getInputStream()));
//                    StringBuilder response = new StringBuilder();
//                    while ((readLine = in.readLine()) != null) {
//                        response.append(readLine);
//                    }
//                    in.close();
//                    return true;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }


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
        Intent lessonsActivity = new Intent(MainActivity.this, LessonsActivity.class);
        Intent exercicesActivity = new Intent(MainActivity.this, ExercicesActivity.class);

        lessons.setOnClickListener(v -> startActivity(lessonsActivity));
        exercices.setOnClickListener(v -> startActivity(exercicesActivity));

    }
}
