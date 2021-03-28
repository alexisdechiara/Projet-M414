package fr.univcotedazur.iut.info.m414.projet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateSpecificExerciceActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_specific_exercice);
        String type = getIntent().getStringExtra("type");
        ListView listExos = (ListView) findViewById(R.id.listeExercices);
        ExerciceAdapter adapter = new ExerciceAdapter(this, type);
        listExos.setAdapter(adapter);
        listExos.setItemsCanFocus(true);

        Button confirmer = (Button) findViewById(R.id.button_confirm_exercice);
        confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LinearLayout test = (LinearLayout) listExos.getItemAtPosition(0);
                //String ontest = ((EditText) findViewById(R.id.valeur1)).getText().toString();
                Log.d("test ouais", listExos.getItemAtPosition(0).toString());
                //Toast toast = Toast.makeText(getApplicationContext(), listExos.getItemAtPosition(0).toString(), Toast.LENGTH_SHORT);
                //toast.show();
            }
        });
    }

}
