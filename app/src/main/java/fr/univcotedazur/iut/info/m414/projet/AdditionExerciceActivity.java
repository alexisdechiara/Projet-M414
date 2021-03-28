package fr.univcotedazur.iut.info.m414.projet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class AdditionExerciceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_exercice);
        Random r = new Random();

        TextView a1 = (TextView) findViewById(R.id.addition_1);
        a1.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a2 = (TextView) findViewById(R.id.addition_2);
        a2.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a3 = (TextView) findViewById(R.id.addition_3);
        a3.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a4 = (TextView) findViewById(R.id.addition_4);
        a4.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a5 = (TextView) findViewById(R.id.addition_5);
        a5.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a6 = (TextView) findViewById(R.id.addition_6);
        a6.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a7 = (TextView) findViewById(R.id.addition_7);
        a7.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a8 = (TextView) findViewById(R.id.addition_8);
        a8.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a9 = (TextView) findViewById(R.id.addition_9);
        a9.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        TextView a10 = (TextView) findViewById(R.id.addition_10);
        a10.setText(String.valueOf(r.nextInt(100) + 1) + " + " + String.valueOf(r.nextInt(100) + 1));

        Button confirm = (Button) findViewById(R.id.addition_confirm);

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
                    String jsonInputString = "{\"expr\": \"" + a1.getText().toString() + "\"}\"";
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
}