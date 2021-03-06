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

public class At_Tin extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/095.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"95:1", "95:2", "95:3", "95:4", "95:5", "95:6", "95:7", "95:8"};

    String [] arabic_verses = {"وَالتِّينِ وَالزَّيْتُونِ",
    "وَطُورِ سِينِينَ",
    "وَهَٰذَا الْبَلَدِ الْأَمِينِ",
    "لَقَدْ خَلَقْنَا الْإِنسَانَ فِي أَحْسَنِ تَقْوِيمٍ",
    "ثُمَّ رَدَدْنَاهُ أَسْفَلَ سَافِلِينَ",
    "إِلَّا الَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ فَلَهُمْ أَجْرٌ غَيْرُ مَمْنُونٍ",
    "فَمَا يُكَذِّبُكَ بَعْدُ بِالدِّينِ",
    "أَلَيْسَ اللَّهُ بِأَحْكَمِ الْحَاكِمِينَ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"By the fig and the olive",
    "And [by] Mount Sinai",
    "And [by] this secure city [Makkah],",
    "We have certainly created man in the best of stature;",
    "Then We return him to the lowest of the low,",
    "Except for those who believe and do righteous deeds, for they will have a reward uninterrupted.",
    "So what yet causes you to deny the Recompense?",
    "Is not Allah the most just of judges?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__tin);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_at_tin);
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
