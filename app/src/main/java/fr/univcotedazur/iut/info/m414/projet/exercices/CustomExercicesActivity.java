package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import fr.univcotedazur.iut.info.m414.projet.R;

public class CustomExercicesActivity extends AppCompatActivity {

    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_exercices);

        create = findViewById(R.id.create_exercice_button);

        Intent createExercice = new Intent(getApplicationContext(), CreateExerciceActivity.class);

        create.setOnClickListener(v -> startActivity(createExercice));

    }
}
