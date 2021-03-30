package fr.univcotedazur.iut.info.m414.projet.exercices;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import fr.univcotedazur.iut.info.m414.projet.MainActivity;
import fr.univcotedazur.iut.info.m414.projet.R;

public class Dialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_dialog,null);

        ImageView icon = v.findViewById(R.id.imageReward);
        TextView textScore = v.findViewById(R.id.TextScore);

        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animation);
        icon.startAnimation(animation);
        textScore.setText( getArguments().getString("msg") + " / 10");

        builder.setView(v);
        builder.setTitle("Score");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getActivity(),ExercicesActivity.class);
                startActivity(intent);
            }
        });
        return  builder.create();
    }

    public Dialog newInstance(String msg) {
        Dialog fragment = new Dialog();

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        fragment.setArguments(bundle);

        return fragment;
    }
}
