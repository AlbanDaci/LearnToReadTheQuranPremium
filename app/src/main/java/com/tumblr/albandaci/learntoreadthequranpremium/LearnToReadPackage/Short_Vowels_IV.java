package com.tumblr.albandaci.learntoreadthequranpremium.LearnToReadPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Short_Vowels_IV_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

public class Short_Vowels_IV extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] arabic_letter = {"كَــ", "كِــ", "كُــ", "لـَـ", "لـِـ", "لُــ", "مَــ", "مِــ", "مُــ", "نــَ", "نِــ", "نُــ", "هَــ", "هِــ", "هُــ", "وَ", "وِ", "وُ", "يــَ", "يِــ", "يُــ"};

    String [] transliteration = {"Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:",
            "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:",
            "Transliteration"};

    String [] english_letter = {"Ka", "Ki", "Ku", "La", "Li", "Lu", "Ma", "Mi", "Mu", "Na", "Ni", "Nu", "Ha", "Hi", "Hu", "Wa", "Wi", "Wu", "Ya", "Yi", "Yu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short__vowels__iv);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_short_vowels_iv);
        adapter = new Short_Vowels_IV_Adapter(arabic_letter, transliteration, english_letter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
    }
}
