package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import fr.univcotedazur.iut.info.m414.projet.CheckResults;
import fr.univcotedazur.iut.info.m414.projet.R;

public class MultiplicationExerciceActivity extends AppCompatActivity {

    private Button confirm;
    private ArrayList<EditText> result = new ArrayList<>();
    private ArrayList<TextView> answer = new ArrayList<>();
    private ProgressBar progress;
    private FragmentActivity multipliActiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_exercice);
        Random r = new Random();
        multipliActiv = this;
        result.add(findViewById(R.id.multiplication_result_1));
        result.add(findViewById(R.id.multiplication_result_2));
        result.add(findViewById(R.id.multiplication_result_3));
        result.add(findViewById(R.id.multiplication_result_4));
        result.add(findViewById(R.id.multiplication_result_5));
        result.add(findViewById(R.id.multiplication_result_6));
        result.add(findViewById(R.id.multiplication_result_7));
        result.add(findViewById(R.id.multiplication_result_8));
        result.add(findViewById(R.id.multiplication_result_9));
        result.add(findViewById(R.id.multiplication_result_10));
        answer.add(findViewById(R.id.multiplication_1));
        answer.add(findViewById(R.id.multiplication_2));
        answer.add(findViewById(R.id.multiplication_3));
        answer.add(findViewById(R.id.multiplication_4));
        answer.add(findViewById(R.id.multiplication_5));
        answer.add(findViewById(R.id.multiplication_6));
        answer.add(findViewById(R.id.multiplication_7));
        answer.add(findViewById(R.id.multiplication_8));
        answer.add(findViewById(R.id.multiplication_9));
        answer.add(findViewById(R.id.multiplication_10));

        for (TextView t: answer) {
            t.setText(String.valueOf(r.nextInt(100) + 1) + " × " + String.valueOf(r.nextInt(100) + 1));
            t.setTextSize(32);
        }

        progress = findViewById(R.id.progressBar);

        new MultiTextWatcher()
                .registerEditText(result.get(0))
                .registerEditText(result.get(1))
                .registerEditText(result.get(2))
                .registerEditText(result.get(3))
                .registerEditText(result.get(4))
                .registerEditText(result.get(5))
                .registerEditText(result.get(6))
                .registerEditText(result.get(7))
                .registerEditText(result.get(8))
                .registerEditText(result.get(9))
                .setCallback(new MultiTextWatcher.TextWatcherWithInstance() {
                    @Override
                    public void beforeTextChanged(EditText editText, CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(EditText editText, CharSequence s, int start, int before, int count) {
                        checkProgressBar();

                    }

                    @Override
                    public void afterTextChanged(EditText editText, Editable editable) {
                    }
                });

        confirm = (Button) findViewById(R.id.multiplication_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] tab = new String[10];
                for (int i = 0; i < 10; i++) {
                    Log.d("regarde ici", answer.get(i).getText().toString());
                    tab[i] = answer.get(i).getText().toString().replace("×", "*");
                }
                Log.d("calculs a la base", Arrays.toString(tab));
                CheckResults cr = new CheckResults(tab, result, multipliActiv);
                cr.execute();
            }
        });
    }
    private void checkProgressBar(){
        int value = 0;
        for (EditText e: result) {
            if(! (e.getText().toString().trim().length() == 0) || ! e.getText().toString().equals("")) value ++;
        }
        progress.setProgress(value,true);
    }
    private void openDialog(String score){
        Dialog dialog = new Dialog().newInstance(score);
        dialog.show(getSupportFragmentManager(),null);
    }
}
