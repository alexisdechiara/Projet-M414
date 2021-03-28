package fr.univcotedazur.iut.info.m414.projet.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.univcotedazur.iut.info.m414.projet.R;

public class LessonsActivity extends AppCompatActivity {

    Button addition;
    Button substraction;
    Button multiplication;
    Button division;
    Button multiplicationTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        addition = findViewById(R.id.additionButton);
        substraction = findViewById(R.id.substractionButton);
        multiplication = findViewById(R.id.multiplicationButton);
        division = findViewById(R.id.divisionButton);
        multiplicationTable = findViewById(R.id.multiplicationTableButton);

        Intent multiplicationTableActivity = new Intent(getApplicationContext(), MultiplicationTableLessonActivity.class);
        Intent additionActivity = new Intent(getApplicationContext(), AdditionLessonActivity.class);
        Intent substractionActivity = new Intent(getApplicationContext(), SubstractionLessonActivity.class);
        Intent multiplicationActivity = new Intent(getApplicationContext(), MultiplicationLessonActivity.class);
        Intent divisionActivity = new Intent(getApplicationContext(), DivisionLessonActivity.class);


        addition.setOnClickListener(v -> startActivity(additionActivity));
        substraction.setOnClickListener(v -> startActivity(substractionActivity));
        multiplication.setOnClickListener(v -> startActivity(multiplicationActivity));
        division.setOnClickListener(v -> startActivity(divisionActivity));
        multiplicationTable.setOnClickListener(v -> startActivity(multiplicationTableActivity));

    }
}
