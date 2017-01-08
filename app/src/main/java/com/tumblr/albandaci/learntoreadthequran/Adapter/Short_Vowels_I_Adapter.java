package com.tumblr.albandaci.learntoreadthequran.Adapter;


import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tumblr.albandaci.learntoreadthequran.R;

public class Short_Vowels_I_Adapter extends RecyclerView.Adapter<Short_Vowels_I_Adapter.AlphabetViewHolder> {

    String [] arabic_letter, transliteration, english_letter;

    public Short_Vowels_I_Adapter (String [] arabic_letter, String [] transliteration, String [] english_letter) {

        this.arabic_letter = arabic_letter;
        this.transliteration = transliteration;
        this.english_letter = english_letter;

    }

    @Override
    public AlphabetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alphabet_list,parent,false);
        AlphabetViewHolder alphabetViewHolder = new AlphabetViewHolder(view);
        return alphabetViewHolder;
    }

    @Override
    public void onBindViewHolder(AlphabetViewHolder holder, int position) {

        holder.arabic_letter2.setText(arabic_letter [position]);
        holder.transliteration2.setText(transliteration [position]);
        holder.english_letter2.setText(english_letter [position]);

    }

    @Override
    public int getItemCount() { return arabic_letter.length; }

    public static class AlphabetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView arabic_letter2, transliteration2, english_letter2;

        private final Context context;

        public AlphabetViewHolder (View view) {

            super(view);
            view.setOnClickListener((View.OnClickListener) this);
            context = view.getContext();

            arabic_letter2 = (TextView) view.findViewById(R.id.arabic_letter);
            transliteration2 = (TextView) view.findViewById(R.id.transliteration);
            english_letter2 = (TextView) view.findViewById(R.id.english_letter);

        }

        @Override
        public void onClick (View v) {
            if (getLayoutPosition() == 0) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.a);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 1) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.i);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 2) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.u);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 3) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.ba);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 4) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.bi);
                mediaPlayer.start();
            } else if(getLayoutPosition() == 5) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.bu);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 6) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.ta);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 7) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.ti);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 8) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.tu);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 9) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.tha);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 10) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.thi);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 11) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.thu);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 12) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.ja);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 13) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.ji);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 14) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.ju);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 15) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.hha);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 16) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.hhi);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 17) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.hhu);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 18) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.kha);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 19) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.khi);
                mediaPlayer.start();
            } else if (getLayoutPosition() == 20) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.khu);
                mediaPlayer.start();
            } else {
                final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.a);
                mediaPlayer.start();
            }
        }

    }
}
