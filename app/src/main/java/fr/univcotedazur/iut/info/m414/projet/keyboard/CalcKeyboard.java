package fr.univcotedazur.iut.info.m414.projet.keyboard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;

public class CalcKeyboard {
    private final KeyboardView mKeyboardView;
    private final Activity mHostActivity;
    private ViewGroup viewGroup;

    public CalcKeyboard(Activity host, ViewGroup vg, int view_id, int layout_id) {
        mHostActivity = host;
        viewGroup = vg;
        mKeyboardView = mHostActivity.findViewById(view_id);
        mKeyboardView.setKeyboard(new Keyboard(mHostActivity, layout_id));
        mKeyboardView.setPreviewEnabled(false);

        OnKeyboardActionListener mOnKeyboardActionListener = new OnKeyboardActionListener() {

            @Override
            public void onKey(int primaryCode, int[] keyCodes) {
                View focusCurrent = mHostActivity.getWindow().getCurrentFocus();
                if (focusCurrent == null || focusCurrent.getClass() != AppCompatEditText.class) {
                    Log.d("!", focusCurrent.getClass().toString());
                    Log.d("!", Boolean.toString(focusCurrent == null));
                    return;
                }
                EditText edittext = (EditText) focusCurrent;
                Editable editable = edittext.getText();
                int start = edittext.getSelectionStart();
                if (primaryCode == Keyboard.KEYCODE_DELETE) {
                    if (editable != null && start > 0) editable.delete(start - 1, start);
                } else {
                    editable.insert(start, Character.toString((char) primaryCode));
                }
            }

            @Override
            public void onPress(int arg0) {
            }

            @Override
            public void onRelease(int primaryCode) {
            }

            @Override
            public void onText(CharSequence text) {
            }

            @Override
            public void swipeDown() {
            }

            @Override
            public void swipeLeft() {
            }

            @Override
            public void swipeRight() {
            }

            @Override
            public void swipeUp() {
            }
        };
        mKeyboardView.setOnKeyboardActionListener(mOnKeyboardActionListener);
        mHostActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void setViewGroup(ViewGroup v){
        viewGroup = v;
    }

    public boolean isCustomKeyboardVisible() {
        return mKeyboardView.getVisibility() == View.VISIBLE;
    }

    public void showCustomKeyboard(View v) {
        mKeyboardView.setVisibility(View.VISIBLE);
        mKeyboardView.setEnabled(true);
        if (v != null)
            ((InputMethodManager) mHostActivity.getSystemService(Activity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public void hideCustomKeyboard() {
        mKeyboardView.setVisibility(View.GONE);
        mKeyboardView.setEnabled(false);
    }

    @SuppressLint("ClickableViewAccessibility")
    public void registerEditText(int res_id) {
        EditText edittext = viewGroup.findViewById(res_id);
        edittext.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) showCustomKeyboard(v);
            else hideCustomKeyboard();
        });
        edittext.setOnClickListener(this::showCustomKeyboard);
        edittext.setOnTouchListener((v, event) -> {
            EditText EditText1 = (EditText) v;
            int inType = EditText1.getInputType();
            EditText1.setInputType(InputType.TYPE_NULL);
            EditText1.onTouchEvent(event);
            EditText1.setInputType(inType);
            return true;
        });
        edittext.setInputType(edittext.getInputType() | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
    }

}