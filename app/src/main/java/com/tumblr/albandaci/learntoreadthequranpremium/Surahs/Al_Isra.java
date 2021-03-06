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

public class Al_Isra extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/017.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"17:1", "17:2", "17:3", "17:4", "17:5", "17:6", "17:7", "17:8", "17:9", "17:10", "17:11", "17:12", "17:13", "17:14", "17:15", "17:16",
            "17:17", "17:18", "17:19", "17:20", "17:21", "17:22", "17:23", "17:24", "17:25", "17:26", "17:27", "17:28", "17:29", "17:30", "17:31", "17:32",
            "17:33", "17:34", "17:35", "17:36", "17:37", "17:38", "17:39", "17:40", "17:41", "17:42", "17:43", "17:44", "17:45", "17:46", "17:47", "17:48",
            "17:49", "17:50", "17:51", "17:52", "17:53", "17:54", "17:55", "17:56", "17:57", "17:58", "17:59", "17:60", "17:61", "17:62", "17:63", "17:64",
            "17:65", "17:66", "17:67", "17:68", "17:69", "17:70", "17:71", "17:72", "17:73", "17:74", "17:75", "17:76", "17:77", "17:78", "17:79", "17:80",
            "17:81", "17:82", "17:83", "17:84", "17:85", "17:86", "17:87", "17:88", "17:89", "17:90", "17:91", "17:92", "17:93", "17:94", "17:95", "17:96",
            "17:97", "17:98", "17:99", "17:100", "17:101", "17:102", "17:103", "17:104", "17:105", "17:106", "17:107", "17:108", "17:109", "17:110", "17:111"};

    String [] arabic_verses = {"سُبْحَانَ الَّذِي أَسْرَىٰ بِعَبْدِهِ لَيْلًا مِّنَ الْمَسْجِدِ الْحَرَامِ إِلَى الْمَسْجِدِ الْأَقْصَى الَّذِي بَارَكْنَا حَوْلَهُ لِنُرِيَهُ مِنْ آيَاتِنَا ۚ إِنَّهُ هُوَ السَّمِيعُ الْبَصِيرُ",
    "وَآتَيْنَا مُوسَى الْكِتَابَ وَجَعَلْنَاهُ هُدًى لِّبَنِي إِسْرَائِيلَ أَلَّا تَتَّخِذُوا مِن دُونِي وَكِيلًا",
    "ذُرِّيَّةَ مَنْ حَمَلْنَا مَعَ نُوحٍ ۚ إِنَّهُ كَانَ عَبْدًا شَكُورًا",
    "وَقَضَيْنَا إِلَىٰ بَنِي إِسْرَائِيلَ فِي الْكِتَابِ لَتُفْسِدُنَّ فِي الْأَرْضِ مَرَّتَيْنِ وَلَتَعْلُنَّ عُلُوًّا كَبِيرًا",
    "فَإِذَا جَاءَ وَعْدُ أُولَاهُمَا بَعَثْنَا عَلَيْكُمْ عِبَادًا لَّنَا أُولِي بَأْسٍ شَدِيدٍ فَجَاسُوا خِلَالَ الدِّيَارِ ۚ وَكَانَ وَعْدًا مَّفْعُولًا",
    "ثُمَّ رَدَدْنَا لَكُمُ الْكَرَّةَ عَلَيْهِمْ وَأَمْدَدْنَاكُم بِأَمْوَالٍ وَبَنِينَ وَجَعَلْنَاكُمْ أَكْثَرَ نَفِيرًا",
    "إِنْ أَحْسَنتُمْ أَحْسَنتُمْ لِأَنفُسِكُمْ ۖ وَإِنْ أَسَأْتُمْ فَلَهَا ۚ فَإِذَا جَاءَ وَعْدُ الْآخِرَةِ لِيَسُوءُوا وُجُوهَكُمْ وَلِيَدْخُلُوا الْمَسْجِدَ كَمَا دَخَلُوهُ أَوَّلَ مَرَّةٍ وَلِيُتَبِّرُوا مَا عَلَوْا تَتْبِيرًا",
    "عَسَىٰ رَبُّكُمْ أَن يَرْحَمَكُمْ ۚ وَإِنْ عُدتُّمْ عُدْنَا ۘ وَجَعَلْنَا جَهَنَّمَ لِلْكَافِرِينَ حَصِيرًا",
    "إِنَّ هَٰذَا الْقُرْآنَ يَهْدِي لِلَّتِي هِيَ أَقْوَمُ وَيُبَشِّرُ الْمُؤْمِنِينَ الَّذِينَ يَعْمَلُونَ الصَّالِحَاتِ أَنَّ لَهُمْ أَجْرًا كَبِيرًا",
    "وَأَنَّ الَّذِينَ لَا يُؤْمِنُونَ بِالْآخِرَةِ أَعْتَدْنَا لَهُمْ عَذَابًا أَلِيمًا",
    "وَيَدْعُ الْإِنسَانُ بِالشَّرِّ دُعَاءَهُ بِالْخَيْرِ ۖ وَكَانَ الْإِنسَانُ عَجُولًا",
    "وَجَعَلْنَا اللَّيْلَ وَالنَّهَارَ آيَتَيْنِ ۖ فَمَحَوْنَا آيَةَ اللَّيْلِ وَجَعَلْنَا آيَةَ النَّهَارِ مُبْصِرَةً لِّتَبْتَغُوا فَضْلًا مِّن رَّبِّكُمْ وَلِتَعْلَمُوا عَدَدَ السِّنِينَ وَالْحِسَابَ ۚ وَكُلَّ شَيْءٍ فَصَّلْنَاهُ تَفْصِيلًا",
    "وَكُلَّ إِنسَانٍ أَلْزَمْنَاهُ طَائِرَهُ فِي عُنُقِهِ ۖ وَنُخْرِجُ لَهُ يَوْمَ الْقِيَامَةِ كِتَابًا يَلْقَاهُ مَنشُورًا",
    "اقْرَأْ كِتَابَكَ كَفَىٰ بِنَفْسِكَ الْيَوْمَ عَلَيْكَ حَسِيبًا",
    "مَّنِ اهْتَدَىٰ فَإِنَّمَا يَهْتَدِي لِنَفْسِهِ ۖ وَمَن ضَلَّ فَإِنَّمَا يَضِلُّ عَلَيْهَا ۚ وَلَا تَزِرُ وَازِرَةٌ وِزْرَ أُخْرَىٰ ۗ وَمَا كُنَّا مُعَذِّبِينَ حَتَّىٰ نَبْعَثَ رَسُولًا",
    "وَإِذَا أَرَدْنَا أَن نُّهْلِكَ قَرْيَةً أَمَرْنَا مُتْرَفِيهَا فَفَسَقُوا فِيهَا فَحَقَّ عَلَيْهَا الْقَوْلُ فَدَمَّرْنَاهَا تَدْمِيرًا",
    "وَكَمْ أَهْلَكْنَا مِنَ الْقُرُونِ مِن بَعْدِ نُوحٍ ۗ وَكَفَىٰ بِرَبِّكَ بِذُنُوبِ عِبَادِهِ خَبِيرًا بَصِيرًا",
    "مَّن كَانَ يُرِيدُ الْعَاجِلَةَ عَجَّلْنَا لَهُ فِيهَا مَا نَشَاءُ لِمَن نُّرِيدُ ثُمَّ جَعَلْنَا لَهُ جَهَنَّمَ يَصْلَاهَا مَذْمُومًا مَّدْحُورًا",
    "وَمَنْ أَرَادَ الْآخِرَةَ وَسَعَىٰ لَهَا سَعْيَهَا وَهُوَ مُؤْمِنٌ فَأُولَٰئِكَ كَانَ سَعْيُهُم مَّشْكُورًا",
    "كُلًّا نُّمِدُّ هَٰؤُلَاءِ وَهَٰؤُلَاءِ مِنْ عَطَاءِ رَبِّكَ ۚ وَمَا كَانَ عَطَاءُ رَبِّكَ مَحْظُورًا",
    "انظُرْ كَيْفَ فَضَّلْنَا بَعْضَهُمْ عَلَىٰ بَعْضٍ ۚ وَلَلْآخِرَةُ أَكْبَرُ دَرَجَاتٍ وَأَكْبَرُ تَفْضِيلًا",
    "لَّا تَجْعَلْ مَعَ اللَّهِ إِلَٰهًا آخَرَ فَتَقْعُدَ مَذْمُومًا مَّخْذُولًا",
    "وَقَضَىٰ رَبُّكَ أَلَّا تَعْبُدُوا إِلَّا إِيَّاهُ وَبِالْوَالِدَيْنِ إِحْسَانًا ۚ إِمَّا يَبْلُغَنَّ عِندَكَ الْكِبَرَ أَحَدُهُمَا أَوْ كِلَاهُمَا فَلَا تَقُل لَّهُمَا أُفٍّ وَلَا تَنْهَرْهُمَا وَقُل لَّهُمَا قَوْلًا كَرِيمًا",
    "وَاخْفِضْ لَهُمَا جَنَاحَ الذُّلِّ مِنَ الرَّحْمَةِ وَقُل رَّبِّ ارْحَمْهُمَا كَمَا رَبَّيَانِي صَغِيرًا",
    "رَّبُّكُمْ أَعْلَمُ بِمَا فِي نُفُوسِكُمْ ۚ إِن تَكُونُوا صَالِحِينَ فَإِنَّهُ كَانَ لِلْأَوَّابِينَ غَفُورًا",
    "وَآتِ ذَا الْقُرْبَىٰ حَقَّهُ وَالْمِسْكِينَ وَابْنَ السَّبِيلِ وَلَا تُبَذِّرْ تَبْذِيرًا",
    "إِنَّ الْمُبَذِّرِينَ كَانُوا إِخْوَانَ الشَّيَاطِينِ ۖ وَكَانَ الشَّيْطَانُ لِرَبِّهِ كَفُورًا",
    "وَإِمَّا تُعْرِضَنَّ عَنْهُمُ ابْتِغَاءَ رَحْمَةٍ مِّن رَّبِّكَ تَرْجُوهَا فَقُل لَّهُمْ قَوْلًا مَّيْسُورًا",
    "وَلَا تَجْعَلْ يَدَكَ مَغْلُولَةً إِلَىٰ عُنُقِكَ وَلَا تَبْسُطْهَا كُلَّ الْبَسْطِ فَتَقْعُدَ مَلُومًا مَّحْسُورًا",
    "إِنَّ رَبَّكَ يَبْسُطُ الرِّزْقَ لِمَن يَشَاءُ وَيَقْدِرُ ۚ إِنَّهُ كَانَ بِعِبَادِهِ خَبِيرًا بَصِيرًا",
    "وَلَا تَقْتُلُوا أَوْلَادَكُمْ خَشْيَةَ إِمْلَاقٍ ۖ نَّحْنُ نَرْزُقُهُمْ وَإِيَّاكُمْ ۚ إِنَّ قَتْلَهُمْ كَانَ خِطْئًا كَبِيرًا",
    "وَلَا تَقْرَبُوا الزِّنَا ۖ إِنَّهُ كَانَ فَاحِشَةً وَسَاءَ سَبِيلًا",
    "وَلَا تَقْتُلُوا النَّفْسَ الَّتِي حَرَّمَ اللَّهُ إِلَّا بِالْحَقِّ ۗ وَمَن قُتِلَ مَظْلُومًا فَقَدْ جَعَلْنَا لِوَلِيِّهِ سُلْطَانًا فَلَا يُسْرِف فِّي الْقَتْلِ ۖ إِنَّهُ كَانَ مَنصُورًا",
    "وَلَا تَقْرَبُوا مَالَ الْيَتِيمِ إِلَّا بِالَّتِي هِيَ أَحْسَنُ حَتَّىٰ يَبْلُغَ أَشُدَّهُ ۚ وَأَوْفُوا بِالْعَهْدِ ۖ إِنَّ الْعَهْدَ كَانَ مَسْئُولًا",
    "وَأَوْفُوا الْكَيْلَ إِذَا كِلْتُمْ وَزِنُوا بِالْقِسْطَاسِ الْمُسْتَقِيمِ ۚ ذَٰلِكَ خَيْرٌ وَأَحْسَنُ تَأْوِيلًا",
    "وَلَا تَقْفُ مَا لَيْسَ لَكَ بِهِ عِلْمٌ ۚ إِنَّ السَّمْعَ وَالْبَصَرَ وَالْفُؤَادَ كُلُّ أُولَٰئِكَ كَانَ عَنْهُ مَسْئُولًا",
    "وَلَا تَمْشِ فِي الْأَرْضِ مَرَحًا ۖ إِنَّكَ لَن تَخْرِقَ الْأَرْضَ وَلَن تَبْلُغَ الْجِبَالَ طُولًا",
    "كُلُّ ذَٰلِكَ كَانَ سَيِّئُهُ عِندَ رَبِّكَ مَكْرُوهًا",
    "ذَٰلِكَ مِمَّا أَوْحَىٰ إِلَيْكَ رَبُّكَ مِنَ الْحِكْمَةِ ۗ وَلَا تَجْعَلْ مَعَ اللَّهِ إِلَٰهًا آخَرَ فَتُلْقَىٰ فِي جَهَنَّمَ مَلُومًا مَّدْحُورًا",
    "أَفَأَصْفَاكُمْ رَبُّكُم بِالْبَنِينَ وَاتَّخَذَ مِنَ الْمَلَائِكَةِ إِنَاثًا ۚ إِنَّكُمْ لَتَقُولُونَ قَوْلًا عَظِيمًا",
    "وَلَقَدْ صَرَّفْنَا فِي هَٰذَا الْقُرْآنِ لِيَذَّكَّرُوا وَمَا يَزِيدُهُمْ إِلَّا نُفُورًا",
    "قُل لَّوْ كَانَ مَعَهُ آلِهَةٌ كَمَا يَقُولُونَ إِذًا لَّابْتَغَوْا إِلَىٰ ذِي الْعَرْشِ سَبِيلًا",
    "سُبْحَانَهُ وَتَعَالَىٰ عَمَّا يَقُولُونَ عُلُوًّا كَبِيرًا",
    "تُسَبِّحُ لَهُ السَّمَاوَاتُ السَّبْعُ وَالْأَرْضُ وَمَن فِيهِنَّ ۚ وَإِن مِّن شَيْءٍ إِلَّا يُسَبِّحُ بِحَمْدِهِ وَلَٰكِن لَّا تَفْقَهُونَ تَسْبِيحَهُمْ ۗ إِنَّهُ كَانَ حَلِيمًا غَفُورًا",
    "وَإِذَا قَرَأْتَ الْقُرْآنَ جَعَلْنَا بَيْنَكَ وَبَيْنَ الَّذِينَ لَا يُؤْمِنُونَ بِالْآخِرَةِ حِجَابًا مَّسْتُورًا",
    "وَجَعَلْنَا عَلَىٰ قُلُوبِهِمْ أَكِنَّةً أَن يَفْقَهُوهُ وَفِي آذَانِهِمْ وَقْرًا ۚ وَإِذَا ذَكَرْتَ رَبَّكَ فِي الْقُرْآنِ وَحْدَهُ وَلَّوْا عَلَىٰ أَدْبَارِهِمْ نُفُورًا",
    "نَّحْنُ أَعْلَمُ بِمَا يَسْتَمِعُونَ بِهِ إِذْ يَسْتَمِعُونَ إِلَيْكَ وَإِذْ هُمْ نَجْوَىٰ إِذْ يَقُولُ الظَّالِمُونَ إِن تَتَّبِعُونَ إِلَّا رَجُلًا مَّسْحُورًا",
    "انظُرْ كَيْفَ ضَرَبُوا لَكَ الْأَمْثَالَ فَضَلُّوا فَلَا يَسْتَطِيعُونَ سَبِيلًا",
    "وَقَالُوا أَإِذَا كُنَّا عِظَامًا وَرُفَاتًا أَإِنَّا لَمَبْعُوثُونَ خَلْقًا جَدِيدًا",
    "قُلْ كُونُوا حِجَارَةً أَوْ حَدِيدًا",
    "أَوْ خَلْقًا مِّمَّا يَكْبُرُ فِي صُدُورِكُمْ ۚ فَسَيَقُولُونَ مَن يُعِيدُنَا ۖ قُلِ الَّذِي فَطَرَكُمْ أَوَّلَ مَرَّةٍ ۚ فَسَيُنْغِضُونَ إِلَيْكَ رُءُوسَهُمْ وَيَقُولُونَ مَتَىٰ هُوَ ۖ قُلْ عَسَىٰ أَن يَكُونَ قَرِيبًا",
    "يَوْمَ يَدْعُوكُمْ فَتَسْتَجِيبُونَ بِحَمْدِهِ وَتَظُنُّونَ إِن لَّبِثْتُمْ إِلَّا قَلِيلًا",
    "وَقُل لِّعِبَادِي يَقُولُوا الَّتِي هِيَ أَحْسَنُ ۚ إِنَّ الشَّيْطَانَ يَنزَغُ بَيْنَهُمْ ۚ إِنَّ الشَّيْطَانَ كَانَ لِلْإِنسَانِ عَدُوًّا مُّبِينًا",
    "رَّبُّكُمْ أَعْلَمُ بِكُمْ ۖ إِن يَشَأْ يَرْحَمْكُمْ أَوْ إِن يَشَأْ يُعَذِّبْكُمْ ۚ وَمَا أَرْسَلْنَاكَ عَلَيْهِمْ وَكِيلًا",
    "وَرَبُّكَ أَعْلَمُ بِمَن فِي السَّمَاوَاتِ وَالْأَرْضِ ۗ وَلَقَدْ فَضَّلْنَا بَعْضَ النَّبِيِّينَ عَلَىٰ بَعْضٍ ۖ وَآتَيْنَا دَاوُودَ زَبُورًا",
    "قُلِ ادْعُوا الَّذِينَ زَعَمْتُم مِّن دُونِهِ فَلَا يَمْلِكُونَ كَشْفَ الضُّرِّ عَنكُمْ وَلَا تَحْوِيلًا",
    "أُولَٰئِكَ الَّذِينَ يَدْعُونَ يَبْتَغُونَ إِلَىٰ رَبِّهِمُ الْوَسِيلَةَ أَيُّهُمْ أَقْرَبُ وَيَرْجُونَ رَحْمَتَهُ وَيَخَافُونَ عَذَابَهُ ۚ إِنَّ عَذَابَ رَبِّكَ كَانَ مَحْذُورًا",
    "وَإِن مِّن قَرْيَةٍ إِلَّا نَحْنُ مُهْلِكُوهَا قَبْلَ يَوْمِ الْقِيَامَةِ أَوْ مُعَذِّبُوهَا عَذَابًا شَدِيدًا ۚ كَانَ ذَٰلِكَ فِي الْكِتَابِ مَسْطُورًا",
    "وَمَا مَنَعَنَا أَن نُّرْسِلَ بِالْآيَاتِ إِلَّا أَن كَذَّبَ بِهَا الْأَوَّلُونَ ۚ وَآتَيْنَا ثَمُودَ النَّاقَةَ مُبْصِرَةً فَظَلَمُوا بِهَا ۚ وَمَا نُرْسِلُ بِالْآيَاتِ إِلَّا تَخْوِيفًا",
    "وَإِذْ قُلْنَا لَكَ إِنَّ رَبَّكَ أَحَاطَ بِالنَّاسِ ۚ وَمَا جَعَلْنَا الرُّؤْيَا الَّتِي أَرَيْنَاكَ إِلَّا فِتْنَةً لِّلنَّاسِ وَالشَّجَرَةَ الْمَلْعُونَةَ فِي الْقُرْآنِ ۚ وَنُخَوِّفُهُمْ فَمَا يَزِيدُهُمْ إِلَّا طُغْيَانًا كَبِيرًا",
    "وَإِذْ قُلْنَا لِلْمَلَائِكَةِ اسْجُدُوا لِآدَمَ فَسَجَدُوا إِلَّا إِبْلِيسَ قَالَ أَأَسْجُدُ لِمَنْ خَلَقْتَ طِينًا",
    "قَالَ أَرَأَيْتَكَ هَٰذَا الَّذِي كَرَّمْتَ عَلَيَّ لَئِنْ أَخَّرْتَنِ إِلَىٰ يَوْمِ الْقِيَامَةِ لَأَحْتَنِكَنَّ ذُرِّيَّتَهُ إِلَّا قَلِيلًا",
    "قَالَ اذْهَبْ فَمَن تَبِعَكَ مِنْهُمْ فَإِنَّ جَهَنَّمَ جَزَاؤُكُمْ جَزَاءً مَّوْفُورًا",
    "وَاسْتَفْزِزْ مَنِ اسْتَطَعْتَ مِنْهُم بِصَوْتِكَ وَأَجْلِبْ عَلَيْهِم بِخَيْلِكَ وَرَجِلِكَ وَشَارِكْهُمْ فِي الْأَمْوَالِ وَالْأَوْلَادِ وَعِدْهُمْ ۚ وَمَا يَعِدُهُمُ الشَّيْطَانُ إِلَّا غُرُورًا",
    "إِنَّ عِبَادِي لَيْسَ لَكَ عَلَيْهِمْ سُلْطَانٌ ۚ وَكَفَىٰ بِرَبِّكَ وَكِيلًا",
    "رَّبُّكُمُ الَّذِي يُزْجِي لَكُمُ الْفُلْكَ فِي الْبَحْرِ لِتَبْتَغُوا مِن فَضْلِهِ ۚ إِنَّهُ كَانَ بِكُمْ رَحِيمًا",
    "وَإِذَا مَسَّكُمُ الضُّرُّ فِي الْبَحْرِ ضَلَّ مَن تَدْعُونَ إِلَّا إِيَّاهُ ۖ فَلَمَّا نَجَّاكُمْ إِلَى الْبَرِّ أَعْرَضْتُمْ ۚ وَكَانَ الْإِنسَانُ كَفُورًا",
    "أَفَأَمِنتُمْ أَن يَخْسِفَ بِكُمْ جَانِبَ الْبَرِّ أَوْ يُرْسِلَ عَلَيْكُمْ حَاصِبًا ثُمَّ لَا تَجِدُوا لَكُمْ وَكِيلًا",
    "أَمْ أَمِنتُمْ أَن يُعِيدَكُمْ فِيهِ تَارَةً أُخْرَىٰ فَيُرْسِلَ عَلَيْكُمْ قَاصِفًا مِّنَ الرِّيحِ فَيُغْرِقَكُم بِمَا كَفَرْتُمْ ۙ ثُمَّ لَا تَجِدُوا لَكُمْ عَلَيْنَا بِهِ تَبِيعًا",
    "وَلَقَدْ كَرَّمْنَا بَنِي آدَمَ وَحَمَلْنَاهُمْ فِي الْبَرِّ وَالْبَحْرِ وَرَزَقْنَاهُم مِّنَ الطَّيِّبَاتِ وَفَضَّلْنَاهُمْ عَلَىٰ كَثِيرٍ مِّمَّنْ خَلَقْنَا تَفْضِيلًا",
    "يَوْمَ نَدْعُو كُلَّ أُنَاسٍ بِإِمَامِهِمْ ۖ فَمَنْ أُوتِيَ كِتَابَهُ بِيَمِينِهِ فَأُولَٰئِكَ يَقْرَءُونَ كِتَابَهُمْ وَلَا يُظْلَمُونَ فَتِيلًا",
    "وَمَن كَانَ فِي هَٰذِهِ أَعْمَىٰ فَهُوَ فِي الْآخِرَةِ أَعْمَىٰ وَأَضَلُّ سَبِيلًا",
    "وَإِن كَادُوا لَيَفْتِنُونَكَ عَنِ الَّذِي أَوْحَيْنَا إِلَيْكَ لِتَفْتَرِيَ عَلَيْنَا غَيْرَهُ ۖ وَإِذًا لَّاتَّخَذُوكَ خَلِيلًا",
    "وَلَوْلَا أَن ثَبَّتْنَاكَ لَقَدْ كِدتَّ تَرْكَنُ إِلَيْهِمْ شَيْئًا قَلِيلًا",
    "إِذًا لَّأَذَقْنَاكَ ضِعْفَ الْحَيَاةِ وَضِعْفَ الْمَمَاتِ ثُمَّ لَا تَجِدُ لَكَ عَلَيْنَا نَصِيرًا",
    "وَإِن كَادُوا لَيَسْتَفِزُّونَكَ مِنَ الْأَرْضِ لِيُخْرِجُوكَ مِنْهَا ۖ وَإِذًا لَّا يَلْبَثُونَ خِلَافَكَ إِلَّا قَلِيلًا",
    "سُنَّةَ مَن قَدْ أَرْسَلْنَا قَبْلَكَ مِن رُّسُلِنَا ۖ وَلَا تَجِدُ لِسُنَّتِنَا تَحْوِيلًا",
    "أَقِمِ الصَّلَاةَ لِدُلُوكِ الشَّمْسِ إِلَىٰ غَسَقِ اللَّيْلِ وَقُرْآنَ الْفَجْرِ ۖ إِنَّ قُرْآنَ الْفَجْرِ كَانَ مَشْهُودًا",
    "وَمِنَ اللَّيْلِ فَتَهَجَّدْ بِهِ نَافِلَةً لَّكَ عَسَىٰ أَن يَبْعَثَكَ رَبُّكَ مَقَامًا مَّحْمُودًا",
    "وَقُل رَّبِّ أَدْخِلْنِي مُدْخَلَ صِدْقٍ وَأَخْرِجْنِي مُخْرَجَ صِدْقٍ وَاجْعَل لِّي مِن لَّدُنكَ سُلْطَانًا نَّصِيرًا",
    "وَقُلْ جَاءَ الْحَقُّ وَزَهَقَ الْبَاطِلُ ۚ إِنَّ الْبَاطِلَ كَانَ زَهُوقًا",
    "وَنُنَزِّلُ مِنَ الْقُرْآنِ مَا هُوَ شِفَاءٌ وَرَحْمَةٌ لِّلْمُؤْمِنِينَ ۙ وَلَا يَزِيدُ الظَّالِمِينَ إِلَّا خَسَارًا",
    "وَإِذَا أَنْعَمْنَا عَلَى الْإِنسَانِ أَعْرَضَ وَنَأَىٰ بِجَانِبِهِ ۖ وَإِذَا مَسَّهُ الشَّرُّ كَانَ يَئُوسًا",
    "قُلْ كُلٌّ يَعْمَلُ عَلَىٰ شَاكِلَتِهِ فَرَبُّكُمْ أَعْلَمُ بِمَنْ هُوَ أَهْدَىٰ سَبِيلًا",
    "وَيَسْأَلُونَكَ عَنِ الرُّوحِ ۖ قُلِ الرُّوحُ مِنْ أَمْرِ رَبِّي وَمَا أُوتِيتُم مِّنَ الْعِلْمِ إِلَّا قَلِيلًا",
    "وَلَئِن شِئْنَا لَنَذْهَبَنَّ بِالَّذِي أَوْحَيْنَا إِلَيْكَ ثُمَّ لَا تَجِدُ لَكَ بِهِ عَلَيْنَا وَكِيلًا",
    "إِلَّا رَحْمَةً مِّن رَّبِّكَ ۚ إِنَّ فَضْلَهُ كَانَ عَلَيْكَ كَبِيرًا",
    "قُل لَّئِنِ اجْتَمَعَتِ الْإِنسُ وَالْجِنُّ عَلَىٰ أَن يَأْتُوا بِمِثْلِ هَٰذَا الْقُرْآنِ لَا يَأْتُونَ بِمِثْلِهِ وَلَوْ كَانَ بَعْضُهُمْ لِبَعْضٍ ظَهِيرًا",
    "وَلَقَدْ صَرَّفْنَا لِلنَّاسِ فِي هَٰذَا الْقُرْآنِ مِن كُلِّ مَثَلٍ فَأَبَىٰ أَكْثَرُ النَّاسِ إِلَّا كُفُورًا",
    "وَقَالُوا لَن نُّؤْمِنَ لَكَ حَتَّىٰ تَفْجُرَ لَنَا مِنَ الْأَرْضِ يَنبُوعًا",
    "أَوْ تَكُونَ لَكَ جَنَّةٌ مِّن نَّخِيلٍ وَعِنَبٍ فَتُفَجِّرَ الْأَنْهَارَ خِلَالَهَا تَفْجِيرًا",
    "أَوْ تُسْقِطَ السَّمَاءَ كَمَا زَعَمْتَ عَلَيْنَا كِسَفًا أَوْ تَأْتِيَ بِاللَّهِ وَالْمَلَائِكَةِ قَبِيلًا",
    "أَوْ يَكُونَ لَكَ بَيْتٌ مِّن زُخْرُفٍ أَوْ تَرْقَىٰ فِي السَّمَاءِ وَلَن نُّؤْمِنَ لِرُقِيِّكَ حَتَّىٰ تُنَزِّلَ عَلَيْنَا كِتَابًا نَّقْرَؤُهُ ۗ قُلْ سُبْحَانَ رَبِّي هَلْ كُنتُ إِلَّا بَشَرًا رَّسُولًا",
    "وَمَا مَنَعَ النَّاسَ أَن يُؤْمِنُوا إِذْ جَاءَهُمُ الْهُدَىٰ إِلَّا أَن قَالُوا أَبَعَثَ اللَّهُ بَشَرًا رَّسُولًا",
    "قُل لَّوْ كَانَ فِي الْأَرْضِ مَلَائِكَةٌ يَمْشُونَ مُطْمَئِنِّينَ لَنَزَّلْنَا عَلَيْهِم مِّنَ السَّمَاءِ مَلَكًا رَّسُولًا",
    "قُلْ كَفَىٰ بِاللَّهِ شَهِيدًا بَيْنِي وَبَيْنَكُمْ ۚ إِنَّهُ كَانَ بِعِبَادِهِ خَبِيرًا بَصِيرًا",
    "وَمَن يَهْدِ اللَّهُ فَهُوَ الْمُهْتَدِ ۖ وَمَن يُضْلِلْ فَلَن تَجِدَ لَهُمْ أَوْلِيَاءَ مِن دُونِهِ ۖ وَنَحْشُرُهُمْ يَوْمَ الْقِيَامَةِ عَلَىٰ وُجُوهِهِمْ عُمْيًا وَبُكْمًا وَصُمًّا ۖ مَّأْوَاهُمْ جَهَنَّمُ ۖ كُلَّمَا خَبَتْ زِدْنَاهُمْ سَعِيرًا",
    "ذَٰلِكَ جَزَاؤُهُم بِأَنَّهُمْ كَفَرُوا بِآيَاتِنَا وَقَالُوا أَإِذَا كُنَّا عِظَامًا وَرُفَاتًا أَإِنَّا لَمَبْعُوثُونَ خَلْقًا جَدِيدًا",
    "أَوَلَمْ يَرَوْا أَنَّ اللَّهَ الَّذِي خَلَقَ السَّمَاوَاتِ وَالْأَرْضَ قَادِرٌ عَلَىٰ أَن يَخْلُقَ مِثْلَهُمْ وَجَعَلَ لَهُمْ أَجَلًا لَّا رَيْبَ فِيهِ فَأَبَى الظَّالِمُونَ إِلَّا كُفُورًا",
    "قُل لَّوْ أَنتُمْ تَمْلِكُونَ خَزَائِنَ رَحْمَةِ رَبِّي إِذًا لَّأَمْسَكْتُمْ خَشْيَةَ الْإِنفَاقِ ۚ وَكَانَ الْإِنسَانُ قَتُورًا",
    "وَلَقَدْ آتَيْنَا مُوسَىٰ تِسْعَ آيَاتٍ بَيِّنَاتٍ ۖ فَاسْأَلْ بَنِي إِسْرَائِيلَ إِذْ جَاءَهُمْ فَقَالَ لَهُ فِرْعَوْنُ إِنِّي لَأَظُنُّكَ يَا مُوسَىٰ مَسْحُورًا",
    "قَالَ لَقَدْ عَلِمْتَ مَا أَنزَلَ هَٰؤُلَاءِ إِلَّا رَبُّ السَّمَاوَاتِ وَالْأَرْضِ بَصَائِرَ وَإِنِّي لَأَظُنُّكَ يَا فِرْعَوْنُ مَثْبُورًا",
    "فَأَرَادَ أَن يَسْتَفِزَّهُم مِّنَ الْأَرْضِ فَأَغْرَقْنَاهُ وَمَن مَّعَهُ جَمِيعًا",
    "وَقُلْنَا مِن بَعْدِهِ لِبَنِي إِسْرَائِيلَ اسْكُنُوا الْأَرْضَ فَإِذَا جَاءَ وَعْدُ الْآخِرَةِ جِئْنَا بِكُمْ لَفِيفًا",
    "وَبِالْحَقِّ أَنزَلْنَاهُ وَبِالْحَقِّ نَزَلَ ۗ وَمَا أَرْسَلْنَاكَ إِلَّا مُبَشِّرًا وَنَذِيرًا",
    "وَقُرْآنًا فَرَقْنَاهُ لِتَقْرَأَهُ عَلَى النَّاسِ عَلَىٰ مُكْثٍ وَنَزَّلْنَاهُ تَنزِيلًا",
    "قُلْ آمِنُوا بِهِ أَوْ لَا تُؤْمِنُوا ۚ إِنَّ الَّذِينَ أُوتُوا الْعِلْمَ مِن قَبْلِهِ إِذَا يُتْلَىٰ عَلَيْهِمْ يَخِرُّونَ لِلْأَذْقَانِ سُجَّدًا",
    "وَيَقُولُونَ سُبْحَانَ رَبِّنَا إِن كَانَ وَعْدُ رَبِّنَا لَمَفْعُولًا",
    "وَيَخِرُّونَ لِلْأَذْقَانِ يَبْكُونَ وَيَزِيدُهُمْ خُشُوعًا ۩",
    "قُلِ ادْعُوا اللَّهَ أَوِ ادْعُوا الرَّحْمَٰنَ ۖ أَيًّا مَّا تَدْعُوا فَلَهُ الْأَسْمَاءُ الْحُسْنَىٰ ۚ وَلَا تَجْهَرْ بِصَلَاتِكَ وَلَا تُخَافِتْ بِهَا وَابْتَغِ بَيْنَ ذَٰلِكَ سَبِيلًا",
    "وَقُلِ الْحَمْدُ لِلَّهِ الَّذِي لَمْ يَتَّخِذْ وَلَدًا وَلَمْ يَكُن لَّهُ شَرِيكٌ فِي الْمُلْكِ وَلَمْ يَكُن لَّهُ وَلِيٌّ مِّنَ الذُّلِّ ۖ وَكَبِّرْهُ تَكْبِيرًا"};

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
            "Sahih International"};

    String [] english_verses = {"Exalted is He who took His Servant by night from al-Masjid al-Haram to al-Masjid al- Aqsa, whose surroundings We have blessed, to show him of Our signs. Indeed, He is the Hearing, the Seeing.",
    "And We gave Moses the Scripture and made it a guidance for the Children of Israel that you not take other than Me as Disposer of affairs,",
    "O descendants of those We carried [in the ship] with Noah. Indeed, he was a grateful servant.",
    "And We conveyed to the Children of Israel in the Scripture that, \"You will surely cause corruption on the earth twice, and you will surely reach [a degree of] great haughtiness.",
    "So when the [time of] promise came for the first of them, We sent against you servants of Ours - those of great military might, and they probed [even] into the homes, and it was a promise fulfilled.",
    "Then We gave back to you a return victory over them. And We reinforced you with wealth and sons and made you more numerous in manpower",
    "[And said], \"If you do good, you do good for yourselves; and if you do evil, [you do it] to yourselves.\" Then when the final promise came, [We sent your enemies] to sadden your faces and to enter the temple in Jerusalem, as they entered it the first time, and to destroy what they had taken over with [total] destruction.",
    "[Then Allah said], \"It is expected, [if you repent], that your Lord will have mercy upon you. But if you return [to sin], We will return [to punishment]. And We have made Hell, for the disbelievers, a prison-bed.\"",
    "Indeed, this Qur'an guides to that which is most suitable and gives good tidings to the believers who do righteous deeds that they will have a great reward.",
    "And that those who do not believe in the Hereafter - We have prepared for them a painful punishment.",
    "And man supplicates for evil as he supplicates for good, and man is ever hasty.",
    "And We have made the night and day two signs, and We erased the sign of the night and made the sign of the day visible that you may seek bounty from your Lord and may know the number of years and the account [of time]. And everything We have set out in detail.",
    "And [for] every person We have imposed his fate upon his neck, and We will produce for him on the Day of Resurrection a record which he will encounter spread open.",
    "[It will be said], \"Read your record. Sufficient is yourself against you this Day as accountant.\"",
    "Whoever is guided is only guided for [the benefit of] his soul. And whoever errs only errs against it. And no bearer of burdens will bear the burden of another. And never would We punish until We sent a messenger.",
    "And when We intend to destroy a city, We command its affluent but they defiantly disobey therein; so the word comes into effect upon it, and We destroy it with [complete] destruction.",
    "And how many have We destroyed from the generations after Noah. And sufficient is your Lord, concerning the sins of His servants, as Acquainted and Seeing.",
    "Whoever should desire the immediate - We hasten for him from it what We will to whom We intend. Then We have made for him Hell, which he will [enter to] burn, censured and banished.",
    "But whoever desires the Hereafter and exerts the effort due to it while he is a believer - it is those whose effort is ever appreciated [by Allah].",
    "To each [category] We extend - to these and to those - from the gift of your Lord. And never has the gift of your Lord been restricted.",
    "Look how We have favored [in provision] some of them over others. But the Hereafter is greater in degrees [of difference] and greater in distinction.",
    "Do not make [as equal] with Allah another deity and [thereby] become censured and forsaken.",
    "And your Lord has decreed that you not worship except Him, and to parents, good treatment. Whether one or both of them reach old age [while] with you, say not to them [so much as], \"uff,\" and do not repel them but speak to them a noble word.",
    "And lower to them the wing of humility out of mercy and say, \"My Lord, have mercy upon them as they brought me up [when I was] small.\"",
    "Your Lord is most knowing of what is within yourselves. If you should be righteous [in intention] - then indeed He is ever, to the often returning [to Him], Forgiving.",
    "And give the relative his right, and [also] the poor and the traveler, and do not spend wastefully.",
    "Indeed, the wasteful are brothers of the devils, and ever has Satan been to his Lord ungrateful.",
    "And if you [must] turn away from the needy awaiting mercy from your Lord which you expect, then speak to them a gentle word.",
    "And do not make your hand [as] chained to your neck or extend it completely and [thereby] become blamed and insolvent.",
    "Indeed, your Lord extends provision for whom He wills and restricts [it]. Indeed He is ever, concerning His servants, Acquainted and Seeing.",
    "And do not kill your children for fear of poverty. We provide for them and for you. Indeed, their killing is ever a great sin.",
    "And do not approach unlawful sexual intercourse. Indeed, it is ever an immorality and is evil as a way.",
    "And do not kill the soul which Allah has forbidden, except by right. And whoever is killed unjustly - We have given his heir authority, but let him not exceed limits in [the matter of] taking life. Indeed, he has been supported [by the law].",
    "And do not approach the property of an orphan, except in the way that is best, until he reaches maturity. And fulfill [every] commitment. Indeed, the commitment is ever [that about which one will be] questioned.",
    "And give full measure when you measure, and weigh with an even balance. That is the best [way] and best in result.",
    "And do not pursue that of which you have no knowledge. Indeed, the hearing, the sight and the heart - about all those [one] will be questioned.",
    "And do not walk upon the earth exultantly. Indeed, you will never tear the earth [apart], and you will never reach the mountains in height.",
    "All that - its evil is ever, in the sight of your Lord, detested.",
    "That is from what your Lord has revealed to you, [O Muhammad], of wisdom. And, [O mankind], do not make [as equal] with Allah another deity, lest you be thrown into Hell, blamed and banished.",
    "Then, has your Lord chosen you for [having] sons and taken from among the angels daughters? Indeed, you say a grave saying.",
    "And We have certainly diversified [the contents] in this Qur'an that mankind may be reminded, but it does not increase the disbelievers except in aversion.",
    "Say, [O Muhammad], \"If there had been with Him [other] gods, as they say, then they [each] would have sought to the Owner of the Throne a way.\"",
    "Exalted is He and high above what they say by great sublimity.",
    "The seven heavens and the earth and whatever is in them exalt Him. And there is not a thing except that it exalts [Allah] by His praise, but you do not understand their [way of] exalting. Indeed, He is ever Forbearing and Forgiving.",
    "And when you recite the Qur'an, We put between you and those who do not believe in the Hereafter a concealed partition.",
    "And We have placed over their hearts coverings, lest they understand it, and in their ears deafness. And when you mention your Lord alone in the Qur'an, they turn back in aversion.",
    "We are most knowing of how they listen to it when they listen to you and [of] when they are in private conversation, when the wrongdoers say, \"You follow not but a man affected by magic.\"",
    "Look how they strike for you comparisons; but they have strayed, so they cannot [find] a way.",
    "And they say, \"When we are bones and crumbled particles, will we [truly] be resurrected as a new creation?\"",
    "Say, \"Be you stones or iron",
    "Or [any] creation of that which is great within your breasts.\" And they will say, \"Who will restore us?\" Say, \"He who brought you forth the first time.\" Then they will nod their heads toward you and say, \"When is that?\" Say, \"Perhaps it will be soon -",
    "On the Day He will call you and you will respond with praise of Him and think that you had not remained [in the world] except for a little.\"",
    "And tell My servants to say that which is best. Indeed, Satan induces [dissension] among them. Indeed Satan is ever, to mankind, a clear enemy.",
    "Your Lord is most knowing of you. If He wills, He will have mercy upon you; or if He wills, He will punish you. And We have not sent you, [O Muhammad], over them as a manager.",
    "And your Lord is most knowing of whoever is in the heavens and the earth. And We have made some of the prophets exceed others [in various ways], and to David We gave the book [of Psalms].",
    "Say, \"Invoke those you have claimed [as gods] besides Him, for they do not possess the [ability for] removal of adversity from you or [for its] transfer [to someone else].\"",
    "Those whom they invoke seek means of access to their Lord, [striving as to] which of them would be nearest, and they hope for His mercy and fear His punishment. Indeed, the punishment of your Lord is ever feared.",
    "And there is no city but that We will destroy it before the Day of Resurrection or punish it with a severe punishment. That has ever been in the Register inscribed.",
    "And nothing has prevented Us from sending signs except that the former peoples denied them. And We gave Thamud the she-camel as a visible sign, but they wronged her. And We send not the signs except as a warning.",
    "And [remember, O Muhammad], when We told you, \"Indeed, your Lord has encompassed the people.\" And We did not make the sight which We showed you except as a trial for the people, as was the accursed tree [mentioned] in the Qur'an. And We threaten them, but it increases them not except in great transgression.",
    "And [mention] when We said to the angles, \"Prostrate to Adam,\" and they prostrated, except for Iblees. He said, \"Should I prostrate to one You created from clay?\"",
    "[Iblees] said, \"Do You see this one whom You have honored above me? If You delay me until the Day of Resurrection, I will surely destroy his descendants, except for a few.\"",
    "[Allah] said, \"Go, for whoever of them follows you, indeed Hell will be the recompense of you - an ample recompense.",
    "And incite [to senselessness] whoever you can among them with your voice and assault them with your horses and foot soldiers and become a partner in their wealth and their children and promise them.\" But Satan does not promise them except delusion.",
    "Indeed, over My [believing] servants there is for you no authority. And sufficient is your Lord as Disposer of affairs.",
    "It is your Lord who drives the ship for you through the sea that you may seek of His bounty. Indeed, He is ever, to you, Merciful.",
    "And when adversity touches you at sea, lost are [all] those you invoke except for Him. But when He delivers you to the land, you turn away [from Him]. And ever is man ungrateful.",
    "Then do you feel secure that [instead] He will not cause a part of the land to swallow you or send against you a storm of stones? Then you would not find for yourselves an advocate.",
    "Or do you feel secure that He will not send you back into the sea another time and send upon you a hurricane of wind and drown you for what you denied? Then you would not find for yourselves against Us an avenger.",
    "And We have certainly honored the children of Adam and carried them on the land and sea and provided for them of the good things and preferred them over much of what We have created, with [definite] preference.",
    "[Mention, O Muhammad], the Day We will call forth every people with their record [of deeds]. Then whoever is given his record in his right hand - those will read their records, and injustice will not be done to them, [even] as much as a thread [inside the date seed].",
    "And whoever is blind in this [life] will be blind in the Hereafter and more astray in way.",
    "And indeed, they were about to tempt you away from that which We revealed to you in order to [make] you invent about Us something else; and then they would have taken you as a friend.",
    "And if We had not strengthened you, you would have almost inclined to them a little.",
    "Then [if you had], We would have made you taste double [punishment in] life and double [after] death. Then you would not find for yourself against Us a helper.",
    "And indeed, they were about to drive you from the land to evict you therefrom. And then [when they do], they will not remain [there] after you, except for a little.",
    "[That is Our] established way for those We had sent before you of Our messengers; and you will not find in Our way any alteration.",
    "Establish prayer at the decline of the sun [from its meridian] until the darkness of the night and [also] the Qur'an of dawn. Indeed, the recitation of dawn is ever witnessed.",
    "And from [part of] the night, pray with it as additional [worship] for you; it is expected that your Lord will resurrect you to a praised station.",
    "And say, \"My Lord, cause me to enter a sound entrance and to exit a sound exit and grant me from Yourself a supporting authority.\"",
    "And say, \"Truth has come, and falsehood has departed. Indeed is falsehood, [by nature], ever bound to depart.\"",
    "And We send down of the Qur'an that which is healing and mercy for the believers, but it does not increase the wrongdoers except in loss.",
    "And when We bestow favor upon the disbeliever, he turns away and distances himself; and when evil touches him, he is ever despairing.",
    "Say, \"Each works according to his manner, but your Lord is most knowing of who is best guided in way.\"",
    "And they ask you, [O Muhammad], about the soul. Say, \"The soul is of the affair of my Lord. And mankind have not been given of knowledge except a little.\"",
    "And if We willed, We could surely do away with that which We revealed to you. Then you would not find for yourself concerning it an advocate against Us.",
    "Except [We have left it with you] as a mercy from your Lord. Indeed, His favor upon you has ever been great.",
    "Say, \"If mankind and the jinn gathered in order to produce the like of this Qur'an, they could not produce the like of it, even if they were to each other assistants.\"",
    "And We have certainly diversified for the people in this Qur'an from every [kind] of example, but most of the people refused [anything] except disbelief.",
    "And they say, \"We will not believe you until you break open for us from the ground a spring.",
    "Or [until] you have a garden of palm tress and grapes and make rivers gush forth within them in force [and abundance]",
    "Or you make the heaven fall upon us in fragments as you have claimed or you bring Allah and the angels before [us]",
    "Or you have a house of gold or you ascend into the sky. And [even then], we will not believe in your ascension until you bring down to us a book we may read.\" Say, \"Exalted is my Lord! Was I ever but a human messenger?\"",
    "And what prevented the people from believing when guidance came to them except that they said, \"Has Allah sent a human messenger?\"",
    "Say, \"If there were upon the earth angels walking securely, We would have sent down to them from the heaven an angel [as a] messenger.\"",
    "Say, \"Sufficient is Allah as Witness between me and you. Indeed he is ever, concerning His servants, Acquainted and Seeing.\"",
    "And whoever Allah guides - he is the [rightly] guided; and whoever He sends astray - you will never find for them protectors besides Him, and We will gather them on the Day of Resurrection [fallen] on their faces - blind, dumb and deaf. Their refuge is Hell; every time it subsides We increase them in blazing fire.",
    "That is their recompense because they disbelieved in Our verses and said, \"When we are bones and crumbled particles, will we [truly] be resurrected [in] a new creation?\"",
    "Do they not see that Allah, who created the heavens and earth, is [the one] Able to create the likes of them? And He has appointed for them a term, about which there is no doubt. But the wrongdoers refuse [anything] except disbelief.",
    "Say [to them], \"If you possessed the depositories of the mercy of my Lord, then you would withhold out of fear of spending.\" And ever has man been stingy.",
    "And We had certainly given Moses nine evident signs, so ask the Children of Israel [about] when he came to them and Pharaoh said to him, \"Indeed I think, O Moses, that you are affected by magic.\"",
    "[Moses] said, \"You have already known that none has sent down these [signs] except the Lord of the heavens and the earth as evidence, and indeed I think, O Pharaoh, that you are destroyed.\"",
    "So he intended to drive them from the land, but We drowned him and those with him all together.",
    "And We said after Pharaoh to the Children of Israel, \"Dwell in the land, and when there comes the promise of the Hereafter, We will bring you forth in [one] gathering.\"",
    "And with the truth We have sent the Qur'an down, and with the truth it has descended. And We have not sent you, [O Muhammad], except as a bringer of good tidings and a warner.",
    "And [it is] a Qur'an which We have separated [by intervals] that you might recite it to the people over a prolonged period. And We have sent it down progressively.",
    "Say, \"Believe in it or do not believe. Indeed, those who were given knowledge before it - when it is recited to them, they fall upon their faces in prostration,",
    "And they say, \"Exalted is our Lord! Indeed, the promise of our Lord has been fulfilled.\"",
    "And they fall upon their faces weeping, and the Qur'an increases them in humble submission.",
    "Say, \"Call upon Allah or call upon the Most Merciful. Whichever [name] you call - to Him belong the best names.\" And do not recite [too] loudly in your prayer or [too] quietly but seek between that an [intermediate] way.",
    "And say, \"Praise to Allah, who has not taken a son and has had no partner in [His] dominion and has no [need of a] protector out of weakness; and glorify Him with [great] glorification.\""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__isra);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_isra);
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
