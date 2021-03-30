package fr.univcotedazur.iut.info.m414.projet.keyboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import fr.univcotedazur.iut.info.m414.projet.R;

public class CalculActivity extends Activity {

    /** OBLIGATOIRE **/
    CalcKeyboard mCalcKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);


        /** OBLIGATOIRE **/
        //mCalcKeyboard = new CalcKeyboard(this, new ViewGroup(), R.id.keyboardview, R.xml.calc);

        //Juste le dernier chacal
        //mCalcKeyboard.registerEditText(R.id.edittext0);
        //mCalcKeyboard.registerEditText(R.id.edittext1);
        /** OBLIGATOIRE (LOGIQUE mdr) **/
        mCalcKeyboard.registerEditText(R.id.edittext2);
    }

    /** OBLIGATOIRE **/
    @Override
    public void onBackPressed() {
        if (mCalcKeyboard.isCustomKeyboardVisible()) mCalcKeyboard.hideCustomKeyboard();
        else this.finish();
    }

}

