package fr.univcotedazur.iut.info.m414.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LessonsActivity extends AppCompatActivity {

    Button multiplication;
    Button addition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        multiplication = findViewById(R.id.buttonMultiplication);
        addition = findViewById(R.id.additionButton);

        Intent multiplicationActivity = new Intent(getApplicationContext(), MultiplicationLessonsActivity.class);
        Intent additionActivity = new Intent(getApplicationContext(), AdditionLessonsActivity.class);


        multiplication.setOnClickListener(v -> startActivity(multiplicationActivity));
        addition.setOnClickListener(v -> startActivity(additionActivity));

    }
}
