package fr.univcotedazur.iut.info.m414.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button lessons;
    Button exercices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lessons = findViewById(R.id.lessons);
        exercices = findViewById(R.id.exercices);
        Intent lessonsActivity = new Intent(MainActivity.this, LessonsActivity.class);
        //Intent exercicesActivity = new Intent(MainActivity.this, ExercicesActivity.class);

        lessons.setOnClickListener(v -> startActivity(lessonsActivity));
        //lessons.setOnClickListener(v -> startActivity(LessonsActivity));

    }
}
