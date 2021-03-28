package fr.univcotedazur.iut.info.m414.projet.lessons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.univcotedazur.iut.info.m414.projet.R;

public class MultiplicationTableLessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_table_lesson);
        getSupportFragmentManager().beginTransaction().replace(R.id.value, new FragmentMultiplicationTableValue()).commit();
    }
}
