package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.app.Activity;
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
import fr.univcotedazur.iut.info.m414.projet.keyboard.CalcKeyboard;

public class ExerciceAdapter extends BaseAdapter {
    private Context context;
    CalcKeyboard mCalcKeyboard;
    private ArrayList<String> calculs;
    private LayoutInflater inflater;

    public ExerciceAdapter(Context c, CalcKeyboard ck) {
        context = c;
        mCalcKeyboard = ck;
        calculs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            calculs.add("test");
        }
        inflater = LayoutInflater.from(context);
    }

    /*@Override
    public void onBackPressed() {
        if (mCalcKeyboard.isCustomKeyboardVisible()) mCalcKeyboard.hideCustomKeyboard();
    }*/

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return calculs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        layoutItem = (LinearLayout) inflater.inflate(R.layout.exercice_layout, parent, false);
        mCalcKeyboard.setViewGroup(layoutItem);
        mCalcKeyboard.registerEditText(R.id.valeur);
        EditText valeur = (EditText) layoutItem.findViewById(R.id.valeur);

        if (calculs.get(position) != "test") {
            valeur.setText(calculs.get(position));
        }

        valeur.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculs.set(position, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return layoutItem;
    }
}
