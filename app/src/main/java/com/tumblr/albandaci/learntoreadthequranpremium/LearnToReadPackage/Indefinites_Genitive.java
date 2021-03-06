package com.tumblr.albandaci.learntoreadthequranpremium.LearnToReadPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Indefinites_Genitive_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

public class Indefinites_Genitive extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] arabic_letter = {"كِتَابٍ", "دَرْسٍ", "قَلَمٍ", "قَائِمٍ", "قَائِلٍ", "جَالِسٍ", "وَرَقَةٍ", "عِلْمٍ", "خُبْزٍ", "مُجْتَهِدٍ"};

    String [] transliteration = {"Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:"};

    String [] english_letter = {"Ki-taa-bin", "Dar-sin", "Qa-la-min", "Qaa-i-min", "Qaa-i-lin", "Jaa-li-sin", "Wa-ra-qa-tin", "'Il-min", "Khub-zin", "Muj-ta-hi-din"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indefinites__genitive);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_indefinites_genitive);
        adapter = new Indefinites_Genitive_Adapter(arabic_letter, transliteration, english_letter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
    }
}
