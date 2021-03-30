package fr.univcotedazur.iut.info.m414.projet.exercices;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import fr.univcotedazur.iut.info.m414.projet.R;
import fr.univcotedazur.iut.info.m414.projet.keyboard.CalcKeyboard;

public class ExercicesCreesAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public ExercicesCreesAdapter(Context c) {
        context = c;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ListeExercices.size();
    }

    @Override
    public Object getItem(int position) {
        return ListeExercices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        layoutItem = (LinearLayout) inflater.inflate(R.layout.exercices_crees_layout, parent, false);
        TextView tv = (TextView) layoutItem.findViewById(R.id.nom_exercice);
        tv.setText(ListeExercices.get(position).getTitre());

        layoutItem.setTag(position);
        layoutItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Integer position = (Integer)v.getTag();
                sendListener(position);
            }

        });

        return layoutItem;
    }

    private ArrayList<ExercicesCreesAdapterListener> mListListener = new ArrayList<>();

    public void addListener(ExercicesCreesAdapterListener aListener) {
        mListListener.add(aListener);
    }

    private void sendListener(int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(position);
        }
    }

    public interface ExercicesCreesAdapterListener {
        public void onClickNom(int position);
    }

}
