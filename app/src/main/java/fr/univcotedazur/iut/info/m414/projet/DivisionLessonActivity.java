package fr.univcotedazur.iut.info.m414.projet;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DivisionLessonActivity extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;
    ToggleButton exempleButton1;
    LinearLayout exempleView1;
    ToggleButton exempleButton2;
    LinearLayout exempleView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_lesson);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        exempleButton1 = findViewById(R.id.example1);
        exempleView1 = findViewById(R.id.exempleView1);
        exempleButton2 = findViewById(R.id.example2);
        exempleView2 = findViewById(R.id.exempleView2);

        exempleButton1.setOnClickListener(v -> {
            if(exempleButton1.isChecked()){
                exempleView1.setVisibility(View.VISIBLE);
            }else{
                exempleView1.setVisibility(View.GONE);
            }
        });

        exempleButton2.setOnClickListener(v -> {
            if(exempleButton2.isChecked()){
                exempleView2.setVisibility(View.VISIBLE);
            }else{
                exempleView2.setVisibility(View.GONE);
            }
        });

    }
}
