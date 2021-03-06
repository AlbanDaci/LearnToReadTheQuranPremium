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

public class Al_Kafirun extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/109.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"109:1", "109:2", "109:3", "109:4", "109:5", "109:6"};

    String [] arabic_verses = {"قُلْ يَا أَيُّهَا الْكَافِرُونَ",
    "لَا أَعْبُدُ مَا تَعْبُدُونَ",
    "وَلَا أَنتُمْ عَابِدُونَ مَا أَعْبُدُ",
    "وَلَا أَنَا عَابِدٌ مَّا عَبَدتُّمْ",
    "وَلَا أَنتُمْ عَابِدُونَ مَا أَعْبُدُ",
    "لَكُمْ دِينُكُمْ وَلِيَ دِينِ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Say, \"O disbelievers,",
    "I do not worship what you worship.",
    "Nor are you worshippers of what I worship.",
    "Nor will I be a worshipper of what you worship.",
    "Nor will you be worshippers of what I worship.",
    "For you is your religion, and for me is my religion.\""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__kafirun);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_kafirun);
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
