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

public class Ash_Shams extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/091.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"91:1", "91:2", "91:3", "91:4", "91:5", "91:6", "91:7", "91:8", "91:9", "91:10", "91:11", "91:12", "91:13", "91:14", "91:15"};

    String [] arabic_verses = {"وَالشَّمْسِ وَضُحَاهَا",
    "وَالْقَمَرِ إِذَا تَلَاهَا",
    "وَالنَّهَارِ إِذَا جَلَّاهَا",
    "وَاللَّيْلِ إِذَا يَغْشَاهَا",
    "وَالسَّمَاءِ وَمَا بَنَاهَا",
    "وَالْأَرْضِ وَمَا طَحَاهَا",
    "وَنَفْسٍ وَمَا سَوَّاهَا",
    "فَأَلْهَمَهَا فُجُورَهَا وَتَقْوَاهَا",
    "قَدْ أَفْلَحَ مَن زَكَّاهَا",
    "وَقَدْ خَابَ مَن دَسَّاهَا",
    "كَذَّبَتْ ثَمُودُ بِطَغْوَاهَا",
    "إِذِ انبَعَثَ أَشْقَاهَا",
    "فَقَالَ لَهُمْ رَسُولُ اللَّهِ نَاقَةَ اللَّهِ وَسُقْيَاهَا",
    "فَكَذَّبُوهُ فَعَقَرُوهَا فَدَمْدَمَ عَلَيْهِمْ رَبُّهُم بِذَنبِهِمْ فَسَوَّاهَا",
    "وَلَا يَخَافُ عُقْبَاهَا"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"By the sun and its brightness",
    "And [by] the moon when it follows it",
    "And [by] the day when it displays it",
    "And [by] the night when it covers it",
    "And [by] the sky and He who constructed it",
    "And [by] the earth and He who spread it",
    "And [by] the soul and He who proportioned it",
    "And inspired it [with discernment of] its wickedness and its righteousness,",
    "He has succeeded who purifies it,",
    "And he has failed who instills it [with corruption].",
    "Thamud denied [their prophet] by reason of their transgression,",
    "When the most wretched of them was sent forth.",
    "And the messenger of Allah [Salih] said to them, \"[Do not harm] the she-camel of Allah or [prevent her from] her drink.\"",
    "But they denied him and hamstrung her. So their Lord brought down upon them destruction for their sin and made it equal [upon all of them].",
    "And He does not fear the consequence thereof."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ash__shams);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_ash_shams);
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
