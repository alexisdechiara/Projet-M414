package fr.univcotedazur.iut.info.m414.projet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MultiplicationTableContent extends Fragment implements FragmentValueInterface {

    private int value;

    public MultiplicationTableContent(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) value = getArguments().getInt(KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content,container, false);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0 ; i <= 100 ; i++) list.add(value + " * " + i + " = " + value * i);
        ListView listView = rootView.findViewById(R.id.contentListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
