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

public class Al_Masad extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "http://download.audioislam.com/audio/quran/recitation/al-afaasee/surah_al_masad.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"111:1", "111:2", "111:3", "111:4", "111:5"};

    String [] arabic_verses = {"تَبَّتْ يَدَا أَبِي لَهَبٍ وَتَبَّ",
    "مَا أَغْنَىٰ عَنْهُ مَالُهُ وَمَا كَسَبَ",
    "سَيَصْلَىٰ نَارًا ذَاتَ لَهَبٍ",
    "وَامْرَأَتُهُ حَمَّالَةَ الْحَطَبِ",
    "فِي جِيدِهَا حَبْلٌ مِّن مَّسَدٍ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"May the hands of Abu Lahab be ruined, and ruined is he.",
    "His wealth will not avail him or that which he gained.",
    "He will [enter to] burn in a Fire of [blazing] flame",
    "And his wife [as well] - the carrier of firewood.",
    "Around her neck is a rope of [twisted] fiber."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__masad);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_masad);
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
