package fr.univcotedazur.iut.info.m414.projet;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CreateSpecificExerciceActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_specific_exercice);
        String type = getIntent().getStringExtra("type");
        ListView listExos = (ListView) findViewById(R.id.listeExercices);
        ExerciceAdapter adapter = new ExerciceAdapter(this, type);
        listExos.setAdapter(adapter);
    }

}
