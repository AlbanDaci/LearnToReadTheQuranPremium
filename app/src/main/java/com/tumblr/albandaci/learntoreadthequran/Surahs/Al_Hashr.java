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

public class Al_Hashr extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] verses = {"59:1", "59:2", "59:3", "59:4", "59:5", "59:6", "59:7", "59:8", "59:9", "59:10", "59:11", "59:12", "59:13", "59:14", "59:15", "59:16",
            "59:17", "59:18", "59:19", "59:20", "59:21", "59:22", "59:23", "59:24"};

    String [] arabic_verses = {"سَبَّحَ لِلَّهِ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ ۖ وَهُوَ الْعَزِيزُ الْحَكِيمُ",
    "هُوَ الَّذِي أَخْرَجَ الَّذِينَ كَفَرُوا مِنْ أَهْلِ الْكِتَابِ مِن دِيَارِهِمْ لِأَوَّلِ الْحَشْرِ ۚ مَا ظَنَنتُمْ أَن يَخْرُجُوا ۖ وَظَنُّوا أَنَّهُم مَّانِعَتُهُمْ حُصُونُهُم مِّنَ اللَّهِ فَأَتَاهُمُ اللَّهُ مِنْ حَيْثُ لَمْ يَحْتَسِبُوا ۖ وَقَذَفَ فِي قُلُوبِهِمُ الرُّعْبَ ۚ يُخْرِبُونَ بُيُوتَهُم بِأَيْدِيهِمْ وَأَيْدِي الْمُؤْمِنِينَ فَاعْتَبِرُوا يَا أُولِي الْأَبْصَارِ",
    "وَلَوْلَا أَن كَتَبَ اللَّهُ عَلَيْهِمُ الْجَلَاءَ لَعَذَّبَهُمْ فِي الدُّنْيَا ۖ وَلَهُمْ فِي الْآخِرَةِ عَذَابُ النَّارِ",
    "ذَٰلِكَ بِأَنَّهُمْ شَاقُّوا اللَّهَ وَرَسُولَهُ ۖ وَمَن يُشَاقِّ اللَّهَ فَإِنَّ اللَّهَ شَدِيدُ الْعِقَابِ",
    "مَا قَطَعْتُم مِّن لِّينَةٍ أَوْ تَرَكْتُمُوهَا قَائِمَةً عَلَىٰ أُصُولِهَا فَبِإِذْنِ اللَّهِ وَلِيُخْزِيَ الْفَاسِقِينَ",
    "وَمَا أَفَاءَ اللَّهُ عَلَىٰ رَسُولِهِ مِنْهُمْ فَمَا أَوْجَفْتُمْ عَلَيْهِ مِنْ خَيْلٍ وَلَا رِكَابٍ وَلَٰكِنَّ اللَّهَ يُسَلِّطُ رُسُلَهُ عَلَىٰ مَن يَشَاءُ ۚ وَاللَّهُ عَلَىٰ كُلِّ شَيْءٍ قَدِيرٌ",
    "مَّا أَفَاءَ اللَّهُ عَلَىٰ رَسُولِهِ مِنْ أَهْلِ الْقُرَىٰ فَلِلَّهِ وَلِلرَّسُولِ وَلِذِي الْقُرْبَىٰ وَالْيَتَامَىٰ وَالْمَسَاكِينِ وَابْنِ السَّبِيلِ كَيْ لَا يَكُونَ دُولَةً بَيْنَ الْأَغْنِيَاءِ مِنكُمْ ۚ وَمَا آتَاكُمُ الرَّسُولُ فَخُذُوهُ وَمَا نَهَاكُمْ عَنْهُ فَانتَهُوا ۚ وَاتَّقُوا اللَّهَ ۖ إِنَّ اللَّهَ شَدِيدُ الْعِقَابِ",
    "لِلْفُقَرَاءِ الْمُهَاجِرِينَ الَّذِينَ أُخْرِجُوا مِن دِيَارِهِمْ وَأَمْوَالِهِمْ يَبْتَغُونَ فَضْلًا مِّنَ اللَّهِ وَرِضْوَانًا وَيَنصُرُونَ اللَّهَ وَرَسُولَهُ ۚ أُولَٰئِكَ هُمُ الصَّادِقُونَ",
    "وَالَّذِينَ تَبَوَّءُوا الدَّارَ وَالْإِيمَانَ مِن قَبْلِهِمْ يُحِبُّونَ مَنْ هَاجَرَ إِلَيْهِمْ وَلَا يَجِدُونَ فِي صُدُورِهِمْ حَاجَةً مِّمَّا أُوتُوا وَيُؤْثِرُونَ عَلَىٰ أَنفُسِهِمْ وَلَوْ كَانَ بِهِمْ خَصَاصَةٌ ۚ وَمَن يُوقَ شُحَّ نَفْسِهِ فَأُولَٰئِكَ هُمُ الْمُفْلِحُونَ",
    "وَالَّذِينَ جَاءُوا مِن بَعْدِهِمْ يَقُولُونَ رَبَّنَا اغْفِرْ لَنَا وَلِإِخْوَانِنَا الَّذِينَ سَبَقُونَا بِالْإِيمَانِ وَلَا تَجْعَلْ فِي قُلُوبِنَا غِلًّا لِّلَّذِينَ آمَنُوا رَبَّنَا إِنَّكَ رَءُوفٌ رَّحِيمٌ",
    "أَلَمْ تَرَ إِلَى الَّذِينَ نَافَقُوا يَقُولُونَ لِإِخْوَانِهِمُ الَّذِينَ كَفَرُوا مِنْ أَهْلِ الْكِتَابِ لَئِنْ أُخْرِجْتُمْ لَنَخْرُجَنَّ مَعَكُمْ وَلَا نُطِيعُ فِيكُمْ أَحَدًا أَبَدًا وَإِن قُوتِلْتُمْ لَنَنصُرَنَّكُمْ وَاللَّهُ يَشْهَدُ إِنَّهُمْ لَكَاذِبُونَ",
    "لَئِنْ أُخْرِجُوا لَا يَخْرُجُونَ مَعَهُمْ وَلَئِن قُوتِلُوا لَا يَنصُرُونَهُمْ وَلَئِن نَّصَرُوهُمْ لَيُوَلُّنَّ الْأَدْبَارَ ثُمَّ لَا يُنصَرُونَ",
    "لَأَنتُمْ أَشَدُّ رَهْبَةً فِي صُدُورِهِم مِّنَ اللَّهِ ۚ ذَٰلِكَ بِأَنَّهُمْ قَوْمٌ لَّا يَفْقَهُونَ",
    "لَا يُقَاتِلُونَكُمْ جَمِيعًا إِلَّا فِي قُرًى مُّحَصَّنَةٍ أَوْ مِن وَرَاءِ جُدُرٍ ۚ بَأْسُهُم بَيْنَهُمْ شَدِيدٌ ۚ تَحْسَبُهُمْ جَمِيعًا وَقُلُوبُهُمْ شَتَّىٰ ۚ ذَٰلِكَ بِأَنَّهُمْ قَوْمٌ لَّا يَعْقِلُونَ",
    "كَمَثَلِ الَّذِينَ مِن قَبْلِهِمْ قَرِيبًا ۖ ذَاقُوا وَبَالَ أَمْرِهِمْ وَلَهُمْ عَذَابٌ أَلِيمٌ",
    "كَمَثَلِ الشَّيْطَانِ إِذْ قَالَ لِلْإِنسَانِ اكْفُرْ فَلَمَّا كَفَرَ قَالَ إِنِّي بَرِيءٌ مِّنكَ إِنِّي أَخَافُ اللَّهَ رَبَّ الْعَالَمِينَ",
    "فَكَانَ عَاقِبَتَهُمَا أَنَّهُمَا فِي النَّارِ خَالِدَيْنِ فِيهَا ۚ وَذَٰلِكَ جَزَاءُ الظَّالِمِينَ",
    "يَا أَيُّهَا الَّذِينَ آمَنُوا اتَّقُوا اللَّهَ وَلْتَنظُرْ نَفْسٌ مَّا قَدَّمَتْ لِغَدٍ ۖ وَاتَّقُوا اللَّهَ ۚ إِنَّ اللَّهَ خَبِيرٌ بِمَا تَعْمَلُونَ",
    "وَلَا تَكُونُوا كَالَّذِينَ نَسُوا اللَّهَ فَأَنسَاهُمْ أَنفُسَهُمْ ۚ أُولَٰئِكَ هُمُ الْفَاسِقُونَ",
    "لَا يَسْتَوِي أَصْحَابُ النَّارِ وَأَصْحَابُ الْجَنَّةِ ۚ أَصْحَابُ الْجَنَّةِ هُمُ الْفَائِزُونَ",
    "لَوْ أَنزَلْنَا هَٰذَا الْقُرْآنَ عَلَىٰ جَبَلٍ لَّرَأَيْتَهُ خَاشِعًا مُّتَصَدِّعًا مِّنْ خَشْيَةِ اللَّهِ ۚ وَتِلْكَ الْأَمْثَالُ نَضْرِبُهَا لِلنَّاسِ لَعَلَّهُمْ يَتَفَكَّرُونَ",
    "هُوَ اللَّهُ الَّذِي لَا إِلَٰهَ إِلَّا هُوَ ۖ عَالِمُ الْغَيْبِ وَالشَّهَادَةِ ۖ هُوَ الرَّحْمَٰنُ الرَّحِيمُ",
    "هُوَ اللَّهُ الَّذِي لَا إِلَٰهَ إِلَّا هُوَ الْمَلِكُ الْقُدُّوسُ السَّلَامُ الْمُؤْمِنُ الْمُهَيْمِنُ الْعَزِيزُ الْجَبَّارُ الْمُتَكَبِّرُ ۚ سُبْحَانَ اللَّهِ عَمَّا يُشْرِكُونَ",
    "هُوَ اللَّهُ الْخَالِقُ الْبَارِئُ الْمُصَوِّرُ ۖ لَهُ الْأَسْمَاءُ الْحُسْنَىٰ ۚ يُسَبِّحُ لَهُ مَا فِي السَّمَاوَاتِ وَالْأَرْضِ ۖ وَهُوَ الْعَزِيزُ الْحَكِيمُ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International"};

    String [] english_verses = {"Whatever is in the heavens and whatever is on the earth exalts Allah, and He is the Exalted in Might, the Wise.",
    "It is He who expelled the ones who disbelieved among the People of the Scripture from their homes at the first gathering. You did not think they would leave, and they thought that their fortresses would protect them from Allah; but [the decree of] Allah came upon them from where they had not expected, and He cast terror into their hearts [so] they destroyed their houses by their [own] hands and the hands of the believers. So take warning, O people of vision.",
    "And if not that Allah had decreed for them evacuation, He would have punished them in [this] world, and for them in the Hereafter is the punishment of the Fire.",
    "That is because they opposed Allah and His Messenger. And whoever opposes Allah - then indeed, Allah is severe in penalty.",
    "Whatever you have cut down of [their] palm trees or left standing on their trunks - it was by permission of Allah and so He would disgrace the defiantly disobedient.",
    "And what Allah restored [of property] to His Messenger from them - you did not spur for it [in an expedition] any horses or camels, but Allah gives His messengers power over whom He wills, and Allah is over all things competent.",
    "And what Allah restored to His Messenger from the people of the towns - it is for Allah and for the Messenger and for [his] near relatives and orphans and the [stranded] traveler - so that it will not be a perpetual distribution among the rich from among you. And whatever the Messenger has given you - take; and what he has forbidden you - refrain from. And fear Allah; indeed, Allah is severe in penalty.",
    "For the poor emigrants who were expelled from their homes and their properties, seeking bounty from Allah and [His] approval and supporting Allah and His Messenger, [there is also a share]. Those are the truthful.",
    "And [also for] those who were settled in al-Madinah and [adopted] the faith before them. They love those who emigrated to them and find not any want in their breasts of what the emigrants were given but give [them] preference over themselves, even though they are in privation. And whoever is protected from the stinginess of his soul - it is those who will be the successful.",
    "And [there is a share for] those who came after them, saying, \"Our Lord, forgive us and our brothers who preceded us in faith and put not in our hearts [any] resentment toward those who have believed. Our Lord, indeed You are Kind and Merciful.\"",
    "Have you not considered those who practice hypocrisy, saying to their brothers who have disbelieved among the People of the Scripture, \"If you are expelled, we will surely leave with you, and we will not obey, in regard to you, anyone - ever; and if you are fought, we will surely aid you.\" But Allah testifies that they are liars.",
    "If they are expelled, they will not leave with them, and if they are fought, they will not aid them. And [even] if they should aid them, they will surely turn their backs; then [thereafter] they will not be aided.",
    "You [believers] are more fearful within their breasts than Allah. That is because they are a people who do not understand.",
    "They will not fight you all except within fortified cities or from behind walls. Their violence among themselves is severe. You think they are together, but their hearts are diverse. That is because they are a people who do not reason.",
    "[Theirs is] like the example of those shortly before them: they tasted the bad consequence of their affair, and they will have a painful punishment.",
    "[The hypocrites are] like the example of Satan when he says to man, \"Disbelieve.\" But when he disbelieves, he says, \"Indeed, I am disassociated from you. Indeed, I fear Allah, Lord of the worlds.\"",
    "So the outcome for both of them is that they will be in the Fire, abiding eternally therein. And that is the recompense of the wrong-doers.",
    "O you who have believed, fear Allah. And let every soul look to what it has put forth for tomorrow - and fear Allah. Indeed, Allah is Acquainted with what you do.",
    "And be not like those who forgot Allah, so He made them forget themselves. Those are the defiantly disobedient.",
    "Not equal are the companions of the Fire and the companions of Paradise. The companions of Paradise - they are the attainers [of success].",
    "If We had sent down this Qur'an upon a mountain, you would have seen it humbled and coming apart from fear of Allah. And these examples We present to the people that perhaps they will give thought.",
    "He is Allah, other than whom there is no deity, Knower of the unseen and the witnessed. He is the Entirely Merciful, the Especially Merciful.",
    "He is Allah, other than whom there is no deity, the Sovereign, the Pure, the Perfection, the Bestower of Faith, the Overseer, the Exalted in Might, the Compeller, the Superior. Exalted is Allah above whatever they associate with Him.",
    "He is Allah, the Creator, the Inventor, the Fashioner; to Him belong the best names. Whatever is in the heavens and earth is exalting Him. And He is the Exalted in Might, the Wise."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__hashr);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_hashr);
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
