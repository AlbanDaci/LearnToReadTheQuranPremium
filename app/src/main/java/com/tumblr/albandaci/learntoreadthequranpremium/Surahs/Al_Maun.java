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

public class Al_Maun extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/107.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"107:1", "107:2", "107:3", "107:4", "107:5", "107:6", "107:7"};

    String [] arabic_verses = {"أَرَأَيْتَ الَّذِي يُكَذِّبُ بِالدِّينِ",
    "فَذَٰلِكَ الَّذِي يَدُعُّ الْيَتِيمَ",
    "وَلَا يَحُضُّ عَلَىٰ طَعَامِ الْمِسْكِينِ",
    "فَوَيْلٌ لِّلْمُصَلِّينَ",
    "الَّذِينَ هُمْ عَن صَلَاتِهِمْ سَاهُونَ",
    "الَّذِينَ هُمْ يُرَاءُونَ",
    "وَيَمْنَعُونَ الْمَاعُونَ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Have you seen the one who denies the Recompense?",
    "For that is the one who drives away the orphan",
    "And does not encourage the feeding of the poor.",
    "So woe to those who pray",
    "[But] who are heedless of their prayer -",
    "Those who make show [of their deeds]",
    "And withhold [simple] assistance."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__maun);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_maun);
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
