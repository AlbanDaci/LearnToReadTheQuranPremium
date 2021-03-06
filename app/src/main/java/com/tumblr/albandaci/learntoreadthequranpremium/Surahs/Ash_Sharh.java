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

public class Ash_Sharh extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/094.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"94:1", "94:2", "94:3", "94:4", "94:5", "94:6", "94:7", "94:8"};

    String [] arabic_verses = {"أَلَمْ نَشْرَحْ لَكَ صَدْرَكَ",
    "وَوَضَعْنَا عَنكَ وِزْرَكَ",
    "الَّذِي أَنقَضَ ظَهْرَكَ",
    "وَرَفَعْنَا لَكَ ذِكْرَكَ",
    "فَإِنَّ مَعَ الْعُسْرِ يُسْرًا",
    "إِنَّ مَعَ الْعُسْرِ يُسْرًا",
    "فَإِذَا فَرَغْتَ فَانصَبْ",
    "وَإِلَىٰ رَبِّكَ فَارْغَب"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Did We not expand for you, [O Muhammad], your breast?",
    "And We removed from you your burden",
    "Which had weighed upon your back",
    "And raised high for you your repute.",
    "For indeed, with hardship [will be] ease.",
    "Indeed, with hardship [will be] ease.",
    "So when you have finished [your duties], then stand up [for worship].",
    "And to your Lord direct [your] longing."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ash__sharh);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_ash_sharh);
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
