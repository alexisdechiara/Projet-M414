package fr.univcotedazur.iut.info.m414.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LessonsActivity extends AppCompatActivity {

    Button multiplicationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        multiplicationButton = findViewById(R.id.buttonMultiplication);

        Intent multiplicationActivity = new Intent(getApplicationContext(), MultiplicationActivity.class);

        multiplicationButton.setOnClickListener(v -> startActivity(multiplicationActivity));

    }
}
