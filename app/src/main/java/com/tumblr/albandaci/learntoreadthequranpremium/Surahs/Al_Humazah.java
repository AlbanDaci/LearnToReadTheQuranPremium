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

public class Al_Humazah extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/104.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses  = {"104:1", "104:2", "104:3", "104:4", "104:5", "104:6", "104:7", "104:8", "104:9"};

    String [] arabic_verses = {"وَيْلٌ لِّكُلِّ هُمَزَةٍ لُّمَزَةٍ",
    "الَّذِي جَمَعَ مَالًا وَعَدَّدَهُ",
    "يَحْسَبُ أَنَّ مَالَهُ أَخْلَدَهُ",
    "كَلَّا ۖ لَيُنبَذَنَّ فِي الْحُطَمَةِ",
    "وَمَا أَدْرَاكَ مَا الْحُطَمَةُ",
    "نَارُ اللَّهِ الْمُوقَدَةُ",
    "الَّتِي تَطَّلِعُ عَلَى الْأَفْئِدَةِ",
    "إِنَّهَا عَلَيْهِم مُّؤْصَدَةٌ",
    "فِي عَمَدٍ مُّمَدَّدَةٍ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Woe to every scorner and mocker",
    "Who collects wealth and [continuously] counts it.",
    "He thinks that his wealth will make him immortal.",
    "No! He will surely be thrown into the Crusher.",
    "And what can make you know what is the Crusher?",
    "It is the fire of Allah, [eternally] fueled,",
    "Which mounts directed at the hearts.",
    "Indeed, Hellfire will be closed down upon them",
    "In extended columns."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__humazah);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_humazah);
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
