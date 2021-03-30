package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.univcotedazur.iut.info.m414.projet.R;
import fr.univcotedazur.iut.info.m414.projet.keyboard.CalcKeyboard;

public class CreateSpecificExerciceActivity extends AppCompatActivity {

    CalcKeyboard mCalcKeyboard;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_specific_exercice);
        ListView listExos = (ListView) findViewById(R.id.listeExercices);
        mCalcKeyboard = new CalcKeyboard(this, null, R.id.keyboardview, R.xml.calc);
        ExerciceAdapter adapter = new ExerciceAdapter(this, mCalcKeyboard);
        Activity active = this;
        listExos.setAdapter(adapter);
        Button confirmer = (Button) findViewById(R.id.button_confirm_exercice);
        confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = true;
                String titre = ((EditText)findViewById(R.id.titre_exercice)).getText().toString();
                if (titre.isEmpty()) {
                    checked = false;
                }
                ArrayList<String> questions = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    if(listExos.getItemAtPosition(i).toString().equals("test"))
                        checked = false;
                    else
                        questions.add(listExos.getItemAtPosition(i).toString());
                }
                if (checked) {
                    ListeExercices.add(new Exercice(titre, true, questions));
                    active.finish();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mCalcKeyboard.isCustomKeyboardVisible()) mCalcKeyboard.hideCustomKeyboard();
        else this.finish();
    }

}
