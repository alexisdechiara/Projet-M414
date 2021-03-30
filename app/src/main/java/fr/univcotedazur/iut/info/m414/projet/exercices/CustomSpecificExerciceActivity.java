package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

import fr.univcotedazur.iut.info.m414.projet.R;


public class CustomSpecificExerciceActivity extends AppCompatActivity {

    private final ArrayList<EditText> result = new ArrayList<>();
    private final ArrayList<TextView> answer = new ArrayList<>();
    private Button confirm;
    private ProgressBar progress;
    private FragmentActivity activ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_exercice_layout);
        activ = this;
        int position = getIntent().getExtras().getInt("position");

        result.add(findViewById(R.id.custom_result_1));
        result.add(findViewById(R.id.custom_result_2));
        result.add(findViewById(R.id.custom_result_3));
        result.add(findViewById(R.id.custom_result_4));
        result.add(findViewById(R.id.custom_result_5));
        result.add(findViewById(R.id.custom_result_6));
        result.add(findViewById(R.id.custom_result_7));
        result.add(findViewById(R.id.custom_result_8));
        result.add(findViewById(R.id.custom_result_9));
        result.add(findViewById(R.id.custom_result_10));
        answer.add(findViewById(R.id.custom_1));
        answer.add(findViewById(R.id.custom_2));
        answer.add(findViewById(R.id.custom_3));
        answer.add(findViewById(R.id.custom_4));
        answer.add(findViewById(R.id.custom_5));
        answer.add(findViewById(R.id.custom_6));
        answer.add(findViewById(R.id.custom_7));
        answer.add(findViewById(R.id.custom_8));
        answer.add(findViewById(R.id.custom_9));
        answer.add(findViewById(R.id.custom_10));

        for (int i = 0; i < 10; i++) {
            answer.get(i).setText(ListeExercices.get(position).getQuestion(i));
            answer.get(i).setTextSize(32);
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

    }

    private void checkProgressBar() {
        int value = 0;
        for (EditText e : result) {
            if (!(e.getText().toString().trim().length() == 0) || !e.getText().toString().equals(""))
                value++;
        }
        progress.setProgress(value, true);
    }

}
