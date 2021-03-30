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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import fr.univcotedazur.iut.info.m414.projet.R;

public class DivisionExerciceActivity extends AppCompatActivity {
    private Button confirm;
    private ArrayList<EditText> result = new ArrayList<>();
    private ArrayList<TextView> answer = new ArrayList<>();
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_exercice);
        Random r = new Random();
        result.add(findViewById(R.id.division_result_1));
        result.add(findViewById(R.id.division_result_2));
        result.add(findViewById(R.id.division_result_3));
        result.add(findViewById(R.id.division_result_4));
        result.add(findViewById(R.id.division_result_5));
        result.add(findViewById(R.id.division_result_6));
        result.add(findViewById(R.id.division_result_7));
        result.add(findViewById(R.id.division_result_8));
        result.add(findViewById(R.id.division_result_9));
        result.add(findViewById(R.id.division_result_10));
        answer.add(findViewById(R.id.division_1));
        answer.add(findViewById(R.id.division_2));
        answer.add(findViewById(R.id.division_3));
        answer.add(findViewById(R.id.division_4));
        answer.add(findViewById(R.id.division_5));
        answer.add(findViewById(R.id.division_6));
        answer.add(findViewById(R.id.division_7));
        answer.add(findViewById(R.id.division_8));
        answer.add(findViewById(R.id.division_9));
        answer.add(findViewById(R.id.division_10));

        for (TextView t: answer) {
            String firstValue = String.valueOf(r.nextInt(100) + 1);
            t.setText(firstValue + " ÷ " + String.valueOf(r.nextInt(Integer.parseInt(firstValue)) + 1));
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

        confirm = (Button) findViewById(R.id.division_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalScore = 0;
                Log.d("click", "t'as cliqué");
                try {
                    URL url = new URL("http://api.mathjs.org/v4/");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setRequestProperty("content-type", "application/json");
                    con.setRequestProperty("accept", "application/json");
                    con.setDoOutput(true);
                    String jsonInputString = "{\"expr\": \"" + answer.get(0).getText().toString() + "\"}\"";
                    OutputStream os = con.getOutputStream();
                    byte[] input = jsonInputString.getBytes();
                    os.write(input, 0, input.length);
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    Log.d("je teste", response.toString());
                } catch (Exception e) {
                    Log.d("ui", e.getMessage());
                }
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
}
