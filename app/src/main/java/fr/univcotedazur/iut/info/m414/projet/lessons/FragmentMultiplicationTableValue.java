package fr.univcotedazur.iut.info.m414.projet.lessons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.univcotedazur.iut.info.m414.projet.R;

public class FragmentMultiplicationTableValue extends Fragment implements FragmentValueInterface {

    public FragmentMultiplicationTableValue(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_value, container, false);
        EditText value = rootView.findViewById(R.id.valueInput);
        rootView.findViewById(R.id.valid).setOnClickListener(v -> {
            if(value.getText().length() != 0){
                int table = Integer.parseInt(value.getText().toString());
                Fragment frag = new MultiplicationTableContent();
                Bundle args = new Bundle();
                args.putInt(KEY, table);
                frag.setArguments(args);
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().replace(R.id.content, frag).commit();
            }
        });

        return rootView;
    }
}
