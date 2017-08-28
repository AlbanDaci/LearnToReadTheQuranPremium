package com.tumblr.albandaci.learntoreadthequran.Surahs;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.tumblr.albandaci.learntoreadthequran.Adapter.Al_Fatihah_Adapter;
import com.tumblr.albandaci.learntoreadthequran.R;

import java.io.IOException;

public class An_Nas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "http://download.audioislam.com/audio/quran/recitation/al-afaasee/surah_an_nas.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"114:1", "114:2", "114:3", "114:4", "114:5", "114:6"};

    String [] arabic_verses = {"قُلْ أَعُوذُ بِرَبِّ النَّاسِ",
    "مَلِكِ النَّاسِ",
    "إِلَٰهِ النَّاسِ",
    "مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ",
    "الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ",
    "مِنَ الْجِنَّةِ وَالنَّاسِ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Say, \"I seek refuge in the Lord of mankind,",
    "The Sovereign of mankind.",
    "The God of mankind,",
    "From the evil of the retreating whisperer -",
    "Who whispers [evil] into the breasts of mankind -",
    "From among the jinn and mankind.\""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an__nas);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_an_nas);
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
