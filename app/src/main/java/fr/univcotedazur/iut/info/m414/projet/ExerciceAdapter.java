package fr.univcotedazur.iut.info.m414.projet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExerciceAdapter extends BaseAdapter {
    private String type;
    private Context context;
    private LayoutInflater inflater;

    public ExerciceAdapter(Context c, String t) {
        context = c;
        type = t;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
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
        switch (type) {
            case "multiplication":
                tv_type.setText("x");
                break;
            case "addition":
                tv_type.setText("+");
                break;
            case "subtraction":
                tv_type.setText("-");
                break;
            case "division":
                tv_type.setText("/");
                break;
        }

        return layoutItem;
    }
}
