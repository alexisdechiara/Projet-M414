package fr.univcotedazur.iut.info.m414.projet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateExerciceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercice);

        Button addition = findViewById(R.id.addition_button_exercice);

        Intent createAdditionActivity = new Intent(getApplicationContext(), CreateSpecificExerciceActivity.class);
        createAdditionActivity.putExtra("type", "addition");

        addition.setOnClickListener(v -> startActivity(createAdditionActivity));

        Button soustraction = findViewById(R.id.subtraction_button_exercice);

        Intent createSubtractionActivity = new Intent(getApplicationContext(), CreateSpecificExerciceActivity.class);
        createSubtractionActivity.putExtra("type", "subtraction");

        soustraction.setOnClickListener(v -> startActivity(createSubtractionActivity));

        Button multiplication = findViewById(R.id.multiplication_button_exercice);

        Intent createMultiplicationActivity = new Intent(getApplicationContext(), CreateSpecificExerciceActivity.class);
        createMultiplicationActivity.putExtra("type", "multiplication");

        multiplication.setOnClickListener(v -> startActivity(createMultiplicationActivity));

        Button division = findViewById(R.id.division_button_exercice);

        Intent createDivisionActivity = new Intent(getApplicationContext(), CreateSpecificExerciceActivity.class);
        createDivisionActivity.putExtra("type", "division");

        division.setOnClickListener(v -> startActivity(createDivisionActivity));

    }
}
