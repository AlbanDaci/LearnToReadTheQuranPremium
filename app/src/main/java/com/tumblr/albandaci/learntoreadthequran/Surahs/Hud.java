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

public class Hud extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "http://download.audioislam.com/audio/quran/recitation/al-afaasee/surah_hud.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"11:1", "11:2", "11:3", "11:4", "11:5", "11:6", "11:7", "11:8", "11:9", "11:10", "11:11", "11:12", "11:13", "11:14", "11:15", "11:16",
            "11:17", "11:18", "11:19", "11:20", "11:21", "11:22", "11:23", "11:24", "11:25", "11:26", "11:27", "11:28", "11:29", "11:30", "11:31", "11:32",
            "11:33", "11:34", "11:35", "11:36", "11:37", "11:38", "11:39", "11:40", "11:41", "11:42", "11:43", "11:44", "11:45", "11:46", "11:47", "11:48",
            "11:49", "11:50", "11:51", "11:52", "11:53", "11:54", "11:55", "11:56", "11:57", "11:58", "11:59", "11:60", "11:61", "11:62", "11:63", "11:64",
            "11:65", "11:66", "11:67", "11:68", "11:69", "11:70", "11:71", "11:72", "11:73", "11:74", "11:75", "11:76", "11:77", "11:78", "11:79", "11:80",
            "11:81", "11:82", "11:83", "11:84", "11:85", "11:86", "11:87", "11:88", "11:89", "11:90", "11:91", "11:92", "11:93", "11:94", "11:95", "11:96",
            "11:97", "11:98", "11:99", "11:100", "11:101", "11:102", "11:103", "11:104", "11:105", "11:106", "11:107", "11:108", "11:109", "11:110", "11:111", "11:112",
            "11:113", "11:114", "11:115", "11:116", "11:117", "11:118", "11:119", "11:120", "11:121", "11:122", "11:123"};

    String [] arabic_verses = {"الر ۚ كِتَابٌ أُحْكِمَتْ آيَاتُهُ ثُمَّ فُصِّلَتْ مِن لَّدُنْ حَكِيمٍ خَبِيرٍ",
    "أَلَّا تَعْبُدُوا إِلَّا اللَّهَ ۚ إِنَّنِي لَكُم مِّنْهُ نَذِيرٌ وَبَشِيرٌ",
    "وَأَنِ اسْتَغْفِرُوا رَبَّكُمْ ثُمَّ تُوبُوا إِلَيْهِ يُمَتِّعْكُم مَّتَاعًا حَسَنًا إِلَىٰ أَجَلٍ مُّسَمًّى وَيُؤْتِ كُلَّ ذِي فَضْلٍ فَضْلَهُ ۖ وَإِن تَوَلَّوْا فَإِنِّي أَخَافُ عَلَيْكُمْ عَذَابَ يَوْمٍ كَبِيرٍ",
    "إِلَى اللَّهِ مَرْجِعُكُمْ ۖ وَهُوَ عَلَىٰ كُلِّ شَيْءٍ قَدِيرٌ",
    "أَلَا إِنَّهُمْ يَثْنُونَ صُدُورَهُمْ لِيَسْتَخْفُوا مِنْهُ ۚ أَلَا حِينَ يَسْتَغْشُونَ ثِيَابَهُمْ يَعْلَمُ مَا يُسِرُّونَ وَمَا يُعْلِنُونَ ۚ إِنَّهُ عَلِيمٌ بِذَاتِ الصُّدُورِ",
    "وَمَا مِن دَابَّةٍ فِي الْأَرْضِ إِلَّا عَلَى اللَّهِ رِزْقُهَا وَيَعْلَمُ مُسْتَقَرَّهَا وَمُسْتَوْدَعَهَا ۚ كُلٌّ فِي كِتَابٍ مُّبِينٍ",
    "وَهُوَ الَّذِي خَلَقَ السَّمَاوَاتِ وَالْأَرْضَ فِي سِتَّةِ أَيَّامٍ وَكَانَ عَرْشُهُ عَلَى الْمَاءِ لِيَبْلُوَكُمْ أَيُّكُمْ أَحْسَنُ عَمَلًا ۗ وَلَئِن قُلْتَ إِنَّكُم مَّبْعُوثُونَ مِن بَعْدِ الْمَوْتِ لَيَقُولَنَّ الَّذِينَ كَفَرُوا إِنْ هَٰذَا إِلَّا سِحْرٌ مُّبِينٌ",
    "وَلَئِنْ أَخَّرْنَا عَنْهُمُ الْعَذَابَ إِلَىٰ أُمَّةٍ مَّعْدُودَةٍ لَّيَقُولُنَّ مَا يَحْبِسُهُ ۗ أَلَا يَوْمَ يَأْتِيهِمْ لَيْسَ مَصْرُوفًا عَنْهُمْ وَحَاقَ بِهِم مَّا كَانُوا بِهِ يَسْتَهْزِئُونَ",
    "وَلَئِنْ أَذَقْنَا الْإِنسَانَ مِنَّا رَحْمَةً ثُمَّ نَزَعْنَاهَا مِنْهُ إِنَّهُ لَيَئُوسٌ كَفُورٌ",
    "وَلَئِنْ أَذَقْنَاهُ نَعْمَاءَ بَعْدَ ضَرَّاءَ مَسَّتْهُ لَيَقُولَنَّ ذَهَبَ السَّيِّئَاتُ عَنِّي ۚ إِنَّهُ لَفَرِحٌ فَخُورٌ",
    "إِلَّا الَّذِينَ صَبَرُوا وَعَمِلُوا الصَّالِحَاتِ أُولَٰئِكَ لَهُم مَّغْفِرَةٌ وَأَجْرٌ كَبِيرٌ",
    "فَلَعَلَّكَ تَارِكٌ بَعْضَ مَا يُوحَىٰ إِلَيْكَ وَضَائِقٌ بِهِ صَدْرُكَ أَن يَقُولُوا لَوْلَا أُنزِلَ عَلَيْهِ كَنزٌ أَوْ جَاءَ مَعَهُ مَلَكٌ ۚ إِنَّمَا أَنتَ نَذِيرٌ ۚ وَاللَّهُ عَلَىٰ كُلِّ شَيْءٍ وَكِيلٌ",
    "أَمْ يَقُولُونَ افْتَرَاهُ ۖ قُلْ فَأْتُوا بِعَشْرِ سُوَرٍ مِّثْلِهِ مُفْتَرَيَاتٍ وَادْعُوا مَنِ اسْتَطَعْتُم مِّن دُونِ اللَّهِ إِن كُنتُمْ صَادِقِينَ",
    "فَإِلَّمْ يَسْتَجِيبُوا لَكُمْ فَاعْلَمُوا أَنَّمَا أُنزِلَ بِعِلْمِ اللَّهِ وَأَن لَّا إِلَٰهَ إِلَّا هُوَ ۖ فَهَلْ أَنتُم مُّسْلِمُونَ",
    "مَن كَانَ يُرِيدُ الْحَيَاةَ الدُّنْيَا وَزِينَتَهَا نُوَفِّ إِلَيْهِمْ أَعْمَالَهُمْ فِيهَا وَهُمْ فِيهَا لَا يُبْخَسُونَ",
    "أُولَٰئِكَ الَّذِينَ لَيْسَ لَهُمْ فِي الْآخِرَةِ إِلَّا النَّارُ ۖ وَحَبِطَ مَا صَنَعُوا فِيهَا وَبَاطِلٌ مَّا كَانُوا يَعْمَلُونَ",
    "أَفَمَن كَانَ عَلَىٰ بَيِّنَةٍ مِّن رَّبِّهِ وَيَتْلُوهُ شَاهِدٌ مِّنْهُ وَمِن قَبْلِهِ كِتَابُ مُوسَىٰ إِمَامًا وَرَحْمَةً ۚ أُولَٰئِكَ يُؤْمِنُونَ بِهِ ۚ وَمَن يَكْفُرْ بِهِ مِنَ الْأَحْزَابِ فَالنَّارُ مَوْعِدُهُ ۚ فَلَا تَكُ فِي مِرْيَةٍ مِّنْهُ ۚ إِنَّهُ الْحَقُّ مِن رَّبِّكَ وَلَٰكِنَّ أَكْثَرَ النَّاسِ لَا يُؤْمِنُونَ",
    "وَمَنْ أَظْلَمُ مِمَّنِ افْتَرَىٰ عَلَى اللَّهِ كَذِبًا ۚ أُولَٰئِكَ يُعْرَضُونَ عَلَىٰ رَبِّهِمْ وَيَقُولُ الْأَشْهَادُ هَٰؤُلَاءِ الَّذِينَ كَذَبُوا عَلَىٰ رَبِّهِمْ ۚ أَلَا لَعْنَةُ اللَّهِ عَلَى الظَّالِمِينَ",
    "الَّذِينَ يَصُدُّونَ عَن سَبِيلِ اللَّهِ وَيَبْغُونَهَا عِوَجًا وَهُم بِالْآخِرَةِ هُمْ كَافِرُونَ",
    "أُولَٰئِكَ لَمْ يَكُونُوا مُعْجِزِينَ فِي الْأَرْضِ وَمَا كَانَ لَهُم مِّن دُونِ اللَّهِ مِنْ أَوْلِيَاءَ ۘ يُضَاعَفُ لَهُمُ الْعَذَابُ ۚ مَا كَانُوا يَسْتَطِيعُونَ السَّمْعَ وَمَا كَانُوا يُبْصِرُونَ",
    "أُولَٰئِكَ الَّذِينَ خَسِرُوا أَنفُسَهُمْ وَضَلَّ عَنْهُم مَّا كَانُوا يَفْتَرُونَ",
    "لَا جَرَمَ أَنَّهُمْ فِي الْآخِرَةِ هُمُ الْأَخْسَرُونَ",
    "إِنَّ الَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ وَأَخْبَتُوا إِلَىٰ رَبِّهِمْ أُولَٰئِكَ أَصْحَابُ الْجَنَّةِ ۖ هُمْ فِيهَا خَالِدُونَ",
    "مَثَلُ الْفَرِيقَيْنِ كَالْأَعْمَىٰ وَالْأَصَمِّ وَالْبَصِيرِ وَالسَّمِيعِ ۚ هَلْ يَسْتَوِيَانِ مَثَلًا ۚ أَفَلَا تَذَكَّرُونَ",
    "وَلَقَدْ أَرْسَلْنَا نُوحًا إِلَىٰ قَوْمِهِ إِنِّي لَكُمْ نَذِيرٌ مُّبِينٌ",
    "أَن لَّا تَعْبُدُوا إِلَّا اللَّهَ ۖ إِنِّي أَخَافُ عَلَيْكُمْ عَذَابَ يَوْمٍ أَلِيمٍ",
    "فَقَالَ الْمَلَأُ الَّذِينَ كَفَرُوا مِن قَوْمِهِ مَا نَرَاكَ إِلَّا بَشَرًا مِّثْلَنَا وَمَا نَرَاكَ اتَّبَعَكَ إِلَّا الَّذِينَ هُمْ أَرَاذِلُنَا بَادِيَ الرَّأْيِ وَمَا نَرَىٰ لَكُمْ عَلَيْنَا مِن فَضْلٍ بَلْ نَظُنُّكُمْ كَاذِبِينَ",
    "قَالَ يَا قَوْمِ أَرَأَيْتُمْ إِن كُنتُ عَلَىٰ بَيِّنَةٍ مِّن رَّبِّي وَآتَانِي رَحْمَةً مِّنْ عِندِهِ فَعُمِّيَتْ عَلَيْكُمْ أَنُلْزِمُكُمُوهَا وَأَنتُمْ لَهَا كَارِهُونَ",
    "وَيَا قَوْمِ لَا أَسْأَلُكُمْ عَلَيْهِ مَالًا ۖ إِنْ أَجْرِيَ إِلَّا عَلَى اللَّهِ ۚ وَمَا أَنَا بِطَارِدِ الَّذِينَ آمَنُوا ۚ إِنَّهُم مُّلَاقُو رَبِّهِمْ وَلَٰكِنِّي أَرَاكُمْ قَوْمًا تَجْهَلُونَ",
    "وَيَا قَوْمِ مَن يَنصُرُنِي مِنَ اللَّهِ إِن طَرَدتُّهُمْ ۚ أَفَلَا تَذَكَّرُونَ",
    "وَلَا أَقُولُ لَكُمْ عِندِي خَزَائِنُ اللَّهِ وَلَا أَعْلَمُ الْغَيْبَ وَلَا أَقُولُ إِنِّي مَلَكٌ وَلَا أَقُولُ لِلَّذِينَ تَزْدَرِي أَعْيُنُكُمْ لَن يُؤْتِيَهُمُ اللَّهُ خَيْرًا ۖ اللَّهُ أَعْلَمُ بِمَا فِي أَنفُسِهِمْ ۖ إِنِّي إِذًا لَّمِنَ الظَّالِمِينَ",
    "قَالُوا يَا نُوحُ قَدْ جَادَلْتَنَا فَأَكْثَرْتَ جِدَالَنَا فَأْتِنَا بِمَا تَعِدُنَا إِن كُنتَ مِنَ الصَّادِقِينَ",
    "قَالَ إِنَّمَا يَأْتِيكُم بِهِ اللَّهُ إِن شَاءَ وَمَا أَنتُم بِمُعْجِزِينَ",
    "وَلَا يَنفَعُكُمْ نُصْحِي إِنْ أَرَدتُّ أَنْ أَنصَحَ لَكُمْ إِن كَانَ اللَّهُ يُرِيدُ أَن يُغْوِيَكُمْ ۚ هُوَ رَبُّكُمْ وَإِلَيْهِ تُرْجَعُونَ",
    "أَمْ يَقُولُونَ افْتَرَاهُ ۖ قُلْ إِنِ افْتَرَيْتُهُ فَعَلَيَّ إِجْرَامِي وَأَنَا بَرِيءٌ مِّمَّا تُجْرِمُونَ",
    "وَأُوحِيَ إِلَىٰ نُوحٍ أَنَّهُ لَن يُؤْمِنَ مِن قَوْمِكَ إِلَّا مَن قَدْ آمَنَ فَلَا تَبْتَئِسْ بِمَا كَانُوا يَفْعَلُونَ",
    "وَاصْنَعِ الْفُلْكَ بِأَعْيُنِنَا وَوَحْيِنَا وَلَا تُخَاطِبْنِي فِي الَّذِينَ ظَلَمُوا ۚ إِنَّهُم مُّغْرَقُونَ",
    "وَيَصْنَعُ الْفُلْكَ وَكُلَّمَا مَرَّ عَلَيْهِ مَلَأٌ مِّن قَوْمِهِ سَخِرُوا مِنْهُ ۚ قَالَ إِن تَسْخَرُوا مِنَّا فَإِنَّا نَسْخَرُ مِنكُمْ كَمَا تَسْخَرُونَ",
    "فَسَوْفَ تَعْلَمُونَ مَن يَأْتِيهِ عَذَابٌ يُخْزِيهِ وَيَحِلُّ عَلَيْهِ عَذَابٌ مُّقِيمٌ",
    "حَتَّىٰ إِذَا جَاءَ أَمْرُنَا وَفَارَ التَّنُّورُ قُلْنَا احْمِلْ فِيهَا مِن كُلٍّ زَوْجَيْنِ اثْنَيْنِ وَأَهْلَكَ إِلَّا مَن سَبَقَ عَلَيْهِ الْقَوْلُ وَمَنْ آمَنَ ۚ وَمَا آمَنَ مَعَهُ إِلَّا قَلِيلٌ",
    "وَقَالَ ارْكَبُوا فِيهَا بِسْمِ اللَّهِ مَجْرَاهَا وَمُرْسَاهَا ۚ إِنَّ رَبِّي لَغَفُورٌ رَّحِيمٌ",
    "وَهِيَ تَجْرِي بِهِمْ فِي مَوْجٍ كَالْجِبَالِ وَنَادَىٰ نُوحٌ ابْنَهُ وَكَانَ فِي مَعْزِلٍ يَا بُنَيَّ ارْكَب مَّعَنَا وَلَا تَكُن مَّعَ الْكَافِرِينَ",
    "قَالَ سَآوِي إِلَىٰ جَبَلٍ يَعْصِمُنِي مِنَ الْمَاءِ ۚ قَالَ لَا عَاصِمَ الْيَوْمَ مِنْ أَمْرِ اللَّهِ إِلَّا مَن رَّحِمَ ۚ وَحَالَ بَيْنَهُمَا الْمَوْجُ فَكَانَ مِنَ الْمُغْرَقِينَ",
    "وَقِيلَ يَا أَرْضُ ابْلَعِي مَاءَكِ وَيَا سَمَاءُ أَقْلِعِي وَغِيضَ الْمَاءُ وَقُضِيَ الْأَمْرُ وَاسْتَوَتْ عَلَى الْجُودِيِّ ۖ وَقِيلَ بُعْدًا لِّلْقَوْمِ الظَّالِمِينَ",
    "وَنَادَىٰ نُوحٌ رَّبَّهُ فَقَالَ رَبِّ إِنَّ ابْنِي مِنْ أَهْلِي وَإِنَّ وَعْدَكَ الْحَقُّ وَأَنتَ أَحْكَمُ الْحَاكِمِينَ",
    "قَالَ يَا نُوحُ إِنَّهُ لَيْسَ مِنْ أَهْلِكَ ۖ إِنَّهُ عَمَلٌ غَيْرُ صَالِحٍ ۖ فَلَا تَسْأَلْنِ مَا لَيْسَ لَكَ بِهِ عِلْمٌ ۖ إِنِّي أَعِظُكَ أَن تَكُونَ مِنَ الْجَاهِلِينَ",
    "قَالَ رَبِّ إِنِّي أَعُوذُ بِكَ أَنْ أَسْأَلَكَ مَا لَيْسَ لِي بِهِ عِلْمٌ ۖ وَإِلَّا تَغْفِرْ لِي وَتَرْحَمْنِي أَكُن مِّنَ الْخَاسِرِينَ",
    "قِيلَ يَا نُوحُ اهْبِطْ بِسَلَامٍ مِّنَّا وَبَرَكَاتٍ عَلَيْكَ وَعَلَىٰ أُمَمٍ مِّمَّن مَّعَكَ ۚ وَأُمَمٌ سَنُمَتِّعُهُمْ ثُمَّ يَمَسُّهُم مِّنَّا عَذَابٌ أَلِيمٌ",
    "تِلْكَ مِنْ أَنبَاءِ الْغَيْبِ نُوحِيهَا إِلَيْكَ ۖ مَا كُنتَ تَعْلَمُهَا أَنتَ وَلَا قَوْمُكَ مِن قَبْلِ هَٰذَا ۖ فَاصْبِرْ ۖ إِنَّ الْعَاقِبَةَ لِلْمُتَّقِينَ",
    "وَإِلَىٰ عَادٍ أَخَاهُمْ هُودًا ۚ قَالَ يَا قَوْمِ اعْبُدُوا اللَّهَ مَا لَكُم مِّنْ إِلَٰهٍ غَيْرُهُ ۖ إِنْ أَنتُمْ إِلَّا مُفْتَرُونَ",
    "يَا قَوْمِ لَا أَسْأَلُكُمْ عَلَيْهِ أَجْرًا ۖ إِنْ أَجْرِيَ إِلَّا عَلَى الَّذِي فَطَرَنِي ۚ أَفَلَا تَعْقِلُونَ",
    "وَيَا قَوْمِ اسْتَغْفِرُوا رَبَّكُمْ ثُمَّ تُوبُوا إِلَيْهِ يُرْسِلِ السَّمَاءَ عَلَيْكُم مِّدْرَارًا وَيَزِدْكُمْ قُوَّةً إِلَىٰ قُوَّتِكُمْ وَلَا تَتَوَلَّوْا مُجْرِمِينَ",
    "قَالُوا يَا هُودُ مَا جِئْتَنَا بِبَيِّنَةٍ وَمَا نَحْنُ بِتَارِكِي آلِهَتِنَا عَن قَوْلِكَ وَمَا نَحْنُ لَكَ بِمُؤْمِنِينَ",
    "إِن نَّقُولُ إِلَّا اعْتَرَاكَ بَعْضُ آلِهَتِنَا بِسُوءٍ ۗ قَالَ إِنِّي أُشْهِدُ اللَّهَ وَاشْهَدُوا أَنِّي بَرِيءٌ مِّمَّا تُشْرِكُونَ",
    "مِن دُونِهِ ۖ فَكِيدُونِي جَمِيعًا ثُمَّ لَا تُنظِرُونِ",
    "إِنِّي تَوَكَّلْتُ عَلَى اللَّهِ رَبِّي وَرَبِّكُم ۚ مَّا مِن دَابَّةٍ إِلَّا هُوَ آخِذٌ بِنَاصِيَتِهَا ۚ إِنَّ رَبِّي عَلَىٰ صِرَاطٍ مُّسْتَقِيمٍ",
    "فَإِن تَوَلَّوْا فَقَدْ أَبْلَغْتُكُم مَّا أُرْسِلْتُ بِهِ إِلَيْكُمْ ۚ وَيَسْتَخْلِفُ رَبِّي قَوْمًا غَيْرَكُمْ وَلَا تَضُرُّونَهُ شَيْئًا ۚ إِنَّ رَبِّي عَلَىٰ كُلِّ شَيْءٍ حَفِيظٌ",
    "وَلَمَّا جَاءَ أَمْرُنَا نَجَّيْنَا هُودًا وَالَّذِينَ آمَنُوا مَعَهُ بِرَحْمَةٍ مِّنَّا وَنَجَّيْنَاهُم مِّنْ عَذَابٍ غَلِيظٍ",
    "وَتِلْكَ عَادٌ ۖ جَحَدُوا بِآيَاتِ رَبِّهِمْ وَعَصَوْا رُسُلَهُ وَاتَّبَعُوا أَمْرَ كُلِّ جَبَّارٍ عَنِيدٍ",
    "وَأُتْبِعُوا فِي هَٰذِهِ الدُّنْيَا لَعْنَةً وَيَوْمَ الْقِيَامَةِ ۗ أَلَا إِنَّ عَادًا كَفَرُوا رَبَّهُمْ ۗ أَلَا بُعْدًا لِّعَادٍ قَوْمِ هُودٍ",
    "وَإِلَىٰ ثَمُودَ أَخَاهُمْ صَالِحًا ۚ قَالَ يَا قَوْمِ اعْبُدُوا اللَّهَ مَا لَكُم مِّنْ إِلَٰهٍ غَيْرُهُ ۖ هُوَ أَنشَأَكُم مِّنَ الْأَرْضِ وَاسْتَعْمَرَكُمْ فِيهَا فَاسْتَغْفِرُوهُ ثُمَّ تُوبُوا إِلَيْهِ ۚ إِنَّ رَبِّي قَرِيبٌ مُّجِيبٌ",
    "قَالُوا يَا صَالِحُ قَدْ كُنتَ فِينَا مَرْجُوًّا قَبْلَ هَٰذَا ۖ أَتَنْهَانَا أَن نَّعْبُدَ مَا يَعْبُدُ آبَاؤُنَا وَإِنَّنَا لَفِي شَكٍّ مِّمَّا تَدْعُونَا إِلَيْهِ مُرِيبٍ",
    "قَالَ يَا قَوْمِ أَرَأَيْتُمْ إِن كُنتُ عَلَىٰ بَيِّنَةٍ مِّن رَّبِّي وَآتَانِي مِنْهُ رَحْمَةً فَمَن يَنصُرُنِي مِنَ اللَّهِ إِنْ عَصَيْتُهُ ۖ فَمَا تَزِيدُونَنِي غَيْرَ تَخْسِيرٍ",
    "وَيَا قَوْمِ هَٰذِهِ نَاقَةُ اللَّهِ لَكُمْ آيَةً فَذَرُوهَا تَأْكُلْ فِي أَرْضِ اللَّهِ وَلَا تَمَسُّوهَا بِسُوءٍ فَيَأْخُذَكُمْ عَذَابٌ قَرِيبٌ",
    "فَعَقَرُوهَا فَقَالَ تَمَتَّعُوا فِي دَارِكُمْ ثَلَاثَةَ أَيَّامٍ ۖ ذَٰلِكَ وَعْدٌ غَيْرُ مَكْذُوبٍ",
    "فَلَمَّا جَاءَ أَمْرُنَا نَجَّيْنَا صَالِحًا وَالَّذِينَ آمَنُوا مَعَهُ بِرَحْمَةٍ مِّنَّا وَمِنْ خِزْيِ يَوْمِئِذٍ ۗ إِنَّ رَبَّكَ هُوَ الْقَوِيُّ الْعَزِيزُ",
    "وَأَخَذَ الَّذِينَ ظَلَمُوا الصَّيْحَةُ فَأَصْبَحُوا فِي دِيَارِهِمْ جَاثِمِينَ",
    "كَأَن لَّمْ يَغْنَوْا فِيهَا ۗ أَلَا إِنَّ ثَمُودَ كَفَرُوا رَبَّهُمْ ۗ أَلَا بُعْدًا لِّثَمُودَ",
    "وَلَقَدْ جَاءَتْ رُسُلُنَا إِبْرَاهِيمَ بِالْبُشْرَىٰ قَالُوا سَلَامًا ۖ قَالَ سَلَامٌ ۖ فَمَا لَبِثَ أَن جَاءَ بِعِجْلٍ حَنِيذٍ",
    "فَلَمَّا رَأَىٰ أَيْدِيَهُمْ لَا تَصِلُ إِلَيْهِ نَكِرَهُمْ وَأَوْجَسَ مِنْهُمْ خِيفَةً ۚ قَالُوا لَا تَخَفْ إِنَّا أُرْسِلْنَا إِلَىٰ قَوْمِ لُوطٍ",
    "وَامْرَأَتُهُ قَائِمَةٌ فَضَحِكَتْ فَبَشَّرْنَاهَا بِإِسْحَاقَ وَمِن وَرَاءِ إِسْحَاقَ يَعْقُوبَ",
    "قَالَتْ يَا وَيْلَتَىٰ أَأَلِدُ وَأَنَا عَجُوزٌ وَهَٰذَا بَعْلِي شَيْخًا ۖ إِنَّ هَٰذَا لَشَيْءٌ عَجِيبٌ",
    "قَالُوا أَتَعْجَبِينَ مِنْ أَمْرِ اللَّهِ ۖ رَحْمَتُ اللَّهِ وَبَرَكَاتُهُ عَلَيْكُمْ أَهْلَ الْبَيْتِ ۚ إِنَّهُ حَمِيدٌ مَّجِيدٌ",
    "فَلَمَّا ذَهَبَ عَنْ إِبْرَاهِيمَ الرَّوْعُ وَجَاءَتْهُ الْبُشْرَىٰ يُجَادِلُنَا فِي قَوْمِ لُوطٍ",
    "إِنَّ إِبْرَاهِيمَ لَحَلِيمٌ أَوَّاهٌ مُّنِيبٌ",
    "يَا إِبْرَاهِيمُ أَعْرِضْ عَنْ هَٰذَا ۖ إِنَّهُ قَدْ جَاءَ أَمْرُ رَبِّكَ ۖ وَإِنَّهُمْ آتِيهِمْ عَذَابٌ غَيْرُ مَرْدُودٍ",
    "وَلَمَّا جَاءَتْ رُسُلُنَا لُوطًا سِيءَ بِهِمْ وَضَاقَ بِهِمْ ذَرْعًا وَقَالَ هَٰذَا يَوْمٌ عَصِيبٌ",
    "وَجَاءَهُ قَوْمُهُ يُهْرَعُونَ إِلَيْهِ وَمِن قَبْلُ كَانُوا يَعْمَلُونَ السَّيِّئَاتِ ۚ قَالَ يَا قَوْمِ هَٰؤُلَاءِ بَنَاتِي هُنَّ أَطْهَرُ لَكُمْ ۖ فَاتَّقُوا اللَّهَ وَلَا تُخْزُونِ فِي ضَيْفِي ۖ أَلَيْسَ مِنكُمْ رَجُلٌ رَّشِيدٌ",
    "قَالُوا لَقَدْ عَلِمْتَ مَا لَنَا فِي بَنَاتِكَ مِنْ حَقٍّ وَإِنَّكَ لَتَعْلَمُ مَا نُرِيدُ",
    "قَالَ لَوْ أَنَّ لِي بِكُمْ قُوَّةً أَوْ آوِي إِلَىٰ رُكْنٍ شَدِيدٍ",
    "قَالُوا يَا لُوطُ إِنَّا رُسُلُ رَبِّكَ لَن يَصِلُوا إِلَيْكَ ۖ فَأَسْرِ بِأَهْلِكَ بِقِطْعٍ مِّنَ اللَّيْلِ وَلَا يَلْتَفِتْ مِنكُمْ أَحَدٌ إِلَّا امْرَأَتَكَ ۖ إِنَّهُ مُصِيبُهَا مَا أَصَابَهُمْ ۚ إِنَّ مَوْعِدَهُمُ الصُّبْحُ ۚ أَلَيْسَ الصُّبْحُ بِقَرِيبٍ",
    "فَلَمَّا جَاءَ أَمْرُنَا جَعَلْنَا عَالِيَهَا سَافِلَهَا وَأَمْطَرْنَا عَلَيْهَا حِجَارَةً مِّن سِجِّيلٍ مَّنضُودٍ",
    "مُّسَوَّمَةً عِندَ رَبِّكَ ۖ وَمَا هِيَ مِنَ الظَّالِمِينَ بِبَعِيدٍ",
    "وَإِلَىٰ مَدْيَنَ أَخَاهُمْ شُعَيْبًا ۚ قَالَ يَا قَوْمِ اعْبُدُوا اللَّهَ مَا لَكُم مِّنْ إِلَٰهٍ غَيْرُهُ ۖ وَلَا تَنقُصُوا الْمِكْيَالَ وَالْمِيزَانَ ۚ إِنِّي أَرَاكُم بِخَيْرٍ وَإِنِّي أَخَافُ عَلَيْكُمْ عَذَابَ يَوْمٍ مُّحِيطٍ",
    "وَيَا قَوْمِ أَوْفُوا الْمِكْيَالَ وَالْمِيزَانَ بِالْقِسْطِ ۖ وَلَا تَبْخَسُوا النَّاسَ أَشْيَاءَهُمْ وَلَا تَعْثَوْا فِي الْأَرْضِ مُفْسِدِينَ",
    "بَقِيَّتُ اللَّهِ خَيْرٌ لَّكُمْ إِن كُنتُم مُّؤْمِنِينَ ۚ وَمَا أَنَا عَلَيْكُم بِحَفِيظٍ",
    "قَالُوا يَا شُعَيْبُ أَصَلَاتُكَ تَأْمُرُكَ أَن نَّتْرُكَ مَا يَعْبُدُ آبَاؤُنَا أَوْ أَن نَّفْعَلَ فِي أَمْوَالِنَا مَا نَشَاءُ ۖ إِنَّكَ لَأَنتَ الْحَلِيمُ الرَّشِيدُ",
    "قَالَ يَا قَوْمِ أَرَأَيْتُمْ إِن كُنتُ عَلَىٰ بَيِّنَةٍ مِّن رَّبِّي وَرَزَقَنِي مِنْهُ رِزْقًا حَسَنًا ۚ وَمَا أُرِيدُ أَنْ أُخَالِفَكُمْ إِلَىٰ مَا أَنْهَاكُمْ عَنْهُ ۚ إِنْ أُرِيدُ إِلَّا الْإِصْلَاحَ مَا اسْتَطَعْتُ ۚ وَمَا تَوْفِيقِي إِلَّا بِاللَّهِ ۚ عَلَيْهِ تَوَكَّلْتُ وَإِلَيْهِ أُنِيبُ",
    "وَيَا قَوْمِ لَا يَجْرِمَنَّكُمْ شِقَاقِي أَن يُصِيبَكُم مِّثْلُ مَا أَصَابَ قَوْمَ نُوحٍ أَوْ قَوْمَ هُودٍ أَوْ قَوْمَ صَالِحٍ ۚ وَمَا قَوْمُ لُوطٍ مِّنكُم بِبَعِيدٍ",
    "وَاسْتَغْفِرُوا رَبَّكُمْ ثُمَّ تُوبُوا إِلَيْهِ ۚ إِنَّ رَبِّي رَحِيمٌ وَدُودٌ",
    "قَالُوا يَا شُعَيْبُ مَا نَفْقَهُ كَثِيرًا مِّمَّا تَقُولُ وَإِنَّا لَنَرَاكَ فِينَا ضَعِيفًا ۖ وَلَوْلَا رَهْطُكَ لَرَجَمْنَاكَ ۖ وَمَا أَنتَ عَلَيْنَا بِعَزِيزٍ",
    "قَالَ يَا قَوْمِ أَرَهْطِي أَعَزُّ عَلَيْكُم مِّنَ اللَّهِ وَاتَّخَذْتُمُوهُ وَرَاءَكُمْ ظِهْرِيًّا ۖ إِنَّ رَبِّي بِمَا تَعْمَلُونَ مُحِيطٌ",
    "وَيَا قَوْمِ اعْمَلُوا عَلَىٰ مَكَانَتِكُمْ إِنِّي عَامِلٌ ۖ سَوْفَ تَعْلَمُونَ مَن يَأْتِيهِ عَذَابٌ يُخْزِيهِ وَمَنْ هُوَ كَاذِبٌ ۖ وَارْتَقِبُوا إِنِّي مَعَكُمْ رَقِيبٌ",
    "وَلَمَّا جَاءَ أَمْرُنَا نَجَّيْنَا شُعَيْبًا وَالَّذِينَ آمَنُوا مَعَهُ بِرَحْمَةٍ مِّنَّا وَأَخَذَتِ الَّذِينَ ظَلَمُوا الصَّيْحَةُ فَأَصْبَحُوا فِي دِيَارِهِمْ جَاثِمِينَ",
    "كَأَن لَّمْ يَغْنَوْا فِيهَا ۗ أَلَا بُعْدًا لِّمَدْيَنَ كَمَا بَعِدَتْ ثَمُودُ",
    "وَلَقَدْ أَرْسَلْنَا مُوسَىٰ بِآيَاتِنَا وَسُلْطَانٍ مُّبِينٍ",
    "إِلَىٰ فِرْعَوْنَ وَمَلَئِهِ فَاتَّبَعُوا أَمْرَ فِرْعَوْنَ ۖ وَمَا أَمْرُ فِرْعَوْنَ بِرَشِيدٍ",
    "يَقْدُمُ قَوْمَهُ يَوْمَ الْقِيَامَةِ فَأَوْرَدَهُمُ النَّارَ ۖ وَبِئْسَ الْوِرْدُ الْمَوْرُودُ",
    "وَأُتْبِعُوا فِي هَٰذِهِ لَعْنَةً وَيَوْمَ الْقِيَامَةِ ۚ بِئْسَ الرِّفْدُ الْمَرْفُودُ",
    "ذَٰلِكَ مِنْ أَنبَاءِ الْقُرَىٰ نَقُصُّهُ عَلَيْكَ ۖ مِنْهَا قَائِمٌ وَحَصِيدٌ",
    "وَمَا ظَلَمْنَاهُمْ وَلَٰكِن ظَلَمُوا أَنفُسَهُمْ ۖ فَمَا أَغْنَتْ عَنْهُمْ آلِهَتُهُمُ الَّتِي يَدْعُونَ مِن دُونِ اللَّهِ مِن شَيْءٍ لَّمَّا جَاءَ أَمْرُ رَبِّكَ ۖ وَمَا زَادُوهُمْ غَيْرَ تَتْبِيبٍ",
    "وَكَذَٰلِكَ أَخْذُ رَبِّكَ إِذَا أَخَذَ الْقُرَىٰ وَهِيَ ظَالِمَةٌ ۚ إِنَّ أَخْذَهُ أَلِيمٌ شَدِيدٌ",
    "إِنَّ فِي ذَٰلِكَ لَآيَةً لِّمَنْ خَافَ عَذَابَ الْآخِرَةِ ۚ ذَٰلِكَ يَوْمٌ مَّجْمُوعٌ لَّهُ النَّاسُ وَذَٰلِكَ يَوْمٌ مَّشْهُودٌ",
    "وَمَا نُؤَخِّرُهُ إِلَّا لِأَجَلٍ مَّعْدُودٍ",
    "يَوْمَ يَأْتِ لَا تَكَلَّمُ نَفْسٌ إِلَّا بِإِذْنِهِ ۚ فَمِنْهُمْ شَقِيٌّ وَسَعِيدٌ",
    "فَأَمَّا الَّذِينَ شَقُوا فَفِي النَّارِ لَهُمْ فِيهَا زَفِيرٌ وَشَهِيقٌ",
    "خَالِدِينَ فِيهَا مَا دَامَتِ السَّمَاوَاتُ وَالْأَرْضُ إِلَّا مَا شَاءَ رَبُّكَ ۚ إِنَّ رَبَّكَ فَعَّالٌ لِّمَا يُرِيدُ",
    "وَأَمَّا الَّذِينَ سُعِدُوا فَفِي الْجَنَّةِ خَالِدِينَ فِيهَا مَا دَامَتِ السَّمَاوَاتُ وَالْأَرْضُ إِلَّا مَا شَاءَ رَبُّكَ ۖ عَطَاءً غَيْرَ مَجْذُوذٍ",
    "فَلَا تَكُ فِي مِرْيَةٍ مِّمَّا يَعْبُدُ هَٰؤُلَاءِ ۚ مَا يَعْبُدُونَ إِلَّا كَمَا يَعْبُدُ آبَاؤُهُم مِّن قَبْلُ ۚ وَإِنَّا لَمُوَفُّوهُمْ نَصِيبَهُمْ غَيْرَ مَنقُوصٍ",
    "وَلَقَدْ آتَيْنَا مُوسَى الْكِتَابَ فَاخْتُلِفَ فِيهِ ۚ وَلَوْلَا كَلِمَةٌ سَبَقَتْ مِن رَّبِّكَ لَقُضِيَ بَيْنَهُمْ ۚ وَإِنَّهُمْ لَفِي شَكٍّ مِّنْهُ مُرِيبٍ",
    "وَإِنَّ كُلًّا لَّمَّا لَيُوَفِّيَنَّهُمْ رَبُّكَ أَعْمَالَهُمْ ۚ إِنَّهُ بِمَا يَعْمَلُونَ خَبِيرٌ",
    "فَاسْتَقِمْ كَمَا أُمِرْتَ وَمَن تَابَ مَعَكَ وَلَا تَطْغَوْا ۚ إِنَّهُ بِمَا تَعْمَلُونَ بَصِيرٌ",
    "وَلَا تَرْكَنُوا إِلَى الَّذِينَ ظَلَمُوا فَتَمَسَّكُمُ النَّارُ وَمَا لَكُم مِّن دُونِ اللَّهِ مِنْ أَوْلِيَاءَ ثُمَّ لَا تُنصَرُونَ",
    "وَأَقِمِ الصَّلَاةَ طَرَفَيِ النَّهَارِ وَزُلَفًا مِّنَ اللَّيْلِ ۚ إِنَّ الْحَسَنَاتِ يُذْهِبْنَ السَّيِّئَاتِ ۚ ذَٰلِكَ ذِكْرَىٰ لِلذَّاكِرِينَ",
    "وَاصْبِرْ فَإِنَّ اللَّهَ لَا يُضِيعُ أَجْرَ الْمُحْسِنِينَ",
    "فَلَوْلَا كَانَ مِنَ الْقُرُونِ مِن قَبْلِكُمْ أُولُو بَقِيَّةٍ يَنْهَوْنَ عَنِ الْفَسَادِ فِي الْأَرْضِ إِلَّا قَلِيلًا مِّمَّنْ أَنجَيْنَا مِنْهُمْ ۗ وَاتَّبَعَ الَّذِينَ ظَلَمُوا مَا أُتْرِفُوا فِيهِ وَكَانُوا مُجْرِمِينَ",
    "وَمَا كَانَ رَبُّكَ لِيُهْلِكَ الْقُرَىٰ بِظُلْمٍ وَأَهْلُهَا مُصْلِحُونَ",
    "وَلَوْ شَاءَ رَبُّكَ لَجَعَلَ النَّاسَ أُمَّةً وَاحِدَةً ۖ وَلَا يَزَالُونَ مُخْتَلِفِينَ",
    "إِلَّا مَن رَّحِمَ رَبُّكَ ۚ وَلِذَٰلِكَ خَلَقَهُمْ ۗ وَتَمَّتْ كَلِمَةُ رَبِّكَ لَأَمْلَأَنَّ جَهَنَّمَ مِنَ الْجِنَّةِ وَالنَّاسِ أَجْمَعِينَ",
    "وَكُلًّا نَّقُصُّ عَلَيْكَ مِنْ أَنبَاءِ الرُّسُلِ مَا نُثَبِّتُ بِهِ فُؤَادَكَ ۚ وَجَاءَكَ فِي هَٰذِهِ الْحَقُّ وَمَوْعِظَةٌ وَذِكْرَىٰ لِلْمُؤْمِنِينَ",
    "وَقُل لِّلَّذِينَ لَا يُؤْمِنُونَ اعْمَلُوا عَلَىٰ مَكَانَتِكُمْ إِنَّا عَامِلُونَ",
    "وَانتَظِرُوا إِنَّا مُنتَظِرُونَ",
    "وَلِلَّهِ غَيْبُ السَّمَاوَاتِ وَالْأَرْضِ وَإِلَيْهِ يُرْجَعُ الْأَمْرُ كُلُّهُ فَاعْبُدْهُ وَتَوَكَّلْ عَلَيْهِ ۚ وَمَا رَبُّكَ بِغَافِلٍ عَمَّا تَعْمَلُونَ"};

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
            "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Alif, Lam, Ra. [This is] a Book whose verses are perfected and then presented in detail from [one who is] Wise and Acquainted.",
    "[Through a messenger, saying], \"Do not worship except Allah. Indeed, I am to you from Him a warner and a bringer of good tidings,\"",
    "And [saying], \"Seek forgiveness of your Lord and repent to Him, [and] He will let you enjoy a good provision for a specified term and give every doer of favor his favor. But if you turn away, then indeed, I fear for you the punishment of a great Day.",
    "To Allah is your return, and He is over all things competent.\"",
    "Unquestionably, they the disbelievers turn away their breasts to hide themselves from Him. Unquestionably, [even] when they cover themselves in their clothing, Allah knows what they conceal and what they declare. Indeed, He is Knowing of that within the breasts.",
    "And there is no creature on earth but that upon Allah is its provision, and He knows its place of dwelling and place of storage. All is in a clear register.",
    "And it is He who created the heavens and the earth in six days - and His Throne had been upon water - that He might test you as to which of you is best in deed. But if you say, \"Indeed, you are resurrected after death,\" those who disbelieve will surely say, \"This is not but obvious magic.\"",
    "And if We hold back from them the punishment for a limited time, they will surely say, \"What detains it?\" Unquestionably, on the Day it comes to them, it will not be averted from them, and they will be enveloped by what they used to ridicule.",
    "And if We give man a taste of mercy from Us and then We withdraw it from him, indeed, he is despairing and ungrateful.",
    "But if We give him a taste of favor after hardship has touched him, he will surely say, \"Bad times have left me.\" Indeed, he is exultant and boastful -",
    "Except for those who are patient and do righteous deeds; those will have forgiveness and great reward.",
    "Then would you possibly leave [out] some of what is revealed to you, or is your breast constrained by it because they say, \"Why has there not been sent down to him a treasure or come with him an angel?\" But you are only a warner. And Allah is Disposer of all things.",
    "Or do they say, \"He invented it\"? Say, \"Then bring ten surahs like it that have been invented and call upon [for assistance] whomever you can besides Allah, if you should be truthful.\"",
    "And if they do not respond to you - then know that the Qur'an was revealed with the knowledge of Allah and that there is no deity except Him. Then, would you [not] be Muslims?",
    "Whoever desires the life of this world and its adornments - We fully repay them for their deeds therein, and they therein will not be deprived.",
    "Those are the ones for whom there is not in the Hereafter but the Fire. And lost is what they did therein, and worthless is what they used to do.",
    "So is one who [stands] upon a clear evidence from his Lord [like the aforementioned]? And a witness from Him follows it, and before it was the Scripture of Moses to lead and as mercy. Those [believers in the former revelations] believe in the Qur'an. But whoever disbelieves in it from the [various] factions - the Fire is his promised destination. So be not in doubt about it. Indeed, it is the truth from your Lord, but most of the people do not believe.",
    "And who is more unjust than he who invents a lie about Allah? Those will be presented before their Lord, and the witnesses will say, \"These are the ones who lied against their Lord.\" Unquestionably, the curse of Allah is upon the wrongdoers.",
    "Who averted [people] from the way of Allah and sought to make it [seem] deviant while they, concerning the Hereafter, were disbelievers.",
    "Those were not causing failure [to Allah] on earth, nor did they have besides Allah any protectors. For them the punishment will be multiplied. They were not able to hear, nor did they see.",
    "Those are the ones who will have lost themselves, and lost from them is what they used to invent.",
    "Assuredly, it is they in the Hereafter who will be the greatest losers.",
    "Indeed, they who have believed and done righteous deeds and humbled themselves to their Lord - those are the companions of Paradise; they will abide eternally therein.",
    "The example of the two parties is like the blind and deaf, and the seeing and hearing. Are they equal in comparison? Then, will you not remember?",
    "And We had certainly sent Noah to his people, [saying], \" Indeed, I am to you a clear warner",
    "That you not worship except Allah. Indeed, I fear for you the punishment of a painful day.\"",
    "So the eminent among those who disbelieved from his people said, \" We do not see you but as a man like ourselves, and we do not see you followed except by those who are the lowest of us [and] at first suggestion. And we do not see in you over us any merit; rather, we think you are liars.\"",
    "He said, \"O my people have you considered: if I should be upon clear evidence from my Lord while He has given me mercy from Himself but it has been made unapparent to you, should we force it upon you while you are averse to it?",
    "And O my people, I ask not of you for it any wealth. My reward is not but from Allah. And I am not one to drive away those who have believed. Indeed, they will meet their Lord, but I see that you are a people behaving ignorantly.",
    "And O my people, who would protect me from Allah if I drove them away? Then will you not be reminded?",
    "And I do not tell you that I have the depositories [containing the provision] of Allah or that I know the unseen, nor do I tell you that I am an angel, nor do I say of those upon whom your eyes look down that Allah will never grant them any good. Allah is most knowing of what is within their souls. Indeed, I would then be among the wrongdoers.\"",
    "They said, \"O Noah, you have disputed us and been frequent in dispute of us. So bring us what you threaten us, if you should be of the truthful.\"",
    "He said, \"Allah will only bring it to you if He wills, and you will not cause [Him] failure.",
    "And my advice will not benefit you - although I wished to advise you - If Allah should intend to put you in error. He is your Lord, and to Him you will be returned.\"",
    "Or do they say [about Prophet Muhammad], \"He invented it\"? Say, \"If I have invented it, then upon me is [the consequence of] my crime; but I am innocent of what [crimes] you commit.\"",
    "And it was revealed to Noah that, \"No one will believe from your people except those who have already believed, so do not be distressed by what they have been doing.",
    "And construct the ship under Our observation and Our inspiration and do not address Me concerning those who have wronged; indeed, they are [to be] drowned.\"",
    "And he constructed the ship, and whenever an assembly of the eminent of his people passed by him, they ridiculed him. He said, \"If you ridicule us, then we will ridicule you just as you ridicule.",
    "And you are going to know who will get a punishment that will disgrace him [on earth] and upon whom will descend an enduring punishment [in the Hereafter].\"",
    "[So it was], until when Our command came and the oven overflowed, We said, \"Load upon the ship of each [creature] two mates and your family, except those about whom the word has preceded, and [include] whoever has believed.\" But none had believed with him, except a few.",
    "And [Noah] said, \"Embark therein; in the name of Allah is its course and its anchorage. Indeed, my Lord is Forgiving and Merciful.\"",
    "And it sailed with them through waves like mountains, and Noah called to his son who was apart [from them], \"O my son, come aboard with us and be not with the disbelievers.\"",
    "[But] he said, \"I will take refuge on a mountain to protect me from the water.\" [Noah] said, \"There is no protector today from the decree of Allah, except for whom He gives mercy.\" And the waves came between them, and he was among the drowned.",
    "And it was said, \"O earth, swallow your water, and O sky, withhold [your rain].\" And the water subsided, and the matter was accomplished, and the ship came to rest on the [mountain of] Judiyy. And it was said, \"Away with the wrongdoing people.\"",
    "And Noah called to his Lord and said, \"My Lord, indeed my son is of my family; and indeed, Your promise is true; and You are the most just of judges!\"",
    "He said, \"O Noah, indeed he is not of your family; indeed, he is [one whose] work was other than righteous, so ask Me not for that about which you have no knowledge. Indeed, I advise you, lest you be among the ignorant.\"",
    "[Noah] said, \"My Lord, I seek refuge in You from asking that of which I have no knowledge. And unless You forgive me and have mercy upon me, I will be among the losers.\"",
    "It was said, \"O Noah, disembark in security from Us and blessings upon you and upon nations [descending] from those with you. But other nations [of them] We will grant enjoyment; then there will touch them from Us a painful punishment.\"",
    "That is from the news of the unseen which We reveal to you, [O Muhammad]. You knew it not, neither you nor your people, before this. So be patient; indeed, the [best] outcome is for the righteous.",
    "And to 'Aad [We sent] their brother Hud. He said, \"O my people, worship Allah; you have no deity other than Him. You are not but inventors [of falsehood].",
    "O my people, I do not ask you for it any reward. My reward is only from the one who created me. Then will you not reason?",
    "And O my people, ask forgiveness of your Lord and then repent to Him. He will send [rain from] the sky upon you in showers and increase you in strength [added] to your strength. And do not turn away, [being] criminals.\"",
    "They said, \"O Hud, you have not brought us clear evidence, and we are not ones to leave our gods on your say-so. Nor are we believers in you.",
    "We only say that some of our gods have possessed you with evil.\" He said, \"Indeed, I call Allah to witness, and witness [yourselves] that I am free from whatever you associate with Allah",
    "Other than Him. So plot against me all together; then do not give me respite.",
    "Indeed, I have relied upon Allah, my Lord and your Lord. There is no creature but that He holds its forelock. Indeed, my Lord is on a path [that is] straight.\"",
    "But if they turn away, [say], \"I have already conveyed that with which I was sent to you. My Lord will give succession to a people other than you, and you will not harm Him at all. Indeed my Lord is, over all things, Guardian.\"",
    "And when Our command came, We saved Hud and those who believed with him, by mercy from Us; and We saved them from a harsh punishment.",
    "And that was 'Aad, who rejected the signs of their Lord and disobeyed His messengers and followed the order of every obstinate tyrant.",
    "And they were [therefore] followed in this world with a curse and [as well] on the Day of Resurrection. Unquestionably, 'Aad denied their Lord; then away with 'Aad, the people of Hud.",
    "And to Thamud [We sent] their brother Salih. He said, \"O my people, worship Allah; you have no deity other than Him. He has produced you from the earth and settled you in it, so ask forgiveness of Him and then repent to Him. Indeed, my Lord is near and responsive.\"",
    "They said, \"O Salih, you were among us a man of promise before this. Do you forbid us to worship what our fathers worshipped? And indeed we are, about that to which you invite us, in disquieting doubt.\"",
    "He said, \"O my people, have you considered: if I should be upon clear evidence from my Lord and He has given me mercy from Himself, who would protect me from Allah if I disobeyed Him? So you would not increase me except in loss.",
    "And O my people, this is the she-camel of Allah - [she is] to you a sign. So let her feed upon Allah's earth and do not touch her with harm, or you will be taken by an impending punishment.\"",
    "But they hamstrung her, so he said, \"Enjoy yourselves in your homes for three days. That is a promise not to be denied.\"",
    "So when Our command came, We saved Salih and those who believed with him, by mercy from Us, and [saved them] from the disgrace of that day. Indeed, it is your Lord who is the Powerful, the Exalted in Might.",
    "And the shriek seized those who had wronged, and they became within their homes [corpses] fallen prone",
    "As if they had never prospered therein. Unquestionably, Thamud denied their Lord; then, away with Thamud.",
    "And certainly did Our messengers come to Abraham with good tidings; they said, \"Peace.\" He said, \"Peace,\" and did not delay in bringing [them] a roasted calf.",
    "But when he saw their hands not reaching for it, he distrusted them and felt from them apprehension. They said, \"Fear not. We have been sent to the people of Lot.\"",
    "And his Wife was standing, and she smiled. Then We gave her good tidings of Isaac and after Isaac, Jacob.",
    "She said, \"Woe to me! Shall I give birth while I am an old woman and this, my husband, is an old man? Indeed, this is an amazing thing!\"",
    "They said, \"Are you amazed at the decree of Allah? May the mercy of Allah and His blessings be upon you, people of the house. Indeed, He is Praiseworthy and Honorable.\"",
    "And when the fright had left Abraham and the good tidings had reached him, he began to argue with Us concerning the people of Lot.",
    "Indeed, Abraham was forbearing, grieving and [frequently] returning [to Allah].",
    "[The angels said], \"O Abraham, give up this [plea]. Indeed, the command of your Lord has come, and indeed, there will reach them a punishment that cannot be repelled.\"",
    "And when Our messengers, [the angels], came to Lot, he was anguished for them and felt for them great discomfort and said, \"This is a trying day.\"",
    "And his people came hastening to him, and before [this] they had been doing evil deeds. He said, \"O my people, these are my daughters; they are purer for you. So fear Allah and do not disgrace me concerning my guests. Is there not among you a man of reason?\"",
    "They said, \"You have already known that we have not concerning your daughters any claim, and indeed, you know what we want.\"",
    "He said, \"If only I had against you some power or could take refuge in a strong support.\"",
    "The angels said, \"O Lot, indeed we are messengers of your Lord; [therefore], they will never reach you. So set out with your family during a portion of the night and let not any among you look back - except your wife; indeed, she will be struck by that which strikes them. Indeed, their appointment is [for] the morning. Is not the morning near?\"",
    "So when Our command came, We made the highest part [of the city] its lowest and rained upon them stones of layered hard clay, [which were]",
    "Marked from your Lord. And Allah's punishment is not from the wrongdoers [very] far.",
    "And to Madyan [We sent] their brother Shu'ayb. He said, \"O my people, worship Allah; you have no deity other than Him. And do not decrease from the measure and the scale. Indeed, I see you in prosperity, but indeed, I fear for you the punishment of an all-encompassing Day.",
    "And O my people, give full measure and weight in justice and do not deprive the people of their due and do not commit abuse on the earth, spreading corruption.",
    "What remains [lawful] from Allah is best for you, if you would be believers. But I am not a guardian over you.\"",
    "They said, \"O Shu'ayb, does your prayer command you that we should leave what our fathers worship or not do with our wealth what we please? Indeed, you are the forbearing, the discerning!\"",
    "He said, \"O my people, have you considered: if I am upon clear evidence from my Lord and He has provided me with a good provision from Him... ? And I do not intend to differ from you in that which I have forbidden you; I only intend reform as much as I am able. And my success is not but through Allah. Upon him I have relied, and to Him I return.",
    "And O my people, let not [your] dissension from me cause you to be struck by that similar to what struck the people of Noah or the people of Hud or the people of Salih. And the people of Lot are not from you far away.",
    "And ask forgiveness of your Lord and then repent to Him. Indeed, my Lord is Merciful and Affectionate.\"",
    "They said, \"O Shu'ayb, we do not understand much of what you say, and indeed, we consider you among us as weak. And if not for your family, we would have stoned you [to death]; and you are not to us one respected.\"",
    "He said, \"O my people, is my family more respected for power by you than Allah? But you put Him behind your backs [in neglect]. Indeed, my Lord is encompassing of what you do.",
    "And O my people, work according to your position; indeed, I am working. You are going to know to whom will come a punishment that will disgrace him and who is a liar. So watch; indeed, I am with you a watcher, [awaiting the outcome].\"",
    "And when Our command came, We saved Shu'ayb and those who believed with him, by mercy from Us. And the shriek seized those who had wronged, and they became within their homes [corpses] fallen prone",
    "As if they had never prospered therein. Then, away with Madyan as Thamud was taken away.",
    "And We did certainly send Moses with Our signs and a clear authority",
    "To Pharaoh and his establishment, but they followed the command of Pharaoh, and the command of Pharaoh was not [at all] discerning.",
    "He will precede his people on the Day of Resurrection and lead them into the Fire; and wretched is the place to which they are led.",
    "And they were followed in this [world] with a curse and on the Day of Resurrection. And wretched is the gift which is given.",
    "That is from the news of the cities, which We relate to you; of them, some are [still] standing and some are [as] a harvest [mowed down].",
    "And We did not wrong them, but they wronged themselves. And they were not availed at all by their gods which they invoked other than Allah when there came the command of your Lord. And they did not increase them in other than ruin.",
    "And thus is the seizure of your Lord when He seizes the cities while they are committing wrong. Indeed, His seizure is painful and severe.",
    "Indeed in that is a sign for those who fear the punishment of the Hereafter. That is a Day for which the people will be collected, and that is a Day [which will be] witnessed.",
    "And We do not delay it except for a limited term.",
    "The Day it comes no soul will speak except by His permission. And among them will be the wretched and the prosperous.",
    "As for those who were [destined to be] wretched, they will be in the Fire. For them therein is [violent] exhaling and inhaling.",
    "[They will be] abiding therein as long as the heavens and the earth endure, except what your Lord should will. Indeed, your Lord is an effecter of what He intends.",
    "And as for those who were [destined to be] prosperous, they will be in Paradise, abiding therein as long as the heavens and the earth endure, except what your Lord should will - a bestowal uninterrupted.",
    "So do not be in doubt, [O Muhammad], as to what these [polytheists] are worshipping. They worship not except as their fathers worshipped before. And indeed, We will give them their share undiminished.",
    "And We had certainly given Moses the Scripture, but it came under disagreement. And if not for a word that preceded from your Lord, it would have been judged between them. And indeed they are, concerning the Qur'an, in disquieting doubt.",
    "And indeed, each [of the believers and disbelievers] - your Lord will fully compensate them for their deeds. Indeed, He is Acquainted with what they do.",
    "So remain on a right course as you have been commanded, [you] and those who have turned back with you [to Allah], and do not transgress. Indeed, He is Seeing of what you do.",
    "And do not incline toward those who do wrong, lest you be touched by the Fire, and you would not have other than Allah any protectors; then you would not be helped.",
    "And establish prayer at the two ends of the day and at the approach of the night. Indeed, good deeds do away with misdeeds. That is a reminder for those who remember.",
    "And be patient, for indeed, Allah does not allow to be lost the reward of those who do good.",
    "So why were there not among the generations before you those of enduring discrimination forbidding corruption on earth - except a few of those We saved from among them? But those who wronged pursued what luxury they were given therein, and they were criminals.",
    "And your Lord would not have destroyed the cities unjustly while their people were reformers.",
    "And if your Lord had willed, He could have made mankind one community; but they will not cease to differ.",
    "Except whom your Lord has given mercy, and for that He created them. But the word of your Lord is to be fulfilled that, \"I will surely fill Hell with jinn and men all together.\"",
    "And each [story] We relate to you from the news of the messengers is that by which We make firm your heart. And there has come to you, in this, the truth and an instruction and a reminder for the believers.",
    "And say to those who do not believe, \"Work according to your position; indeed, we are working.",
    "And wait, indeed, we are waiting.\"",
    "And to Allah belong the unseen [aspects] of the heavens and the earth and to Him will be returned the matter, all of it, so worship Him and rely upon Him. And your Lord is not unaware of that which you do."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hud);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_hud);
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
