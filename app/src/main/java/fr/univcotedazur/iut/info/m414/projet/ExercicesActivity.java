package fr.univcotedazur.iut.info.m414.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ExercicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        Button createExercice = findViewById(R.id.create_exercice_button);

        Intent createExerciceActivity = new Intent(getApplicationContext(), CreateExerciceActivity.class);

        createExercice.setOnClickListener(v -> startActivity(createExerciceActivity));
    }
}
