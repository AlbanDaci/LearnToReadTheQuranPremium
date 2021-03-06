package com.tumblr.albandaci.learntoreadthequranpremium.Surahs;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.tumblr.albandaci.learntoreadthequranpremium.Adapter.Al_Fatihah_Adapter;
import com.tumblr.albandaci.learntoreadthequranpremium.R;

import java.io.IOException;

public class Al_Muminun extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/023.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"23:1", "23:2", "23:3", "23:4", "23:5", "23:6", "23:7", "23:8", "23:9", "23:10", "23:11", "23:12", "23:13", "23:14", "23:15", "23:16",
            "23:17", "23:18", "23:19", "23:20", "23:21", "23:22", "23:23", "23:24", "23:25", "23:26", "23:27", "23:28", "23:29", "23:30", "23:31", "23:32",
            "23:33", "23:34", "23:35", "23:36", "23:37", "23:38", "23:39", "23:40", "23:41", "23:42", "23:43", "23:44", "23:45", "23:46", "23:47", "23:48",
            "23:49", "23:50", "23:51", "23:52", "23:53", "23:54", "23:55", "23:56", "23:57", "23:58", "23:59", "23:60", "23:61", "23:62", "23:63", "23:64",
            "23:65", "23:66", "23:67", "23:68", "23:69", "23:70", "23:71", "23:72", "23:73", "23:74", "23:75", "23:76", "23:77", "23:78", "23:79", "23:80",
            "23:81", "23:82", "23:83", "23:84", "23:85", "23:86", "23:87", "23:88", "23:89", "23:90", "23:91", "23:92", "23:93", "23:94", "23:95", "23:96",
            "23:97", "23:98", "23:99", "23:100", "23:101", "23:102", "23:103", "23:104", "23:105", "23:106", "23:107", "23:108", "23:109", "23:110", "23:111", "23:112",
            "23:113", "23:114", "23:115", "23:116", "23:117", "23:118"};

    String [] arabic_verses = {"قَدْ أَفْلَحَ الْمُؤْمِنُونَ",
    "الَّذِينَ هُمْ فِي صَلَاتِهِمْ خَاشِعُونَ",
    "وَالَّذِينَ هُمْ عَنِ اللَّغْوِ مُعْرِضُونَ",
    "وَالَّذِينَ هُمْ لِلزَّكَاةِ فَاعِلُونَ",
    "وَالَّذِينَ هُمْ لِفُرُوجِهِمْ حَافِظُونَ",
    "إِلَّا عَلَىٰ أَزْوَاجِهِمْ أَوْ مَا مَلَكَتْ أَيْمَانُهُمْ فَإِنَّهُمْ غَيْرُ مَلُومِينَ",
    "فَمَنِ ابْتَغَىٰ وَرَاءَ ذَٰلِكَ فَأُولَٰئِكَ هُمُ الْعَادُونَ",
    "وَالَّذِينَ هُمْ لِأَمَانَاتِهِمْ وَعَهْدِهِمْ رَاعُونَ",
    "وَالَّذِينَ هُمْ عَلَىٰ صَلَوَاتِهِمْ يُحَافِظُونَ",
    "أُولَٰئِكَ هُمُ الْوَارِثُونَ",
    "الَّذِينَ يَرِثُونَ الْفِرْدَوْسَ هُمْ فِيهَا خَالِدُونَ",
    "وَلَقَدْ خَلَقْنَا الْإِنسَانَ مِن سُلَالَةٍ مِّن طِينٍ",
    "ثُمَّ جَعَلْنَاهُ نُطْفَةً فِي قَرَارٍ مَّكِينٍ",
    "ثُمَّ خَلَقْنَا النُّطْفَةَ عَلَقَةً فَخَلَقْنَا الْعَلَقَةَ مُضْغَةً فَخَلَقْنَا الْمُضْغَةَ عِظَامًا فَكَسَوْنَا الْعِظَامَ لَحْمًا ثُمَّ أَنشَأْنَاهُ خَلْقًا آخَرَ ۚ فَتَبَارَكَ اللَّهُ أَحْسَنُ الْخَالِقِينَ",
    "ثُمَّ إِنَّكُم بَعْدَ ذَٰلِكَ لَمَيِّتُونَ",
    "ثُمَّ إِنَّكُمْ يَوْمَ الْقِيَامَةِ تُبْعَثُونَ",
    "وَلَقَدْ خَلَقْنَا فَوْقَكُمْ سَبْعَ طَرَائِقَ وَمَا كُنَّا عَنِ الْخَلْقِ غَافِلِينَ",
    "وَأَنزَلْنَا مِنَ السَّمَاءِ مَاءً بِقَدَرٍ فَأَسْكَنَّاهُ فِي الْأَرْضِ ۖ وَإِنَّا عَلَىٰ ذَهَابٍ بِهِ لَقَادِرُونَ",
    "فَأَنشَأْنَا لَكُم بِهِ جَنَّاتٍ مِّن نَّخِيلٍ وَأَعْنَابٍ لَّكُمْ فِيهَا فَوَاكِهُ كَثِيرَةٌ وَمِنْهَا تَأْكُلُونَ",
    "وَشَجَرَةً تَخْرُجُ مِن طُورِ سَيْنَاءَ تَنبُتُ بِالدُّهْنِ وَصِبْغٍ لِّلْآكِلِينَ",
    "وَإِنَّ لَكُمْ فِي الْأَنْعَامِ لَعِبْرَةً ۖ نُّسْقِيكُم مِّمَّا فِي بُطُونِهَا وَلَكُمْ فِيهَا مَنَافِعُ كَثِيرَةٌ وَمِنْهَا تَأْكُلُونَ",
    "وَعَلَيْهَا وَعَلَى الْفُلْكِ تُحْمَلُونَ",
    "وَلَقَدْ أَرْسَلْنَا نُوحًا إِلَىٰ قَوْمِهِ فَقَالَ يَا قَوْمِ اعْبُدُوا اللَّهَ مَا لَكُم مِّنْ إِلَٰهٍ غَيْرُهُ ۖ أَفَلَا تَتَّقُونَ",
    "فَقَالَ الْمَلَأُ الَّذِينَ كَفَرُوا مِن قَوْمِهِ مَا هَٰذَا إِلَّا بَشَرٌ مِّثْلُكُمْ يُرِيدُ أَن يَتَفَضَّلَ عَلَيْكُمْ وَلَوْ شَاءَ اللَّهُ لَأَنزَلَ مَلَائِكَةً مَّا سَمِعْنَا بِهَٰذَا فِي آبَائِنَا الْأَوَّلِينَ",
    "إِنْ هُوَ إِلَّا رَجُلٌ بِهِ جِنَّةٌ فَتَرَبَّصُوا بِهِ حَتَّىٰ حِينٍ",
    "قَالَ رَبِّ انصُرْنِي بِمَا كَذَّبُونِ",
    "فَأَوْحَيْنَا إِلَيْهِ أَنِ اصْنَعِ الْفُلْكَ بِأَعْيُنِنَا وَوَحْيِنَا فَإِذَا جَاءَ أَمْرُنَا وَفَارَ التَّنُّورُ ۙ فَاسْلُكْ فِيهَا مِن كُلٍّ زَوْجَيْنِ اثْنَيْنِ وَأَهْلَكَ إِلَّا مَن سَبَقَ عَلَيْهِ الْقَوْلُ مِنْهُمْ ۖ وَلَا تُخَاطِبْنِي فِي الَّذِينَ ظَلَمُوا ۖ إِنَّهُم مُّغْرَقُونَ",
    "فَإِذَا اسْتَوَيْتَ أَنتَ وَمَن مَّعَكَ عَلَى الْفُلْكِ فَقُلِ الْحَمْدُ لِلَّهِ الَّذِي نَجَّانَا مِنَ الْقَوْمِ الظَّالِمِينَ",
    "وَقُل رَّبِّ أَنزِلْنِي مُنزَلًا مُّبَارَكًا وَأَنتَ خَيْرُ الْمُنزِلِينَ",
    "إِنَّ فِي ذَٰلِكَ لَآيَاتٍ وَإِن كُنَّا لَمُبْتَلِينَ",
    "ثُمَّ أَنشَأْنَا مِن بَعْدِهِمْ قَرْنًا آخَرِينَ",
    "فَأَرْسَلْنَا فِيهِمْ رَسُولًا مِّنْهُمْ أَنِ اعْبُدُوا اللَّهَ مَا لَكُم مِّنْ إِلَٰهٍ غَيْرُهُ ۖ أَفَلَا تَتَّقُونَ",
    "وَقَالَ الْمَلَأُ مِن قَوْمِهِ الَّذِينَ كَفَرُوا وَكَذَّبُوا بِلِقَاءِ الْآخِرَةِ وَأَتْرَفْنَاهُمْ فِي الْحَيَاةِ الدُّنْيَا مَا هَٰذَا إِلَّا بَشَرٌ مِّثْلُكُمْ يَأْكُلُ مِمَّا تَأْكُلُونَ مِنْهُ وَيَشْرَبُ مِمَّا تَشْرَبُونَ",
    "وَلَئِنْ أَطَعْتُم بَشَرًا مِّثْلَكُمْ إِنَّكُمْ إِذًا لَّخَاسِرُونَ",
    "أَيَعِدُكُمْ أَنَّكُمْ إِذَا مِتُّمْ وَكُنتُمْ تُرَابًا وَعِظَامًا أَنَّكُم مُّخْرَجُونَ",
    "هَيْهَاتَ هَيْهَاتَ لِمَا تُوعَدُونَ",
    "إِنْ هِيَ إِلَّا حَيَاتُنَا الدُّنْيَا نَمُوتُ وَنَحْيَا وَمَا نَحْنُ بِمَبْعُوثِينَ",
    "إِنْ هُوَ إِلَّا رَجُلٌ افْتَرَىٰ عَلَى اللَّهِ كَذِبًا وَمَا نَحْنُ لَهُ بِمُؤْمِنِينَ",
    "قَالَ رَبِّ انصُرْنِي بِمَا كَذَّبُونِ",
    "قَالَ عَمَّا قَلِيلٍ لَّيُصْبِحُنَّ نَادِمِينَ",
    "فَأَخَذَتْهُمُ الصَّيْحَةُ بِالْحَقِّ فَجَعَلْنَاهُمْ غُثَاءً ۚ فَبُعْدًا لِّلْقَوْمِ الظَّالِمِينَ",
    "ثُمَّ أَنشَأْنَا مِن بَعْدِهِمْ قُرُونًا آخَرِينَ",
    "مَا تَسْبِقُ مِنْ أُمَّةٍ أَجَلَهَا وَمَا يَسْتَأْخِرُونَ",
    "ثُمَّ أَرْسَلْنَا رُسُلَنَا تَتْرَىٰ ۖ كُلَّ مَا جَاءَ أُمَّةً رَّسُولُهَا كَذَّبُوهُ ۚ فَأَتْبَعْنَا بَعْضَهُم بَعْضًا وَجَعَلْنَاهُمْ أَحَادِيثَ ۚ فَبُعْدًا لِّقَوْمٍ لَّا يُؤْمِنُونَ",
    "ثُمَّ أَرْسَلْنَا مُوسَىٰ وَأَخَاهُ هَارُونَ بِآيَاتِنَا وَسُلْطَانٍ مُّبِينٍ",
    "إِلَىٰ فِرْعَوْنَ وَمَلَئِهِ فَاسْتَكْبَرُوا وَكَانُوا قَوْمًا عَالِينَ",
    "فَقَالُوا أَنُؤْمِنُ لِبَشَرَيْنِ مِثْلِنَا وَقَوْمُهُمَا لَنَا عَابِدُونَ",
    "فَكَذَّبُوهُمَا فَكَانُوا مِنَ الْمُهْلَكِينَ",
    "وَلَقَدْ آتَيْنَا مُوسَى الْكِتَابَ لَعَلَّهُمْ يَهْتَدُونَ",
    "وَجَعَلْنَا ابْنَ مَرْيَمَ وَأُمَّهُ آيَةً وَآوَيْنَاهُمَا إِلَىٰ رَبْوَةٍ ذَاتِ قَرَارٍ وَمَعِينٍ",
    "يَا أَيُّهَا الرُّسُلُ كُلُوا مِنَ الطَّيِّبَاتِ وَاعْمَلُوا صَالِحًا ۖ إِنِّي بِمَا تَعْمَلُونَ عَلِيمٌ",
    "وَإِنَّ هَٰذِهِ أُمَّتُكُمْ أُمَّةً وَاحِدَةً وَأَنَا رَبُّكُمْ فَاتَّقُونِ",
    "فَتَقَطَّعُوا أَمْرَهُم بَيْنَهُمْ زُبُرًا ۖ كُلُّ حِزْبٍ بِمَا لَدَيْهِمْ فَرِحُونَ",
    "فَذَرْهُمْ فِي غَمْرَتِهِمْ حَتَّىٰ حِينٍ",
    "أَيَحْسَبُونَ أَنَّمَا نُمِدُّهُم بِهِ مِن مَّالٍ وَبَنِينَ",
    "نُسَارِعُ لَهُمْ فِي الْخَيْرَاتِ ۚ بَل لَّا يَشْعُرُونَ",
    "إِنَّ الَّذِينَ هُم مِّنْ خَشْيَةِ رَبِّهِم مُّشْفِقُونَ",
    "وَالَّذِينَ هُم بِآيَاتِ رَبِّهِمْ يُؤْمِنُونَ",
    "وَالَّذِينَ هُم بِرَبِّهِمْ لَا يُشْرِكُونَ",
    "وَالَّذِينَ يُؤْتُونَ مَا آتَوا وَّقُلُوبُهُمْ وَجِلَةٌ أَنَّهُمْ إِلَىٰ رَبِّهِمْ رَاجِعُونَ",
    "أُولَٰئِكَ يُسَارِعُونَ فِي الْخَيْرَاتِ وَهُمْ لَهَا سَابِقُونَ",
    "وَلَا نُكَلِّفُ نَفْسًا إِلَّا وُسْعَهَا ۖ وَلَدَيْنَا كِتَابٌ يَنطِقُ بِالْحَقِّ ۚ وَهُمْ لَا يُظْلَمُونَ",
    "بَلْ قُلُوبُهُمْ فِي غَمْرَةٍ مِّنْ هَٰذَا وَلَهُمْ أَعْمَالٌ مِّن دُونِ ذَٰلِكَ هُمْ لَهَا عَامِلُونَ",
    "حَتَّىٰ إِذَا أَخَذْنَا مُتْرَفِيهِم بِالْعَذَابِ إِذَا هُمْ يَجْأَرُونَ",
    "لَا تَجْأَرُوا الْيَوْمَ ۖ إِنَّكُم مِّنَّا لَا تُنصَرُونَ",
    "قَدْ كَانَتْ آيَاتِي تُتْلَىٰ عَلَيْكُمْ فَكُنتُمْ عَلَىٰ أَعْقَابِكُمْ تَنكِصُونَ",
    "مُسْتَكْبِرِينَ بِهِ سَامِرًا تَهْجُرُونَ",
    "أَفَلَمْ يَدَّبَّرُوا الْقَوْلَ أَمْ جَاءَهُم مَّا لَمْ يَأْتِ آبَاءَهُمُ الْأَوَّلِينَ",
    "أَمْ لَمْ يَعْرِفُوا رَسُولَهُمْ فَهُمْ لَهُ مُنكِرُونَ",
    "أَمْ يَقُولُونَ بِهِ جِنَّةٌ ۚ بَلْ جَاءَهُم بِالْحَقِّ وَأَكْثَرُهُمْ لِلْحَقِّ كَارِهُونَ",
    "وَلَوِ اتَّبَعَ الْحَقُّ أَهْوَاءَهُمْ لَفَسَدَتِ السَّمَاوَاتُ وَالْأَرْضُ وَمَن فِيهِنَّ ۚ بَلْ أَتَيْنَاهُم بِذِكْرِهِمْ فَهُمْ عَن ذِكْرِهِم مُّعْرِضُونَ",
    "أَمْ تَسْأَلُهُمْ خَرْجًا فَخَرَاجُ رَبِّكَ خَيْرٌ ۖ وَهُوَ خَيْرُ الرَّازِقِينَ",
    "وَإِنَّكَ لَتَدْعُوهُمْ إِلَىٰ صِرَاطٍ مُّسْتَقِيمٍ",
    "وَإِنَّ الَّذِينَ لَا يُؤْمِنُونَ بِالْآخِرَةِ عَنِ الصِّرَاطِ لَنَاكِبُونَ",
    "وَلَوْ رَحِمْنَاهُمْ وَكَشَفْنَا مَا بِهِم مِّن ضُرٍّ لَّلَجُّوا فِي طُغْيَانِهِمْ يَعْمَهُونَ",
    "وَلَقَدْ أَخَذْنَاهُم بِالْعَذَابِ فَمَا اسْتَكَانُوا لِرَبِّهِمْ وَمَا يَتَضَرَّعُونَ",
    "حَتَّىٰ إِذَا فَتَحْنَا عَلَيْهِم بَابًا ذَا عَذَابٍ شَدِيدٍ إِذَا هُمْ فِيهِ مُبْلِسُونَ",
    "وَهُوَ الَّذِي أَنشَأَ لَكُمُ السَّمْعَ وَالْأَبْصَارَ وَالْأَفْئِدَةَ ۚ قَلِيلًا مَّا تَشْكُرُونَ",
    "وَهُوَ الَّذِي ذَرَأَكُمْ فِي الْأَرْضِ وَإِلَيْهِ تُحْشَرُونَ",
    "وَهُوَ الَّذِي يُحْيِي وَيُمِيتُ وَلَهُ اخْتِلَافُ اللَّيْلِ وَالنَّهَارِ ۚ أَفَلَا تَعْقِلُونَ",
    "بَلْ قَالُوا مِثْلَ مَا قَالَ الْأَوَّلُونَ",
    "قَالُوا أَإِذَا مِتْنَا وَكُنَّا تُرَابًا وَعِظَامًا أَإِنَّا لَمَبْعُوثُونَ",
    "لَقَدْ وُعِدْنَا نَحْنُ وَآبَاؤُنَا هَٰذَا مِن قَبْلُ إِنْ هَٰذَا إِلَّا أَسَاطِيرُ الْأَوَّلِينَ",
    "قُل لِّمَنِ الْأَرْضُ وَمَن فِيهَا إِن كُنتُمْ تَعْلَمُونَ",
    "سَيَقُولُونَ لِلَّهِ ۚ قُلْ أَفَلَا تَذَكَّرُونَ",
    "قُلْ مَن رَّبُّ السَّمَاوَاتِ السَّبْعِ وَرَبُّ الْعَرْشِ الْعَظِيمِ",
    "سَيَقُولُونَ لِلَّهِ ۚ قُلْ أَفَلَا تَتَّقُونَ",
    "قُلْ مَن بِيَدِهِ مَلَكُوتُ كُلِّ شَيْءٍ وَهُوَ يُجِيرُ وَلَا يُجَارُ عَلَيْهِ إِن كُنتُمْ تَعْلَمُونَ",
    "سَيَقُولُونَ لِلَّهِ ۚ قُلْ فَأَنَّىٰ تُسْحَرُونَ",
    "بَلْ أَتَيْنَاهُم بِالْحَقِّ وَإِنَّهُمْ لَكَاذِبُونَ",
    "مَا اتَّخَذَ اللَّهُ مِن وَلَدٍ وَمَا كَانَ مَعَهُ مِنْ إِلَٰهٍ ۚ إِذًا لَّذَهَبَ كُلُّ إِلَٰهٍ بِمَا خَلَقَ وَلَعَلَا بَعْضُهُمْ عَلَىٰ بَعْضٍ ۚ سُبْحَانَ اللَّهِ عَمَّا يَصِفُونَ",
    "عَالِمِ الْغَيْبِ وَالشَّهَادَةِ فَتَعَالَىٰ عَمَّا يُشْرِكُونَ",
    "قُل رَّبِّ إِمَّا تُرِيَنِّي مَا يُوعَدُونَ",
    "رَبِّ فَلَا تَجْعَلْنِي فِي الْقَوْمِ الظَّالِمِينَ",
    "وَإِنَّا عَلَىٰ أَن نُّرِيَكَ مَا نَعِدُهُمْ لَقَادِرُونَ",
    "ادْفَعْ بِالَّتِي هِيَ أَحْسَنُ السَّيِّئَةَ ۚ نَحْنُ أَعْلَمُ بِمَا يَصِفُونَ",
    "وَقُل رَّبِّ أَعُوذُ بِكَ مِنْ هَمَزَاتِ الشَّيَاطِينِ",
    "وَأَعُوذُ بِكَ رَبِّ أَن يَحْضُرُونِ",
    "حَتَّىٰ إِذَا جَاءَ أَحَدَهُمُ الْمَوْتُ قَالَ رَبِّ ارْجِعُونِ",
    "لَعَلِّي أَعْمَلُ صَالِحًا فِيمَا تَرَكْتُ ۚ كَلَّا ۚ إِنَّهَا كَلِمَةٌ هُوَ قَائِلُهَا ۖ وَمِن وَرَائِهِم بَرْزَخٌ إِلَىٰ يَوْمِ يُبْعَثُونَ",
    "فَإِذَا نُفِخَ فِي الصُّورِ فَلَا أَنسَابَ بَيْنَهُمْ يَوْمَئِذٍ وَلَا يَتَسَاءَلُونَ",
    "فَمَن ثَقُلَتْ مَوَازِينُهُ فَأُولَٰئِكَ هُمُ الْمُفْلِحُونَ",
    "وَمَنْ خَفَّتْ مَوَازِينُهُ فَأُولَٰئِكَ الَّذِينَ خَسِرُوا أَنفُسَهُمْ فِي جَهَنَّمَ خَالِدُونَ",
    "تَلْفَحُ وُجُوهَهُمُ النَّارُ وَهُمْ فِيهَا كَالِحُونَ",
    "أَلَمْ تَكُنْ آيَاتِي تُتْلَىٰ عَلَيْكُمْ فَكُنتُم بِهَا تُكَذِّبُونَ",
    "قَالُوا رَبَّنَا غَلَبَتْ عَلَيْنَا شِقْوَتُنَا وَكُنَّا قَوْمًا ضَالِّينَ",
    "رَبَّنَا أَخْرِجْنَا مِنْهَا فَإِنْ عُدْنَا فَإِنَّا ظَالِمُونَ",
    "قَالَ اخْسَئُوا فِيهَا وَلَا تُكَلِّمُونِ",
    "إِنَّهُ كَانَ فَرِيقٌ مِّنْ عِبَادِي يَقُولُونَ رَبَّنَا آمَنَّا فَاغْفِرْ لَنَا وَارْحَمْنَا وَأَنتَ خَيْرُ الرَّاحِمِينَ",
    "فَاتَّخَذْتُمُوهُمْ سِخْرِيًّا حَتَّىٰ أَنسَوْكُمْ ذِكْرِي وَكُنتُم مِّنْهُمْ تَضْحَكُونَ",
    "إِنِّي جَزَيْتُهُمُ الْيَوْمَ بِمَا صَبَرُوا أَنَّهُمْ هُمُ الْفَائِزُونَ",
    "قَالَ كَمْ لَبِثْتُمْ فِي الْأَرْضِ عَدَدَ سِنِينَ",
    "قَالُوا لَبِثْنَا يَوْمًا أَوْ بَعْضَ يَوْمٍ فَاسْأَلِ الْعَادِّينَ",
    "قَالَ إِن لَّبِثْتُمْ إِلَّا قَلِيلًا ۖ لَّوْ أَنَّكُمْ كُنتُمْ تَعْلَمُونَ",
    "أَفَحَسِبْتُمْ أَنَّمَا خَلَقْنَاكُمْ عَبَثًا وَأَنَّكُمْ إِلَيْنَا لَا تُرْجَعُونَ",
    "فَتَعَالَى اللَّهُ الْمَلِكُ الْحَقُّ ۖ لَا إِلَٰهَ إِلَّا هُوَ رَبُّ الْعَرْشِ الْكَرِيمِ",
    "وَمَن يَدْعُ مَعَ اللَّهِ إِلَٰهًا آخَرَ لَا بُرْهَانَ لَهُ بِهِ فَإِنَّمَا حِسَابُهُ عِندَ رَبِّهِ ۚ إِنَّهُ لَا يُفْلِحُ الْكَافِرُونَ",
    "وَقُل رَّبِّ اغْفِرْ وَارْحَمْ وَأَنتَ خَيْرُ الرَّاحِمِينَ"};

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
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Certainly will the believers have succeeded:",
    "They who are during their prayer humbly submissive",
    "And they who turn away from ill speech",
    "And they who are observant of zakah",
    "And they who guard their private parts",
    "Except from their wives or those their right hands possess, for indeed, they will not be blamed -",
    "But whoever seeks beyond that, then those are the transgressors -",
    "And they who are to their trusts and their promises attentive",
    "And they who carefully maintain their prayers -",
    "Those are the inheritors",
    "Who will inherit al-Firdaus. They will abide therein eternally.",
    "And certainly did We create man from an extract of clay.",
    "Then We placed him as a sperm-drop in a firm lodging.",
    "Then We made the sperm-drop into a clinging clot, and We made the clot into a lump [of flesh], and We made [from] the lump, bones, and We covered the bones with flesh; then We developed him into another creation. So blessed is Allah, the best of creators.",
    "Then indeed, after that you are to die.",
    "Then indeed you, on the Day of Resurrection, will be resurrected.",
    "And We have created above you seven layered heavens, and never have We been of [Our] creation unaware.",
    "And We have sent down rain from the sky in a measured amount and settled it in the earth. And indeed, We are Able to take it away.",
    "And We brought forth for you thereby gardens of palm trees and grapevines in which for you are abundant fruits and from which you eat.",
    "And [We brought forth] a tree issuing from Mount Sinai which produces oil and food for those who eat.",
    "And indeed, for you in livestock is a lesson. We give you drink from that which is in their bellies, and for you in them are numerous benefits, and from them you eat.",
    "And upon them and on ships you are carried.",
    "And We had certainly sent Noah to his people, and he said, \"O my people, worship Allah; you have no deity other than Him; then will you not fear Him?\"",
    "But the eminent among those who disbelieved from his people said, \"This is not but a man like yourselves who wishes to take precedence over you; and if Allah had willed [to send a messenger], He would have sent down angels. We have not heard of this among our forefathers.",
    "He is not but a man possessed with madness, so wait concerning him for a time.\"",
    "[Noah] said, \"My Lord, support me because they have denied me.\"",
    "So We inspired to him, \"Construct the ship under Our observation, and Our inspiration, and when Our command comes and the oven overflows, put into the ship from each [creature] two mates and your family, except those for whom the decree [of destruction] has proceeded. And do not address Me concerning those who have wronged; indeed, they are to be drowned.",
    "And when you have boarded the ship, you and those with you, then say, 'Praise to Allah who has saved us form the wrongdoing people.'",
    "And say, 'My Lord, let me land at a blessed landing place, and You are the best to accommodate [us].' \"",
    "Indeed in that are signs, and indeed, We are ever testing [Our servants].",
    "Then We produced after them a generation of others.",
    "And We sent among them a messenger from themselves, [saying], \"Worship Allah; you have no deity other than Him; then will you not fear Him?\"",
    "And the eminent among his people who disbelieved and denied the meeting of the Hereafter while We had given them luxury in the worldly life said, \"This is not but a man like yourselves. He eats of that from which you eat and drinks of what you drink.",
    "And if you should obey a man like yourselves, indeed, you would then be losers.",
    "Does he promise you that when you have died and become dust and bones that you will be brought forth [once more]?",
    "How far, how far, is that which you are promised.",
    "Life is not but our worldly life - we die and live, but we will not be resurrected.",
    "He is not but a man who has invented a lie about Allah, and we will not believe him.\"",
    "He said, \"My Lord, support me because they have denied me.\"",
    "[Allah] said, \"After a little, they will surely become regretful.\"",
    "So the shriek seized them in truth, and We made them as [plant] stubble. Then away with the wrongdoing people.",
    "Then We produced after them other generations.",
    "No nation will precede its time [of termination], nor will they remain [thereafter].",
    "Then We sent Our messengers in succession. Every time there came to a nation its messenger, they denied him, so We made them follow one another [to destruction], and We made them narrations. So away with a people who do not believe.",
    "Then We sent Moses and his brother Aaron with Our signs and a clear authority",
    "To Pharaoh and his establishment, but they were arrogant and were a haughty people.",
    "They said, \"Should we believe two men like ourselves while their people are for us in servitude?\"",
    "So they denied them and were of those destroyed.",
    "And We certainly gave Moses the Scripture that perhaps they would be guided.",
    "And We made the son of Mary and his mother a sign and sheltered them within a high ground having level [areas] and flowing water.",
    "[Allah said], \"O messengers, eat from the good foods and work righteousness. Indeed, I, of what you do, am Knowing.",
    "And indeed this, your religion, is one religion, and I am your Lord, so fear Me.\"",
    "But the people divided their religion among them into sects - each faction, in what it has, rejoicing.",
    "So leave them in their confusion for a time.",
    "Do they think that what We extend to them of wealth and children",
    "Is [because] We hasten for them good things? Rather, they do not perceive.",
    "Indeed, they who are apprehensive from fear of their Lord",
    "And they who believe in the signs of their Lord",
    "And they who do not associate anything with their Lord",
    "And they who give what they give while their hearts are fearful because they will be returning to their Lord -",
    "It is those who hasten to good deeds, and they outstrip [others] therein.",
    "And We charge no soul except [with that within] its capacity, and with Us is a record which speaks with truth; and they will not be wronged.",
    "But their hearts are covered with confusion over this, and they have [evil] deeds besides disbelief which they are doing,",
    "Until when We seize their affluent ones with punishment, at once they are crying [to Allah] for help.",
    "Do not cry out today. Indeed, by Us you will not be helped.",
    "My verses had already been recited to you, but you were turning back on your heels",
    "In arrogance regarding it, conversing by night, speaking evil.",
    "Then have they not reflected over the Qur'an, or has there come to them that which had not come to their forefathers?",
    "Or did they not know their Messenger, so they are toward him disacknowledging?",
    "Or do they say, \"In him is madness?\" Rather, he brought them the truth, but most of them, to the truth, are averse.",
    "But if the Truth had followed their inclinations, the heavens and the earth and whoever is in them would have been ruined. Rather, We have brought them their message, but they, from their message, are turning away.",
    "Or do you, [O Muhammad], ask them for payment? But the reward of your Lord is best, and He is the best of providers.",
    "And indeed, you invite them to a straight path.",
    "But indeed, those who do not believe in the Hereafter are deviating from the path.",
    "And even if We gave them mercy and removed what was upon them of affliction, they would persist in their transgression, wandering blindly.",
    "And We had gripped them with suffering [as a warning], but they did not yield to their Lord, nor did they humbly supplicate, [and will continue thus]",
    "Until when We have opened before them a door of severe punishment, immediately they will be therein in despair.",
    "And it is He who produced for you hearing and vision and hearts; little are you grateful.",
    "And it is He who has multiplied you throughout the earth, and to Him you will be gathered.",
    "And it is He who gives life and causes death, and His is the alternation of the night and the day. Then will you not reason?",
    "Rather, they say like what the former peoples said.",
    "They said, \"When we have died and become dust and bones, are we indeed to be resurrected?",
    "We have been promised this, we and our forefathers, before; this is not but legends of the former peoples.\"",
    "Say, [O Muhammad], \"To whom belongs the earth and whoever is in it, if you should know?\"",
    "They will say, \"To Allah.\" Say, \"Then will you not remember?\"",
    "Say, \"Who is Lord of the seven heavens and Lord of the Great Throne?\"",
    "They will say, \"[They belong] to Allah.\" Say, \"Then will you not fear Him?\"",
    "Say, \"In whose hand is the realm of all things - and He protects while none can protect against Him - if you should know?\"",
    "They will say, \"[All belongs] to Allah.\" Say, \"Then how are you deluded?\"",
    "Rather, We have brought them the truth, and indeed they are liars.",
    "Allah has not taken any son, nor has there ever been with Him any deity. [If there had been], then each deity would have taken what it created, and some of them would have sought to overcome others. Exalted is Allah above what they describe [concerning Him].",
    "[He is] Knower of the unseen and the witnessed, so high is He above what they associate [with Him].",
    "Say, [O Muhammad], \"My Lord, if You should show me that which they are promised,",
    "My Lord, then do not place me among the wrongdoing people.\"",
    "And indeed, We are able to show you what We have promised them.",
    "Repel, by [means of] what is best, [their] evil. We are most knowing of what they describe.",
    "And say, \"My Lord, I seek refuge in You from the incitements of the devils,",
    "And I seek refuge in You, my Lord , lest they be present with me.\"",
    "[For such is the state of the disbelievers], until, when death comes to one of them, he says, \"My Lord, send me back",
    "That I might do righteousness in that which I left behind.\" No! It is only a word he is saying; and behind them is a barrier until the Day they are resurrected.",
    "So when the Horn is blown, no relationship will there be among them that Day, nor will they ask about one another.",
    "And those whose scales are heavy [with good deeds] - it is they who are the successful.",
    "But those whose scales are light - those are the ones who have lost their souls, [being] in Hell, abiding eternally.",
    "The Fire will sear their faces, and they therein will have taut smiles.",
    "[It will be said]. \"Were not My verses recited to you and you used to deny them?\"",
    "They will say, \"Our Lord, our wretchedness overcame us, and we were a people astray.",
    "Our Lord, remove us from it, and if we were to return [to evil], we would indeed be wrongdoers.\"",
    "He will say, \"Remain despised therein and do not speak to Me.",
    "Indeed, there was a party of My servants who said, 'Our Lord, we have believed, so forgive us and have mercy upon us, and You are the best of the merciful.'",
    "But you took them in mockery to the point that they made you forget My remembrance, and you used to laugh at them.",
    "Indeed, I have rewarded them this Day for their patient endurance - that they are the attainers [of success].\"",
    "[Allah] will say, \"How long did you remain on earth in number of years?\"",
    "They will say, \"We remained a day or part of a day; ask those who enumerate.\"",
    "He will say, \"You stayed not but a little - if only you had known.",
    "Then did you think that We created you uselessly and that to Us you would not be returned?\"",
    "So exalted is Allah, the Sovereign, the Truth; there is no deity except Him, Lord of the Noble Throne.",
    "And whoever invokes besides Allah another deity for which he has no proof - then his account is only with his Lord. Indeed, the disbelievers will not succeed.",
    "And, [O Muhammad], say, \"My Lord, forgive and have mercy, and You are the best of the merciful.\""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__muminun);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_muminun);
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
