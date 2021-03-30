package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.animation.ObjectAnimator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.univcotedazur.iut.info.m414.projet.R;

public class AdditionExerciceActivity extends AppCompatActivity {

    private Button confirm;
    private ArrayList<EditText> result = new ArrayList<>();
    private ArrayList<TextView> a = new ArrayList<>();
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

        a.add((TextView) findViewById(R.id.addition_1));
        a.get(0).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(0).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_2));
        a.get(1).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(1).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_3));
        a.get(2).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(2).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_4));
        a.get(3).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(3).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_5));
        a.get(4).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(4).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_6));
        a.get(5).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(5).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_7));
        a.get(6).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(6).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_8));
        a.get(7).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(7).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_9));
        a.get(8).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(8).setTextSize(32);

        a.add((TextView) findViewById(R.id.addition_10));
        a.get(9).setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));
        a.get(9).setTextSize(32);

        confirm = (Button) findViewById(R.id.addition_confirm);

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
                    String jsonInputString = "{\"expr\": \"" + a.get(0).getText().toString() + "\"}\"";
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
