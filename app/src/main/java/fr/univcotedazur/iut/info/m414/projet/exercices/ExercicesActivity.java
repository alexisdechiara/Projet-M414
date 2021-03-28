package fr.univcotedazur.iut.info.m414.projet.exercices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.univcotedazur.iut.info.m414.projet.R;
import fr.univcotedazur.iut.info.m414.projet.lessons.AdditionExerciceActivity;

public class ExercicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        Button addition = findViewById(R.id.addition_button);

        Intent createAdditionActivity = new Intent(getApplicationContext(), AdditionExerciceActivity.class);

        addition.setOnClickListener(v -> startActivity(createAdditionActivity));

        Button createExercice = findViewById(R.id.create_exercice_button);

        Intent createExerciceActivity = new Intent(getApplicationContext(), CreateExerciceActivity.class);

        createExercice.setOnClickListener(v -> startActivity(createExerciceActivity));
    }
}
