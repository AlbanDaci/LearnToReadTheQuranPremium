package com.tumblr.albandaci.learntoreadthequranpremium.LearnToReadPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Sukuun_IV_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

public class Sukuun_IV extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] arabic_letter = {"نُصْ", "فِلْمْ", "دَرْسْ", "حِرْسْ", "حِفْظْ", "قُدْسْ", "مُشْطْ", "ثَبْتْ", "بَرْدْ", "قِرْدْ", "شَوْقْ", "فَوْقْ", "خُلْدْ", "زِبْدْ", "كُشْكْ", "نَوْمْ"};

    String [] transliteration = {"Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:",
            "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:", "Transliteration:"};

    String [] english_letter = {"Nuss", "Film", "Dars", "Hhirs", "Hhifzh", "Quds", "Mushtt", "Thabt", "Berd", "Qird", "Shawq", "Fawq", "Khuld", "Zibd", "Kushk", "Nawm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sukuun__iv);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_sukuun_iv);
        adapter = new Sukuun_IV_Adapter(arabic_letter, transliteration, english_letter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
    }
}
