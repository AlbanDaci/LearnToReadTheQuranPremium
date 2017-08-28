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

public class Al_Ankabut extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "http://download.audioislam.com/audio/quran/recitation/al-afaasee/surah_al_ankabut.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"29:1", "29:2", "29:3", "29:4", "29:5", "29:6", "29:7", "29:8", "29:9", "29:10", "29:11", "29:12", "29:13", "29:14", "29:15", "29:16",
            "29:17", "29:18", "29:19", "29:20", "29:21", "29:22", "29:23", "29:24", "29:25", "29:26", "29:27", "29:28", "29:29", "29:30", "29:31", "29:32",
            "29:33", "29:34", "29:35", "29:36", "29:37", "29:38", "29:39", "29:40", "29:41", "29:42", "29:43", "29:44", "29:45", "29:46", "29:47", "29:48",
            "29:49", "29:50", "29:51", "29:52", "29:53", "29:54", "29:55", "29:56", "29:57", "29:58", "29:59", "29:60", "29:61", "29:62", "29:63", "29:64",
            "29:65", "29:66", "29:67", "29:68", "29:69"};

    String [] arabic_verses = {"الم",
    "أَحَسِبَ النَّاسُ أَن يُتْرَكُوا أَن يَقُولُوا آمَنَّا وَهُمْ لَا يُفْتَنُونَ",
    "وَلَقَدْ فَتَنَّا الَّذِينَ مِن قَبْلِهِمْ ۖ فَلَيَعْلَمَنَّ اللَّهُ الَّذِينَ صَدَقُوا وَلَيَعْلَمَنَّ الْكَاذِبِينَ",
    "أَمْ حَسِبَ الَّذِينَ يَعْمَلُونَ السَّيِّئَاتِ أَن يَسْبِقُونَا ۚ سَاءَ مَا يَحْكُمُونَ",
    "مَن كَانَ يَرْجُو لِقَاءَ اللَّهِ فَإِنَّ أَجَلَ اللَّهِ لَآتٍ ۚ وَهُوَ السَّمِيعُ الْعَلِيمُ",
    "وَمَن جَاهَدَ فَإِنَّمَا يُجَاهِدُ لِنَفْسِهِ ۚ إِنَّ اللَّهَ لَغَنِيٌّ عَنِ الْعَالَمِينَ",
    "وَالَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ لَنُكَفِّرَنَّ عَنْهُمْ سَيِّئَاتِهِمْ وَلَنَجْزِيَنَّهُمْ أَحْسَنَ الَّذِي كَانُوا يَعْمَلُونَ",
    "وَوَصَّيْنَا الْإِنسَانَ بِوَالِدَيْهِ حُسْنًا ۖ وَإِن جَاهَدَاكَ لِتُشْرِكَ بِي مَا لَيْسَ لَكَ بِهِ عِلْمٌ فَلَا تُطِعْهُمَا ۚ إِلَيَّ مَرْجِعُكُمْ فَأُنَبِّئُكُم بِمَا كُنتُمْ تَعْمَلُونَ",
    "وَالَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ لَنُدْخِلَنَّهُمْ فِي الصَّالِحِينَ",
    "وَمِنَ النَّاسِ مَن يَقُولُ آمَنَّا بِاللَّهِ فَإِذَا أُوذِيَ فِي اللَّهِ جَعَلَ فِتْنَةَ النَّاسِ كَعَذَابِ اللَّهِ وَلَئِن جَاءَ نَصْرٌ مِّن رَّبِّكَ لَيَقُولُنَّ إِنَّا كُنَّا مَعَكُمْ ۚ أَوَلَيْسَ اللَّهُ بِأَعْلَمَ بِمَا فِي صُدُورِ الْعَالَمِينَ",
    "وَلَيَعْلَمَنَّ اللَّهُ الَّذِينَ آمَنُوا وَلَيَعْلَمَنَّ الْمُنَافِقِينَ",
    "وَقَالَ الَّذِينَ كَفَرُوا لِلَّذِينَ آمَنُوا اتَّبِعُوا سَبِيلَنَا وَلْنَحْمِلْ خَطَايَاكُمْ وَمَا هُم بِحَامِلِينَ مِنْ خَطَايَاهُم مِّن شَيْءٍ ۖ إِنَّهُمْ لَكَاذِبُونَ",
    "وَلَيَحْمِلُنَّ أَثْقَالَهُمْ وَأَثْقَالًا مَّعَ أَثْقَالِهِمْ ۖ وَلَيُسْأَلُنَّ يَوْمَ الْقِيَامَةِ عَمَّا كَانُوا يَفْتَرُونَ",
    "وَلَقَدْ أَرْسَلْنَا نُوحًا إِلَىٰ قَوْمِهِ فَلَبِثَ فِيهِمْ أَلْفَ سَنَةٍ إِلَّا خَمْسِينَ عَامًا فَأَخَذَهُمُ الطُّوفَانُ وَهُمْ ظَالِمُونَ",
    "فَأَنجَيْنَاهُ وَأَصْحَابَ السَّفِينَةِ وَجَعَلْنَاهَا آيَةً لِّلْعَالَمِينَ",
    "وَإِبْرَاهِيمَ إِذْ قَالَ لِقَوْمِهِ اعْبُدُوا اللَّهَ وَاتَّقُوهُ ۖ ذَٰلِكُمْ خَيْرٌ لَّكُمْ إِن كُنتُمْ تَعْلَمُونَ",
    "إِنَّمَا تَعْبُدُونَ مِن دُونِ اللَّهِ أَوْثَانًا وَتَخْلُقُونَ إِفْكًا ۚ إِنَّ الَّذِينَ تَعْبُدُونَ مِن دُونِ اللَّهِ لَا يَمْلِكُونَ لَكُمْ رِزْقًا فَابْتَغُوا عِندَ اللَّهِ الرِّزْقَ وَاعْبُدُوهُ وَاشْكُرُوا لَهُ ۖ إِلَيْهِ تُرْجَعُونَ",
    "وَإِن تُكَذِّبُوا فَقَدْ كَذَّبَ أُمَمٌ مِّن قَبْلِكُمْ ۖ وَمَا عَلَى الرَّسُولِ إِلَّا الْبَلَاغُ الْمُبِينُ",
    "أَوَلَمْ يَرَوْا كَيْفَ يُبْدِئُ اللَّهُ الْخَلْقَ ثُمَّ يُعِيدُهُ ۚ إِنَّ ذَٰلِكَ عَلَى اللَّهِ يَسِيرٌ",
    "قُلْ سِيرُوا فِي الْأَرْضِ فَانظُرُوا كَيْفَ بَدَأَ الْخَلْقَ ۚ ثُمَّ اللَّهُ يُنشِئُ النَّشْأَةَ الْآخِرَةَ ۚ إِنَّ اللَّهَ عَلَىٰ كُلِّ شَيْءٍ قَدِيرٌ",
    "يُعَذِّبُ مَن يَشَاءُ وَيَرْحَمُ مَن يَشَاءُ ۖ وَإِلَيْهِ تُقْلَبُونَ",
    "وَمَا أَنتُم بِمُعْجِزِينَ فِي الْأَرْضِ وَلَا فِي السَّمَاءِ ۖ وَمَا لَكُم مِّن دُونِ اللَّهِ مِن وَلِيٍّ وَلَا نَصِيرٍ",
    "وَالَّذِينَ كَفَرُوا بِآيَاتِ اللَّهِ وَلِقَائِهِ أُولَٰئِكَ يَئِسُوا مِن رَّحْمَتِي وَأُولَٰئِكَ لَهُمْ عَذَابٌ أَلِيمٌ",
    "فَمَا كَانَ جَوَابَ قَوْمِهِ إِلَّا أَن قَالُوا اقْتُلُوهُ أَوْ حَرِّقُوهُ فَأَنجَاهُ اللَّهُ مِنَ النَّارِ ۚ إِنَّ فِي ذَٰلِكَ لَآيَاتٍ لِّقَوْمٍ يُؤْمِنُونَ",
    "وَقَالَ إِنَّمَا اتَّخَذْتُم مِّن دُونِ اللَّهِ أَوْثَانًا مَّوَدَّةَ بَيْنِكُمْ فِي الْحَيَاةِ الدُّنْيَا ۖ ثُمَّ يَوْمَ الْقِيَامَةِ يَكْفُرُ بَعْضُكُم بِبَعْضٍ وَيَلْعَنُ بَعْضُكُم بَعْضًا وَمَأْوَاكُمُ النَّارُ وَمَا لَكُم مِّن نَّاصِرِينَ",
    "فَآمَنَ لَهُ لُوطٌ ۘ وَقَالَ إِنِّي مُهَاجِرٌ إِلَىٰ رَبِّي ۖ إِنَّهُ هُوَ الْعَزِيزُ الْحَكِيمُ",
    "وَوَهَبْنَا لَهُ إِسْحَاقَ وَيَعْقُوبَ وَجَعَلْنَا فِي ذُرِّيَّتِهِ النُّبُوَّةَ وَالْكِتَابَ وَآتَيْنَاهُ أَجْرَهُ فِي الدُّنْيَا ۖ وَإِنَّهُ فِي الْآخِرَةِ لَمِنَ الصَّالِحِينَ",
    "وَلُوطًا إِذْ قَالَ لِقَوْمِهِ إِنَّكُمْ لَتَأْتُونَ الْفَاحِشَةَ مَا سَبَقَكُم بِهَا مِنْ أَحَدٍ مِّنَ الْعَالَمِينَ",
    "أَئِنَّكُمْ لَتَأْتُونَ الرِّجَالَ وَتَقْطَعُونَ السَّبِيلَ وَتَأْتُونَ فِي نَادِيكُمُ الْمُنكَرَ ۖ فَمَا كَانَ جَوَابَ قَوْمِهِ إِلَّا أَن قَالُوا ائْتِنَا بِعَذَابِ اللَّهِ إِن كُنتَ مِنَ الصَّادِقِينَ",
    "قَالَ رَبِّ انصُرْنِي عَلَى الْقَوْمِ الْمُفْسِدِينَ",
    "وَلَمَّا جَاءَتْ رُسُلُنَا إِبْرَاهِيمَ بِالْبُشْرَىٰ قَالُوا إِنَّا مُهْلِكُو أَهْلِ هَٰذِهِ الْقَرْيَةِ ۖ إِنَّ أَهْلَهَا كَانُوا ظَالِمِينَ",
    "قَالَ إِنَّ فِيهَا لُوطًا ۚ قَالُوا نَحْنُ أَعْلَمُ بِمَن فِيهَا ۖ لَنُنَجِّيَنَّهُ وَأَهْلَهُ إِلَّا امْرَأَتَهُ كَانَتْ مِنَ الْغَابِرِينَ",
    "وَلَمَّا أَن جَاءَتْ رُسُلُنَا لُوطًا سِيءَ بِهِمْ وَضَاقَ بِهِمْ ذَرْعًا وَقَالُوا لَا تَخَفْ وَلَا تَحْزَنْ ۖ إِنَّا مُنَجُّوكَ وَأَهْلَكَ إِلَّا امْرَأَتَكَ كَانَتْ مِنَ الْغَابِرِينَ",
    "إِنَّا مُنزِلُونَ عَلَىٰ أَهْلِ هَٰذِهِ الْقَرْيَةِ رِجْزًا مِّنَ السَّمَاءِ بِمَا كَانُوا يَفْسُقُونَ",
    "وَلَقَد تَّرَكْنَا مِنْهَا آيَةً بَيِّنَةً لِّقَوْمٍ يَعْقِلُونَ",
    "وَإِلَىٰ مَدْيَنَ أَخَاهُمْ شُعَيْبًا فَقَالَ يَا قَوْمِ اعْبُدُوا اللَّهَ وَارْجُوا الْيَوْمَ الْآخِرَ وَلَا تَعْثَوْا فِي الْأَرْضِ مُفْسِدِينَ",
    "فَكَذَّبُوهُ فَأَخَذَتْهُمُ الرَّجْفَةُ فَأَصْبَحُوا فِي دَارِهِمْ جَاثِمِينَ",
    "وَعَادًا وَثَمُودَ وَقَد تَّبَيَّنَ لَكُم مِّن مَّسَاكِنِهِمْ ۖ وَزَيَّنَ لَهُمُ الشَّيْطَانُ أَعْمَالَهُمْ فَصَدَّهُمْ عَنِ السَّبِيلِ وَكَانُوا مُسْتَبْصِرِينَ",
    "وَقَارُونَ وَفِرْعَوْنَ وَهَامَانَ ۖ وَلَقَدْ جَاءَهُم مُّوسَىٰ بِالْبَيِّنَاتِ فَاسْتَكْبَرُوا فِي الْأَرْضِ وَمَا كَانُوا سَابِقِينَ",
    "فَكُلًّا أَخَذْنَا بِذَنبِهِ ۖ فَمِنْهُم مَّنْ أَرْسَلْنَا عَلَيْهِ حَاصِبًا وَمِنْهُم مَّنْ أَخَذَتْهُ الصَّيْحَةُ وَمِنْهُم مَّنْ خَسَفْنَا بِهِ الْأَرْضَ وَمِنْهُم مَّنْ أَغْرَقْنَا ۚ وَمَا كَانَ اللَّهُ لِيَظْلِمَهُمْ وَلَٰكِن كَانُوا أَنفُسَهُمْ يَظْلِمُونَ",
    "مَثَلُ الَّذِينَ اتَّخَذُوا مِن دُونِ اللَّهِ أَوْلِيَاءَ كَمَثَلِ الْعَنكَبُوتِ اتَّخَذَتْ بَيْتًا ۖ وَإِنَّ أَوْهَنَ الْبُيُوتِ لَبَيْتُ الْعَنكَبُوتِ ۖ لَوْ كَانُوا يَعْلَمُونَ",
    "إِنَّ اللَّهَ يَعْلَمُ مَا يَدْعُونَ مِن دُونِهِ مِن شَيْءٍ ۚ وَهُوَ الْعَزِيزُ الْحَكِيمُ",
    "وَتِلْكَ الْأَمْثَالُ نَضْرِبُهَا لِلنَّاسِ ۖ وَمَا يَعْقِلُهَا إِلَّا الْعَالِمُونَ",
    "خَلَقَ اللَّهُ السَّمَاوَاتِ وَالْأَرْضَ بِالْحَقِّ ۚ إِنَّ فِي ذَٰلِكَ لَآيَةً لِّلْمُؤْمِنِينَ",
    "اتْلُ مَا أُوحِيَ إِلَيْكَ مِنَ الْكِتَابِ وَأَقِمِ الصَّلَاةَ ۖ إِنَّ الصَّلَاةَ تَنْهَىٰ عَنِ الْفَحْشَاءِ وَالْمُنكَرِ ۗ وَلَذِكْرُ اللَّهِ أَكْبَرُ ۗ وَاللَّهُ يَعْلَمُ مَا تَصْنَعُونَ",
    "وَلَا تُجَادِلُوا أَهْلَ الْكِتَابِ إِلَّا بِالَّتِي هِيَ أَحْسَنُ إِلَّا الَّذِينَ ظَلَمُوا مِنْهُمْ ۖ وَقُولُوا آمَنَّا بِالَّذِي أُنزِلَ إِلَيْنَا وَأُنزِلَ إِلَيْكُمْ وَإِلَٰهُنَا وَإِلَٰهُكُمْ وَاحِدٌ وَنَحْنُ لَهُ مُسْلِمُونَ",
    "وَكَذَٰلِكَ أَنزَلْنَا إِلَيْكَ الْكِتَابَ ۚ فَالَّذِينَ آتَيْنَاهُمُ الْكِتَابَ يُؤْمِنُونَ بِهِ ۖ وَمِنْ هَٰؤُلَاءِ مَن يُؤْمِنُ بِهِ ۚ وَمَا يَجْحَدُ بِآيَاتِنَا إِلَّا الْكَافِرُونَ",
    "وَمَا كُنتَ تَتْلُو مِن قَبْلِهِ مِن كِتَابٍ وَلَا تَخُطُّهُ بِيَمِينِكَ ۖ إِذًا لَّارْتَابَ الْمُبْطِلُونَ",
    "بَلْ هُوَ آيَاتٌ بَيِّنَاتٌ فِي صُدُورِ الَّذِينَ أُوتُوا الْعِلْمَ ۚ وَمَا يَجْحَدُ بِآيَاتِنَا إِلَّا الظَّالِمُونَ",
    "وَقَالُوا لَوْلَا أُنزِلَ عَلَيْهِ آيَاتٌ مِّن رَّبِّهِ ۖ قُلْ إِنَّمَا الْآيَاتُ عِندَ اللَّهِ وَإِنَّمَا أَنَا نَذِيرٌ مُّبِينٌ",
    "أَوَلَمْ يَكْفِهِمْ أَنَّا أَنزَلْنَا عَلَيْكَ الْكِتَابَ يُتْلَىٰ عَلَيْهِمْ ۚ إِنَّ فِي ذَٰلِكَ لَرَحْمَةً وَذِكْرَىٰ لِقَوْمٍ يُؤْمِنُونَ",
    "قُلْ كَفَىٰ بِاللَّهِ بَيْنِي وَبَيْنَكُمْ شَهِيدًا ۖ يَعْلَمُ مَا فِي السَّمَاوَاتِ وَالْأَرْضِ ۗ وَالَّذِينَ آمَنُوا بِالْبَاطِلِ وَكَفَرُوا بِاللَّهِ أُولَٰئِكَ هُمُ الْخَاسِرُونَ",
    "وَيَسْتَعْجِلُونَكَ بِالْعَذَابِ ۚ وَلَوْلَا أَجَلٌ مُّسَمًّى لَّجَاءَهُمُ الْعَذَابُ وَلَيَأْتِيَنَّهُم بَغْتَةً وَهُمْ لَا يَشْعُرُونَ",
    "يَسْتَعْجِلُونَكَ بِالْعَذَابِ وَإِنَّ جَهَنَّمَ لَمُحِيطَةٌ بِالْكَافِرِينَ",
    "يَوْمَ يَغْشَاهُمُ الْعَذَابُ مِن فَوْقِهِمْ وَمِن تَحْتِ أَرْجُلِهِمْ وَيَقُولُ ذُوقُوا مَا كُنتُمْ تَعْمَلُونَ",
    "يَا عِبَادِيَ الَّذِينَ آمَنُوا إِنَّ أَرْضِي وَاسِعَةٌ فَإِيَّايَ فَاعْبُدُونِ",
    "كُلُّ نَفْسٍ ذَائِقَةُ الْمَوْتِ ۖ ثُمَّ إِلَيْنَا تُرْجَعُونَ",
    "وَالَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ لَنُبَوِّئَنَّهُم مِّنَ الْجَنَّةِ غُرَفًا تَجْرِي مِن تَحْتِهَا الْأَنْهَارُ خَالِدِينَ فِيهَا ۚ نِعْمَ أَجْرُ الْعَامِلِينَ",
    "الَّذِينَ صَبَرُوا وَعَلَىٰ رَبِّهِمْ يَتَوَكَّلُونَ",
    "وَكَأَيِّن مِّن دَابَّةٍ لَّا تَحْمِلُ رِزْقَهَا اللَّهُ يَرْزُقُهَا وَإِيَّاكُمْ ۚ وَهُوَ السَّمِيعُ الْعَلِيمُ",
    "وَلَئِن سَأَلْتَهُم مَّنْ خَلَقَ السَّمَاوَاتِ وَالْأَرْضَ وَسَخَّرَ الشَّمْسَ وَالْقَمَرَ لَيَقُولُنَّ اللَّهُ ۖ فَأَنَّىٰ يُؤْفَكُونَ",
    "اللَّهُ يَبْسُطُ الرِّزْقَ لِمَن يَشَاءُ مِنْ عِبَادِهِ وَيَقْدِرُ لَهُ ۚ إِنَّ اللَّهَ بِكُلِّ شَيْءٍ عَلِيمٌ",
    "وَلَئِن سَأَلْتَهُم مَّن نَّزَّلَ مِنَ السَّمَاءِ مَاءً فَأَحْيَا بِهِ الْأَرْضَ مِن بَعْدِ مَوْتِهَا لَيَقُولُنَّ اللَّهُ ۚ قُلِ الْحَمْدُ لِلَّهِ ۚ بَلْ أَكْثَرُهُمْ لَا يَعْقِلُونَ",
    "وَمَا هَٰذِهِ الْحَيَاةُ الدُّنْيَا إِلَّا لَهْوٌ وَلَعِبٌ ۚ وَإِنَّ الدَّارَ الْآخِرَةَ لَهِيَ الْحَيَوَانُ ۚ لَوْ كَانُوا يَعْلَمُونَ",
    "فَإِذَا رَكِبُوا فِي الْفُلْكِ دَعَوُا اللَّهَ مُخْلِصِينَ لَهُ الدِّينَ فَلَمَّا نَجَّاهُمْ إِلَى الْبَرِّ إِذَا هُمْ يُشْرِكُونَ",
    "لِيَكْفُرُوا بِمَا آتَيْنَاهُمْ وَلِيَتَمَتَّعُوا ۖ فَسَوْفَ يَعْلَمُونَ",
    "أَوَلَمْ يَرَوْا أَنَّا جَعَلْنَا حَرَمًا آمِنًا وَيُتَخَطَّفُ النَّاسُ مِنْ حَوْلِهِمْ ۚ أَفَبِالْبَاطِلِ يُؤْمِنُونَ وَبِنِعْمَةِ اللَّهِ يَكْفُرُونَ",
    "وَمَنْ أَظْلَمُ مِمَّنِ افْتَرَىٰ عَلَى اللَّهِ كَذِبًا أَوْ كَذَّبَ بِالْحَقِّ لَمَّا جَاءَهُ ۚ أَلَيْسَ فِي جَهَنَّمَ مَثْوًى لِّلْكَافِرِينَ",
    "وَالَّذِينَ جَاهَدُوا فِينَا لَنَهْدِيَنَّهُمْ سُبُلَنَا ۚ وَإِنَّ اللَّهَ لَمَعَ الْمُحْسِنِينَ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Alif, Lam, Meem.",
    "Do the people think that they will be left to say, \"We believe\" and they will not be tried?",
    "But We have certainly tried those before them, and Allah will surely make evident those who are truthful, and He will surely make evident the liars.",
    "Or do those who do evil deeds think they can outrun Us? Evil is what they judge.",
    "Whoever should hope for the meeting with Allah - indeed, the term decreed by Allah is coming. And He is the Hearing, the Knowing.",
    "And whoever strives only strives for [the benefit of] himself. Indeed, Allah is free from need of the worlds.",
    "And those who believe and do righteous deeds - We will surely remove from them their misdeeds and will surely reward them according to the best of what they used to do.",
    "And We have enjoined upon man goodness to parents. But if they endeavor to make you associate with Me that of which you have no knowledge, do not obey them. To Me is your return, and I will inform you about what you used to do.",
    "And those who believe and do righteous deeds - We will surely admit them among the righteous [into Paradise].",
    "And of the people are some who say, \"We believe in Allah,\" but when one [of them] is harmed for [the cause of] Allah, they consider the trial of the people as [if it were] the punishment of Allah. But if victory comes from your Lord, they say, \"Indeed, We were with you.\" Is not Allah most knowing of what is within the breasts of all creatures?",
    "And Allah will surely make evident those who believe, and He will surely make evident the hypocrites.",
    "And those who disbelieve say to those who believe, \"Follow our way, and we will carry your sins.\" But they will not carry anything of their sins. Indeed, they are liars.",
    "But they will surely carry their [own] burdens and [other] burdens along with their burdens, and they will surely be questioned on the Day of Resurrection about what they used to invent.",
    "And We certainly sent Noah to his people, and he remained among them a thousand years minus fifty years, and the flood seized them while they were wrongdoers.",
    "But We saved him and the companions of the ship, and We made it a sign for the worlds.",
    "And [We sent] Abraham, when he said to his people, \"Worship Allah and fear Him. That is best for you, if you should know.",
    "You only worship, besides Allah, idols, and you produce a falsehood. Indeed, those you worship besides Allah do not possess for you [the power of] provision. So seek from Allah provision and worship Him and be grateful to Him. To Him you will be returned.\"",
    "And if you [people] deny [the message] - already nations before you have denied. And there is not upon the Messenger except [the duty of] clear notification.",
    "Have they not considered how Allah begins creation and then repeats it? Indeed that, for Allah, is easy.",
    "Say, [O Muhammad], \"Travel through the land and observe how He began creation. Then Allah will produce the final creation. Indeed Allah, over all things, is competent.\"",
    "He punishes whom He wills and has mercy upon whom He wills, and to Him you will be returned.",
    "And you will not cause failure [to Allah] upon the earth or in the heaven. And you have not other than Allah any protector or any helper.",
    "And the ones who disbelieve in the signs of Allah and the meeting with Him - those have despaired of My mercy, and they will have a painful punishment.",
    "And the answer of Abraham's people was not but that they said, \"Kill him or burn him,\" but Allah saved him from the fire. Indeed in that are signs for a people who believe.",
    "And [Abraham] said, \"You have only taken, other than Allah, idols as [a bond of] affection among you in worldly life. Then on the Day of Resurrection you will deny one another and curse one another, and your refuge will be the Fire, and you will not have any helpers.\"",
    "And Lot believed him. [Abraham] said, \"Indeed, I will emigrate to [the service of] my Lord. Indeed, He is the Exalted in Might, the Wise.\"",
    "And We gave to Him Isaac and Jacob and placed in his descendants prophethood and scripture. And We gave him his reward in this world, and indeed, he is in the Hereafter among the righteous.",
    "And [mention] Lot, when he said to his people, \"Indeed, you commit such immorality as no one has preceded you with from among the worlds.",
    "Indeed, you approach men and obstruct the road and commit in your meetings [every] evil.\" And the answer of his people was not but they said, \"Bring us the punishment of Allah, if you should be of the truthful.\"",
    "He said, \"My Lord, support me against the corrupting people.\"",
    "And when Our messengers came to Abraham with the good tidings, they said, \"Indeed, we will destroy the people of that Lot's city. Indeed, its people have been wrongdoers.\"",
    "[Abraham] said, \"Indeed, within it is Lot.\" They said, \"We are more knowing of who is within it. We will surely save him and his family, except his wife. She is to be of those who remain behind.\"",
    "And when Our messengers came to Lot, he was distressed for them and felt for them great discomfort. They said, \"Fear not, nor grieve. Indeed, we will save you and your family, except your wife; she is to be of those who remain behind.",
    "Indeed, we will bring down on the people of this city punishment from the sky because they have been defiantly disobedient.\"",
    "And We have certainly left of it a sign as clear evidence for a people who use reason.",
    "And to Madyan [We sent] their brother Shu'ayb, and he said, \"O my people, worship Allah and expect the Last Day and do not commit abuse on the earth, spreading corruption.\"",
    "But they denied him, so the earthquake seized them, and they became within their home [corpses] fallen prone.",
    "And [We destroyed] 'Aad and Thamud, and it has become clear to you from their [ruined] dwellings. And Satan had made pleasing to them their deeds and averted them from the path, and they were endowed with perception.",
    "And [We destroyed] Qarun and Pharaoh and Haman. And Moses had already come to them with clear evidences, and they were arrogant in the land, but they were not outrunners [of Our punishment].",
    "So each We seized for his sin; and among them were those upon whom We sent a storm of stones, and among them were those who were seized by the blast [from the sky], and among them were those whom We caused the earth to swallow, and among them were those whom We drowned. And Allah would not have wronged them, but it was they who were wronging themselves.",
    "The example of those who take allies other than Allah is like that of the spider who takes a home. And indeed, the weakest of homes is the home of the spider, if they only knew.",
    "Indeed, Allah knows whatever thing they call upon other than Him. And He is the Exalted in Might, the Wise.",
    "And these examples We present to the people, but none will understand them except those of knowledge.",
    "Allah created the heavens and the earth in truth. Indeed in that is a sign for the believers.",
    "Recite, [O Muhammad], what has been revealed to you of the Book and establish prayer. Indeed, prayer prohibits immorality and wrongdoing, and the remembrance of Allah is greater. And Allah knows that which you do.",
    "And do not argue with the People of the Scripture except in a way that is best, except for those who commit injustice among them, and say, \"We believe in that which has been revealed to us and revealed to you. And our God and your God is one; and we are Muslims [in submission] to Him.\"",
    "And thus We have sent down to you the Qur'an. And those to whom We [previously] gave the Scripture believe in it. And among these [people of Makkah] are those who believe in it. And none reject Our verses except the disbelievers.",
    "And you did not recite before it any scripture, nor did you inscribe one with your right hand. Otherwise the falsifiers would have had [cause for] doubt.",
    "Rather, the Qur'an is distinct verses [preserved] within the breasts of those who have been given knowledge. And none reject Our verses except the wrongdoers.",
    "But they say, \"Why are not signs sent down to him from his Lord?\" Say, \"The signs are only with Allah, and I am only a clear warner.\"",
    "And is it not sufficient for them that We revealed to you the Book which is recited to them? Indeed in that is a mercy and reminder for a people who believe.",
    "Say, \"Sufficient is Allah between me and you as Witness. He knows what is in the heavens and earth. And they who have believed in falsehood and disbelieved in Allah - it is those who are the losers.\"",
    "And they urge you to hasten the punishment. And if not for [the decree of] a specified term, punishment would have reached them. But it will surely come to them suddenly while they perceive not.",
    "They urge you to hasten the punishment. And indeed, Hell will be encompassing of the disbelievers",
    "On the Day the punishment will cover them from above them and from below their feet and it is said, \"Taste [the result of] what you used to do.\"",
    "O My servants who have believed, indeed My earth is spacious, so worship only Me.",
    "Every soul will taste death. Then to Us will you be returned.",
    "And those who have believed and done righteous deeds - We will surely assign to them of Paradise [elevated] chambers beneath which rivers flow, wherein they abide eternally. Excellent is the reward of the [righteous] workers",
    "Who have been patient and upon their Lord rely.",
    "And how many a creature carries not its [own] provision. Allah provides for it and for you. And He is the Hearing, the Knowing.",
    "If you asked them, \"Who created the heavens and earth and subjected the sun and the moon?\" they would surely say, \"Allah.\" Then how are they deluded?",
    "Allah extends provision for whom He wills of His servants and restricts for him. Indeed Allah is, of all things, Knowing.",
    "And if you asked them, \"Who sends down rain from the sky and gives life thereby to the earth after its lifelessness?\" they would surely say \"Allah.\" Say, \"Praise to Allah\"; but most of them do not reason.",
    "And this worldly life is not but diversion and amusement. And indeed, the home of the Hereafter - that is the [eternal] life, if only they knew.",
    "And when they board a ship, they supplicate Allah, sincere to Him in religion. But when He delivers them to the land, at once they associate others with Him",
    "So that they will deny what We have granted them, and they will enjoy themselves. But they are going to know.",
    "Have they not seen that We made [Makkah] a safe sanctuary, while people are being taken away all around them? Then in falsehood do they believe, and in the favor of Allah they disbelieve?",
    "And who is more unjust than one who invents a lie about Allah or denies the truth when it has come to him? Is there not in Hell a [sufficient] residence for the disbelievers?",
    "And those who strive for Us - We will surely guide them to Our ways. And indeed, Allah is with the doers of good."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__ankabut);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_ankabut);
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
