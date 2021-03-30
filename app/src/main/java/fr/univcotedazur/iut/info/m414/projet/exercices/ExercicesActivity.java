package fr.univcotedazur.iut.info.m414.projet.exercices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.univcotedazur.iut.info.m414.projet.R;

public class ExercicesActivity extends AppCompatActivity {

    Button addition;
    Button multiplication;
    Button createExercice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        addition = findViewById(R.id.addition_button);
        multiplication = findViewById(R.id.multiplication_button);
        createExercice = findViewById(R.id.create_exercice_button);


        Intent additionActivity = new Intent(getApplicationContext(), AdditionExerciceActivity.class);
        Intent multiplicationActivity = new Intent(getApplicationContext(), MultiplicationExerciceActivity.class);
        Intent createExerciceActivity = new Intent(getApplicationContext(), CreateSpecificExerciceActivity.class);

        addition.setOnClickListener(v -> startActivity(additionActivity));
        multiplication.setOnClickListener(v -> startActivity(multiplicationActivity));
        createExercice.setOnClickListener(v -> startActivity(createExerciceActivity));
    }
}
