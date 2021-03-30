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
