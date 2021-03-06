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

public class Saba extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "https://www.al-hamdoulillah.com/coran/mp3/files/mohammed-siddiq-minshawi/034.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"34:1", "34:2", "34:3", "34:4", "34:5", "34:6", "34:7", "34:8", "34:9", "34:10", "34:11", "34:12", "34:13", "34:14", "34:15", "34:16",
            "34:17", "34:18", "34:19", "34:20", "34:21", "34:22", "34:23", "34:24", "34:25", "34:26", "34:27", "34:28", "34:29", "34:30", "34:31", "34:32",
            "34:33", "34:34", "34:35", "34:36", "34:37", "34:38", "34:39", "34:40", "34:41", "34:42", "34:43", "34:44", "34:45", "34:46", "34:47", "34:48",
            "34:49", "34:50", "34:51", "34:52", "34:53", "34:54"};

    String [] arabic_verses = {"الْحَمْدُ لِلَّهِ الَّذِي لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ وَلَهُ الْحَمْدُ فِي الْآخِرَةِ ۚ وَهُوَ الْحَكِيمُ الْخَبِيرُ",
    "يَعْلَمُ مَا يَلِجُ فِي الْأَرْضِ وَمَا يَخْرُجُ مِنْهَا وَمَا يَنزِلُ مِنَ السَّمَاءِ وَمَا يَعْرُجُ فِيهَا ۚ وَهُوَ الرَّحِيمُ الْغَفُورُ",
    "وَقَالَ الَّذِينَ كَفَرُوا لَا تَأْتِينَا السَّاعَةُ ۖ قُلْ بَلَىٰ وَرَبِّي لَتَأْتِيَنَّكُمْ عَالِمِ الْغَيْبِ ۖ لَا يَعْزُبُ عَنْهُ مِثْقَالُ ذَرَّةٍ فِي السَّمَاوَاتِ وَلَا فِي الْأَرْضِ وَلَا أَصْغَرُ مِن ذَٰلِكَ وَلَا أَكْبَرُ إِلَّا فِي كِتَابٍ مُّبِينٍ",
    "لِّيَجْزِيَ الَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ ۚ أُولَٰئِكَ لَهُم مَّغْفِرَةٌ وَرِزْقٌ كَرِيمٌ",
    "وَالَّذِينَ سَعَوْا فِي آيَاتِنَا مُعَاجِزِينَ أُولَٰئِكَ لَهُمْ عَذَابٌ مِّن رِّجْزٍ أَلِيمٌ",
    "وَيَرَى الَّذِينَ أُوتُوا الْعِلْمَ الَّذِي أُنزِلَ إِلَيْكَ مِن رَّبِّكَ هُوَ الْحَقَّ وَيَهْدِي إِلَىٰ صِرَاطِ الْعَزِيزِ الْحَمِيدِ",
    "وَقَالَ الَّذِينَ كَفَرُوا هَلْ نَدُلُّكُمْ عَلَىٰ رَجُلٍ يُنَبِّئُكُمْ إِذَا مُزِّقْتُمْ كُلَّ مُمَزَّقٍ إِنَّكُمْ لَفِي خَلْقٍ جَدِيدٍ",
    "أَفْتَرَىٰ عَلَى اللَّهِ كَذِبًا أَم بِهِ جِنَّةٌ ۗ بَلِ الَّذِينَ لَا يُؤْمِنُونَ بِالْآخِرَةِ فِي الْعَذَابِ وَالضَّلَالِ الْبَعِيدِ",
    "أَفَلَمْ يَرَوْا إِلَىٰ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُم مِّنَ السَّمَاءِ وَالْأَرْضِ ۚ إِن نَّشَأْ نَخْسِفْ بِهِمُ الْأَرْضَ أَوْ نُسْقِطْ عَلَيْهِمْ كِسَفًا مِّنَ السَّمَاءِ ۚ إِنَّ فِي ذَٰلِكَ لَآيَةً لِّكُلِّ عَبْدٍ مُّنِيبٍ",
    "وَلَقَدْ آتَيْنَا دَاوُودَ مِنَّا فَضْلًا ۖ يَا جِبَالُ أَوِّبِي مَعَهُ وَالطَّيْرَ ۖ وَأَلَنَّا لَهُ الْحَدِيدَ",
    "أَنِ اعْمَلْ سَابِغَاتٍ وَقَدِّرْ فِي السَّرْدِ ۖ وَاعْمَلُوا صَالِحًا ۖ إِنِّي بِمَا تَعْمَلُونَ بَصِيرٌ",
    "وَلِسُلَيْمَانَ الرِّيحَ غُدُوُّهَا شَهْرٌ وَرَوَاحُهَا شَهْرٌ ۖ وَأَسَلْنَا لَهُ عَيْنَ الْقِطْرِ ۖ وَمِنَ الْجِنِّ مَن يَعْمَلُ بَيْنَ يَدَيْهِ بِإِذْنِ رَبِّهِ ۖ وَمَن يَزِغْ مِنْهُمْ عَنْ أَمْرِنَا نُذِقْهُ مِنْ عَذَابِ السَّعِيرِ",
    "يَعْمَلُونَ لَهُ مَا يَشَاءُ مِن مَّحَارِيبَ وَتَمَاثِيلَ وَجِفَانٍ كَالْجَوَابِ وَقُدُورٍ رَّاسِيَاتٍ ۚ اعْمَلُوا آلَ دَاوُودَ شُكْرًا ۚ وَقَلِيلٌ مِّنْ عِبَادِيَ الشَّكُورُ",
    "فَلَمَّا قَضَيْنَا عَلَيْهِ الْمَوْتَ مَا دَلَّهُمْ عَلَىٰ مَوْتِهِ إِلَّا دَابَّةُ الْأَرْضِ تَأْكُلُ مِنسَأَتَهُ ۖ فَلَمَّا خَرَّ تَبَيَّنَتِ الْجِنُّ أَن لَّوْ كَانُوا يَعْلَمُونَ الْغَيْبَ مَا لَبِثُوا فِي الْعَذَابِ الْمُهِينِ",
    "لَقَدْ كَانَ لِسَبَإٍ فِي مَسْكَنِهِمْ آيَةٌ ۖ جَنَّتَانِ عَن يَمِينٍ وَشِمَالٍ ۖ كُلُوا مِن رِّزْقِ رَبِّكُمْ وَاشْكُرُوا لَهُ ۚ بَلْدَةٌ طَيِّبَةٌ وَرَبٌّ غَفُورٌ",
    "فَأَعْرَضُوا فَأَرْسَلْنَا عَلَيْهِمْ سَيْلَ الْعَرِمِ وَبَدَّلْنَاهُم بِجَنَّتَيْهِمْ جَنَّتَيْنِ ذَوَاتَيْ أُكُلٍ خَمْطٍ وَأَثْلٍ وَشَيْءٍ مِّن سِدْرٍ قَلِيلٍ",
    "ذَٰلِكَ جَزَيْنَاهُم بِمَا كَفَرُوا ۖ وَهَلْ نُجَازِي إِلَّا الْكَفُورَ",
    "وَجَعَلْنَا بَيْنَهُمْ وَبَيْنَ الْقُرَى الَّتِي بَارَكْنَا فِيهَا قُرًى ظَاهِرَةً وَقَدَّرْنَا فِيهَا السَّيْرَ ۖ سِيرُوا فِيهَا لَيَالِيَ وَأَيَّامًا آمِنِينَ",
    "فَقَالُوا رَبَّنَا بَاعِدْ بَيْنَ أَسْفَارِنَا وَظَلَمُوا أَنفُسَهُمْ فَجَعَلْنَاهُمْ أَحَادِيثَ وَمَزَّقْنَاهُمْ كُلَّ مُمَزَّقٍ ۚ إِنَّ فِي ذَٰلِكَ لَآيَاتٍ لِّكُلِّ صَبَّارٍ شَكُورٍ",
    "وَلَقَدْ صَدَّقَ عَلَيْهِمْ إِبْلِيسُ ظَنَّهُ فَاتَّبَعُوهُ إِلَّا فَرِيقًا مِّنَ الْمُؤْمِنِينَ",
    "وَمَا كَانَ لَهُ عَلَيْهِم مِّن سُلْطَانٍ إِلَّا لِنَعْلَمَ مَن يُؤْمِنُ بِالْآخِرَةِ مِمَّنْ هُوَ مِنْهَا فِي شَكٍّ ۗ وَرَبُّكَ عَلَىٰ كُلِّ شَيْءٍ حَفِيظٌ",
    "قُلِ ادْعُوا الَّذِينَ زَعَمْتُم مِّن دُونِ اللَّهِ ۖ لَا يَمْلِكُونَ مِثْقَالَ ذَرَّةٍ فِي السَّمَاوَاتِ وَلَا فِي الْأَرْضِ وَمَا لَهُمْ فِيهِمَا مِن شِرْكٍ وَمَا لَهُ مِنْهُم مِّن ظَهِيرٍ",
    "وَلَا تَنفَعُ الشَّفَاعَةُ عِندَهُ إِلَّا لِمَنْ أَذِنَ لَهُ ۚ حَتَّىٰ إِذَا فُزِّعَ عَن قُلُوبِهِمْ قَالُوا مَاذَا قَالَ رَبُّكُمْ ۖ قَالُوا الْحَقَّ ۖ وَهُوَ الْعَلِيُّ الْكَبِيرُ",
    "قُلْ مَن يَرْزُقُكُم مِّنَ السَّمَاوَاتِ وَالْأَرْضِ ۖ قُلِ اللَّهُ ۖ وَإِنَّا أَوْ إِيَّاكُمْ لَعَلَىٰ هُدًى أَوْ فِي ضَلَالٍ مُّبِينٍ",
    "قُل لَّا تُسْأَلُونَ عَمَّا أَجْرَمْنَا وَلَا نُسْأَلُ عَمَّا تَعْمَلُونَ",
    "قُلْ يَجْمَعُ بَيْنَنَا رَبُّنَا ثُمَّ يَفْتَحُ بَيْنَنَا بِالْحَقِّ وَهُوَ الْفَتَّاحُ الْعَلِيمُ",
    "قُلْ أَرُونِيَ الَّذِينَ أَلْحَقْتُم بِهِ شُرَكَاءَ ۖ كَلَّا ۚ بَلْ هُوَ اللَّهُ الْعَزِيزُ الْحَكِيمُ",
    "وَمَا أَرْسَلْنَاكَ إِلَّا كَافَّةً لِّلنَّاسِ بَشِيرًا وَنَذِيرًا وَلَٰكِنَّ أَكْثَرَ النَّاسِ لَا يَعْلَمُونَ",
    "وَيَقُولُونَ مَتَىٰ هَٰذَا الْوَعْدُ إِن كُنتُمْ صَادِقِينَ",
    "قُل لَّكُم مِّيعَادُ يَوْمٍ لَّا تَسْتَأْخِرُونَ عَنْهُ سَاعَةً وَلَا تَسْتَقْدِمُونَ",
    "وَقَالَ الَّذِينَ كَفَرُوا لَن نُّؤْمِنَ بِهَٰذَا الْقُرْآنِ وَلَا بِالَّذِي بَيْنَ يَدَيْهِ ۗ وَلَوْ تَرَىٰ إِذِ الظَّالِمُونَ مَوْقُوفُونَ عِندَ رَبِّهِمْ يَرْجِعُ بَعْضُهُمْ إِلَىٰ بَعْضٍ الْقَوْلَ يَقُولُ الَّذِينَ اسْتُضْعِفُوا لِلَّذِينَ اسْتَكْبَرُوا لَوْلَا أَنتُمْ لَكُنَّا مُؤْمِنِينَ",
    "قَالَ الَّذِينَ اسْتَكْبَرُوا لِلَّذِينَ اسْتُضْعِفُوا أَنَحْنُ صَدَدْنَاكُمْ عَنِ الْهُدَىٰ بَعْدَ إِذْ جَاءَكُم ۖ بَلْ كُنتُم مُّجْرِمِينَ",
    "وَقَالَ الَّذِينَ اسْتُضْعِفُوا لِلَّذِينَ اسْتَكْبَرُوا بَلْ مَكْرُ اللَّيْلِ وَالنَّهَارِ إِذْ تَأْمُرُونَنَا أَن نَّكْفُرَ بِاللَّهِ وَنَجْعَلَ لَهُ أَندَادًا ۚ وَأَسَرُّوا النَّدَامَةَ لَمَّا رَأَوُا الْعَذَابَ وَجَعَلْنَا الْأَغْلَالَ فِي أَعْنَاقِ الَّذِينَ كَفَرُوا ۚ هَلْ يُجْزَوْنَ إِلَّا مَا كَانُوا يَعْمَلُونَ",
    "وَمَا أَرْسَلْنَا فِي قَرْيَةٍ مِّن نَّذِيرٍ إِلَّا قَالَ مُتْرَفُوهَا إِنَّا بِمَا أُرْسِلْتُم بِهِ كَافِرُونَ",
    "وَقَالُوا نَحْنُ أَكْثَرُ أَمْوَالًا وَأَوْلَادًا وَمَا نَحْنُ بِمُعَذَّبِينَ",
    "قُلْ إِنَّ رَبِّي يَبْسُطُ الرِّزْقَ لِمَن يَشَاءُ وَيَقْدِرُ وَلَٰكِنَّ أَكْثَرَ النَّاسِ لَا يَعْلَمُونَ",
    "وَمَا أَمْوَالُكُمْ وَلَا أَوْلَادُكُم بِالَّتِي تُقَرِّبُكُمْ عِندَنَا زُلْفَىٰ إِلَّا مَنْ آمَنَ وَعَمِلَ صَالِحًا فَأُولَٰئِكَ لَهُمْ جَزَاءُ الضِّعْفِ بِمَا عَمِلُوا وَهُمْ فِي الْغُرُفَاتِ آمِنُونَ",
    "وَالَّذِينَ يَسْعَوْنَ فِي آيَاتِنَا مُعَاجِزِينَ أُولَٰئِكَ فِي الْعَذَابِ مُحْضَرُونَ",
    "قُلْ إِنَّ رَبِّي يَبْسُطُ الرِّزْقَ لِمَن يَشَاءُ مِنْ عِبَادِهِ وَيَقْدِرُ لَهُ ۚ وَمَا أَنفَقْتُم مِّن شَيْءٍ فَهُوَ يُخْلِفُهُ ۖ وَهُوَ خَيْرُ الرَّازِقِينَ",
    "وَيَوْمَ يَحْشُرُهُمْ جَمِيعًا ثُمَّ يَقُولُ لِلْمَلَائِكَةِ أَهَٰؤُلَاءِ إِيَّاكُمْ كَانُوا يَعْبُدُونَ",
    "قَالُوا سُبْحَانَكَ أَنتَ وَلِيُّنَا مِن دُونِهِم ۖ بَلْ كَانُوا يَعْبُدُونَ الْجِنَّ ۖ أَكْثَرُهُم بِهِم مُّؤْمِنُونَ",
    "فَالْيَوْمَ لَا يَمْلِكُ بَعْضُكُمْ لِبَعْضٍ نَّفْعًا وَلَا ضَرًّا وَنَقُولُ لِلَّذِينَ ظَلَمُوا ذُوقُوا عَذَابَ النَّارِ الَّتِي كُنتُم بِهَا تُكَذِّبُونَ",
    "وَإِذَا تُتْلَىٰ عَلَيْهِمْ آيَاتُنَا بَيِّنَاتٍ قَالُوا مَا هَٰذَا إِلَّا رَجُلٌ يُرِيدُ أَن يَصُدَّكُمْ عَمَّا كَانَ يَعْبُدُ آبَاؤُكُمْ وَقَالُوا مَا هَٰذَا إِلَّا إِفْكٌ مُّفْتَرًى ۚ وَقَالَ الَّذِينَ كَفَرُوا لِلْحَقِّ لَمَّا جَاءَهُمْ إِنْ هَٰذَا إِلَّا سِحْرٌ مُّبِينٌ",
    "وَمَا آتَيْنَاهُم مِّن كُتُبٍ يَدْرُسُونَهَا ۖ وَمَا أَرْسَلْنَا إِلَيْهِمْ قَبْلَكَ مِن نَّذِيرٍ",
    "وَكَذَّبَ الَّذِينَ مِن قَبْلِهِمْ وَمَا بَلَغُوا مِعْشَارَ مَا آتَيْنَاهُمْ فَكَذَّبُوا رُسُلِي ۖ فَكَيْفَ كَانَ نَكِيرِ",
    "قُلْ إِنَّمَا أَعِظُكُم بِوَاحِدَةٍ ۖ أَن تَقُومُوا لِلَّهِ مَثْنَىٰ وَفُرَادَىٰ ثُمَّ تَتَفَكَّرُوا ۚ مَا بِصَاحِبِكُم مِّن جِنَّةٍ ۚ إِنْ هُوَ إِلَّا نَذِيرٌ لَّكُم بَيْنَ يَدَيْ عَذَابٍ شَدِيدٍ",
    "قُلْ مَا سَأَلْتُكُم مِّنْ أَجْرٍ فَهُوَ لَكُمْ ۖ إِنْ أَجْرِيَ إِلَّا عَلَى اللَّهِ ۖ وَهُوَ عَلَىٰ كُلِّ شَيْءٍ شَهِيدٌ",
    "قُلْ إِنَّ رَبِّي يَقْذِفُ بِالْحَقِّ عَلَّامُ الْغُيُوبِ",
    "قُلْ جَاءَ الْحَقُّ وَمَا يُبْدِئُ الْبَاطِلُ وَمَا يُعِيدُ",
    "قُلْ إِن ضَلَلْتُ فَإِنَّمَا أَضِلُّ عَلَىٰ نَفْسِي ۖ وَإِنِ اهْتَدَيْتُ فَبِمَا يُوحِي إِلَيَّ رَبِّي ۚ إِنَّهُ سَمِيعٌ قَرِيبٌ",
    "وَلَوْ تَرَىٰ إِذْ فَزِعُوا فَلَا فَوْتَ وَأُخِذُوا مِن مَّكَانٍ قَرِيبٍ",
    "وَقَالُوا آمَنَّا بِهِ وَأَنَّىٰ لَهُمُ التَّنَاوُشُ مِن مَّكَانٍ بَعِيدٍ",
    "وَقَدْ كَفَرُوا بِهِ مِن قَبْلُ ۖ وَيَقْذِفُونَ بِالْغَيْبِ مِن مَّكَانٍ بَعِيدٍ",
    "وَحِيلَ بَيْنَهُمْ وَبَيْنَ مَا يَشْتَهُونَ كَمَا فُعِلَ بِأَشْيَاعِهِم مِّن قَبْلُ ۚ إِنَّهُمْ كَانُوا فِي شَكٍّ مُّرِيبٍ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"[All] praise is [due] to Allah, to whom belongs whatever is in the heavens and whatever is in the earth, and to Him belongs [all] praise in the Hereafter. And He is the Wise, the Acquainted.",
    "He knows what penetrates into the earth and what emerges from it and what descends from the heaven and what ascends therein. And He is the Merciful, the Forgiving.",
    "But those who disbelieve say, \"The Hour will not come to us.\" Say, \"Yes, by my Lord, it will surely come to you. [Allah is] the Knower of the unseen.\" Not absent from Him is an atom's weight within the heavens or within the earth or [what is] smaller than that or greater, except that it is in a clear register -",
    "That He may reward those who believe and do righteous deeds. Those will have forgiveness and noble provision.",
    "But those who strive against Our verses [seeking] to cause failure - for them will be a painful punishment of foul nature.",
    "And those who have been given knowledge see that what is revealed to you from your Lord is the truth, and it guides to the path of the Exalted in Might, the Praiseworthy.",
    "But those who disbelieve say, \"Shall we direct you to a man who will inform you [that] when you have disintegrated in complete disintegration, you will [then] be [recreated] in a new creation?",
    "Has he invented about Allah a lie or is there in him madness?\" Rather, they who do not believe in the Hereafter will be in the punishment and [are in] extreme error.",
    "Then, do they not look at what is before them and what is behind them of the heaven and earth? If We should will, We could cause the earth to swallow them or [could] let fall upon them fragments from the sky. Indeed in that is a sign for every servant turning back [to Allah].",
    "And We certainly gave David from Us bounty. [We said], \"O mountains, repeat [Our] praises with him, and the birds [as well].\" And We made pliable for him iron,",
    "[Commanding him], \"Make full coats of mail and calculate [precisely] the links, and work [all of you] righteousness. Indeed I, of what you do, am Seeing.\"",
    "And to Solomon [We subjected] the wind - its morning [journey was that of] a month - and its afternoon [journey was that of] a month, and We made flow for him a spring of [liquid] copper. And among the jinn were those who worked for him by the permission of his Lord. And whoever deviated among them from Our command - We will make him taste of the punishment of the Blaze.",
    "They made for him what he willed of elevated chambers, statues, bowls like reservoirs, and stationary kettles. [We said], \"Work, O family of David, in gratitude.\" And few of My servants are grateful.",
    "And when We decreed for Solomon death, nothing indicated to the jinn his death except a creature of the earth eating his staff. But when he fell, it became clear to the jinn that if they had known the unseen, they would not have remained in humiliating punishment.",
    "There was for [the tribe of] Saba' in their dwelling place a sign: two [fields of] gardens on the right and on the left. [They were told], \"Eat from the provisions of your Lord and be grateful to Him. A good land [have you], and a forgiving Lord.\"",
    "But they turned away [refusing], so We sent upon them the flood of the dam, and We replaced their two [fields of] gardens with gardens of bitter fruit, tamarisks and something of sparse lote trees.",
    "[By] that We repaid them because they disbelieved. And do We [thus] repay except the ungrateful?",
    "And We placed between them and the cities which We had blessed [many] visible cities. And We determined between them the [distances of] journey, [saying], \"Travel between them by night or day in safety.\"",
    "But [insolently] they said, \"Our Lord, lengthen the distance between our journeys,\" and wronged themselves, so We made them narrations and dispersed them in total dispersion. Indeed in that are signs for everyone patient and grateful.",
    "And Iblees had already confirmed through them his assumption, so they followed him, except for a party of believers.",
    "And he had over them no authority except [it was decreed] that We might make evident who believes in the Hereafter from who is thereof in doubt. And your Lord, over all things, is Guardian.",
    "Say, [O Muhammad], \"Invoke those you claim [as deities] besides Allah.\" They do not possess an atom's weight [of ability] in the heavens or on the earth, and they do not have therein any partnership [with Him], nor is there for Him from among them any assistant.",
    "And intercession does not benefit with Him except for one whom He permits. [And those wait] until, when terror is removed from their hearts, they will say [to one another], \"What has your Lord said?\" They will say, \"The truth.\" And He is the Most High, the Grand.",
    "Say, \"Who provides for you from the heavens and the earth?\" Say, \"Allah. And indeed, we or you are either upon guidance or in clear error.\"",
    "Say, \"You will not be asked about what we committed, and we will not be asked about what you do.\"",
    "Say, \"Our Lord will bring us together; then He will judge between us in truth. And He is the Knowing Judge.\"",
    "Say, \"Show me those whom you have attached to Him as partners. No! Rather, He [alone] is Allah, the Exalted in Might, the Wise.\"",
    "And We have not sent you except comprehensively to mankind as a bringer of good tidings and a warner. But most of the people do not know.",
    "And they say, \"When is this promise, if you should be truthful?\"",
    "Say, \"For you is the appointment of a Day [when] you will not remain thereafter an hour, nor will you precede [it].\"",
    "And those who disbelieve say, \"We will never believe in this Qur'an nor in that before it.\" But if you could see when the wrongdoers are made to stand before their Lord, refuting each other's words... Those who were oppressed will say to those who were arrogant, \"If not for you, we would have been believers.\"",
    "Those who were arrogant will say to those who were oppressed, \"Did we avert you from guidance after it had come to you? Rather, you were criminals.\"",
    "Those who were oppressed will say to those who were arrogant, \"Rather, [it was your] conspiracy of night and day when you were ordering us to disbelieve in Allah and attribute to Him equals.\" But they will [all] confide regret when they see the punishment; and We will put shackles on the necks of those who disbelieved. Will they be recompensed except for what they used to do?",
    "And We did not send into a city any warner except that its affluent said, \"Indeed we, in that with which you were sent, are disbelievers.\"",
    "And they said, \"We are more [than the believers] in wealth and children, and we are not to be punished.\"",
    "Say, \"Indeed, my Lord extends provision for whom He wills and restricts [it], but most of the people do not know.\"",
    "And it is not your wealth or your children that bring you nearer to Us in position, but it is [by being] one who has believed and done righteousness. For them there will be the double reward for what they did, and they will be in the upper chambers [of Paradise], safe [and secure].",
    "And the ones who strive against Our verses to cause [them] failure - those will be brought into the punishment [to remain].",
    "Say, \"Indeed, my Lord extends provision for whom He wills of His servants and restricts [it] for him. But whatever thing you spend [in His cause] - He will compensate it; and He is the best of providers.\"",
    "And [mention] the Day when He will gather them all and then say to the angels, \"Did these [people] used to worship you?\"",
    "They will say, \"Exalted are You! You, [O Allah], are our benefactor not them. Rather, they used to worship the jinn; most of them were believers in them.\"",
    "But today you do not hold for one another [the power of] benefit or harm, and We will say to those who wronged, \"Taste the punishment of the Fire, which you used to deny.\"",
    "And when our verses are recited to them as clear evidences, they say, \"This is not but a man who wishes to avert you from that which your fathers were worshipping.\" And they say, \"This is not except a lie invented.\" And those who disbelieve say of the truth when it has come to them, \"This is not but obvious magic.\"",
    "And We had not given them any scriptures which they could study, and We had not sent to them before you, [O Muhammad], any warner.",
    "And those before them denied, and the people of Makkah have not attained a tenth of what We had given them. But the former peoples denied My messengers, so how [terrible] was My reproach.",
    "Say, \"I only advise you of one [thing] - that you stand for Allah, [seeking truth] in pairs and individually, and then give thought.\" There is not in your companion any madness. He is only a warner to you before a severe punishment.",
    "Say, \"Whatever payment I might have asked of you - it is yours. My payment is only from Allah, and He is, over all things, Witness.\"",
    "Say, \"Indeed, my Lord projects the truth. Knower of the unseen.\"",
    "Say, \"The truth has come, and falsehood can neither begin [anything] nor repeat [it].\"",
    "Say, \"If I should err, I would only err against myself. But if I am guided, it is by what my Lord reveals to me. Indeed, He is Hearing and near.\"",
    "And if you could see when they are terrified but there is no escape, and they will be seized from a place nearby.",
    "And they will [then] say, \"We believe in it!\" But how for them will be the taking [of faith] from a place far away?",
    "And they had already disbelieved in it before and would assault the unseen from a place far away.",
    "And prevention will be placed between them and what they desire, as was done with their kind before. Indeed, they were in disquieting denial."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saba);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_saba);
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
