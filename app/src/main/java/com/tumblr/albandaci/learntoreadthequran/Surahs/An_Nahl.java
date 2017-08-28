package com.tumblr.albandaci.learntoreadthequran.Surahs;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.tumblr.albandaci.learntoreadthequran.Adapter.Al_Fatihah_Adapter;
import com.tumblr.albandaci.learntoreadthequran.R;

import java.io.IOException;

public class An_Nahl extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "http://download.audioislam.com/audio/quran/recitation/al-afaasee/surah_an_nahl.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"16:1", "16:2", "16:3", "16:4", "16:5", "16:6", "16:7", "16:8", "16:9", "16:10", "16:11", "16:12", "16:13", "16:14", "16:15", "16:16",
            "16:17", "16:18", "16:19", "16:20", "16:21", "16:22", "16:23", "16:24", "16:25", "16:26", "16:27", "16:28", "16:29", "16:30", "16:31", "16:32",
            "16:33", "16:34", "16:35", "16:36", "16:37", "16:38", "16:39", "16:40", "16:41", "16:42", "16:43", "16:44", "16:45", "16:46", "16:47", "16:48",
            "16:49", "16:50", "16:51", "16:52", "16:53", "16:54", "16:55", "16:56", "16:57", "16:58", "16:59", "16:60", "16:61", "16:62", "16:63", "16:64",
            "16:65", "16:66", "16:67", "16:68", "16:69", "16:70", "16:71", "16:72", "16:73", "16:74", "16:75", "16:76", "16:77", "16:78", "16:79", "16:80",
            "16:81", "16:82", "16:83", "16:84", "16:85", "16:86", "16:87", "16:88", "16:89", "16:90", "16:91", "16:92", "16:93", "16:94", "16:95", "16:96",
            "16:97", "16:98", "16:99", "16:100", "16:101", "16:102", "16:103", "16:104", "16:105", "16:106", "16:107", "16:108", "16:109", "16:110", "16:111", "16:112",
            "16:113", "16:114", "16:115", "16:116", "16:117", "16:118", "16:119", "16:120", "16:121", "16:122", "16:123", "16:124", "16:125", "16:126", "16:127", "16:128"};

    String [] arabic_verses = {"أَتَىٰ أَمْرُ اللَّهِ فَلَا تَسْتَعْجِلُوهُ ۚ سُبْحَانَهُ وَتَعَالَىٰ عَمَّا يُشْرِكُونَ",
    "يُنَزِّلُ الْمَلَائِكَةَ بِالرُّوحِ مِنْ أَمْرِهِ عَلَىٰ مَن يَشَاءُ مِنْ عِبَادِهِ أَنْ أَنذِرُوا أَنَّهُ لَا إِلَٰهَ إِلَّا أَنَا فَاتَّقُونِ",
    "خَلَقَ السَّمَاوَاتِ وَالْأَرْضَ بِالْحَقِّ ۚ تَعَالَىٰ عَمَّا يُشْرِكُونَ",
    "خَلَقَ الْإِنسَانَ مِن نُّطْفَةٍ فَإِذَا هُوَ خَصِيمٌ مُّبِينٌ",
    "وَالْأَنْعَامَ خَلَقَهَا ۗ لَكُمْ فِيهَا دِفْءٌ وَمَنَافِعُ وَمِنْهَا تَأْكُلُونَ",
    "وَلَكُمْ فِيهَا جَمَالٌ حِينَ تُرِيحُونَ وَحِينَ تَسْرَحُونَ",
    "وَتَحْمِلُ أَثْقَالَكُمْ إِلَىٰ بَلَدٍ لَّمْ تَكُونُوا بَالِغِيهِ إِلَّا بِشِقِّ الْأَنفُسِ ۚ إِنَّ رَبَّكُمْ لَرَءُوفٌ رَّحِيمٌ",
    "وَالْخَيْلَ وَالْبِغَالَ وَالْحَمِيرَ لِتَرْكَبُوهَا وَزِينَةً ۚ وَيَخْلُقُ مَا لَا تَعْلَمُونَ",
    "وَعَلَى اللَّهِ قَصْدُ السَّبِيلِ وَمِنْهَا جَائِرٌ ۚ وَلَوْ شَاءَ لَهَدَاكُمْ أَجْمَعِينَ",
    "هُوَ الَّذِي أَنزَلَ مِنَ السَّمَاءِ مَاءً ۖ لَّكُم مِّنْهُ شَرَابٌ وَمِنْهُ شَجَرٌ فِيهِ تُسِيمُونَ",
    "يُنبِتُ لَكُم بِهِ الزَّرْعَ وَالزَّيْتُونَ وَالنَّخِيلَ وَالْأَعْنَابَ وَمِن كُلِّ الثَّمَرَاتِ ۗ إِنَّ فِي ذَٰلِكَ لَآيَةً لِّقَوْمٍ يَتَفَكَّرُونَ",
    "وَسَخَّرَ لَكُمُ اللَّيْلَ وَالنَّهَارَ وَالشَّمْسَ وَالْقَمَرَ ۖ وَالنُّجُومُ مُسَخَّرَاتٌ بِأَمْرِهِ ۗ إِنَّ فِي ذَٰلِكَ لَآيَاتٍ لِّقَوْمٍ يَعْقِلُونَ",
    "وَمَا ذَرَأَ لَكُمْ فِي الْأَرْضِ مُخْتَلِفًا أَلْوَانُهُ ۗ إِنَّ فِي ذَٰلِكَ لَآيَةً لِّقَوْمٍ يَذَّكَّرُونَ",
    "وَهُوَ الَّذِي سَخَّرَ الْبَحْرَ لِتَأْكُلُوا مِنْهُ لَحْمًا طَرِيًّا وَتَسْتَخْرِجُوا مِنْهُ حِلْيَةً تَلْبَسُونَهَا وَتَرَى الْفُلْكَ مَوَاخِرَ فِيهِ وَلِتَبْتَغُوا مِن فَضْلِهِ وَلَعَلَّكُمْ تَشْكُرُونَ",
    "وَأَلْقَىٰ فِي الْأَرْضِ رَوَاسِيَ أَن تَمِيدَ بِكُمْ وَأَنْهَارًا وَسُبُلًا لَّعَلَّكُمْ تَهْتَدُونَ",
    "وَعَلَامَاتٍ ۚ وَبِالنَّجْمِ هُمْ يَهْتَدُونَ",
    "أَفَمَن يَخْلُقُ كَمَن لَّا يَخْلُقُ ۗ أَفَلَا تَذَكَّرُونَ",
    "وَإِن تَعُدُّوا نِعْمَةَ اللَّهِ لَا تُحْصُوهَا ۗ إِنَّ اللَّهَ لَغَفُورٌ رَّحِيمٌ",
    "وَاللَّهُ يَعْلَمُ مَا تُسِرُّونَ وَمَا تُعْلِنُونَ",
    "وَالَّذِينَ يَدْعُونَ مِن دُونِ اللَّهِ لَا يَخْلُقُونَ شَيْئًا وَهُمْ يُخْلَقُونَ",
    "أَمْوَاتٌ غَيْرُ أَحْيَاءٍ ۖ وَمَا يَشْعُرُونَ أَيَّانَ يُبْعَثُونَ",
    "إِلَٰهُكُمْ إِلَٰهٌ وَاحِدٌ ۚ فَالَّذِينَ لَا يُؤْمِنُونَ بِالْآخِرَةِ قُلُوبُهُم مُّنكِرَةٌ وَهُم مُّسْتَكْبِرُونَ",
    "لَا جَرَمَ أَنَّ اللَّهَ يَعْلَمُ مَا يُسِرُّونَ وَمَا يُعْلِنُونَ ۚ إِنَّهُ لَا يُحِبُّ الْمُسْتَكْبِرِينَ",
    "وَإِذَا قِيلَ لَهُم مَّاذَا أَنزَلَ رَبُّكُمْ ۙ قَالُوا أَسَاطِيرُ الْأَوَّلِينَ",
    "لِيَحْمِلُوا أَوْزَارَهُمْ كَامِلَةً يَوْمَ الْقِيَامَةِ ۙ وَمِنْ أَوْزَارِ الَّذِينَ يُضِلُّونَهُم بِغَيْرِ عِلْمٍ ۗ أَلَا سَاءَ مَا يَزِرُونَ",
    "قَدْ مَكَرَ الَّذِينَ مِن قَبْلِهِمْ فَأَتَى اللَّهُ بُنْيَانَهُم مِّنَ الْقَوَاعِدِ فَخَرَّ عَلَيْهِمُ السَّقْفُ مِن فَوْقِهِمْ وَأَتَاهُمُ الْعَذَابُ مِنْ حَيْثُ لَا يَشْعُرُونَ",
    "ثُمَّ يَوْمَ الْقِيَامَةِ يُخْزِيهِمْ وَيَقُولُ أَيْنَ شُرَكَائِيَ الَّذِينَ كُنتُمْ تُشَاقُّونَ فِيهِمْ ۚ قَالَ الَّذِينَ أُوتُوا الْعِلْمَ إِنَّ الْخِزْيَ الْيَوْمَ وَالسُّوءَ عَلَى الْكَافِرِينَ",
    "الَّذِينَ تَتَوَفَّاهُمُ الْمَلَائِكَةُ ظَالِمِي أَنفُسِهِمْ ۖ فَأَلْقَوُا السَّلَمَ مَا كُنَّا نَعْمَلُ مِن سُوءٍ ۚ بَلَىٰ إِنَّ اللَّهَ عَلِيمٌ بِمَا كُنتُمْ تَعْمَلُونَ",
    "فَادْخُلُوا أَبْوَابَ جَهَنَّمَ خَالِدِينَ فِيهَا ۖ فَلَبِئْسَ مَثْوَى الْمُتَكَبِّرِينَ",
    "وَقِيلَ لِلَّذِينَ اتَّقَوْا مَاذَا أَنزَلَ رَبُّكُمْ ۚ قَالُوا خَيْرًا ۗ لِّلَّذِينَ أَحْسَنُوا فِي هَٰذِهِ الدُّنْيَا حَسَنَةٌ ۚ وَلَدَارُ الْآخِرَةِ خَيْرٌ ۚ وَلَنِعْمَ دَارُ الْمُتَّقِينَ",
    "جَنَّاتُ عَدْنٍ يَدْخُلُونَهَا تَجْرِي مِن تَحْتِهَا الْأَنْهَارُ ۖ لَهُمْ فِيهَا مَا يَشَاءُونَ ۚ كَذَٰلِكَ يَجْزِي اللَّهُ الْمُتَّقِينَ",
    "الَّذِينَ تَتَوَفَّاهُمُ الْمَلَائِكَةُ طَيِّبِينَ ۙ يَقُولُونَ سَلَامٌ عَلَيْكُمُ ادْخُلُوا الْجَنَّةَ بِمَا كُنتُمْ تَعْمَلُونَ",
    "هَلْ يَنظُرُونَ إِلَّا أَن تَأْتِيَهُمُ الْمَلَائِكَةُ أَوْ يَأْتِيَ أَمْرُ رَبِّكَ ۚ كَذَٰلِكَ فَعَلَ الَّذِينَ مِن قَبْلِهِمْ ۚ وَمَا ظَلَمَهُمُ اللَّهُ وَلَٰكِن كَانُوا أَنفُسَهُمْ يَظْلِمُونَ",
    "فَأَصَابَهُمْ سَيِّئَاتُ مَا عَمِلُوا وَحَاقَ بِهِم مَّا كَانُوا بِهِ يَسْتَهْزِئُونَ",
    "وَقَالَ الَّذِينَ أَشْرَكُوا لَوْ شَاءَ اللَّهُ مَا عَبَدْنَا مِن دُونِهِ مِن شَيْءٍ نَّحْنُ وَلَا آبَاؤُنَا وَلَا حَرَّمْنَا مِن دُونِهِ مِن شَيْءٍ ۚ كَذَٰلِكَ فَعَلَ الَّذِينَ مِن قَبْلِهِمْ ۚ فَهَلْ عَلَى الرُّسُلِ إِلَّا الْبَلَاغُ الْمُبِينُ",
    "وَلَقَدْ بَعَثْنَا فِي كُلِّ أُمَّةٍ رَّسُولًا أَنِ اعْبُدُوا اللَّهَ وَاجْتَنِبُوا الطَّاغُوتَ ۖ فَمِنْهُم مَّنْ هَدَى اللَّهُ وَمِنْهُم مَّنْ حَقَّتْ عَلَيْهِ الضَّلَالَةُ ۚ فَسِيرُوا فِي الْأَرْضِ فَانظُرُوا كَيْفَ كَانَ عَاقِبَةُ الْمُكَذِّبِينَ",
    "إِن تَحْرِصْ عَلَىٰ هُدَاهُمْ فَإِنَّ اللَّهَ لَا يَهْدِي مَن يُضِلُّ ۖ وَمَا لَهُم مِّن نَّاصِرِينَ",
    "وَأَقْسَمُوا بِاللَّهِ جَهْدَ أَيْمَانِهِمْ ۙ لَا يَبْعَثُ اللَّهُ مَن يَمُوتُ ۚ بَلَىٰ وَعْدًا عَلَيْهِ حَقًّا وَلَٰكِنَّ أَكْثَرَ النَّاسِ لَا يَعْلَمُونَ",
    "لِيُبَيِّنَ لَهُمُ الَّذِي يَخْتَلِفُونَ فِيهِ وَلِيَعْلَمَ الَّذِينَ كَفَرُوا أَنَّهُمْ كَانُوا كَاذِبِينَ",
    "إِنَّمَا قَوْلُنَا لِشَيْءٍ إِذَا أَرَدْنَاهُ أَن نَّقُولَ لَهُ كُن فَيَكُونُ",
    "وَالَّذِينَ هَاجَرُوا فِي اللَّهِ مِن بَعْدِ مَا ظُلِمُوا لَنُبَوِّئَنَّهُمْ فِي الدُّنْيَا حَسَنَةً ۖ وَلَأَجْرُ الْآخِرَةِ أَكْبَرُ ۚ لَوْ كَانُوا يَعْلَمُونَ",
    "الَّذِينَ صَبَرُوا وَعَلَىٰ رَبِّهِمْ يَتَوَكَّلُونَ",
    "وَمَا أَرْسَلْنَا مِن قَبْلِكَ إِلَّا رِجَالًا نُّوحِي إِلَيْهِمْ ۚ فَاسْأَلُوا أَهْلَ الذِّكْرِ إِن كُنتُمْ لَا تَعْلَمُونَ",
    "بِالْبَيِّنَاتِ وَالزُّبُرِ ۗ وَأَنزَلْنَا إِلَيْكَ الذِّكْرَ لِتُبَيِّنَ لِلنَّاسِ مَا نُزِّلَ إِلَيْهِمْ وَلَعَلَّهُمْ يَتَفَكَّرُونَ",
    "أَفَأَمِنَ الَّذِينَ مَكَرُوا السَّيِّئَاتِ أَن يَخْسِفَ اللَّهُ بِهِمُ الْأَرْضَ أَوْ يَأْتِيَهُمُ الْعَذَابُ مِنْ حَيْثُ لَا يَشْعُرُونَ",
    "أَوْ يَأْخُذَهُمْ فِي تَقَلُّبِهِمْ فَمَا هُم بِمُعْجِزِينَ",
    "أَوْ يَأْخُذَهُمْ عَلَىٰ تَخَوُّفٍ فَإِنَّ رَبَّكُمْ لَرَءُوفٌ رَّحِيمٌ",
    "أَوَلَمْ يَرَوْا إِلَىٰ مَا خَلَقَ اللَّهُ مِن شَيْءٍ يَتَفَيَّأُ ظِلَالُهُ عَنِ الْيَمِينِ وَالشَّمَائِلِ سُجَّدًا لِّلَّهِ وَهُمْ دَاخِرُونَ",
    "وَلِلَّهِ يَسْجُدُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مِن دَابَّةٍ وَالْمَلَائِكَةُ وَهُمْ لَا يَسْتَكْبِرُونَ",
    "يَخَافُونَ رَبَّهُم مِّن فَوْقِهِمْ وَيَفْعَلُونَ مَا يُؤْمَرُونَ ۩",
    "وَقَالَ اللَّهُ لَا تَتَّخِذُوا إِلَٰهَيْنِ اثْنَيْنِ ۖ إِنَّمَا هُوَ إِلَٰهٌ وَاحِدٌ ۖ فَإِيَّايَ فَارْهَبُونِ",
    "وَلَهُ مَا فِي السَّمَاوَاتِ وَالْأَرْضِ وَلَهُ الدِّينُ وَاصِبًا ۚ أَفَغَيْرَ اللَّهِ تَتَّقُونَ",
    "وَمَا بِكُم مِّن نِّعْمَةٍ فَمِنَ اللَّهِ ۖ ثُمَّ إِذَا مَسَّكُمُ الضُّرُّ فَإِلَيْهِ تَجْأَرُونَ",
    "ثُمَّ إِذَا كَشَفَ الضُّرَّ عَنكُمْ إِذَا فَرِيقٌ مِّنكُم بِرَبِّهِمْ يُشْرِكُونَ",
    "لِيَكْفُرُوا بِمَا آتَيْنَاهُمْ ۚ فَتَمَتَّعُوا ۖ فَسَوْفَ تَعْلَمُونَ",
    "وَيَجْعَلُونَ لِمَا لَا يَعْلَمُونَ نَصِيبًا مِّمَّا رَزَقْنَاهُمْ ۗ تَاللَّهِ لَتُسْأَلُنَّ عَمَّا كُنتُمْ تَفْتَرُونَ",
    "وَيَجْعَلُونَ لِلَّهِ الْبَنَاتِ سُبْحَانَهُ ۙ وَلَهُم مَّا يَشْتَهُونَ",
    "وَإِذَا بُشِّرَ أَحَدُهُم بِالْأُنثَىٰ ظَلَّ وَجْهُهُ مُسْوَدًّا وَهُوَ كَظِيمٌ",
    "يَتَوَارَىٰ مِنَ الْقَوْمِ مِن سُوءِ مَا بُشِّرَ بِهِ ۚ أَيُمْسِكُهُ عَلَىٰ هُونٍ أَمْ يَدُسُّهُ فِي التُّرَابِ ۗ أَلَا سَاءَ مَا يَحْكُمُونَ",
    "لِلَّذِينَ لَا يُؤْمِنُونَ بِالْآخِرَةِ مَثَلُ السَّوْءِ ۖ وَلِلَّهِ الْمَثَلُ الْأَعْلَىٰ ۚ وَهُوَ الْعَزِيزُ الْحَكِيمُ",
    "وَلَوْ يُؤَاخِذُ اللَّهُ النَّاسَ بِظُلْمِهِم مَّا تَرَكَ عَلَيْهَا مِن دَابَّةٍ وَلَٰكِن يُؤَخِّرُهُمْ إِلَىٰ أَجَلٍ مُّسَمًّى ۖ فَإِذَا جَاءَ أَجَلُهُمْ لَا يَسْتَأْخِرُونَ سَاعَةً ۖ وَلَا يَسْتَقْدِمُونَ",
    "وَيَجْعَلُونَ لِلَّهِ مَا يَكْرَهُونَ وَتَصِفُ أَلْسِنَتُهُمُ الْكَذِبَ أَنَّ لَهُمُ الْحُسْنَىٰ ۖ لَا جَرَمَ أَنَّ لَهُمُ النَّارَ وَأَنَّهُم مُّفْرَطُونَ",
    "تَاللَّهِ لَقَدْ أَرْسَلْنَا إِلَىٰ أُمَمٍ مِّن قَبْلِكَ فَزَيَّنَ لَهُمُ الشَّيْطَانُ أَعْمَالَهُمْ فَهُوَ وَلِيُّهُمُ الْيَوْمَ وَلَهُمْ عَذَابٌ أَلِيمٌ",
    "وَمَا أَنزَلْنَا عَلَيْكَ الْكِتَابَ إِلَّا لِتُبَيِّنَ لَهُمُ الَّذِي اخْتَلَفُوا فِيهِ ۙ وَهُدًى وَرَحْمَةً لِّقَوْمٍ يُؤْمِنُونَ",
    "وَاللَّهُ أَنزَلَ مِنَ السَّمَاءِ مَاءً فَأَحْيَا بِهِ الْأَرْضَ بَعْدَ مَوْتِهَا ۚ إِنَّ فِي ذَٰلِكَ لَآيَةً لِّقَوْمٍ يَسْمَعُونَ",
    "وَإِنَّ لَكُمْ فِي الْأَنْعَامِ لَعِبْرَةً ۖ نُّسْقِيكُم مِّمَّا فِي بُطُونِهِ مِن بَيْنِ فَرْثٍ وَدَمٍ لَّبَنًا خَالِصًا سَائِغًا لِّلشَّارِبِينَ",
    "وَمِن ثَمَرَاتِ النَّخِيلِ وَالْأَعْنَابِ تَتَّخِذُونَ مِنْهُ سَكَرًا وَرِزْقًا حَسَنًا ۗ إِنَّ فِي ذَٰلِكَ لَآيَةً لِّقَوْمٍ يَعْقِلُونَ",
    "وَأَوْحَىٰ رَبُّكَ إِلَى النَّحْلِ أَنِ اتَّخِذِي مِنَ الْجِبَالِ بُيُوتًا وَمِنَ الشَّجَرِ وَمِمَّا يَعْرِشُونَ",
    "ثُمَّ كُلِي مِن كُلِّ الثَّمَرَاتِ فَاسْلُكِي سُبُلَ رَبِّكِ ذُلُلًا ۚ يَخْرُجُ مِن بُطُونِهَا شَرَابٌ مُّخْتَلِفٌ أَلْوَانُهُ فِيهِ شِفَاءٌ لِّلنَّاسِ ۗ إِنَّ فِي ذَٰلِكَ لَآيَةً لِّقَوْمٍ يَتَفَكَّرُونَ",
    "وَاللَّهُ خَلَقَكُمْ ثُمَّ يَتَوَفَّاكُمْ ۚ وَمِنكُم مَّن يُرَدُّ إِلَىٰ أَرْذَلِ الْعُمُرِ لِكَيْ لَا يَعْلَمَ بَعْدَ عِلْمٍ شَيْئًا ۚ إِنَّ اللَّهَ عَلِيمٌ قَدِيرٌ",
    "وَاللَّهُ فَضَّلَ بَعْضَكُمْ عَلَىٰ بَعْضٍ فِي الرِّزْقِ ۚ فَمَا الَّذِينَ فُضِّلُوا بِرَادِّي رِزْقِهِمْ عَلَىٰ مَا مَلَكَتْ أَيْمَانُهُمْ فَهُمْ فِيهِ سَوَاءٌ ۚ أَفَبِنِعْمَةِ اللَّهِ يَجْحَدُونَ",
    "وَاللَّهُ جَعَلَ لَكُم مِّنْ أَنفُسِكُمْ أَزْوَاجًا وَجَعَلَ لَكُم مِّنْ أَزْوَاجِكُم بَنِينَ وَحَفَدَةً وَرَزَقَكُم مِّنَ الطَّيِّبَاتِ ۚ أَفَبِالْبَاطِلِ يُؤْمِنُونَ وَبِنِعْمَتِ اللَّهِ هُمْ يَكْفُرُونَ",
    "وَيَعْبُدُونَ مِن دُونِ اللَّهِ مَا لَا يَمْلِكُ لَهُمْ رِزْقًا مِّنَ السَّمَاوَاتِ وَالْأَرْضِ شَيْئًا وَلَا يَسْتَطِيعُونَ",
    "فَلَا تَضْرِبُوا لِلَّهِ الْأَمْثَالَ ۚ إِنَّ اللَّهَ يَعْلَمُ وَأَنتُمْ لَا تَعْلَمُونَ",
    "ضَرَبَ اللَّهُ مَثَلًا عَبْدًا مَّمْلُوكًا لَّا يَقْدِرُ عَلَىٰ شَيْءٍ وَمَن رَّزَقْنَاهُ مِنَّا رِزْقًا حَسَنًا فَهُوَ يُنفِقُ مِنْهُ سِرًّا وَجَهْرًا ۖ هَلْ يَسْتَوُونَ ۚ الْحَمْدُ لِلَّهِ ۚ بَلْ أَكْثَرُهُمْ لَا يَعْلَمُونَ",
    "وَضَرَبَ اللَّهُ مَثَلًا رَّجُلَيْنِ أَحَدُهُمَا أَبْكَمُ لَا يَقْدِرُ عَلَىٰ شَيْءٍ وَهُوَ كَلٌّ عَلَىٰ مَوْلَاهُ أَيْنَمَا يُوَجِّههُّ لَا يَأْتِ بِخَيْرٍ ۖ هَلْ يَسْتَوِي هُوَ وَمَن يَأْمُرُ بِالْعَدْلِ ۙ وَهُوَ عَلَىٰ صِرَاطٍ مُّسْتَقِيمٍ",
    "وَلِلَّهِ غَيْبُ السَّمَاوَاتِ وَالْأَرْضِ ۚ وَمَا أَمْرُ السَّاعَةِ إِلَّا كَلَمْحِ الْبَصَرِ أَوْ هُوَ أَقْرَبُ ۚ إِنَّ اللَّهَ عَلَىٰ كُلِّ شَيْءٍ قَدِيرٌ",
    "وَاللَّهُ أَخْرَجَكُم مِّن بُطُونِ أُمَّهَاتِكُمْ لَا تَعْلَمُونَ شَيْئًا وَجَعَلَ لَكُمُ السَّمْعَ وَالْأَبْصَارَ وَالْأَفْئِدَةَ ۙ لَعَلَّكُمْ تَشْكُرُونَ",
    "أَلَمْ يَرَوْا إِلَى الطَّيْرِ مُسَخَّرَاتٍ فِي جَوِّ السَّمَاءِ مَا يُمْسِكُهُنَّ إِلَّا اللَّهُ ۗ إِنَّ فِي ذَٰلِكَ لَآيَاتٍ لِّقَوْمٍ يُؤْمِنُونَ",
    "وَاللَّهُ جَعَلَ لَكُم مِّن بُيُوتِكُمْ سَكَنًا وَجَعَلَ لَكُم مِّن جُلُودِ الْأَنْعَامِ بُيُوتًا تَسْتَخِفُّونَهَا يَوْمَ ظَعْنِكُمْ وَيَوْمَ إِقَامَتِكُمْ ۙ وَمِنْ أَصْوَافِهَا وَأَوْبَارِهَا وَأَشْعَارِهَا أَثَاثًا وَمَتَاعًا إِلَىٰ حِينٍ",
    "وَاللَّهُ جَعَلَ لَكُم مِّمَّا خَلَقَ ظِلَالًا وَجَعَلَ لَكُم مِّنَ الْجِبَالِ أَكْنَانًا وَجَعَلَ لَكُمْ سَرَابِيلَ تَقِيكُمُ الْحَرَّ وَسَرَابِيلَ تَقِيكُم بَأْسَكُمْ ۚ كَذَٰلِكَ يُتِمُّ نِعْمَتَهُ عَلَيْكُمْ لَعَلَّكُمْ تُسْلِمُونَ",
    "فَإِن تَوَلَّوْا فَإِنَّمَا عَلَيْكَ الْبَلَاغُ الْمُبِينُ",
    "يَعْرِفُونَ نِعْمَتَ اللَّهِ ثُمَّ يُنكِرُونَهَا وَأَكْثَرُهُمُ الْكَافِرُونَ",
    "وَيَوْمَ نَبْعَثُ مِن كُلِّ أُمَّةٍ شَهِيدًا ثُمَّ لَا يُؤْذَنُ لِلَّذِينَ كَفَرُوا وَلَا هُمْ يُسْتَعْتَبُونَ",
    "وَإِذَا رَأَى الَّذِينَ ظَلَمُوا الْعَذَابَ فَلَا يُخَفَّفُ عَنْهُمْ وَلَا هُمْ يُنظَرُونَ",
    "وَإِذَا رَأَى الَّذِينَ أَشْرَكُوا شُرَكَاءَهُمْ قَالُوا رَبَّنَا هَٰؤُلَاءِ شُرَكَاؤُنَا الَّذِينَ كُنَّا نَدْعُو مِن دُونِكَ ۖ فَأَلْقَوْا إِلَيْهِمُ الْقَوْلَ إِنَّكُمْ لَكَاذِبُونَ",
    "وَأَلْقَوْا إِلَى اللَّهِ يَوْمَئِذٍ السَّلَمَ ۖ وَضَلَّ عَنْهُم مَّا كَانُوا يَفْتَرُونَ",
    "الَّذِينَ كَفَرُوا وَصَدُّوا عَن سَبِيلِ اللَّهِ زِدْنَاهُمْ عَذَابًا فَوْقَ الْعَذَابِ بِمَا كَانُوا يُفْسِدُونَ",
    "وَيَوْمَ نَبْعَثُ فِي كُلِّ أُمَّةٍ شَهِيدًا عَلَيْهِم مِّنْ أَنفُسِهِمْ ۖ وَجِئْنَا بِكَ شَهِيدًا عَلَىٰ هَٰؤُلَاءِ ۚ وَنَزَّلْنَا عَلَيْكَ الْكِتَابَ تِبْيَانًا لِّكُلِّ شَيْءٍ وَهُدًى وَرَحْمَةً وَبُشْرَىٰ لِلْمُسْلِمِينَ",
    "إِنَّ اللَّهَ يَأْمُرُ بِالْعَدْلِ وَالْإِحْسَانِ وَإِيتَاءِ ذِي الْقُرْبَىٰ وَيَنْهَىٰ عَنِ الْفَحْشَاءِ وَالْمُنكَرِ وَالْبَغْيِ ۚ يَعِظُكُمْ لَعَلَّكُمْ تَذَكَّرُونَ",
    "وَأَوْفُوا بِعَهْدِ اللَّهِ إِذَا عَاهَدتُّمْ وَلَا تَنقُضُوا الْأَيْمَانَ بَعْدَ تَوْكِيدِهَا وَقَدْ جَعَلْتُمُ اللَّهَ عَلَيْكُمْ كَفِيلًا ۚ إِنَّ اللَّهَ يَعْلَمُ مَا تَفْعَلُونَ",
    "وَلَا تَكُونُوا كَالَّتِي نَقَضَتْ غَزْلَهَا مِن بَعْدِ قُوَّةٍ أَنكَاثًا تَتَّخِذُونَ أَيْمَانَكُمْ دَخَلًا بَيْنَكُمْ أَن تَكُونَ أُمَّةٌ هِيَ أَرْبَىٰ مِنْ أُمَّةٍ ۚ إِنَّمَا يَبْلُوكُمُ اللَّهُ بِهِ ۚ وَلَيُبَيِّنَنَّ لَكُمْ يَوْمَ الْقِيَامَةِ مَا كُنتُمْ فِيهِ تَخْتَلِفُونَ",
    "وَلَوْ شَاءَ اللَّهُ لَجَعَلَكُمْ أُمَّةً وَاحِدَةً وَلَٰكِن يُضِلُّ مَن يَشَاءُ وَيَهْدِي مَن يَشَاءُ ۚ وَلَتُسْأَلُنَّ عَمَّا كُنتُمْ تَعْمَلُونَ",
    "وَلَا تَتَّخِذُوا أَيْمَانَكُمْ دَخَلًا بَيْنَكُمْ فَتَزِلَّ قَدَمٌ بَعْدَ ثُبُوتِهَا وَتَذُوقُوا السُّوءَ بِمَا صَدَدتُّمْ عَن سَبِيلِ اللَّهِ ۖ وَلَكُمْ عَذَابٌ عَظِيمٌ",
    "وَلَا تَشْتَرُوا بِعَهْدِ اللَّهِ ثَمَنًا قَلِيلًا ۚ إِنَّمَا عِندَ اللَّهِ هُوَ خَيْرٌ لَّكُمْ إِن كُنتُمْ تَعْلَمُونَ",
    "مَا عِندَكُمْ يَنفَدُ ۖ وَمَا عِندَ اللَّهِ بَاقٍ ۗ وَلَنَجْزِيَنَّ الَّذِينَ صَبَرُوا أَجْرَهُم بِأَحْسَنِ مَا كَانُوا يَعْمَلُونَ",
    "مَنْ عَمِلَ صَالِحًا مِّن ذَكَرٍ أَوْ أُنثَىٰ وَهُوَ مُؤْمِنٌ فَلَنُحْيِيَنَّهُ حَيَاةً طَيِّبَةً ۖ وَلَنَجْزِيَنَّهُمْ أَجْرَهُم بِأَحْسَنِ مَا كَانُوا يَعْمَلُونَ",
    "فَإِذَا قَرَأْتَ الْقُرْآنَ فَاسْتَعِذْ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ",
    "إِنَّهُ لَيْسَ لَهُ سُلْطَانٌ عَلَى الَّذِينَ آمَنُوا وَعَلَىٰ رَبِّهِمْ يَتَوَكَّلُونَ",
    "إِنَّمَا سُلْطَانُهُ عَلَى الَّذِينَ يَتَوَلَّوْنَهُ وَالَّذِينَ هُم بِهِ مُشْرِكُونَ",
    "وَإِذَا بَدَّلْنَا آيَةً مَّكَانَ آيَةٍ ۙ وَاللَّهُ أَعْلَمُ بِمَا يُنَزِّلُ قَالُوا إِنَّمَا أَنتَ مُفْتَرٍ ۚ بَلْ أَكْثَرُهُمْ لَا يَعْلَمُونَ",
    "قُلْ نَزَّلَهُ رُوحُ الْقُدُسِ مِن رَّبِّكَ بِالْحَقِّ لِيُثَبِّتَ الَّذِينَ آمَنُوا وَهُدًى وَبُشْرَىٰ لِلْمُسْلِمِينَ",
    "وَلَقَدْ نَعْلَمُ أَنَّهُمْ يَقُولُونَ إِنَّمَا يُعَلِّمُهُ بَشَرٌ ۗ لِّسَانُ الَّذِي يُلْحِدُونَ إِلَيْهِ أَعْجَمِيٌّ وَهَٰذَا لِسَانٌ عَرَبِيٌّ مُّبِينٌ",
    "إِنَّ الَّذِينَ لَا يُؤْمِنُونَ بِآيَاتِ اللَّهِ لَا يَهْدِيهِمُ اللَّهُ وَلَهُمْ عَذَابٌ أَلِيمٌ",
    "إِنَّمَا يَفْتَرِي الْكَذِبَ الَّذِينَ لَا يُؤْمِنُونَ بِآيَاتِ اللَّهِ ۖ وَأُولَٰئِكَ هُمُ الْكَاذِبُونَ",
    "مَن كَفَرَ بِاللَّهِ مِن بَعْدِ إِيمَانِهِ إِلَّا مَنْ أُكْرِهَ وَقَلْبُهُ مُطْمَئِنٌّ بِالْإِيمَانِ وَلَٰكِن مَّن شَرَحَ بِالْكُفْرِ صَدْرًا فَعَلَيْهِمْ غَضَبٌ مِّنَ اللَّهِ وَلَهُمْ عَذَابٌ عَظِيمٌ",
    "ذَٰلِكَ بِأَنَّهُمُ اسْتَحَبُّوا الْحَيَاةَ الدُّنْيَا عَلَى الْآخِرَةِ وَأَنَّ اللَّهَ لَا يَهْدِي الْقَوْمَ الْكَافِرِينَ",
    "أُولَٰئِكَ الَّذِينَ طَبَعَ اللَّهُ عَلَىٰ قُلُوبِهِمْ وَسَمْعِهِمْ وَأَبْصَارِهِمْ ۖ وَأُولَٰئِكَ هُمُ الْغَافِلُونَ",
    "لَا جَرَمَ أَنَّهُمْ فِي الْآخِرَةِ هُمُ الْخَاسِرُونَ",
    "ثُمَّ إِنَّ رَبَّكَ لِلَّذِينَ هَاجَرُوا مِن بَعْدِ مَا فُتِنُوا ثُمَّ جَاهَدُوا وَصَبَرُوا إِنَّ رَبَّكَ مِن بَعْدِهَا لَغَفُورٌ رَّحِيمٌ",
    "يَوْمَ تَأْتِي كُلُّ نَفْسٍ تُجَادِلُ عَن نَّفْسِهَا وَتُوَفَّىٰ كُلُّ نَفْسٍ مَّا عَمِلَتْ وَهُمْ لَا يُظْلَمُونَ",
    "وَضَرَبَ اللَّهُ مَثَلًا قَرْيَةً كَانَتْ آمِنَةً مُّطْمَئِنَّةً يَأْتِيهَا رِزْقُهَا رَغَدًا مِّن كُلِّ مَكَانٍ فَكَفَرَتْ بِأَنْعُمِ اللَّهِ فَأَذَاقَهَا اللَّهُ لِبَاسَ الْجُوعِ وَالْخَوْفِ بِمَا كَانُوا يَصْنَعُونَ",
    "وَلَقَدْ جَاءَهُمْ رَسُولٌ مِّنْهُمْ فَكَذَّبُوهُ فَأَخَذَهُمُ الْعَذَابُ وَهُمْ ظَالِمُونَ",
    "فَكُلُوا مِمَّا رَزَقَكُمُ اللَّهُ حَلَالًا طَيِّبًا وَاشْكُرُوا نِعْمَتَ اللَّهِ إِن كُنتُمْ إِيَّاهُ تَعْبُدُونَ",
    "إِنَّمَا حَرَّمَ عَلَيْكُمُ الْمَيْتَةَ وَالدَّمَ وَلَحْمَ الْخِنزِيرِ وَمَا أُهِلَّ لِغَيْرِ اللَّهِ بِهِ ۖ فَمَنِ اضْطُرَّ غَيْرَ بَاغٍ وَلَا عَادٍ فَإِنَّ اللَّهَ غَفُورٌ رَّحِيمٌ",
    "وَلَا تَقُولُوا لِمَا تَصِفُ أَلْسِنَتُكُمُ الْكَذِبَ هَٰذَا حَلَالٌ وَهَٰذَا حَرَامٌ لِّتَفْتَرُوا عَلَى اللَّهِ الْكَذِبَ ۚ إِنَّ الَّذِينَ يَفْتَرُونَ عَلَى اللَّهِ الْكَذِبَ لَا يُفْلِحُونَ",
    "مَتَاعٌ قَلِيلٌ وَلَهُمْ عَذَابٌ أَلِيمٌ",
    "وَعَلَى الَّذِينَ هَادُوا حَرَّمْنَا مَا قَصَصْنَا عَلَيْكَ مِن قَبْلُ ۖ وَمَا ظَلَمْنَاهُمْ وَلَٰكِن كَانُوا أَنفُسَهُمْ يَظْلِمُونَ",
    "ثُمَّ إِنَّ رَبَّكَ لِلَّذِينَ عَمِلُوا السُّوءَ بِجَهَالَةٍ ثُمَّ تَابُوا مِن بَعْدِ ذَٰلِكَ وَأَصْلَحُوا إِنَّ رَبَّكَ مِن بَعْدِهَا لَغَفُورٌ رَّحِيمٌ",
    "إِنَّ إِبْرَاهِيمَ كَانَ أُمَّةً قَانِتًا لِّلَّهِ حَنِيفًا وَلَمْ يَكُ مِنَ الْمُشْرِكِينَ",
    "شَاكِرًا لِّأَنْعُمِهِ ۚ اجْتَبَاهُ وَهَدَاهُ إِلَىٰ صِرَاطٍ مُّسْتَقِيمٍ",
    "وَآتَيْنَاهُ فِي الدُّنْيَا حَسَنَةً ۖ وَإِنَّهُ فِي الْآخِرَةِ لَمِنَ الصَّالِحِينَ",
    "ثُمَّ أَوْحَيْنَا إِلَيْكَ أَنِ اتَّبِعْ مِلَّةَ إِبْرَاهِيمَ حَنِيفًا ۖ وَمَا كَانَ مِنَ الْمُشْرِكِينَ",
    "إِنَّمَا جُعِلَ السَّبْتُ عَلَى الَّذِينَ اخْتَلَفُوا فِيهِ ۚ وَإِنَّ رَبَّكَ لَيَحْكُمُ بَيْنَهُمْ يَوْمَ الْقِيَامَةِ فِيمَا كَانُوا فِيهِ يَخْتَلِفُونَ",
    "ادْعُ إِلَىٰ سَبِيلِ رَبِّكَ بِالْحِكْمَةِ وَالْمَوْعِظَةِ الْحَسَنَةِ ۖ وَجَادِلْهُم بِالَّتِي هِيَ أَحْسَنُ ۚ إِنَّ رَبَّكَ هُوَ أَعْلَمُ بِمَن ضَلَّ عَن سَبِيلِهِ ۖ وَهُوَ أَعْلَمُ بِالْمُهْتَدِينَ",
    "وَإِنْ عَاقَبْتُمْ فَعَاقِبُوا بِمِثْلِ مَا عُوقِبْتُم بِهِ ۖ وَلَئِن صَبَرْتُمْ لَهُوَ خَيْرٌ لِّلصَّابِرِينَ",
    "وَاصْبِرْ وَمَا صَبْرُكَ إِلَّا بِاللَّهِ ۚ وَلَا تَحْزَنْ عَلَيْهِمْ وَلَا تَكُ فِي ضَيْقٍ مِّمَّا يَمْكُرُونَ",
    "إِنَّ اللَّهَ مَعَ الَّذِينَ اتَّقَوا وَّالَّذِينَ هُم مُّحْسِنُونَ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"The command of Allah is coming, so be not impatient for it. Exalted is He and high above what they associate with Him.",
    "He sends down the angels, with the inspiration of His command, upon whom He wills of His servants, [telling them], \"Warn that there is no deity except Me; so fear Me.\"",
    "He created the heavens and earth in truth. High is He above what they associate with Him.",
    "He created man from a sperm-drop; then at once, he is a clear adversary.",
    "And the grazing livestock He has created for you; in them is warmth and [numerous] benefits, and from them you eat.",
    "And for you in them is [the enjoyment of] beauty when you bring them in [for the evening] and when you send them out [to pasture].",
    "And they carry your loads to a land you could not have reached except with difficulty to yourselves. Indeed, your Lord is Kind and Merciful.",
    "And [He created] the horses, mules and donkeys for you to ride and [as] adornment. And He creates that which you do not know.",
    "And upon Allah is the direction of the [right] way, and among the various paths are those deviating. And if He willed, He could have guided you all.",
    "It is He who sends down rain from the sky; from it is drink and from it is foliage in which you pasture [animals].",
    "He causes to grow for you thereby the crops, olives, palm trees, grapevines, and from all the fruits. Indeed in that is a sign for a people who give thought.",
    "And He has subjected for you the night and day and the sun and moon, and the stars are subjected by His command. Indeed in that are signs for a people who reason.",
    "And [He has subjected] whatever He multiplied for you on the earth of varying colors. Indeed in that is a sign for a people who remember.",
    "And it is He who subjected the sea for you to eat from it tender meat and to extract from it ornaments which you wear. And you see the ships plowing through it, and [He subjected it] that you may seek of His bounty; and perhaps you will be grateful.",
    "And He has cast into the earth firmly set mountains, lest it shift with you, and [made] rivers and roads, that you may be guided,",
    "And landmarks. And by the stars they are [also] guided.",
    "Then is He who creates like one who does not create? So will you not be reminded?",
    "And if you should count the favors of Allah, you could not enumerate them. Indeed, Allah is Forgiving and Merciful.",
    "And Allah knows what you conceal and what you declare.",
    "And those they invoke other than Allah create nothing, and they [themselves] are created.",
    "They are, [in fact], dead, not alive, and they do not perceive when they will be resurrected.",
    "Your god is one God. But those who do not believe in the Hereafter - their hearts are disapproving, and they are arrogant.",
    "Assuredly, Allah knows what they conceal and what they declare. Indeed, He does not like the arrogant.",
    "And when it is said to them, \"What has your Lord sent down?\" They say, \"Legends of the former peoples,\"",
    "That they may bear their own burdens in full on the Day of Resurrection and some of the burdens of those whom they misguide without knowledge. Unquestionably, evil is that which they bear.",
    "Those before them had already plotted, but Allah came at their building from the foundations, so the roof fell upon them from above them, and the punishment came to them from where they did not perceive.",
    "Then on the Day of Resurrection He will disgrace them and say, \"Where are My 'partners' for whom you used to oppose [the believers]?\" Those who were given knowledge will say, \"Indeed disgrace, this Day, and evil are upon the disbelievers\" -",
    "The ones whom the angels take in death [while] wronging themselves, and [who] then offer submission, [saying], \"We were not doing any evil.\" But, yes! Indeed, Allah is Knowing of what you used to do.",
    "So enter the gates of Hell to abide eternally therein, and how wretched is the residence of the arrogant.",
    "And it will be said to those who feared Allah, \"What did your Lord send down?\" They will say, \"[That which is] good.\" For those who do good in this world is good; and the home of the Hereafter is better. And how excellent is the home of the righteous -",
    "Gardens of perpetual residence, which they will enter, beneath which rivers flow. They will have therein whatever they wish. Thus does Allah reward the righteous -",
    "The ones whom the angels take in death, [being] good and pure; [the angels] will say, \"Peace be upon you. Enter Paradise for what you used to do.\"",
    "Do the disbelievers await [anything] except that the angels should come to them or there comes the command of your Lord? Thus did those do before them. And Allah wronged them not, but they had been wronging themselves.",
    "So they were struck by the evil consequences of what they did and were enveloped by what they used to ridicule.",
    "And those who associate others with Allah say, \"If Allah had willed, we would not have worshipped anything other than Him, neither we nor our fathers, nor would we have forbidden anything through other than Him.\" Thus did those do before them. So is there upon the messengers except [the duty of] clear notification?",
    "And We certainly sent into every nation a messenger, [saying], \"Worship Allah and avoid Taghut.\" And among them were those whom Allah guided, and among them were those upon whom error was [deservedly] decreed. So proceed through the earth and observe how was the end of the deniers.",
    "[Even] if you should strive for their guidance, [O Muhammad], indeed, Allah does not guide those He sends astray, and they will have no helpers.",
    "And they swear by Allah their strongest oaths [that] Allah will not resurrect one who dies. But yes - [it is] a true promise [binding] upon Him, but most of the people do not know.",
    "[It is] so He will make clear to them [the truth of] that wherein they differ and so those who have disbelieved may know that they were liars.",
    "Indeed, Our word to a thing when We intend it is but that We say to it, \"Be,\" and it is.",
    "And those who emigrated for [the cause of] Allah after they had been wronged - We will surely settle them in this world in a good place; but the reward of the Hereafter is greater, if only they could know.",
    "[They are] those who endured patiently and upon their Lord relied.",
    "And We sent not before you except men to whom We revealed [Our message]. So ask the people of the message if you do not know.",
    "[We sent them] with clear proofs and written ordinances. And We revealed to you the message that you may make clear to the people what was sent down to them and that they might give thought.",
    "Then, do those who have planned evil deeds feel secure that Allah will not cause the earth to swallow them or that the punishment will not come upon them from where they do not perceive?",
    "Or that He would not seize them during their [usual] activity, and they could not cause failure?",
    "Or that He would not seize them gradually [in a state of dread]? But indeed, your Lord is Kind and Merciful.",
    "Have they not considered what things Allah has created? Their shadows incline to the right and to the left, prostrating to Allah, while they are humble.",
    "And to Allah prostrates whatever is in the heavens and whatever is on the earth of creatures, and the angels [as well], and they are not arrogant.",
    "They fear their Lord above them, and they do what they are commanded.",
    "And Allah has said, \"Do not take for yourselves two deities. He is but one God, so fear only Me.\"",
    "And to Him belongs whatever is in the heavens and the earth, and to Him is [due] worship constantly. Then is it other than Allah that you fear?",
    "And whatever you have of favor - it is from Allah. Then when adversity touches you, to Him you cry for help.",
    "Then when He removes the adversity from you, at once a party of you associates others with their Lord",
    "So they will deny what We have given them. Then enjoy yourselves, for you are going to know.",
    "And they assign to what they do not know a portion of that which We have provided them. By Allah, you will surely be questioned about what you used to invent.",
    "And they attribute to Allah daughters - exalted is He - and for them is what they desire.",
    "And when one of them is informed of [the birth of] a female, his face becomes dark, and he suppresses grief.",
    "He hides himself from the people because of the ill of which he has been informed. Should he keep it in humiliation or bury it in the ground? Unquestionably, evil is what they decide.",
    "For those who do not believe in the Hereafter is the description of evil; and for Allah is the highest attribute. And He is Exalted in Might, the Wise.",
    "And if Allah were to impose blame on the people for their wrongdoing, He would not have left upon the earth any creature, but He defers them for a specified term. And when their term has come, they will not remain behind an hour, nor will they precede [it].",
    "And they attribute to Allah that which they dislike, and their tongues assert the lie that they will have the best [from Him]. Assuredly, they will have the Fire, and they will be [therein] neglected.",
    "By Allah, We did certainly send [messengers] to nations before you, but Satan made their deeds attractive to them. And he is the disbelievers' ally today [as well], and they will have a painful punishment.",
    "And We have not revealed to you the Book, [O Muhammad], except for you to make clear to them that wherein they have differed and as guidance and mercy for a people who believe.",
    "And Allah has sent down rain from the sky and given life thereby to the earth after its lifelessness. Indeed in that is a sign for a people who listen.",
    "And indeed, for you in grazing livestock is a lesson. We give you drink from what is in their bellies - between excretion and blood - pure milk, palatable to drinkers.",
    "And from the fruits of the palm trees and grapevines you take intoxicant and good provision. Indeed in that is a sign for a people who reason.",
    "And your Lord inspired to the bee, \"Take for yourself among the mountains, houses, and among the trees and [in] that which they construct.",
    "Then eat from all the fruits and follow the ways of your Lord laid down [for you].\" There emerges from their bellies a drink, varying in colors, in which there is healing for people. Indeed in that is a sign for a people who give thought.",
    "And Allah created you; then He will take you in death. And among you is he who is reversed to the most decrepit [old] age so that he will not know, after [having had] knowledge, a thing. Indeed, Allah is Knowing and Competent.",
    "And Allah has favored some of you over others in provision. But those who were favored would not hand over their provision to those whom their right hands possess so they would be equal to them therein. Then is it the favor of Allah they reject?",
    "And Allah has made for you from yourselves mates and has made for you from your mates sons and grandchildren and has provided for you from the good things. Then in falsehood do they believe and in the favor of Allah they disbelieve?",
    "And they worship besides Allah that which does not possess for them [the power of] provision from the heavens and the earth at all, and [in fact], they are unable.",
    "So do not assert similarities to Allah. Indeed, Allah knows and you do not know.",
    "Allah presents an example: a slave [who is] owned and unable to do a thing and he to whom We have provided from Us good provision, so he spends from it secretly and publicly. Can they be equal? Praise to Allah ! But most of them do not know.",
    "And Allah presents an example of two men, one of them dumb and unable to do a thing, while he is a burden to his guardian. Wherever he directs him, he brings no good. Is he equal to one who commands justice, while he is on a straight path?",
    "And to Allah belongs the unseen [aspects] of the heavens and the earth. And the command for the Hour is not but as a glance of the eye or even nearer. Indeed, Allah is over all things competent.",
    "And Allah has extracted you from the wombs of your mothers not knowing a thing, and He made for you hearing and vision and intellect that perhaps you would be grateful.",
    "Do they not see the birds controlled in the atmosphere of the sky? None holds them up except Allah. Indeed in that are signs for a people who believe.",
    "And Allah has made for you from your homes a place of rest and made for you from the hides of the animals tents which you find light on your day of travel and your day of encampment; and from their wool, fur and hair is furnishing and enjoyment for a time.",
    "And Allah has made for you, from that which He has created, shadows and has made for you from the mountains, shelters and has made for you garments which protect you from the heat and garments which protect you from your [enemy in] battle. Thus does He complete His favor upon you that you might submit [to Him].",
    "But if they turn away, [O Muhammad] - then only upon you is [responsibility for] clear notification.",
    "They recognize the favor of Allah; then they deny it. And most of them are disbelievers.",
    "And [mention] the Day when We will resurrect from every nation a witness. Then it will not be permitted to the disbelievers [to apologize or make excuses], nor will they be asked to appease [Allah].",
    "And when those who wronged see the punishment, it will not be lightened for them, nor will they be reprieved.",
    "And when those who associated others with Allah see their \"partners,\" they will say,\" Our Lord, these are our partners [to You] whom we used to invoke besides You.\" But they will throw at them the statement, \"Indeed, you are liars.\"",
    "And they will impart to Allah that Day [their] submission, and lost from them is what they used to invent.",
    "Those who disbelieved and averted [others] from the way of Allah - We will increase them in punishment over [their] punishment for what corruption they were causing.",
    "And [mention] the Day when We will resurrect among every nation a witness over them from themselves. And We will bring you, [O Muhammad], as a witness over your nation. And We have sent down to you the Book as clarification for all things and as guidance and mercy and good tidings for the Muslims.",
    "Indeed, Allah orders justice and good conduct and giving to relatives and forbids immorality and bad conduct and oppression. He admonishes you that perhaps you will be reminded.",
    "And fulfill the covenant of Allah when you have taken it, [O believers], and do not break oaths after their confirmation while you have made Allah, over you, a witness. Indeed, Allah knows what you do.",
    "And do not be like she who untwisted her spun thread after it was strong [by] taking your oaths as [means of] deceit between you because one community is more plentiful [in number or wealth] than another community. Allah only tries you thereby. And He will surely make clear to you on the Day of Resurrection that over which you used to differ.",
    "And if Allah had willed, He could have made you [of] one religion, but He causes to stray whom He wills and guides whom He wills. And you will surely be questioned about what you used to do.",
    "And do not take your oaths as [means of] deceit between you, lest a foot slip after it was [once] firm, and you would taste evil [in this world] for what [people] you diverted from the way of Allah, and you would have [in the Hereafter] a great punishment.",
    "And do not exchange the covenant of Allah for a small price. Indeed, what is with Allah is best for you, if only you could know.",
    "Whatever you have will end, but what Allah has is lasting. And We will surely give those who were patient their reward according to the best of what they used to do.",
    "Whoever does righteousness, whether male or female, while he is a believer - We will surely cause him to live a good life, and We will surely give them their reward [in the Hereafter] according to the best of what they used to do.",
    "So when you recite the Qur'an, [first] seek refuge in Allah from Satan, the expelled [from His mercy].",
    "Indeed, there is for him no authority over those who have believed and rely upon their Lord.",
    "His authority is only over those who take him as an ally and those who through him associate others with Allah.",
    "And when We substitute a verse in place of a verse - and Allah is most knowing of what He sends down - they say, \"You, [O Muhammad], are but an inventor [of lies].\" But most of them do not know.",
    "Say, [O Muhammad], \"The Pure Spirit has brought it down from your Lord in truth to make firm those who believe and as guidance and good tidings to the Muslims.\"",
    "And We certainly know that they say, \"It is only a human being who teaches the Prophet.\" The tongue of the one they refer to is foreign, and this Qur'an is [in] a clear Arabic language.",
    "Indeed, those who do not believe in the verses of Allah - Allah will not guide them, and for them is a painful punishment.",
    "They only invent falsehood who do not believe in the verses of Allah, and it is those who are the liars.",
    "Whoever disbelieves in Allah after his belief... except for one who is forced [to renounce his religion] while his heart is secure in faith. But those who [willingly] open their breasts to disbelief, upon them is wrath from Allah, and for them is a great punishment;",
    "That is because they preferred the worldly life over the Hereafter and that Allah does not guide the disbelieving people.",
    "Those are the ones over whose hearts and hearing and vision Allah has sealed, and it is those who are the heedless.",
    "Assuredly, it is they, in the Hereafter, who will be the losers.",
    "Then, indeed your Lord, to those who emigrated after they had been compelled [to renounce their religion] and thereafter fought [for the cause of Allah] and were patient - indeed, your Lord, after that, is Forgiving and Merciful",
    "On the Day when every soul will come disputing for itself, and every soul will be fully compensated for what it did, and they will not be wronged.",
    "And Allah presents an example: a city which was safe and secure, its provision coming to it in abundance from every location, but it denied the favors of Allah. So Allah made it taste the envelopment of hunger and fear for what they had been doing.",
    "And there had certainly come to them a Messenger from among themselves, but they denied him; so punishment overtook them while they were wrongdoers.",
    "Then eat of what Allah has provided for you [which is] lawful and good. And be grateful for the favor of Allah, if it is [indeed] Him that you worship.",
    "He has only forbidden to you dead animals, blood, the flesh of swine, and that which has been dedicated to other than Allah. But whoever is forced [by necessity], neither desiring [it] nor transgressing [its limit] - then indeed, Allah is Forgiving and Merciful.",
    "And do not say about what your tongues assert of untruth, \"This is lawful and this is unlawful,\" to invent falsehood about Allah. Indeed, those who invent falsehood about Allah will not succeed.",
    "[It is but] a brief enjoyment, and they will have a painful punishment.",
    "And to those who are Jews We have prohibited that which We related to you before. And We did not wrong them [thereby], but they were wronging themselves.",
    "Then, indeed your Lord, to those who have done wrong out of ignorance and then repent after that and correct themselves - indeed, your Lord, thereafter, is Forgiving and Merciful.",
    "Indeed, Abraham was a [comprehensive] leader, devoutly obedient to Allah, inclining toward truth, and he was not of those who associate others with Allah.",
    "[He was] grateful for His favors. Allah chose him and guided him to a straight path.",
    "And We gave him good in this world, and indeed, in the Hereafter he will be among the righteous.",
    "Then We revealed to you, [O Muhammad], to follow the religion of Abraham, inclining toward truth; and he was not of those who associate with Allah.",
    "The sabbath was only appointed for those who differed over it. And indeed, your Lord will judge between them on the Day of Resurrection concerning that over which they used to differ.",
    "Invite to the way of your Lord with wisdom and good instruction, and argue with them in a way that is best. Indeed, your Lord is most knowing of who has strayed from His way, and He is most knowing of who is [rightly] guided.",
    "And if you punish [an enemy, O believers], punish with an equivalent of that with which you were harmed. But if you are patient - it is better for those who are patient.",
    "And be patient, [O Muhammad], and your patience is not but through Allah. And do not grieve over them and do not be in distress over what they conspire.",
    "Indeed, Allah is with those who fear Him and those who are doers of good."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an__nahl);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_an_nahl);
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
