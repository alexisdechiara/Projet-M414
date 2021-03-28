package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import fr.univcotedazur.iut.info.m414.projet.R;

public class ExerciceAdapter extends BaseAdapter {
    private String type;
    private Context context;
    private ArrayList<String> calculs1;
    private ArrayList<String> calculs2;
    private LayoutInflater inflater;

    public ExerciceAdapter(Context c, String t) {
        context = c;
        switch (t) {
            case "multiplication":
                type = "x";
                break;
            case "addition":
                type = "+";
                break;
            case "subtraction":
                type = "-";
                break;
            case "division":
                type = "/";
                break;
        }
        calculs1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            calculs1.add("test");
        }
        calculs2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            calculs2.add("test");
        }
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return calculs1.get(position) + type + calculs2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        layoutItem = (LinearLayout) inflater.inflate(R.layout.exercice_layout, parent, false);

        TextView tv_type = (TextView) layoutItem.findViewById(R.id.type);
        tv_type.setText(type);

        EditText valeur1 = (EditText) layoutItem.findViewById(R.id.valeur1);

        if (calculs1.get(position) != "test") {
            valeur1.setText(calculs1.get(position));
        }

        valeur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculs1.set(position, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText valeur2 = (EditText) layoutItem.findViewById(R.id.valeur2);

        valeur2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculs2.set(position, s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return layoutItem;
    }
}
