package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import fr.univcotedazur.iut.info.m414.projet.CheckResults;
import fr.univcotedazur.iut.info.m414.projet.R;

public class AdditionExerciceActivity extends AppCompatActivity {

    private final ArrayList<EditText> result = new ArrayList<>();
    private final ArrayList<TextView> answer = new ArrayList<>();
    private Button confirm;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_exercice);
        Random r = new Random();
        result.add(findViewById(R.id.addition_result_1));
        result.add(findViewById(R.id.addition_result_2));
        result.add(findViewById(R.id.addition_result_3));
        result.add(findViewById(R.id.addition_result_4));
        result.add(findViewById(R.id.addition_result_5));
        result.add(findViewById(R.id.addition_result_6));
        result.add(findViewById(R.id.addition_result_7));
        result.add(findViewById(R.id.addition_result_8));
        result.add(findViewById(R.id.addition_result_9));
        result.add(findViewById(R.id.addition_result_10));
        answer.add(findViewById(R.id.addition_1));
        answer.add(findViewById(R.id.addition_2));
        answer.add(findViewById(R.id.addition_3));
        answer.add(findViewById(R.id.addition_4));
        answer.add(findViewById(R.id.addition_5));
        answer.add(findViewById(R.id.addition_6));
        answer.add(findViewById(R.id.addition_7));
        answer.add(findViewById(R.id.addition_8));
        answer.add(findViewById(R.id.addition_9));
        answer.add(findViewById(R.id.addition_10));

        for (TextView t : answer) {
            t.setText((r.nextInt(100) + 1) + " + " + (r.nextInt(100) + 1));
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

        confirm = findViewById(R.id.create_exercice_button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] tab = new String[10];
                for (int i = 0; i < 10; i++) {
                    tab[i] = answer.get(i).getText().toString();
                }
                Log.d("calculs a la base", Arrays.toString(tab));
                CheckResults cr = new CheckResults(tab);
                cr.execute();
                try {
                    cr.get(1000, TimeUnit.MILLISECONDS);
                } catch (ExecutionException | InterruptedException | TimeoutException e) {
                    e.printStackTrace();
                }
                int[] results = cr.getResult();
                int finalScore = 0;
                for (int i = 0; i < 10; i++) {
                    if (result.get(i).getText().toString().trim().length() != 0) {
                        Log.d("premier", Integer.parseInt(result.get(i).getText().toString()) + "");
                        Log.d("deuxieme", results[i] + "");
                        if (Integer.parseInt(result.get(i).getText().toString()) == results[i]) {
                            finalScore++;
                        }
                    }
                }
                Log.d("final Score", String.valueOf(finalScore));
                openDialog(String.valueOf(finalScore));
            }
        });
    }

    private void checkProgressBar() {
        int value = 0;
        for (EditText e : result) {
            if (!(e.getText().toString().trim().length() == 0) || !e.getText().toString().equals(""))
                value++;
        }
        progress.setProgress(value, true);
    }

    private void openDialog(String score) {
        Dialog dialog = new Dialog().newInstance(score);
        dialog.show(getSupportFragmentManager(), null);
    }
}
