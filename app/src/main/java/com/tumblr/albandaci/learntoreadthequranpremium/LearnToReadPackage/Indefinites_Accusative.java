package com.tumblr.albandaci.learntoreadthequranpremium.LearnToReadPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Indefinites_Accusative_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

public class Indefinites_Accusative extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] arabic_letter = {"كِتَابًا", "دَرْسًا", "قَلَمًا", "قَائِمًا", "قَائِلًا", "جَالِسًا", "وَرَقَةً", "عِلْمًا", "خُبْزًا", "مُجْتَهِدًا"};

    String [] transliteration = {"Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:"};

    String [] english_letter = {"Ki-taa-ban", "Dar-san", "Qa-la-man", "Qaa-i-man", "Qaa-i-lan", "Jaa-li-san", "Wa-ra-qa-tan", "'Il-man", "Khub-zan", "Muj-ta-hi-dan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indefinites__accusative);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_indefinites_accusative);
        adapter = new Indefinites_Accusative_Adapter(arabic_letter, transliteration, english_letter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
    }
}
