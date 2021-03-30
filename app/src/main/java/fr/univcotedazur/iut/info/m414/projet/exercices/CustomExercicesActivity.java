package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import fr.univcotedazur.iut.info.m414.projet.R;
import fr.univcotedazur.iut.info.m414.projet.keyboard.CalcKeyboard;

public class CustomExercicesActivity extends AppCompatActivity {

    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_exercices);

        ListView listExos = (ListView) findViewById(R.id.listeExercicesCrees);
        ExercicesCreesAdapter adapter = new ExercicesCreesAdapter(this);
        listExos.setAdapter(adapter);

        create = findViewById(R.id.create_exercice_button);

        Intent createExercice = new Intent(getApplicationContext(), CreateExerciceActivity.class);

        create.setOnClickListener(v -> startActivity(createExercice));

    }
}
