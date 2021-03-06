package com.tumblr.albandaci.learntoreadthequranpremium.LearnToReadPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Long_Vowels_III_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

public class Long_Vowels_III extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] arabic_letter = {"ضَا", "ضِي", "ضُو", "طَا", "طِي", "طُو", "ظَا", "ظِي", "ظُو", "عَا", "عِي", "عُو", "غَا", "غِي", "غُو", "فَا", "فِي", "فُو", "قَا", "قِي", "قُو"};

    String [] transliteration = {"Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:",
            "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:",
            "Transliteration"};

    String [] english_letter = {"Ddaa", "Ddii", "Dduu", "Ttaa", "Ttii", "Ttuu", "Zhaa", "Zhii", "Zhuu", "'Aa", "'Ii", "'Uu", "Ghaa", "Ghii", "Ghuu", "Faa", "Fii", "Fuu", "Qaa", "Qii", "Quu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long__vowels__iii);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_long_vowels_iii);
        adapter = new Long_Vowels_III_Adapter(arabic_letter, transliteration, english_letter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
    }
}
