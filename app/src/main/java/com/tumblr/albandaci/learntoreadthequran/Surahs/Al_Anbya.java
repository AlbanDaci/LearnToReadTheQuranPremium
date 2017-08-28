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

public class Al_Anbya extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "http://download.audioislam.com/audio/quran/recitation/al-afaasee/surah_al_anbiya.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"21:1", "21:2", "21:3", "21:4", "21:5", "21:6", "21:7", "21:8", "21:9", "21:10", "21:11", "21:12", "21:13", "21:14", "21:15", "21:16",
            "21:17", "21:18", "21:19", "21:20", "21:21", "21:22", "21:23", "21:24", "21:25", "21:26", "21:27", "21:28", "21:29", "21:30", "21:31", "21:32",
            "21:33", "21:34", "21:35", "21:36", "21:37", "21:38", "21:39", "21:40", "21:41", "21:42", "21:43", "21:44", "21:45", "21:46", "21:47", "21:48",
            "21:49", "21:50", "21:51", "21:52", "21:53", "21:54", "21:55", "21:56", "21:57", "21:58", "21:59", "21:60", "21:61", "21:62", "21:63", "21:64",
            "21:65", "21:66", "21:67", "21:68", "21:69", "21:70", "21:71", "21:72", "21:73", "21:74", "21:75", "21:76", "21:77", "21:78", "21:79", "21:80",
            "21:81", "21:82", "21:83", "21:84", "21:85", "21:86", "21:87", "21:88", "21:89", "21:90", "21:91", "21:92", "21:93", "21:94", "21:95", "21:96",
            "21:97", "21:98", "21:99", "21:100", "21:101", "21:102", "21:103", "21:104", "21:105", "21:106", "21:107", "21:108", "21:109", "21:110", "21:111", "21:112"};

    String [] arabic_verses = {"اقْتَرَبَ لِلنَّاسِ حِسَابُهُمْ وَهُمْ فِي غَفْلَةٍ مُّعْرِضُونَ",
    "مَا يَأْتِيهِم مِّن ذِكْرٍ مِّن رَّبِّهِم مُّحْدَثٍ إِلَّا اسْتَمَعُوهُ وَهُمْ يَلْعَبُونَ",
    "لَاهِيَةً قُلُوبُهُمْ ۗ وَأَسَرُّوا النَّجْوَى الَّذِينَ ظَلَمُوا هَلْ هَٰذَا إِلَّا بَشَرٌ مِّثْلُكُمْ ۖ أَفَتَأْتُونَ السِّحْرَ وَأَنتُمْ تُبْصِرُونَ",
    "قَالَ رَبِّي يَعْلَمُ الْقَوْلَ فِي السَّمَاءِ وَالْأَرْضِ ۖ وَهُوَ السَّمِيعُ الْعَلِيمُ",
    "بَلْ قَالُوا أَضْغَاثُ أَحْلَامٍ بَلِ افْتَرَاهُ بَلْ هُوَ شَاعِرٌ فَلْيَأْتِنَا بِآيَةٍ كَمَا أُرْسِلَ الْأَوَّلُونَ",
    "مَا آمَنَتْ قَبْلَهُم مِّن قَرْيَةٍ أَهْلَكْنَاهَا ۖ أَفَهُمْ يُؤْمِنُونَ",
    "وَمَا أَرْسَلْنَا قَبْلَكَ إِلَّا رِجَالًا نُّوحِي إِلَيْهِمْ ۖ فَاسْأَلُوا أَهْلَ الذِّكْرِ إِن كُنتُمْ لَا تَعْلَمُونَ",
    "وَمَا جَعَلْنَاهُمْ جَسَدًا لَّا يَأْكُلُونَ الطَّعَامَ وَمَا كَانُوا خَالِدِينَ",
    "ثُمَّ صَدَقْنَاهُمُ الْوَعْدَ فَأَنجَيْنَاهُمْ وَمَن نَّشَاءُ وَأَهْلَكْنَا الْمُسْرِفِينَ",
    "لَقَدْ أَنزَلْنَا إِلَيْكُمْ كِتَابًا فِيهِ ذِكْرُكُمْ ۖ أَفَلَا تَعْقِلُونَ",
    "وَكَمْ قَصَمْنَا مِن قَرْيَةٍ كَانَتْ ظَالِمَةً وَأَنشَأْنَا بَعْدَهَا قَوْمًا آخَرِينَ",
    "فَلَمَّا أَحَسُّوا بَأْسَنَا إِذَا هُم مِّنْهَا يَرْكُضُونَ",
    "لَا تَرْكُضُوا وَارْجِعُوا إِلَىٰ مَا أُتْرِفْتُمْ فِيهِ وَمَسَاكِنِكُمْ لَعَلَّكُمْ تُسْأَلُونَ",
    "قَالُوا يَا وَيْلَنَا إِنَّا كُنَّا ظَالِمِينَ",
    "فَمَا زَالَت تِّلْكَ دَعْوَاهُمْ حَتَّىٰ جَعَلْنَاهُمْ حَصِيدًا خَامِدِينَ",
    "وَمَا خَلَقْنَا السَّمَاءَ وَالْأَرْضَ وَمَا بَيْنَهُمَا لَاعِبِينَ",
    "لَوْ أَرَدْنَا أَن نَّتَّخِذَ لَهْوًا لَّاتَّخَذْنَاهُ مِن لَّدُنَّا إِن كُنَّا فَاعِلِينَ",
    "بَلْ نَقْذِفُ بِالْحَقِّ عَلَى الْبَاطِلِ فَيَدْمَغُهُ فَإِذَا هُوَ زَاهِقٌ ۚ وَلَكُمُ الْوَيْلُ مِمَّا تَصِفُونَ",
    "وَلَهُ مَن فِي السَّمَاوَاتِ وَالْأَرْضِ ۚ وَمَنْ عِندَهُ لَا يَسْتَكْبِرُونَ عَنْ عِبَادَتِهِ وَلَا يَسْتَحْسِرُونَ",
    "يُسَبِّحُونَ اللَّيْلَ وَالنَّهَارَ لَا يَفْتُرُونَ",
    "أَمِ اتَّخَذُوا آلِهَةً مِّنَ الْأَرْضِ هُمْ يُنشِرُونَ",
    "لَوْ كَانَ فِيهِمَا آلِهَةٌ إِلَّا اللَّهُ لَفَسَدَتَا ۚ فَسُبْحَانَ اللَّهِ رَبِّ الْعَرْشِ عَمَّا يَصِفُونَ",
    "لَا يُسْأَلُ عَمَّا يَفْعَلُ وَهُمْ يُسْأَلُونَ",
    "أَمِ اتَّخَذُوا مِن دُونِهِ آلِهَةً ۖ قُلْ هَاتُوا بُرْهَانَكُمْ ۖ هَٰذَا ذِكْرُ مَن مَّعِيَ وَذِكْرُ مَن قَبْلِي ۗ بَلْ أَكْثَرُهُمْ لَا يَعْلَمُونَ الْحَقَّ ۖ فَهُم مُّعْرِضُونَ",
    "وَمَا أَرْسَلْنَا مِن قَبْلِكَ مِن رَّسُولٍ إِلَّا نُوحِي إِلَيْهِ أَنَّهُ لَا إِلَٰهَ إِلَّا أَنَا فَاعْبُدُونِ",
    "وَقَالُوا اتَّخَذَ الرَّحْمَٰنُ وَلَدًا ۗ سُبْحَانَهُ ۚ بَلْ عِبَادٌ مُّكْرَمُونَ",
    "لَا يَسْبِقُونَهُ بِالْقَوْلِ وَهُم بِأَمْرِهِ يَعْمَلُونَ",
    "يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يَشْفَعُونَ إِلَّا لِمَنِ ارْتَضَىٰ وَهُم مِّنْ خَشْيَتِهِ مُشْفِقُونَ",
    "وَمَن يَقُلْ مِنْهُمْ إِنِّي إِلَٰهٌ مِّن دُونِهِ فَذَٰلِكَ نَجْزِيهِ جَهَنَّمَ ۚ كَذَٰلِكَ نَجْزِي الظَّالِمِينَ",
    "أَوَلَمْ يَرَ الَّذِينَ كَفَرُوا أَنَّ السَّمَاوَاتِ وَالْأَرْضَ كَانَتَا رَتْقًا فَفَتَقْنَاهُمَا ۖ وَجَعَلْنَا مِنَ الْمَاءِ كُلَّ شَيْءٍ حَيٍّ ۖ أَفَلَا يُؤْمِنُونَ",
    "وَجَعَلْنَا فِي الْأَرْضِ رَوَاسِيَ أَن تَمِيدَ بِهِمْ وَجَعَلْنَا فِيهَا فِجَاجًا سُبُلًا لَّعَلَّهُمْ يَهْتَدُونَ",
    "وَجَعَلْنَا السَّمَاءَ سَقْفًا مَّحْفُوظًا ۖ وَهُمْ عَنْ آيَاتِهَا مُعْرِضُونَ",
    "وَهُوَ الَّذِي خَلَقَ اللَّيْلَ وَالنَّهَارَ وَالشَّمْسَ وَالْقَمَرَ ۖ كُلٌّ فِي فَلَكٍ يَسْبَحُونَ",
    "وَمَا جَعَلْنَا لِبَشَرٍ مِّن قَبْلِكَ الْخُلْدَ ۖ أَفَإِن مِّتَّ فَهُمُ الْخَالِدُونَ",
    "كُلُّ نَفْسٍ ذَائِقَةُ الْمَوْتِ ۗ وَنَبْلُوكُم بِالشَّرِّ وَالْخَيْرِ فِتْنَةً ۖ وَإِلَيْنَا تُرْجَعُونَ",
    "وَإِذَا رَآكَ الَّذِينَ كَفَرُوا إِن يَتَّخِذُونَكَ إِلَّا هُزُوًا أَهَٰذَا الَّذِي يَذْكُرُ آلِهَتَكُمْ وَهُم بِذِكْرِ الرَّحْمَٰنِ هُمْ كَافِرُونَ",
    "خُلِقَ الْإِنسَانُ مِنْ عَجَلٍ ۚ سَأُرِيكُمْ آيَاتِي فَلَا تَسْتَعْجِلُونِ",
    "وَيَقُولُونَ مَتَىٰ هَٰذَا الْوَعْدُ إِن كُنتُمْ صَادِقِينَ",
    "لَوْ يَعْلَمُ الَّذِينَ كَفَرُوا حِينَ لَا يَكُفُّونَ عَن وُجُوهِهِمُ النَّارَ وَلَا عَن ظُهُورِهِمْ وَلَا هُمْ يُنصَرُونَ",
    "بَلْ تَأْتِيهِم بَغْتَةً فَتَبْهَتُهُمْ فَلَا يَسْتَطِيعُونَ رَدَّهَا وَلَا هُمْ يُنظَرُونَ",
    "وَلَقَدِ اسْتُهْزِئَ بِرُسُلٍ مِّن قَبْلِكَ فَحَاقَ بِالَّذِينَ سَخِرُوا مِنْهُم مَّا كَانُوا بِهِ يَسْتَهْزِئُونَ",
    "قُلْ مَن يَكْلَؤُكُم بِاللَّيْلِ وَالنَّهَارِ مِنَ الرَّحْمَٰنِ ۗ بَلْ هُمْ عَن ذِكْرِ رَبِّهِم مُّعْرِضُونَ",
    "أَمْ لَهُمْ آلِهَةٌ تَمْنَعُهُم مِّن دُونِنَا ۚ لَا يَسْتَطِيعُونَ نَصْرَ أَنفُسِهِمْ وَلَا هُم مِّنَّا يُصْحَبُونَ",
    "بَلْ مَتَّعْنَا هَٰؤُلَاءِ وَآبَاءَهُمْ حَتَّىٰ طَالَ عَلَيْهِمُ الْعُمُرُ ۗ أَفَلَا يَرَوْنَ أَنَّا نَأْتِي الْأَرْضَ نَنقُصُهَا مِنْ أَطْرَافِهَا ۚ أَفَهُمُ الْغَالِبُونَ",
    "قُلْ إِنَّمَا أُنذِرُكُم بِالْوَحْيِ ۚ وَلَا يَسْمَعُ الصُّمُّ الدُّعَاءَ إِذَا مَا يُنذَرُونَ",
    "وَلَئِن مَّسَّتْهُمْ نَفْحَةٌ مِّنْ عَذَابِ رَبِّكَ لَيَقُولُنَّ يَا وَيْلَنَا إِنَّا كُنَّا ظَالِمِينَ",
    "وَنَضَعُ الْمَوَازِينَ الْقِسْطَ لِيَوْمِ الْقِيَامَةِ فَلَا تُظْلَمُ نَفْسٌ شَيْئًا ۖ وَإِن كَانَ مِثْقَالَ حَبَّةٍ مِّنْ خَرْدَلٍ أَتَيْنَا بِهَا ۗ وَكَفَىٰ بِنَا حَاسِبِينَ",
    "وَلَقَدْ آتَيْنَا مُوسَىٰ وَهَارُونَ الْفُرْقَانَ وَضِيَاءً وَذِكْرًا لِّلْمُتَّقِينَ",
    "الَّذِينَ يَخْشَوْنَ رَبَّهُم بِالْغَيْبِ وَهُم مِّنَ السَّاعَةِ مُشْفِقُونَ",
    "وَهَٰذَا ذِكْرٌ مُّبَارَكٌ أَنزَلْنَاهُ ۚ أَفَأَنتُمْ لَهُ مُنكِرُونَ",
    "وَلَقَدْ آتَيْنَا إِبْرَاهِيمَ رُشْدَهُ مِن قَبْلُ وَكُنَّا بِهِ عَالِمِينَ",
    "إِذْ قَالَ لِأَبِيهِ وَقَوْمِهِ مَا هَٰذِهِ التَّمَاثِيلُ الَّتِي أَنتُمْ لَهَا عَاكِفُونَ",
    "قَالُوا وَجَدْنَا آبَاءَنَا لَهَا عَابِدِينَ",
    "قَالَ لَقَدْ كُنتُمْ أَنتُمْ وَآبَاؤُكُمْ فِي ضَلَالٍ مُّبِينٍ",
    "قَالُوا أَجِئْتَنَا بِالْحَقِّ أَمْ أَنتَ مِنَ اللَّاعِبِينَ",
    "قَالَ بَل رَّبُّكُمْ رَبُّ السَّمَاوَاتِ وَالْأَرْضِ الَّذِي فَطَرَهُنَّ وَأَنَا عَلَىٰ ذَٰلِكُم مِّنَ الشَّاهِدِينَ",
    "وَتَاللَّهِ لَأَكِيدَنَّ أَصْنَامَكُم بَعْدَ أَن تُوَلُّوا مُدْبِرِينَ",
    "فَجَعَلَهُمْ جُذَاذًا إِلَّا كَبِيرًا لَّهُمْ لَعَلَّهُمْ إِلَيْهِ يَرْجِعُونَ",
    "قَالُوا مَن فَعَلَ هَٰذَا بِآلِهَتِنَا إِنَّهُ لَمِنَ الظَّالِمِينَ",
    "قَالُوا سَمِعْنَا فَتًى يَذْكُرُهُمْ يُقَالُ لَهُ إِبْرَاهِيمُ",
    "قَالُوا فَأْتُوا بِهِ عَلَىٰ أَعْيُنِ النَّاسِ لَعَلَّهُمْ يَشْهَدُونَ",
    "قَالُوا أَأَنتَ فَعَلْتَ هَٰذَا بِآلِهَتِنَا يَا إِبْرَاهِيمُ",
    "قَالَ بَلْ فَعَلَهُ كَبِيرُهُمْ هَٰذَا فَاسْأَلُوهُمْ إِن كَانُوا يَنطِقُونَ",
    "فَرَجَعُوا إِلَىٰ أَنفُسِهِمْ فَقَالُوا إِنَّكُمْ أَنتُمُ الظَّالِمُونَ",
    "ثُمَّ نُكِسُوا عَلَىٰ رُءُوسِهِمْ لَقَدْ عَلِمْتَ مَا هَٰؤُلَاءِ يَنطِقُونَ",
    "قَالَ أَفَتَعْبُدُونَ مِن دُونِ اللَّهِ مَا لَا يَنفَعُكُمْ شَيْئًا وَلَا يَضُرُّكُمْ",
    "أُفٍّ لَّكُمْ وَلِمَا تَعْبُدُونَ مِن دُونِ اللَّهِ ۖ أَفَلَا تَعْقِلُونَ",
    "قَالُوا حَرِّقُوهُ وَانصُرُوا آلِهَتَكُمْ إِن كُنتُمْ فَاعِلِينَ",
    "قُلْنَا يَا نَارُ كُونِي بَرْدًا وَسَلَامًا عَلَىٰ إِبْرَاهِيمَ",
    "وَأَرَادُوا بِهِ كَيْدًا فَجَعَلْنَاهُمُ الْأَخْسَرِينَ",
    "وَنَجَّيْنَاهُ وَلُوطًا إِلَى الْأَرْضِ الَّتِي بَارَكْنَا فِيهَا لِلْعَالَمِينَ",
    "وَوَهَبْنَا لَهُ إِسْحَاقَ وَيَعْقُوبَ نَافِلَةً ۖ وَكُلًّا جَعَلْنَا صَالِحِينَ",
    "وَجَعَلْنَاهُمْ أَئِمَّةً يَهْدُونَ بِأَمْرِنَا وَأَوْحَيْنَا إِلَيْهِمْ فِعْلَ الْخَيْرَاتِ وَإِقَامَ الصَّلَاةِ وَإِيتَاءَ الزَّكَاةِ ۖ وَكَانُوا لَنَا عَابِدِينَ",
    "وَلُوطًا آتَيْنَاهُ حُكْمًا وَعِلْمًا وَنَجَّيْنَاهُ مِنَ الْقَرْيَةِ الَّتِي كَانَت تَّعْمَلُ الْخَبَائِثَ ۗ إِنَّهُمْ كَانُوا قَوْمَ سَوْءٍ فَاسِقِينَ",
    "وَأَدْخَلْنَاهُ فِي رَحْمَتِنَا ۖ إِنَّهُ مِنَ الصَّالِحِينَ",
    "وَنُوحًا إِذْ نَادَىٰ مِن قَبْلُ فَاسْتَجَبْنَا لَهُ فَنَجَّيْنَاهُ وَأَهْلَهُ مِنَ الْكَرْبِ الْعَظِيمِ",
    "وَنَصَرْنَاهُ مِنَ الْقَوْمِ الَّذِينَ كَذَّبُوا بِآيَاتِنَا ۚ إِنَّهُمْ كَانُوا قَوْمَ سَوْءٍ فَأَغْرَقْنَاهُمْ أَجْمَعِينَ",
    "وَدَاوُودَ وَسُلَيْمَانَ إِذْ يَحْكُمَانِ فِي الْحَرْثِ إِذْ نَفَشَتْ فِيهِ غَنَمُ الْقَوْمِ وَكُنَّا لِحُكْمِهِمْ شَاهِدِينَ",
    "فَفَهَّمْنَاهَا سُلَيْمَانَ ۚ وَكُلًّا آتَيْنَا حُكْمًا وَعِلْمًا ۚ وَسَخَّرْنَا مَعَ دَاوُودَ الْجِبَالَ يُسَبِّحْنَ وَالطَّيْرَ ۚ وَكُنَّا فَاعِلِينَ",
    "وَعَلَّمْنَاهُ صَنْعَةَ لَبُوسٍ لَّكُمْ لِتُحْصِنَكُم مِّن بَأْسِكُمْ ۖ فَهَلْ أَنتُمْ شَاكِرُونَ",
    "وَلِسُلَيْمَانَ الرِّيحَ عَاصِفَةً تَجْرِي بِأَمْرِهِ إِلَى الْأَرْضِ الَّتِي بَارَكْنَا فِيهَا ۚ وَكُنَّا بِكُلِّ شَيْءٍ عَالِمِينَ",
    "وَمِنَ الشَّيَاطِينِ مَن يَغُوصُونَ لَهُ وَيَعْمَلُونَ عَمَلًا دُونَ ذَٰلِكَ ۖ وَكُنَّا لَهُمْ حَافِظِينَ",
    "وَأَيُّوبَ إِذْ نَادَىٰ رَبَّهُ أَنِّي مَسَّنِيَ الضُّرُّ وَأَنتَ أَرْحَمُ الرَّاحِمِينَ",
    "فَاسْتَجَبْنَا لَهُ فَكَشَفْنَا مَا بِهِ مِن ضُرٍّ ۖ وَآتَيْنَاهُ أَهْلَهُ وَمِثْلَهُم مَّعَهُمْ رَحْمَةً مِّنْ عِندِنَا وَذِكْرَىٰ لِلْعَابِدِينَ",
    "وَإِسْمَاعِيلَ وَإِدْرِيسَ وَذَا الْكِفْلِ ۖ كُلٌّ مِّنَ الصَّابِرِينَ",
    "وَأَدْخَلْنَاهُمْ فِي رَحْمَتِنَا ۖ إِنَّهُم مِّنَ الصَّالِحِينَ",
    "وَذَا النُّونِ إِذ ذَّهَبَ مُغَاضِبًا فَظَنَّ أَن لَّن نَّقْدِرَ عَلَيْهِ فَنَادَىٰ فِي الظُّلُمَاتِ أَن لَّا إِلَٰهَ إِلَّا أَنتَ سُبْحَانَكَ إِنِّي كُنتُ مِنَ الظَّالِمِينَ",
    "فَاسْتَجَبْنَا لَهُ وَنَجَّيْنَاهُ مِنَ الْغَمِّ ۚ وَكَذَٰلِكَ نُنجِي الْمُؤْمِنِينَ",
    "وَزَكَرِيَّا إِذْ نَادَىٰ رَبَّهُ رَبِّ لَا تَذَرْنِي فَرْدًا وَأَنتَ خَيْرُ الْوَارِثِينَ",
    "فَاسْتَجَبْنَا لَهُ وَوَهَبْنَا لَهُ يَحْيَىٰ وَأَصْلَحْنَا لَهُ زَوْجَهُ ۚ إِنَّهُمْ كَانُوا يُسَارِعُونَ فِي الْخَيْرَاتِ وَيَدْعُونَنَا رَغَبًا وَرَهَبًا ۖ وَكَانُوا لَنَا خَاشِعِينَ",
    "وَالَّتِي أَحْصَنَتْ فَرْجَهَا فَنَفَخْنَا فِيهَا مِن رُّوحِنَا وَجَعَلْنَاهَا وَابْنَهَا آيَةً لِّلْعَالَمِينَ",
    "إِنَّ هَٰذِهِ أُمَّتُكُمْ أُمَّةً وَاحِدَةً وَأَنَا رَبُّكُمْ فَاعْبُدُونِ",
    "وَتَقَطَّعُوا أَمْرَهُم بَيْنَهُمْ ۖ كُلٌّ إِلَيْنَا رَاجِعُونَ",
    "فَمَن يَعْمَلْ مِنَ الصَّالِحَاتِ وَهُوَ مُؤْمِنٌ فَلَا كُفْرَانَ لِسَعْيِهِ وَإِنَّا لَهُ كَاتِبُونَ",
    "وَحَرَامٌ عَلَىٰ قَرْيَةٍ أَهْلَكْنَاهَا أَنَّهُمْ لَا يَرْجِعُونَ",
    "حَتَّىٰ إِذَا فُتِحَتْ يَأْجُوجُ وَمَأْجُوجُ وَهُم مِّن كُلِّ حَدَبٍ يَنسِلُونَ",
    "وَاقْتَرَبَ الْوَعْدُ الْحَقُّ فَإِذَا هِيَ شَاخِصَةٌ أَبْصَارُ الَّذِينَ كَفَرُوا يَا وَيْلَنَا قَدْ كُنَّا فِي غَفْلَةٍ مِّنْ هَٰذَا بَلْ كُنَّا ظَالِمِينَ",
    "إِنَّكُمْ وَمَا تَعْبُدُونَ مِن دُونِ اللَّهِ حَصَبُ جَهَنَّمَ أَنتُمْ لَهَا وَارِدُونَ",
    "لَوْ كَانَ هَٰؤُلَاءِ آلِهَةً مَّا وَرَدُوهَا ۖ وَكُلٌّ فِيهَا خَالِدُونَ",
    "لَهُمْ فِيهَا زَفِيرٌ وَهُمْ فِيهَا لَا يَسْمَعُونَ",
    "إِنَّ الَّذِينَ سَبَقَتْ لَهُم مِّنَّا الْحُسْنَىٰ أُولَٰئِكَ عَنْهَا مُبْعَدُونَ",
    "لَا يَسْمَعُونَ حَسِيسَهَا ۖ وَهُمْ فِي مَا اشْتَهَتْ أَنفُسُهُمْ خَالِدُونَ",
    "لَا يَحْزُنُهُمُ الْفَزَعُ الْأَكْبَرُ وَتَتَلَقَّاهُمُ الْمَلَائِكَةُ هَٰذَا يَوْمُكُمُ الَّذِي كُنتُمْ تُوعَدُونَ",
    "يَوْمَ نَطْوِي السَّمَاءَ كَطَيِّ السِّجِلِّ لِلْكُتُبِ ۚ كَمَا بَدَأْنَا أَوَّلَ خَلْقٍ نُّعِيدُهُ ۚ وَعْدًا عَلَيْنَا ۚ إِنَّا كُنَّا فَاعِلِينَ",
    "وَلَقَدْ كَتَبْنَا فِي الزَّبُورِ مِن بَعْدِ الذِّكْرِ أَنَّ الْأَرْضَ يَرِثُهَا عِبَادِيَ الصَّالِحُونَ",
    "إِنَّ فِي هَٰذَا لَبَلَاغًا لِّقَوْمٍ عَابِدِينَ",
    "وَمَا أَرْسَلْنَاكَ إِلَّا رَحْمَةً لِّلْعَالَمِينَ",
    "قُلْ إِنَّمَا يُوحَىٰ إِلَيَّ أَنَّمَا إِلَٰهُكُمْ إِلَٰهٌ وَاحِدٌ ۖ فَهَلْ أَنتُم مُّسْلِمُونَ",
    "فَإِن تَوَلَّوْا فَقُلْ آذَنتُكُمْ عَلَىٰ سَوَاءٍ ۖ وَإِنْ أَدْرِي أَقَرِيبٌ أَم بَعِيدٌ مَّا تُوعَدُونَ",
    "إِنَّهُ يَعْلَمُ الْجَهْرَ مِنَ الْقَوْلِ وَيَعْلَمُ مَا تَكْتُمُونَ",
    "وَإِنْ أَدْرِي لَعَلَّهُ فِتْنَةٌ لَّكُمْ وَمَتَاعٌ إِلَىٰ حِينٍ",
    "قَالَ رَبِّ احْكُم بِالْحَقِّ ۗ وَرَبُّنَا الرَّحْمَٰنُ الْمُسْتَعَانُ عَلَىٰ مَا تَصِفُونَ"};

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
            "Sahih International", "Sahih International"};

    String [] english_verses = {"[The time of] their account has approached for the people, while they are in heedlessness turning away.",
    "No mention comes to them anew from their Lord except that they listen to it while they are at play",
    "With their hearts distracted. And those who do wrong conceal their private conversation, [saying], \"Is this [Prophet] except a human being like you? So would you approach magic while you are aware [of it]?\"",
    "The Prophet said, \"My Lord knows whatever is said throughout the heaven and earth, and He is the Hearing, the Knowing.\"",
    "But they say, \"[The revelation is but] a mixture of false dreams; rather, he has invented it; rather, he is a poet. So let him bring us a sign just as the previous [messengers] were sent [with miracles].\"",
    "Not a [single] city which We destroyed believed before them, so will they believe?",
    "And We sent not before you, [O Muhammad], except men to whom We revealed [the message], so ask the people of the message if you do not know.",
    "And We did not make the prophets forms not eating food, nor were they immortal [on earth].",
    "Then We fulfilled for them the promise, and We saved them and whom We willed and destroyed the transgressors.",
    "We have certainly sent down to you a Book in which is your mention. Then will you not reason?",
    "And how many a city which was unjust have We shattered and produced after it another people.",
    "And when its inhabitants perceived Our punishment, at once they fled from it.",
    "[Some angels said], \"Do not flee but return to where you were given luxury and to your homes - perhaps you will be questioned.\"",
    "They said, \"O woe to us! Indeed, we were wrongdoers.\"",
    "And that declaration of theirs did not cease until We made them [as] a harvest [mowed down], extinguished [like a fire].",
    "And We did not create the heaven and earth and that between them in play.",
    "Had We intended to take a diversion, We could have taken it from [what is] with Us - if [indeed] We were to do so.",
    "Rather, We dash the truth upon falsehood, and it destroys it, and thereupon it departs. And for you is destruction from that which you describe.",
    "To Him belongs whoever is in the heavens and the earth. And those near Him are not prevented by arrogance from His worship, nor do they tire.",
    "They exalt [Him] night and day [and] do not slacken.",
    "Or have men taken for themselves gods from the earth who resurrect [the dead]?",
    "Had there been within the heavens and earth gods besides Allah, they both would have been ruined. So exalted is Allah, Lord of the Throne, above what they describe.",
    "He is not questioned about what He does, but they will be questioned.",
    "Or have they taken gods besides Him? Say, [O Muhammad], \"Produce your proof. This [Qur'an] is the message for those with me and the message of those before me.\" But most of them do not know the truth, so they are turning away.",
    "And We sent not before you any messenger except that We revealed to him that, \"There is no deity except Me, so worship Me.\"",
    "And they say, \"The Most Merciful has taken a son.\" Exalted is He! Rather, they are [but] honored servants.",
    "They cannot precede Him in word, and they act by His command.",
    "He knows what is [presently] before them and what will be after them, and they cannot intercede except on behalf of one whom He approves. And they, from fear of Him, are apprehensive.",
    "And whoever of them should say, \"Indeed, I am a god besides Him\"- that one We would recompense with Hell. Thus do We recompense the wrongdoers.",
    "Have those who disbelieved not considered that the heavens and the earth were a joined entity, and We separated them and made from water every living thing? Then will they not believe?",
    "And We placed within the earth firmly set mountains, lest it should shift with them, and We made therein [mountain] passes [as] roads that they might be guided.",
    "And We made the sky a protected ceiling, but they, from its signs, are turning away.",
    "And it is He who created the night and the day and the sun and the moon; all [heavenly bodies] in an orbit are swimming.",
    "And We did not grant to any man before you eternity [on earth]; so if you die - would they be eternal?",
    "Every soul will taste death. And We test you with evil and with good as trial; and to Us you will be returned.",
    "And when those who disbelieve see you, [O Muhammad], they take you not except in ridicule, [saying], \"Is this the one who insults your gods?\" And they are, at the mention of the Most Merciful, disbelievers.",
    "Man was created of haste. I will show you My signs, so do not impatiently urge Me.",
    "And they say, \"When is this promise, if you should be truthful?\"",
    "If those who disbelieved but knew the time when they will not avert the Fire from their faces or from their backs and they will not be aided...",
    "Rather, it will come to them unexpectedly and bewilder them, and they will not be able to repel it, nor will they be reprieved.",
    "And already were messengers ridiculed before you, but those who mocked them were enveloped by what they used to ridicule.",
    "Say, \"Who can protect you at night or by day from the Most Merciful?\" But they are, from the remembrance of their Lord, turning away.",
    "Or do they have gods to defend them other than Us? They are unable [even] to help themselves, nor can they be protected from Us.",
    "But, [on the contrary], We have provided good things for these [disbelievers] and their fathers until life was prolonged for them. Then do they not see that We set upon the land, reducing it from its borders? So it is they who will overcome?",
    "Say, \"I only warn you by revelation.\" But the deaf do not hear the call when they are warned.",
    "And if [as much as] a whiff of the punishment of your Lord should touch them, they would surely say, \"O woe to us! Indeed, we have been wrongdoers.\"",
    "And We place the scales of justice for the Day of Resurrection, so no soul will be treated unjustly at all. And if there is [even] the weight of a mustard seed, We will bring it forth. And sufficient are We as accountant.",
    "And We had already given Moses and Aaron the criterion and a light and a reminder for the righteous",
    "Who fear their Lord unseen, while they are of the Hour apprehensive.",
    "And this [Qur'an] is a blessed message which We have sent down. Then are you with it unacquainted?",
    "And We had certainly given Abraham his sound judgement before, and We were of him well-Knowing",
    "When he said to his father and his people, \"What are these statues to which you are devoted?\"",
    "They said, \"We found our fathers worshippers of them.\"",
    "He said, \"You were certainly, you and your fathers, in manifest error.\"",
    "They said, \"Have you come to us with truth, or are you of those who jest?\"",
    "He said, \"[No], rather, your Lord is the Lord of the heavens and the earth who created them, and I, to that, am of those who testify.",
    "And [I swear] by Allah, I will surely plan against your idols after you have turned and gone away.\"",
    "So he made them into fragments, except a large one among them, that they might return to it [and question].",
    "They said, \"Who has done this to our gods? Indeed, he is of the wrongdoers.\"",
    "They said, \"We heard a young man mention them who is called Abraham.\"",
    "They said, \"Then bring him before the eyes of the people that they may testify.\"",
    "They said, \"Have you done this to our gods, O Abraham?\"",
    "He said, \"Rather, this - the largest of them - did it, so ask them, if they should [be able to] speak.\"",
    "So they returned to [blaming] themselves and said [to each other], \"Indeed, you are the wrongdoers.\"",
    "Then they reversed themselves, [saying], \"You have already known that these do not speak!\"",
    "He said, \"Then do you worship instead of Allah that which does not benefit you at all or harm you?",
    "Uff to you and to what you worship instead of Allah. Then will you not use reason?\"",
    "They said, \"Burn him and support your gods - if you are to act.\"",
    "Allah said, \"O fire, be coolness and safety upon Abraham.\"",
    "And they intended for him harm, but We made them the greatest losers.",
    "And We delivered him and Lot to the land which We had blessed for the worlds.",
    "And We gave him Isaac and Jacob in addition, and all [of them] We made righteous.",
    "And We made them leaders guiding by Our command. And We inspired to them the doing of good deeds, establishment of prayer, and giving of zakah; and they were worshippers of Us.",
    "And to Lot We gave judgement and knowledge, and We saved him from the city that was committing wicked deeds. Indeed, they were a people of evil, defiantly disobedient.",
    "And We admitted him into Our mercy. Indeed, he was of the righteous.",
    "And [mention] Noah, when he called [to Allah] before [that time], so We responded to him and saved him and his family from the great flood.",
    "And We saved him from the people who denied Our signs. Indeed, they were a people of evil, so We drowned them, all together.",
    "And [mention] David and Solomon, when they judged concerning the field - when the sheep of a people overran it [at night], and We were witness to their judgement.",
    "And We gave understanding of the case to Solomon, and to each [of them] We gave judgement and knowledge. And We subjected the mountains to exalt [Us], along with David and [also] the birds. And We were doing [that].",
    "And We taught him the fashioning of coats of armor to protect you from your [enemy in] battle. So will you then be grateful?",
    "And to Solomon [We subjected] the wind, blowing forcefully, proceeding by his command toward the land which We had blessed. And We are ever, of all things, Knowing.",
    "And of the devils were those who dived for him and did work other than that. And We were of them a guardian.",
    "And [mention] Job, when he called to his Lord, \"Indeed, adversity has touched me, and you are the Most Merciful of the merciful.\"",
    "So We responded to him and removed what afflicted him of adversity. And We gave him [back] his family and the like thereof with them as mercy from Us and a reminder for the worshippers [of Allah].",
    "And [mention] Ishmael and Idrees and Dhul-Kifl; all were of the patient.",
    "And We admitted them into Our mercy. Indeed, they were of the righteous.",
    "And [mention] the man of the fish, when he went off in anger and thought that We would not decree [anything] upon him. And he called out within the darknesses, \"There is no deity except You; exalted are You. Indeed, I have been of the wrongdoers.\"",
    "So We responded to him and saved him from the distress. And thus do We save the believers.",
    "And [mention] Zechariah, when he called to his Lord, \"My Lord, do not leave me alone [with no heir], while you are the best of inheritors.\"",
    "So We responded to him, and We gave to him John, and amended for him his wife. Indeed, they used to hasten to good deeds and supplicate Us in hope and fear, and they were to Us humbly submissive.",
    "And [mention] the one who guarded her chastity, so We blew into her [garment] through Our angel [Gabriel], and We made her and her son a sign for the worlds.",
    "Indeed this, your religion, is one religion, and I am your Lord, so worship Me.",
    "And [yet] they divided their affair among themselves, [but] all to Us will return.",
    "So whoever does righteous deeds while he is a believer - no denial will there be for his effort, and indeed We, of it, are recorders.",
    "And there is prohibition upon [the people of] a city which We have destroyed that they will [ever] return",
    "Until when [the dam of] Gog and Magog has been opened and they, from every elevation, descend",
    "And [when] the true promise has approached; then suddenly the eyes of those who disbelieved will be staring [in horror, while they say], \"O woe to us; we had been unmindful of this; rather, we were wrongdoers.\"",
    "Indeed, you [disbelievers] and what you worship other than Allah are the firewood of Hell. You will be coming to [enter] it.",
    "Had these [false deities] been [actual] gods, they would not have come to it, but all are eternal therein.",
    "For them therein is heavy sighing, and they therein will not hear.",
    "Indeed, those for whom the best [reward] has preceded from Us - they are from it far removed.",
    "They will not hear its sound, while they are, in that which their souls desire, abiding eternally.",
    "They will not be grieved by the greatest terror, and the angels will meet them, [saying], \"This is your Day which you have been promised\" -",
    "The Day when We will fold the heaven like the folding of a [written] sheet for the records. As We began the first creation, We will repeat it. [That is] a promise binding upon Us. Indeed, We will do it.",
    "And We have already written in the book [of Psalms] after the [previous] mention that the land [of Paradise] is inherited by My righteous servants.",
    "Indeed, in this [Qur'an] is notification for a worshipping people.",
    "And We have not sent you, [O Muhammad], except as a mercy to the worlds.",
    "Say, \"It is only revealed to me that your god is but one God; so will you be Muslims [in submission to Him]?\"",
    "But if they turn away, then say, \"I have announced to [all of] you equally. And I know not whether near or far is that which you are promised.",
    "Indeed, He knows what is declared of speech, and He knows what you conceal.",
    "And I know not; perhaps it is a trial for you and enjoyment for a time.\"",
    "[The Prophet] has said, \"My Lord, judge [between us] in truth. And our Lord is the Most Merciful, the one whose help is sought against that which you describe.\""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__anbya);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_anbya);
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
