package fr.univcotedazur.iut.info.m414.projet.exercices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.univcotedazur.iut.info.m414.projet.R;

public class ExercicesActivity extends AppCompatActivity {

    Button addition;
    Button multiplication;
    Button soustraction;
    Button division;
    Button customExercices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);

        addition = findViewById(R.id.addition_button);
        multiplication = findViewById(R.id.multiplication_button);
        soustraction = findViewById(R.id.subtraction_button);
        division = findViewById(R.id.division_button);
        customExercices = findViewById(R.id.custom_exercices_button);


        Intent additionActivity = new Intent(getApplicationContext(), AdditionExerciceActivity.class);
        Intent multiplicationActivity = new Intent(getApplicationContext(), MultiplicationExerciceActivity.class);
        Intent soustractionActivity = new Intent(getApplicationContext(), SoustractionExerciceActivity.class);
        Intent divisionActivity = new Intent(getApplicationContext(), DivisionExerciceActivity.class);
        Intent cutomExercicesActivity = new Intent(getApplicationContext(), CustomExercicesActivity.class);

        addition.setOnClickListener(v -> startActivity(additionActivity));
        multiplication.setOnClickListener(v -> startActivity(multiplicationActivity));
        soustraction.setOnClickListener(v -> startActivity(soustractionActivity));
        division.setOnClickListener(v -> startActivity(divisionActivity));
        customExercices.setOnClickListener(v -> startActivity(cutomExercicesActivity));
    }
}
