package com.tumblr.albandaci.learntoreadthequranpremium.LearnToReadPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Definites_Plural_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

public class Definites_Plural extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] arabic_letter = {"اَلْكُتُب", "اَلدُّرُوس", "اَلْأَقْلَام", "اَلْقَائِلُون", "اَلْقَائِمُون", "اَلْجَالِسُون", "اَلْأَوْرَاق", "اَلْعُلُوم", "اَلْأَخْبَاز", "اَلْمُجْتَهِدُون"};

    String [] transliteration = {"Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:"};

    String [] english_letter = {"Al-kutub", "Ad-du-ruus", "Al-aq-laam", "Al-qaa-i-luun", "Al-qaa-i-muun", "Al-jaa-li-suun", "Al-aw-raaq", "Al-'u-luum", "Al-akh-baaz", "Al-muj-ta-hi-duun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definites__plural);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_definites_plural);
        adapter = new Definites_Plural_Adapter(arabic_letter, transliteration, english_letter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
    }
}
