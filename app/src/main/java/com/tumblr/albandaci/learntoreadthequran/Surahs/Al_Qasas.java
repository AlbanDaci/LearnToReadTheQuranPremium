package com.tumblr.albandaci.learntoreadthequran.Surahs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.tumblr.albandaci.learntoreadthequran.Adapter.Al_Fatihah_Adapter;
import com.tumblr.albandaci.learntoreadthequran.R;

public class Al_Qasas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] verses = {"28:1", "28:2", "28:3", "28:4", "28:5", "28:6", "28:7", "28:8", "28:9", "28:10", "28:11", "28:12", "28:13", "28:14", "28:15", "28:16",
            "28:17", "28:18", "28:19", "28:20", "28:21", "28:22", "28:23", "28:24", "28:25", "28:26", "28:27", "28:28", "28:29", "28:30", "28:31", "28:32",
            "28:33", "28:34", "28:35", "28:36", "28:37", "28:38", "28:39", "28:40", "28:41", "28:42", "28:43", "28:44", "28:45", "28:46", "28:47", "28:48",
            "28:49", "28:50", "28:51", "28:52", "28:53", "28:54", "28:55", "28:56", "28:57", "28:58", "28:59", "28:60", "28:61", "28:62", "28:63", "28:64",
            "28:65", "28:66", "28:67", "28:68", "28:69", "28:70", "28:71", "28:72", "28:73", "28:74", "28:75", "28:76", "28:77", "28:78", "28:79", "28:80",
            "28:81", "28:82", "28:83", "28:84", "28:85", "28:86", "28:87", "28:88"};

    String [] arabic_verses = {"طسم",
    "تِلْكَ آيَاتُ الْكِتَابِ الْمُبِينِ",
    "نَتْلُو عَلَيْكَ مِن نَّبَإِ مُوسَىٰ وَفِرْعَوْنَ بِالْحَقِّ لِقَوْمٍ يُؤْمِنُونَ",
    "إِنَّ فِرْعَوْنَ عَلَا فِي الْأَرْضِ وَجَعَلَ أَهْلَهَا شِيَعًا يَسْتَضْعِفُ طَائِفَةً مِّنْهُمْ يُذَبِّحُ أَبْنَاءَهُمْ وَيَسْتَحْيِي نِسَاءَهُمْ ۚ إِنَّهُ كَانَ مِنَ الْمُفْسِدِينَ",
    "وَنُرِيدُ أَن نَّمُنَّ عَلَى الَّذِينَ اسْتُضْعِفُوا فِي الْأَرْضِ وَنَجْعَلَهُمْ أَئِمَّةً وَنَجْعَلَهُمُ الْوَارِثِينَ",
    "وَنُمَكِّنَ لَهُمْ فِي الْأَرْضِ وَنُرِيَ فِرْعَوْنَ وَهَامَانَ وَجُنُودَهُمَا مِنْهُم مَّا كَانُوا يَحْذَرُونَ",
    "وَأَوْحَيْنَا إِلَىٰ أُمِّ مُوسَىٰ أَنْ أَرْضِعِيهِ ۖ فَإِذَا خِفْتِ عَلَيْهِ فَأَلْقِيهِ فِي الْيَمِّ وَلَا تَخَافِي وَلَا تَحْزَنِي ۖ إِنَّا رَادُّوهُ إِلَيْكِ وَجَاعِلُوهُ مِنَ الْمُرْسَلِينَ",
    "فَالْتَقَطَهُ آلُ فِرْعَوْنَ لِيَكُونَ لَهُمْ عَدُوًّا وَحَزَنًا ۗ إِنَّ فِرْعَوْنَ وَهَامَانَ وَجُنُودَهُمَا كَانُوا خَاطِئِينَ",
    "وَقَالَتِ امْرَأَتُ فِرْعَوْنَ قُرَّتُ عَيْنٍ لِّي وَلَكَ ۖ لَا تَقْتُلُوهُ عَسَىٰ أَن يَنفَعَنَا أَوْ نَتَّخِذَهُ وَلَدًا وَهُمْ لَا يَشْعُرُونَ",
    "وَأَصْبَحَ فُؤَادُ أُمِّ مُوسَىٰ فَارِغًا ۖ إِن كَادَتْ لَتُبْدِي بِهِ لَوْلَا أَن رَّبَطْنَا عَلَىٰ قَلْبِهَا لِتَكُونَ مِنَ الْمُؤْمِنِينَ",
    "وَقَالَتْ لِأُخْتِهِ قُصِّيهِ ۖ فَبَصُرَتْ بِهِ عَن جُنُبٍ وَهُمْ لَا يَشْعُرُونَ",
    "وَحَرَّمْنَا عَلَيْهِ الْمَرَاضِعَ مِن قَبْلُ فَقَالَتْ هَلْ أَدُلُّكُمْ عَلَىٰ أَهْلِ بَيْتٍ يَكْفُلُونَهُ لَكُمْ وَهُمْ لَهُ نَاصِحُونَ",
    "فَرَدَدْنَاهُ إِلَىٰ أُمِّهِ كَيْ تَقَرَّ عَيْنُهَا وَلَا تَحْزَنَ وَلِتَعْلَمَ أَنَّ وَعْدَ اللَّهِ حَقٌّ وَلَٰكِنَّ أَكْثَرَهُمْ لَا يَعْلَمُونَ",
    "وَلَمَّا بَلَغَ أَشُدَّهُ وَاسْتَوَىٰ آتَيْنَاهُ حُكْمًا وَعِلْمًا ۚ وَكَذَٰلِكَ نَجْزِي الْمُحْسِنِينَ",
    "وَدَخَلَ الْمَدِينَةَ عَلَىٰ حِينِ غَفْلَةٍ مِّنْ أَهْلِهَا فَوَجَدَ فِيهَا رَجُلَيْنِ يَقْتَتِلَانِ هَٰذَا مِن شِيعَتِهِ وَهَٰذَا مِنْ عَدُوِّهِ ۖ فَاسْتَغَاثَهُ الَّذِي مِن شِيعَتِهِ عَلَى الَّذِي مِنْ عَدُوِّهِ فَوَكَزَهُ مُوسَىٰ فَقَضَىٰ عَلَيْهِ ۖ قَالَ هَٰذَا مِنْ عَمَلِ الشَّيْطَانِ ۖ إِنَّهُ عَدُوٌّ مُّضِلٌّ مُّبِينٌ",
    "قَالَ رَبِّ إِنِّي ظَلَمْتُ نَفْسِي فَاغْفِرْ لِي فَغَفَرَ لَهُ ۚ إِنَّهُ هُوَ الْغَفُورُ الرَّحِيمُ",
    "قَالَ رَبِّ بِمَا أَنْعَمْتَ عَلَيَّ فَلَنْ أَكُونَ ظَهِيرًا لِّلْمُجْرِمِينَ",
    "فَأَصْبَحَ فِي الْمَدِينَةِ خَائِفًا يَتَرَقَّبُ فَإِذَا الَّذِي اسْتَنصَرَهُ بِالْأَمْسِ يَسْتَصْرِخُهُ ۚ قَالَ لَهُ مُوسَىٰ إِنَّكَ لَغَوِيٌّ مُّبِينٌ",
    "فَلَمَّا أَنْ أَرَادَ أَن يَبْطِشَ بِالَّذِي هُوَ عَدُوٌّ لَّهُمَا قَالَ يَا مُوسَىٰ أَتُرِيدُ أَن تَقْتُلَنِي كَمَا قَتَلْتَ نَفْسًا بِالْأَمْسِ ۖ إِن تُرِيدُ إِلَّا أَن تَكُونَ جَبَّارًا فِي الْأَرْضِ وَمَا تُرِيدُ أَن تَكُونَ مِنَ الْمُصْلِحِينَ",
    "وَجَاءَ رَجُلٌ مِّنْ أَقْصَى الْمَدِينَةِ يَسْعَىٰ قَالَ يَا مُوسَىٰ إِنَّ الْمَلَأَ يَأْتَمِرُونَ بِكَ لِيَقْتُلُوكَ فَاخْرُجْ إِنِّي لَكَ مِنَ النَّاصِحِينَ",
    "فَخَرَجَ مِنْهَا خَائِفًا يَتَرَقَّبُ ۖ قَالَ رَبِّ نَجِّنِي مِنَ الْقَوْمِ الظَّالِمِينَ",
    "وَلَمَّا تَوَجَّهَ تِلْقَاءَ مَدْيَنَ قَالَ عَسَىٰ رَبِّي أَن يَهْدِيَنِي سَوَاءَ السَّبِيلِ",
    "وَلَمَّا وَرَدَ مَاءَ مَدْيَنَ وَجَدَ عَلَيْهِ أُمَّةً مِّنَ النَّاسِ يَسْقُونَ وَوَجَدَ مِن دُونِهِمُ امْرَأَتَيْنِ تَذُودَانِ ۖ قَالَ مَا خَطْبُكُمَا ۖ قَالَتَا لَا نَسْقِي حَتَّىٰ يُصْدِرَ الرِّعَاءُ ۖ وَأَبُونَا شَيْخٌ كَبِيرٌ",
    "فَسَقَىٰ لَهُمَا ثُمَّ تَوَلَّىٰ إِلَى الظِّلِّ فَقَالَ رَبِّ إِنِّي لِمَا أَنزَلْتَ إِلَيَّ مِنْ خَيْرٍ فَقِيرٌ",
    "فَجَاءَتْهُ إِحْدَاهُمَا تَمْشِي عَلَى اسْتِحْيَاءٍ قَالَتْ إِنَّ أَبِي يَدْعُوكَ لِيَجْزِيَكَ أَجْرَ مَا سَقَيْتَ لَنَا ۚ فَلَمَّا جَاءَهُ وَقَصَّ عَلَيْهِ الْقَصَصَ قَالَ لَا تَخَفْ ۖ نَجَوْتَ مِنَ الْقَوْمِ الظَّالِمِينَ",
    "قَالَتْ إِحْدَاهُمَا يَا أَبَتِ اسْتَأْجِرْهُ ۖ إِنَّ خَيْرَ مَنِ اسْتَأْجَرْتَ الْقَوِيُّ الْأَمِينُ",
    "قَالَ إِنِّي أُرِيدُ أَنْ أُنكِحَكَ إِحْدَى ابْنَتَيَّ هَاتَيْنِ عَلَىٰ أَن تَأْجُرَنِي ثَمَانِيَ حِجَجٍ ۖ فَإِنْ أَتْمَمْتَ عَشْرًا فَمِنْ عِندِكَ ۖ وَمَا أُرِيدُ أَنْ أَشُقَّ عَلَيْكَ ۚ سَتَجِدُنِي إِن شَاءَ اللَّهُ مِنَ الصَّالِحِينَ",
    "قَالَ ذَٰلِكَ بَيْنِي وَبَيْنَكَ ۖ أَيَّمَا الْأَجَلَيْنِ قَضَيْتُ فَلَا عُدْوَانَ عَلَيَّ ۖ وَاللَّهُ عَلَىٰ مَا نَقُولُ وَكِيلٌ",
    "فَلَمَّا قَضَىٰ مُوسَى الْأَجَلَ وَسَارَ بِأَهْلِهِ آنَسَ مِن جَانِبِ الطُّورِ نَارًا قَالَ لِأَهْلِهِ امْكُثُوا إِنِّي آنَسْتُ نَارًا لَّعَلِّي آتِيكُم مِّنْهَا بِخَبَرٍ أَوْ جَذْوَةٍ مِّنَ النَّارِ لَعَلَّكُمْ تَصْطَلُونَ",
    "فَلَمَّا أَتَاهَا نُودِيَ مِن شَاطِئِ الْوَادِ الْأَيْمَنِ فِي الْبُقْعَةِ الْمُبَارَكَةِ مِنَ الشَّجَرَةِ أَن يَا مُوسَىٰ إِنِّي أَنَا اللَّهُ رَبُّ الْعَالَمِينَ",
    "وَأَنْ أَلْقِ عَصَاكَ ۖ فَلَمَّا رَآهَا تَهْتَزُّ كَأَنَّهَا جَانٌّ وَلَّىٰ مُدْبِرًا وَلَمْ يُعَقِّبْ ۚ يَا مُوسَىٰ أَقْبِلْ وَلَا تَخَفْ ۖ إِنَّكَ مِنَ الْآمِنِينَ",
    "اسْلُكْ يَدَكَ فِي جَيْبِكَ تَخْرُجْ بَيْضَاءَ مِنْ غَيْرِ سُوءٍ وَاضْمُمْ إِلَيْكَ جَنَاحَكَ مِنَ الرَّهْبِ ۖ فَذَانِكَ بُرْهَانَانِ مِن رَّبِّكَ إِلَىٰ فِرْعَوْنَ وَمَلَئِهِ ۚ إِنَّهُمْ كَانُوا قَوْمًا فَاسِقِينَ",
    "قَالَ رَبِّ إِنِّي قَتَلْتُ مِنْهُمْ نَفْسًا فَأَخَافُ أَن يَقْتُلُونِ",
    "وَأَخِي هَارُونُ هُوَ أَفْصَحُ مِنِّي لِسَانًا فَأَرْسِلْهُ مَعِيَ رِدْءًا يُصَدِّقُنِي ۖ إِنِّي أَخَافُ أَن يُكَذِّبُونِ",
    "قَالَ سَنَشُدُّ عَضُدَكَ بِأَخِيكَ وَنَجْعَلُ لَكُمَا سُلْطَانًا فَلَا يَصِلُونَ إِلَيْكُمَا ۚ بِآيَاتِنَا أَنتُمَا وَمَنِ اتَّبَعَكُمَا الْغَالِبُونَ",
    "فَلَمَّا جَاءَهُم مُّوسَىٰ بِآيَاتِنَا بَيِّنَاتٍ قَالُوا مَا هَٰذَا إِلَّا سِحْرٌ مُّفْتَرًى وَمَا سَمِعْنَا بِهَٰذَا فِي آبَائِنَا الْأَوَّلِينَ",
    "وَقَالَ مُوسَىٰ رَبِّي أَعْلَمُ بِمَن جَاءَ بِالْهُدَىٰ مِنْ عِندِهِ وَمَن تَكُونُ لَهُ عَاقِبَةُ الدَّارِ ۖ إِنَّهُ لَا يُفْلِحُ الظَّالِمُونَ",
    "وَقَالَ فِرْعَوْنُ يَا أَيُّهَا الْمَلَأُ مَا عَلِمْتُ لَكُم مِّنْ إِلَٰهٍ غَيْرِي فَأَوْقِدْ لِي يَا هَامَانُ عَلَى الطِّينِ فَاجْعَل لِّي صَرْحًا لَّعَلِّي أَطَّلِعُ إِلَىٰ إِلَٰهِ مُوسَىٰ وَإِنِّي لَأَظُنُّهُ مِنَ الْكَاذِبِينَ",
    "وَاسْتَكْبَرَ هُوَ وَجُنُودُهُ فِي الْأَرْضِ بِغَيْرِ الْحَقِّ وَظَنُّوا أَنَّهُمْ إِلَيْنَا لَا يُرْجَعُونَ",
    "فَأَخَذْنَاهُ وَجُنُودَهُ فَنَبَذْنَاهُمْ فِي الْيَمِّ ۖ فَانظُرْ كَيْفَ كَانَ عَاقِبَةُ الظَّالِمِينَ",
    "وَجَعَلْنَاهُمْ أَئِمَّةً يَدْعُونَ إِلَى النَّارِ ۖ وَيَوْمَ الْقِيَامَةِ لَا يُنصَرُونَ",
    "وَأَتْبَعْنَاهُمْ فِي هَٰذِهِ الدُّنْيَا لَعْنَةً ۖ وَيَوْمَ الْقِيَامَةِ هُم مِّنَ الْمَقْبُوحِينَ",
    "وَلَقَدْ آتَيْنَا مُوسَى الْكِتَابَ مِن بَعْدِ مَا أَهْلَكْنَا الْقُرُونَ الْأُولَىٰ بَصَائِرَ لِلنَّاسِ وَهُدًى وَرَحْمَةً لَّعَلَّهُمْ يَتَذَكَّرُونَ",
    "وَمَا كُنتَ بِجَانِبِ الْغَرْبِيِّ إِذْ قَضَيْنَا إِلَىٰ مُوسَى الْأَمْرَ وَمَا كُنتَ مِنَ الشَّاهِدِينَ",
    "وَلَٰكِنَّا أَنشَأْنَا قُرُونًا فَتَطَاوَلَ عَلَيْهِمُ الْعُمُرُ ۚ وَمَا كُنتَ ثَاوِيًا فِي أَهْلِ مَدْيَنَ تَتْلُو عَلَيْهِمْ آيَاتِنَا وَلَٰكِنَّا كُنَّا مُرْسِلِينَ",
    "وَمَا كُنتَ بِجَانِبِ الطُّورِ إِذْ نَادَيْنَا وَلَٰكِن رَّحْمَةً مِّن رَّبِّكَ لِتُنذِرَ قَوْمًا مَّا أَتَاهُم مِّن نَّذِيرٍ مِّن قَبْلِكَ لَعَلَّهُمْ يَتَذَكَّرُونَ",
    "وَلَوْلَا أَن تُصِيبَهُم مُّصِيبَةٌ بِمَا قَدَّمَتْ أَيْدِيهِمْ فَيَقُولُوا رَبَّنَا لَوْلَا أَرْسَلْتَ إِلَيْنَا رَسُولًا فَنَتَّبِعَ آيَاتِكَ وَنَكُونَ مِنَ الْمُؤْمِنِينَ",
    "فَلَمَّا جَاءَهُمُ الْحَقُّ مِنْ عِندِنَا قَالُوا لَوْلَا أُوتِيَ مِثْلَ مَا أُوتِيَ مُوسَىٰ ۚ أَوَلَمْ يَكْفُرُوا بِمَا أُوتِيَ مُوسَىٰ مِن قَبْلُ ۖ قَالُوا سِحْرَانِ تَظَاهَرَا وَقَالُوا إِنَّا بِكُلٍّ كَافِرُونَ",
    "قُلْ فَأْتُوا بِكِتَابٍ مِّنْ عِندِ اللَّهِ هُوَ أَهْدَىٰ مِنْهُمَا أَتَّبِعْهُ إِن كُنتُمْ صَادِقِينَ",
    "فَإِن لَّمْ يَسْتَجِيبُوا لَكَ فَاعْلَمْ أَنَّمَا يَتَّبِعُونَ أَهْوَاءَهُمْ ۚ وَمَنْ أَضَلُّ مِمَّنِ اتَّبَعَ هَوَاهُ بِغَيْرِ هُدًى مِّنَ اللَّهِ ۚ إِنَّ اللَّهَ لَا يَهْدِي الْقَوْمَ الظَّالِمِينَ",
    "وَلَقَدْ وَصَّلْنَا لَهُمُ الْقَوْلَ لَعَلَّهُمْ يَتَذَكَّرُونَ",
    "الَّذِينَ آتَيْنَاهُمُ الْكِتَابَ مِن قَبْلِهِ هُم بِهِ يُؤْمِنُونَ",
    "وَإِذَا يُتْلَىٰ عَلَيْهِمْ قَالُوا آمَنَّا بِهِ إِنَّهُ الْحَقُّ مِن رَّبِّنَا إِنَّا كُنَّا مِن قَبْلِهِ مُسْلِمِينَ",
    "أُولَٰئِكَ يُؤْتَوْنَ أَجْرَهُم مَّرَّتَيْنِ بِمَا صَبَرُوا وَيَدْرَءُونَ بِالْحَسَنَةِ السَّيِّئَةَ وَمِمَّا رَزَقْنَاهُمْ يُنفِقُونَ",
    "وَإِذَا سَمِعُوا اللَّغْوَ أَعْرَضُوا عَنْهُ وَقَالُوا لَنَا أَعْمَالُنَا وَلَكُمْ أَعْمَالُكُمْ سَلَامٌ عَلَيْكُمْ لَا نَبْتَغِي الْجَاهِلِينَ",
    "إِنَّكَ لَا تَهْدِي مَنْ أَحْبَبْتَ وَلَٰكِنَّ اللَّهَ يَهْدِي مَن يَشَاءُ ۚ وَهُوَ أَعْلَمُ بِالْمُهْتَدِينَ",
    "وَقَالُوا إِن نَّتَّبِعِ الْهُدَىٰ مَعَكَ نُتَخَطَّفْ مِنْ أَرْضِنَا ۚ أَوَلَمْ نُمَكِّن لَّهُمْ حَرَمًا آمِنًا يُجْبَىٰ إِلَيْهِ ثَمَرَاتُ كُلِّ شَيْءٍ رِّزْقًا مِّن لَّدُنَّا وَلَٰكِنَّ أَكْثَرَهُمْ لَا يَعْلَمُونَ",
    "وَكَمْ أَهْلَكْنَا مِن قَرْيَةٍ بَطِرَتْ مَعِيشَتَهَا ۖ فَتِلْكَ مَسَاكِنُهُمْ لَمْ تُسْكَن مِّن بَعْدِهِمْ إِلَّا قَلِيلًا ۖ وَكُنَّا نَحْنُ الْوَارِثِينَ",
    "وَمَا كَانَ رَبُّكَ مُهْلِكَ الْقُرَىٰ حَتَّىٰ يَبْعَثَ فِي أُمِّهَا رَسُولًا يَتْلُو عَلَيْهِمْ آيَاتِنَا ۚ وَمَا كُنَّا مُهْلِكِي الْقُرَىٰ إِلَّا وَأَهْلُهَا ظَالِمُونَ",
    "وَمَا أُوتِيتُم مِّن شَيْءٍ فَمَتَاعُ الْحَيَاةِ الدُّنْيَا وَزِينَتُهَا ۚ وَمَا عِندَ اللَّهِ خَيْرٌ وَأَبْقَىٰ ۚ أَفَلَا تَعْقِلُونَ",
    "أَفَمَن وَعَدْنَاهُ وَعْدًا حَسَنًا فَهُوَ لَاقِيهِ كَمَن مَّتَّعْنَاهُ مَتَاعَ الْحَيَاةِ الدُّنْيَا ثُمَّ هُوَ يَوْمَ الْقِيَامَةِ مِنَ الْمُحْضَرِينَ",
    "وَيَوْمَ يُنَادِيهِمْ فَيَقُولُ أَيْنَ شُرَكَائِيَ الَّذِينَ كُنتُمْ تَزْعُمُونَ",
    "قَالَ الَّذِينَ حَقَّ عَلَيْهِمُ الْقَوْلُ رَبَّنَا هَٰؤُلَاءِ الَّذِينَ أَغْوَيْنَا أَغْوَيْنَاهُمْ كَمَا غَوَيْنَا ۖ تَبَرَّأْنَا إِلَيْكَ ۖ مَا كَانُوا إِيَّانَا يَعْبُدُونَ",
    "وَقِيلَ ادْعُوا شُرَكَاءَكُمْ فَدَعَوْهُمْ فَلَمْ يَسْتَجِيبُوا لَهُمْ وَرَأَوُا الْعَذَابَ ۚ لَوْ أَنَّهُمْ كَانُوا يَهْتَدُونَ",
    "وَيَوْمَ يُنَادِيهِمْ فَيَقُولُ مَاذَا أَجَبْتُمُ الْمُرْسَلِينَ",
    "فَعَمِيَتْ عَلَيْهِمُ الْأَنبَاءُ يَوْمَئِذٍ فَهُمْ لَا يَتَسَاءَلُونَ",
    "فَأَمَّا مَن تَابَ وَآمَنَ وَعَمِلَ صَالِحًا فَعَسَىٰ أَن يَكُونَ مِنَ الْمُفْلِحِينَ",
    "وَرَبُّكَ يَخْلُقُ مَا يَشَاءُ وَيَخْتَارُ ۗ مَا كَانَ لَهُمُ الْخِيَرَةُ ۚ سُبْحَانَ اللَّهِ وَتَعَالَىٰ عَمَّا يُشْرِكُونَ",
    "وَرَبُّكَ يَعْلَمُ مَا تُكِنُّ صُدُورُهُمْ وَمَا يُعْلِنُونَ",
    "وَهُوَ اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ ۖ لَهُ الْحَمْدُ فِي الْأُولَىٰ وَالْآخِرَةِ ۖ وَلَهُ الْحُكْمُ وَإِلَيْهِ تُرْجَعُونَ",
    "قُلْ أَرَأَيْتُمْ إِن جَعَلَ اللَّهُ عَلَيْكُمُ اللَّيْلَ سَرْمَدًا إِلَىٰ يَوْمِ الْقِيَامَةِ مَنْ إِلَٰهٌ غَيْرُ اللَّهِ يَأْتِيكُم بِضِيَاءٍ ۖ أَفَلَا تَسْمَعُونَ",
    "قُلْ أَرَأَيْتُمْ إِن جَعَلَ اللَّهُ عَلَيْكُمُ النَّهَارَ سَرْمَدًا إِلَىٰ يَوْمِ الْقِيَامَةِ مَنْ إِلَٰهٌ غَيْرُ اللَّهِ يَأْتِيكُم بِلَيْلٍ تَسْكُنُونَ فِيهِ ۖ أَفَلَا تُبْصِرُونَ",
    "وَمِن رَّحْمَتِهِ جَعَلَ لَكُمُ اللَّيْلَ وَالنَّهَارَ لِتَسْكُنُوا فِيهِ وَلِتَبْتَغُوا مِن فَضْلِهِ وَلَعَلَّكُمْ تَشْكُرُونَ",
    "وَيَوْمَ يُنَادِيهِمْ فَيَقُولُ أَيْنَ شُرَكَائِيَ الَّذِينَ كُنتُمْ تَزْعُمُونَ",
    "وَنَزَعْنَا مِن كُلِّ أُمَّةٍ شَهِيدًا فَقُلْنَا هَاتُوا بُرْهَانَكُمْ فَعَلِمُوا أَنَّ الْحَقَّ لِلَّهِ وَضَلَّ عَنْهُم مَّا كَانُوا يَفْتَرُونَ",
    "إِنَّ قَارُونَ كَانَ مِن قَوْمِ مُوسَىٰ فَبَغَىٰ عَلَيْهِمْ ۖ وَآتَيْنَاهُ مِنَ الْكُنُوزِ مَا إِنَّ مَفَاتِحَهُ لَتَنُوءُ بِالْعُصْبَةِ أُولِي الْقُوَّةِ إِذْ قَالَ لَهُ قَوْمُهُ لَا تَفْرَحْ ۖ إِنَّ اللَّهَ لَا يُحِبُّ الْفَرِحِينَ",
    "وَابْتَغِ فِيمَا آتَاكَ اللَّهُ الدَّارَ الْآخِرَةَ ۖ وَلَا تَنسَ نَصِيبَكَ مِنَ الدُّنْيَا ۖ وَأَحْسِن كَمَا أَحْسَنَ اللَّهُ إِلَيْكَ ۖ وَلَا تَبْغِ الْفَسَادَ فِي الْأَرْضِ ۖ إِنَّ اللَّهَ لَا يُحِبُّ الْمُفْسِدِينَ",
    "قَالَ إِنَّمَا أُوتِيتُهُ عَلَىٰ عِلْمٍ عِندِي ۚ أَوَلَمْ يَعْلَمْ أَنَّ اللَّهَ قَدْ أَهْلَكَ مِن قَبْلِهِ مِنَ الْقُرُونِ مَنْ هُوَ أَشَدُّ مِنْهُ قُوَّةً وَأَكْثَرُ جَمْعًا ۚ وَلَا يُسْأَلُ عَن ذُنُوبِهِمُ الْمُجْرِمُونَ",
    "فَخَرَجَ عَلَىٰ قَوْمِهِ فِي زِينَتِهِ ۖ قَالَ الَّذِينَ يُرِيدُونَ الْحَيَاةَ الدُّنْيَا يَا لَيْتَ لَنَا مِثْلَ مَا أُوتِيَ قَارُونُ إِنَّهُ لَذُو حَظٍّ عَظِيمٍ",
    "وَقَالَ الَّذِينَ أُوتُوا الْعِلْمَ وَيْلَكُمْ ثَوَابُ اللَّهِ خَيْرٌ لِّمَنْ آمَنَ وَعَمِلَ صَالِحًا وَلَا يُلَقَّاهَا إِلَّا الصَّابِرُونَ",
    "فَخَسَفْنَا بِهِ وَبِدَارِهِ الْأَرْضَ فَمَا كَانَ لَهُ مِن فِئَةٍ يَنصُرُونَهُ مِن دُونِ اللَّهِ وَمَا كَانَ مِنَ الْمُنتَصِرِينَ",
    "وَأَصْبَحَ الَّذِينَ تَمَنَّوْا مَكَانَهُ بِالْأَمْسِ يَقُولُونَ وَيْكَأَنَّ اللَّهَ يَبْسُطُ الرِّزْقَ لِمَن يَشَاءُ مِنْ عِبَادِهِ وَيَقْدِرُ ۖ لَوْلَا أَن مَّنَّ اللَّهُ عَلَيْنَا لَخَسَفَ بِنَا ۖ وَيْكَأَنَّهُ لَا يُفْلِحُ الْكَافِرُونَ",
    "تِلْكَ الدَّارُ الْآخِرَةُ نَجْعَلُهَا لِلَّذِينَ لَا يُرِيدُونَ عُلُوًّا فِي الْأَرْضِ وَلَا فَسَادًا ۚ وَالْعَاقِبَةُ لِلْمُتَّقِينَ",
    "مَن جَاءَ بِالْحَسَنَةِ فَلَهُ خَيْرٌ مِّنْهَا ۖ وَمَن جَاءَ بِالسَّيِّئَةِ فَلَا يُجْزَى الَّذِينَ عَمِلُوا السَّيِّئَاتِ إِلَّا مَا كَانُوا يَعْمَلُونَ",
    "إِنَّ الَّذِي فَرَضَ عَلَيْكَ الْقُرْآنَ لَرَادُّكَ إِلَىٰ مَعَادٍ ۚ قُل رَّبِّي أَعْلَمُ مَن جَاءَ بِالْهُدَىٰ وَمَنْ هُوَ فِي ضَلَالٍ مُّبِينٍ",
    "وَمَا كُنتَ تَرْجُو أَن يُلْقَىٰ إِلَيْكَ الْكِتَابُ إِلَّا رَحْمَةً مِّن رَّبِّكَ ۖ فَلَا تَكُونَنَّ ظَهِيرًا لِّلْكَافِرِينَ",
    "وَلَا يَصُدُّنَّكَ عَنْ آيَاتِ اللَّهِ بَعْدَ إِذْ أُنزِلَتْ إِلَيْكَ ۖ وَادْعُ إِلَىٰ رَبِّكَ ۖ وَلَا تَكُونَنَّ مِنَ الْمُشْرِكِينَ",
    "وَلَا تَدْعُ مَعَ اللَّهِ إِلَٰهًا آخَرَ ۘ لَا إِلَٰهَ إِلَّا هُوَ ۚ كُلُّ شَيْءٍ هَالِكٌ إِلَّا وَجْهَهُ ۚ لَهُ الْحُكْمُ وَإِلَيْهِ تُرْجَعُونَ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Ta, Seen, Meem.",
    "These are the verses of the clear Book.",
    "We recite to you from the news of Moses and Pharaoh in truth for a people who believe.",
    "Indeed, Pharaoh exalted himself in the land and made its people into factions, oppressing a sector among them, slaughtering their [newborn] sons and keeping their females alive. Indeed, he was of the corrupters.",
    "And We wanted to confer favor upon those who were oppressed in the land and make them leaders and make them inheritors",
    "And establish them in the land and show Pharaoh and [his minister] Haman and their soldiers through them that which they had feared.",
    "And We inspired to the mother of Moses, \"Suckle him; but when you fear for him, cast him into the river and do not fear and do not grieve. Indeed, We will return him to you and will make him [one] of the messengers.\"",
    "And the family of Pharaoh picked him up [out of the river] so that he would become to them an enemy and a [cause of] grief. Indeed, Pharaoh and Haman and their soldiers were deliberate sinners.",
    "And the wife of Pharaoh said, \"[He will be] a comfort of the eye for me and for you. Do not kill him; perhaps he may benefit us, or we may adopt him as a son.\" And they perceived not.",
    "And the heart of Moses' mother became empty [of all else]. She was about to disclose [the matter concerning] him had We not bound fast her heart that she would be of the believers.",
    "And she said to his sister, \"Follow him\"; so she watched him from a distance while they perceived not.",
    "And We had prevented from him [all] wet nurses before, so she said, \"Shall I direct you to a household that will be responsible for him for you while they are to him [for his upbringing] sincere?\"",
    "So We restored him to his mother that she might be content and not grieve and that she would know that the promise of Allah is true. But most of the people do not know.",
    "And when he attained his full strength and was [mentally] mature, We bestowed upon him judgement and knowledge. And thus do We reward the doers of good.",
    "And he entered the city at a time of inattention by its people and found therein two men fighting: one from his faction and one from among his enemy. And the one from his faction called for help to him against the one from his enemy, so Moses struck him and [unintentionally] killed him. [Moses] said, \"This is from the work of Satan. Indeed, he is a manifest, misleading enemy.\"",
    "He said, \"My Lord, indeed I have wronged myself, so forgive me,\" and He forgave him. Indeed, He is the Forgiving, the Merciful.",
    "He said, \"My Lord, for the favor You bestowed upon me, I will never be an assistant to the criminals.\"",
    "And he became inside the city fearful and anticipating [exposure], when suddenly the one who sought his help the previous day cried out to him [once again]. Moses said to him, \"Indeed, you are an evident, [persistent] deviator.\"",
    "And when he wanted to strike the one who was an enemy to both of them, he said, \"O Moses, do you intend to kill me as you killed someone yesterday? You only want to be a tyrant in the land and do not want to be of the amenders.\"",
    "And a man came from the farthest end of the city, running. He said, \"O Moses, indeed the eminent ones are conferring over you [intending] to kill you, so leave [the city]; indeed, I am to you of the sincere advisors.\"",
    "So he left it, fearful and anticipating [apprehension]. He said, \"My Lord, save me from the wrongdoing people.\"",
    "And when he directed himself toward Madyan, he said, \"Perhaps my Lord will guide me to the sound way.\"",
    "And when he came to the well of Madyan, he found there a crowd of people watering [their flocks], and he found aside from them two women driving back [their flocks]. He said, \"What is your circumstance?\" They said, \"We do not water until the shepherds dispatch [their flocks]; and our father is an old man.\"",
    "So he watered [their flocks] for them; then he went back to the shade and said, \"My Lord, indeed I am, for whatever good You would send down to me, in need.\"",
    "Then one of the two women came to him walking with shyness. She said, \"Indeed, my father invites you that he may reward you for having watered for us.\" So when he came to him and related to him the story, he said, \"Fear not. You have escaped from the wrongdoing people.\"",
    "One of the women said, \"O my father, hire him. Indeed, the best one you can hire is the strong and the trustworthy.\"",
    "He said, \"Indeed, I wish to wed you one of these, my two daughters, on [the condition] that you serve me for eight years; but if you complete ten, it will be [as a favor] from you. And I do not wish to put you in difficulty. You will find me, if Allah wills, from among the righteous.\"",
    "[Moses] said, \"That is [established] between me and you. Whichever of the two terms I complete - there is no injustice to me, and Allah, over what we say, is Witness.\"",
    "And when Moses had completed the term and was traveling with his family, he perceived from the direction of the mount a fire. He said to his family, \"Stay here; indeed, I have perceived a fire. Perhaps I will bring you from there [some] information or burning wood from the fire that you may warm yourselves.\"",
    "But when he came to it, he was called from the right side of the valley in a blessed spot - from the tree, \"O Moses, indeed I am Allah, Lord of the worlds.\"",
    "And [he was told], \"Throw down your staff.\" But when he saw it writhing as if it was a snake, he turned in flight and did not return. [Allah said], \"O Moses, approach and fear not. Indeed, you are of the secure.",
    "Insert your hand into the opening of your garment; it will come out white, without disease. And draw in your arm close to you [as prevention] from fear, for those are two proofs from your Lord to Pharaoh and his establishment. Indeed, they have been a people defiantly disobedient.\"",
    "He said, \"My Lord, indeed, I killed from among them someone, and I fear they will kill me.",
    "And my brother Aaron is more fluent than me in tongue, so send him with me as support, verifying me. Indeed, I fear that they will deny me.\"",
    "[Allah] said, \"We will strengthen your arm through your brother and grant you both supremacy so they will not reach you. [It will be] through Our signs; you and those who follow you will be the predominant.\"",
    "But when Moses came to them with Our signs as clear evidences, they said, \"This is not except invented magic, and we have not heard of this [religion] among our forefathers.\"",
    "And Moses said, \"My Lord is more knowing [than we or you] of who has come with guidance from Him and to whom will be succession in the home. Indeed, wrongdoers do not succeed.\"",
    "And Pharaoh said, \"O eminent ones, I have not known you to have a god other than me. Then ignite for me, O Haman, [a fire] upon the clay and make for me a tower that I may look at the God of Moses. And indeed, I do think he is among the liars.\"",
    "And he was arrogant, he and his soldiers, in the land, without right, and they thought that they would not be returned to Us.",
    "So We took him and his soldiers and threw them into the sea. So see how was the end of the wrongdoers.",
    "And We made them leaders inviting to the Fire, and on the Day of Resurrection they will not be helped.",
    "And We caused to overtake them in this world a curse, and on the Day of Resurrection they will be of the despised.",
    "And We gave Moses the Scripture, after We had destroyed the former generations, as enlightenment for the people and guidance and mercy that they might be reminded.",
    "And you, [O Muhammad], were not on the western side [of the mount] when We revealed to Moses the command, and you were not among the witnesses [to that].",
    "But We produced [many] generations [after Moses], and prolonged was their duration. And you were not a resident among the people of Madyan, reciting to them Our verses, but We were senders [of this message].",
    "And you were not at the side of the mount when We called [Moses] but [were sent] as a mercy from your Lord to warn a people to whom no warner had come before you that they might be reminded.",
    "And if not that a disaster should strike them for what their hands put forth [of sins] and they would say, \"Our Lord, why did You not send us a messenger so we could have followed Your verses and been among the believers?\"...",
    "But when the truth came to them from Us, they said, \"Why was he not given like that which was given to Moses?\" Did they not disbelieve in that which was given to Moses before? They said, \"[They are but] two works of magic supporting each other, and indeed we are, in both, disbelievers.\"",
    "Say, \"Then bring a scripture from Allah which is more guiding than either of them that I may follow it, if you should be truthful.\"",
    "But if they do not respond to you - then know that they only follow their [own] desires. And who is more astray than one who follows his desire without guidance from Allah? Indeed, Allah does not guide the wrongdoing people.",
    "And We have [repeatedly] conveyed to them the Qur'an that they might be reminded.",
    "Those to whom We gave the Scripture before it - they are believers in it.",
    "And when it is recited to them, they say, \"We have believed in it; indeed, it is the truth from our Lord. Indeed we were, [even] before it, Muslims [submitting to Allah].\"",
    "Those will be given their reward twice for what they patiently endured and [because] they avert evil through good, and from what We have provided them they spend.",
    "And when they hear ill speech, they turn away from it and say, \"For us are our deeds, and for you are your deeds. Peace will be upon you; we seek not the ignorant.\"",
    "Indeed, [O Muhammad], you do not guide whom you like, but Allah guides whom He wills. And He is most knowing of the [rightly] guided.",
    "And they say, \"If we were to follow the guidance with you, we would be swept from our land.\" Have we not established for them a safe sanctuary to which are brought the fruits of all things as provision from Us? But most of them do not know.",
    "And how many a city have We destroyed that was insolent in its [way of] living, and those are their dwellings which have not been inhabited after them except briefly. And it is We who were the inheritors.",
    "And never would your Lord have destroyed the cities until He had sent to their mother a messenger reciting to them Our verses. And We would not destroy the cities except while their people were wrongdoers.",
    "And whatever thing you [people] have been given - it is [only for] the enjoyment of worldly life and its adornment. And what is with Allah is better and more lasting; so will you not use reason?",
    "Then is he whom We have promised a good promise which he will obtain like he for whom We provided enjoyment of worldly life [but] then he is, on the Day of Resurrection, among those presented [for punishment in Hell]?",
    "And [warn of] the Day He will call them and say, \"Where are My 'partners' which you used to claim?\"",
    "Those upon whom the word will have come into effect will say, \"Our Lord, these are the ones we led to error. We led them to error just as we were in error. We declare our disassociation [from them] to You. They did not used to worship us.\"",
    "And it will be said, \"Invoke your 'partners' \" and they will invoke them; but they will not respond to them, and they will see the punishment. If only they had followed guidance!",
    "And [mention] the Day He will call them and say, \"What did you answer the messengers?\"",
    "But the information will be unapparent to them that Day, so they will not [be able to] ask one another.",
    "But as for one who had repented, believed, and done righteousness, it is promised by Allah that he will be among the successful.",
    "And your Lord creates what He wills and chooses; not for them was the choice. Exalted is Allah and high above what they associate with Him.",
    "And your Lord knows what their breasts conceal and what they declare.",
    "And He is Allah; there is no deity except Him. To Him is [due all] praise in the first [life] and the Hereafter. And His is the [final] decision, and to Him you will be returned.",
    "Say, \"Have you considered: if Allah should make for you the night continuous until the Day of Resurrection, what deity other than Allah could bring you light? Then will you not hear?\"",
    "Say, \"Have you considered: if Allah should make for you the day continuous until the Day of Resurrection, what deity other than Allah could bring you a night in which you may rest? Then will you not see?\"",
    "And out of His mercy He made for you the night and the day that you may rest therein and [by day] seek from His bounty and [that] perhaps you will be grateful.",
    "And [warn of] the Day He will call them and say, \"Where are my 'partners' which you used to claim?\"",
    "And We will extract from every nation a witness and say, \"Produce your proof,\" and they will know that the truth belongs to Allah, and lost from them is that which they used to invent.",
    "Indeed, Qarun was from the people of Moses, but he tyrannized them. And We gave him of treasures whose keys would burden a band of strong men; thereupon his people said to him, \"Do not exult. Indeed, Allah does not like the exultant.",
    "But seek, through that which Allah has given you, the home of the Hereafter; and [yet], do not forget your share of the world. And do good as Allah has done good to you. And desire not corruption in the land. Indeed, Allah does not like corrupters.\"",
    "He said, \"I was only given it because of knowledge I have.\" Did he not know that Allah had destroyed before him of generations those who were greater than him in power and greater in accumulation [of wealth]? But the criminals, about their sins, will not be asked.",
    "So he came out before his people in his adornment. Those who desired the worldly life said, \"Oh, would that we had like what was given to Qarun. Indeed, he is one of great fortune.\"",
    "But those who had been given knowledge said, \"Woe to you! The reward of Allah is better for he who believes and does righteousness. And none are granted it except the patient.\"",
    "And We caused the earth to swallow him and his home. And there was for him no company to aid him other than Allah, nor was he of those who [could] defend themselves.",
    "And those who had wished for his position the previous day began to say, \"Oh, how Allah extends provision to whom He wills of His servants and restricts it! If not that Allah had conferred favor on us, He would have caused it to swallow us. Oh, how the disbelievers do not succeed!\"",
    "That home of the Hereafter We assign to those who do not desire exaltedness upon the earth or corruption. And the [best] outcome is for the righteous.",
    "Whoever comes [on the Day of Judgement] with a good deed will have better than it; and whoever comes with an evil deed - then those who did evil deeds will not be recompensed except [as much as] what they used to do.",
    "Indeed, [O Muhammad], He who imposed upon you the Qur'an will take you back to a place of return. Say, \"My Lord is most knowing of who brings guidance and who is in clear error.\"",
    "And you were not expecting that the Book would be conveyed to you, but [it is] a mercy from your Lord. So do not be an assistant to the disbelievers.",
    "And never let them avert you from the verses of Allah after they have been revealed to you. And invite [people] to your Lord. And never be of those who associate others with Allah.",
    "And do not invoke with Allah another deity. There is no deity except Him. Everything will be destroyed except His Face. His is the judgement, and to Him you will be returned."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__qasas);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_qasas);
        adapter = new Al_Fatihah_Adapter(verses, arabic_verses, sahih_international, english_verses);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize (true);
        recyclerView.setAdapter (adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.play_arrow_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), "You need to download the premium version of this app: \"Learn To Read The Quran Premium\" to listen to the audio", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}
