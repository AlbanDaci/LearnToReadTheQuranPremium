package com.tumblr.albandaci.learntoreadthequranpremium.Surahs;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Al_Fatihah_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

import java.io.IOException;

public class Al_Fil extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/105.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"105:1", "105:2", "105:3", "105:4", "105:5"};

    String [] arabic_verses = {"أَلَمْ تَرَ كَيْفَ فَعَلَ رَبُّكَ بِأَصْحَابِ الْفِيلِ",
    "أَلَمْ يَجْعَلْ كَيْدَهُمْ فِي تَضْلِيلٍ",
    "وَأَرْسَلَ عَلَيْهِمْ طَيْرًا أَبَابِيلَ",
    "تَرْمِيهِم بِحِجَارَةٍ مِّن سِجِّيلٍ",
    "فَجَعَلَهُمْ كَعَصْفٍ مَّأْكُولٍ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Have you not considered, [O Muhammad], how your Lord dealt with the companions of the elephant?",
    "Did He not make their plan into misguidance?",
    "And He sent against them birds in flocks,",
    "Striking them with stones of hard clay,",
    "And He made them like eaten straw."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__fil);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_fil);
        adapter = new Al_Fatihah_Adapter(verses, arabic_verses, sahih_international, english_verses);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.play_arrow_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            mediaPlayer.setDataSource(URL1);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer1) {
                    mediaPlayer1.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onOptionsItemSelected(item);
    }
}
