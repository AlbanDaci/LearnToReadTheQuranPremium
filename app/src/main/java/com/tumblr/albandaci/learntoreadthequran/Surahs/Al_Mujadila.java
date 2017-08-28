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

public class Al_Mujadila extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String URL1 = "http://download.audioislam.com/audio/quran/recitation/al-afaasee/surah_al_mujadilah.mp3";
    private MediaPlayer mediaPlayer;

    String [] verses = {"58:1", "58:2", "58:3", "58:4", "58:5", "58:6", "58:7", "58:8", "58:9", "58:10", "58:11", "58:12", "58:13", "58:14", "58:15", "58:16",
            "58:17", "58:18", "58:19", "58:20", "58:21", "58:22"};

    String [] arabic_verses = {"قَدْ سَمِعَ اللَّهُ قَوْلَ الَّتِي تُجَادِلُكَ فِي زَوْجِهَا وَتَشْتَكِي إِلَى اللَّهِ وَاللَّهُ يَسْمَعُ تَحَاوُرَكُمَا ۚ إِنَّ اللَّهَ سَمِيعٌ بَصِيرٌ",
    "الَّذِينَ يُظَاهِرُونَ مِنكُم مِّن نِّسَائِهِم مَّا هُنَّ أُمَّهَاتِهِمْ ۖ إِنْ أُمَّهَاتُهُمْ إِلَّا اللَّائِي وَلَدْنَهُمْ ۚ وَإِنَّهُمْ لَيَقُولُونَ مُنكَرًا مِّنَ الْقَوْلِ وَزُورًا ۚ وَإِنَّ اللَّهَ لَعَفُوٌّ غَفُورٌ",
    "وَالَّذِينَ يُظَاهِرُونَ مِن نِّسَائِهِمْ ثُمَّ يَعُودُونَ لِمَا قَالُوا فَتَحْرِيرُ رَقَبَةٍ مِّن قَبْلِ أَن يَتَمَاسَّا ۚ ذَٰلِكُمْ تُوعَظُونَ بِهِ ۚ وَاللَّهُ بِمَا تَعْمَلُونَ خَبِيرٌ",
    "فَمَن لَّمْ يَجِدْ فَصِيَامُ شَهْرَيْنِ مُتَتَابِعَيْنِ مِن قَبْلِ أَن يَتَمَاسَّا ۖ فَمَن لَّمْ يَسْتَطِعْ فَإِطْعَامُ سِتِّينَ مِسْكِينًا ۚ ذَٰلِكَ لِتُؤْمِنُوا بِاللَّهِ وَرَسُولِهِ ۚ وَتِلْكَ حُدُودُ اللَّهِ ۗ وَلِلْكَافِرِينَ عَذَابٌ أَلِيمٌ",
    "إِنَّ الَّذِينَ يُحَادُّونَ اللَّهَ وَرَسُولَهُ كُبِتُوا كَمَا كُبِتَ الَّذِينَ مِن قَبْلِهِمْ ۚ وَقَدْ أَنزَلْنَا آيَاتٍ بَيِّنَاتٍ ۚ وَلِلْكَافِرِينَ عَذَابٌ مُّهِينٌ",
    "يَوْمَ يَبْعَثُهُمُ اللَّهُ جَمِيعًا فَيُنَبِّئُهُم بِمَا عَمِلُوا ۚ أَحْصَاهُ اللَّهُ وَنَسُوهُ ۚ وَاللَّهُ عَلَىٰ كُلِّ شَيْءٍ شَهِيدٌ",
    "أَلَمْ تَرَ أَنَّ اللَّهَ يَعْلَمُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ ۖ مَا يَكُونُ مِن نَّجْوَىٰ ثَلَاثَةٍ إِلَّا هُوَ رَابِعُهُمْ وَلَا خَمْسَةٍ إِلَّا هُوَ سَادِسُهُمْ وَلَا أَدْنَىٰ مِن ذَٰلِكَ وَلَا أَكْثَرَ إِلَّا هُوَ مَعَهُمْ أَيْنَ مَا كَانُوا ۖ ثُمَّ يُنَبِّئُهُم بِمَا عَمِلُوا يَوْمَ الْقِيَامَةِ ۚ إِنَّ اللَّهَ بِكُلِّ شَيْءٍ عَلِيمٌ",
    "أَلَمْ تَرَ إِلَى الَّذِينَ نُهُوا عَنِ النَّجْوَىٰ ثُمَّ يَعُودُونَ لِمَا نُهُوا عَنْهُ وَيَتَنَاجَوْنَ بِالْإِثْمِ وَالْعُدْوَانِ وَمَعْصِيَتِ الرَّسُولِ وَإِذَا جَاءُوكَ حَيَّوْكَ بِمَا لَمْ يُحَيِّكَ بِهِ اللَّهُ وَيَقُولُونَ فِي أَنفُسِهِمْ لَوْلَا يُعَذِّبُنَا اللَّهُ بِمَا نَقُولُ ۚ حَسْبُهُمْ جَهَنَّمُ يَصْلَوْنَهَا ۖ فَبِئْسَ الْمَصِيرُ",
    "يَا أَيُّهَا الَّذِينَ آمَنُوا إِذَا تَنَاجَيْتُمْ فَلَا تَتَنَاجَوْا بِالْإِثْمِ وَالْعُدْوَانِ وَمَعْصِيَتِ الرَّسُولِ وَتَنَاجَوْا بِالْبِرِّ وَالتَّقْوَىٰ ۖ وَاتَّقُوا اللَّهَ الَّذِي إِلَيْهِ تُحْشَرُونَ",
    "إِنَّمَا النَّجْوَىٰ مِنَ الشَّيْطَانِ لِيَحْزُنَ الَّذِينَ آمَنُوا وَلَيْسَ بِضَارِّهِمْ شَيْئًا إِلَّا بِإِذْنِ اللَّهِ ۚ وَعَلَى اللَّهِ فَلْيَتَوَكَّلِ الْمُؤْمِنُونَ",
    "يَا أَيُّهَا الَّذِينَ آمَنُوا إِذَا قِيلَ لَكُمْ تَفَسَّحُوا فِي الْمَجَالِسِ فَافْسَحُوا يَفْسَحِ اللَّهُ لَكُمْ ۖ وَإِذَا قِيلَ انشُزُوا فَانشُزُوا يَرْفَعِ اللَّهُ الَّذِينَ آمَنُوا مِنكُمْ وَالَّذِينَ أُوتُوا الْعِلْمَ دَرَجَاتٍ ۚ وَاللَّهُ بِمَا تَعْمَلُونَ خَبِيرٌ",
    "يَا أَيُّهَا الَّذِينَ آمَنُوا إِذَا نَاجَيْتُمُ الرَّسُولَ فَقَدِّمُوا بَيْنَ يَدَيْ نَجْوَاكُمْ صَدَقَةً ۚ ذَٰلِكَ خَيْرٌ لَّكُمْ وَأَطْهَرُ ۚ فَإِن لَّمْ تَجِدُوا فَإِنَّ اللَّهَ غَفُورٌ رَّحِيمٌ",
    "أَأَشْفَقْتُمْ أَن تُقَدِّمُوا بَيْنَ يَدَيْ نَجْوَاكُمْ صَدَقَاتٍ ۚ فَإِذْ لَمْ تَفْعَلُوا وَتَابَ اللَّهُ عَلَيْكُمْ فَأَقِيمُوا الصَّلَاةَ وَآتُوا الزَّكَاةَ وَأَطِيعُوا اللَّهَ وَرَسُولَهُ ۚ وَاللَّهُ خَبِيرٌ بِمَا تَعْمَلُونَ",
    "أَلَمْ تَرَ إِلَى الَّذِينَ تَوَلَّوْا قَوْمًا غَضِبَ اللَّهُ عَلَيْهِم مَّا هُم مِّنكُمْ وَلَا مِنْهُمْ وَيَحْلِفُونَ عَلَى الْكَذِبِ وَهُمْ يَعْلَمُونَ",
    "أَعَدَّ اللَّهُ لَهُمْ عَذَابًا شَدِيدًا ۖ إِنَّهُمْ سَاءَ مَا كَانُوا يَعْمَلُونَ",
    "اتَّخَذُوا أَيْمَانَهُمْ جُنَّةً فَصَدُّوا عَن سَبِيلِ اللَّهِ فَلَهُمْ عَذَابٌ مُّهِينٌ",
    "لَّن تُغْنِيَ عَنْهُمْ أَمْوَالُهُمْ وَلَا أَوْلَادُهُم مِّنَ اللَّهِ شَيْئًا ۚ أُولَٰئِكَ أَصْحَابُ النَّارِ ۖ هُمْ فِيهَا خَالِدُونَ",
    "يَوْمَ يَبْعَثُهُمُ اللَّهُ جَمِيعًا فَيَحْلِفُونَ لَهُ كَمَا يَحْلِفُونَ لَكُمْ ۖ وَيَحْسَبُونَ أَنَّهُمْ عَلَىٰ شَيْءٍ ۚ أَلَا إِنَّهُمْ هُمُ الْكَاذِبُونَ",
    "اسْتَحْوَذَ عَلَيْهِمُ الشَّيْطَانُ فَأَنسَاهُمْ ذِكْرَ اللَّهِ ۚ أُولَٰئِكَ حِزْبُ الشَّيْطَانِ ۚ أَلَا إِنَّ حِزْبَ الشَّيْطَانِ هُمُ الْخَاسِرُونَ",
    "إِنَّ الَّذِينَ يُحَادُّونَ اللَّهَ وَرَسُولَهُ أُولَٰئِكَ فِي الْأَذَلِّينَ",
    "كَتَبَ اللَّهُ لَأَغْلِبَنَّ أَنَا وَرُسُلِي ۚ إِنَّ اللَّهَ قَوِيٌّ عَزِيزٌ",
    "لَّا تَجِدُ قَوْمًا يُؤْمِنُونَ بِاللَّهِ وَالْيَوْمِ الْآخِرِ يُوَادُّونَ مَنْ حَادَّ اللَّهَ وَرَسُولَهُ وَلَوْ كَانُوا آبَاءَهُمْ أَوْ أَبْنَاءَهُمْ أَوْ إِخْوَانَهُمْ أَوْ عَشِيرَتَهُمْ ۚ أُولَٰئِكَ كَتَبَ فِي قُلُوبِهِمُ الْإِيمَانَ وَأَيَّدَهُم بِرُوحٍ مِّنْهُ ۖ وَيُدْخِلُهُمْ جَنَّاتٍ تَجْرِي مِن تَحْتِهَا الْأَنْهَارُ خَالِدِينَ فِيهَا ۚ رَضِيَ اللَّهُ عَنْهُمْ وَرَضُوا عَنْهُ ۚ أُولَٰئِكَ حِزْبُ اللَّهِ ۚ أَلَا إِنَّ حِزْبَ اللَّهِ هُمُ الْمُفْلِحُونَ"};

    String [] sahih_international = {"Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International", "Sahih International",
            "Sahih International", "Sahih International"};

    String [] english_verses = {"Certainly has Allah heard the speech of the one who argues with you, [O Muhammad], concerning her husband and directs her complaint to Allah. And Allah hears your dialogue; indeed, Allah is Hearing and Seeing.",
    "Those who pronounce thihar among you [to separate] from their wives - they are not [consequently] their mothers. Their mothers are none but those who gave birth to them. And indeed, they are saying an objectionable statement and a falsehood. But indeed, Allah is Pardoning and Forgiving.",
    "And those who pronounce thihar from their wives and then [wish to] go back on what they said - then [there must be] the freeing of a slave before they touch one another. That is what you are admonished thereby; and Allah is Acquainted with what you do.",
    "And he who does not find [a slave] - then a fast for two months consecutively before they touch one another; and he who is unable - then the feeding of sixty poor persons. That is for you to believe [completely] in Allah and His Messenger; and those are the limits [set by] Allah. And for the disbelievers is a painful punishment.",
    "Indeed, those who oppose Allah and His Messenger are abased as those before them were abased. And We have certainly sent down verses of clear evidence. And for the disbelievers is a humiliating punishment.",
    "On the Day when Allah will resurrect them all and inform them of what they did. Allah had enumerated it, while they forgot it; and Allah is, over all things, Witness.",
    "Have you not considered that Allah knows what is in the heavens and what is on the earth? There is in no private conversation three but that He is the fourth of them, nor are there five but that He is the sixth of them - and no less than that and no more except that He is with them [in knowledge] wherever they are. Then He will inform them of what they did, on the Day of Resurrection. Indeed Allah is, of all things, Knowing.",
    "Have you not considered those who were forbidden from private conversation, then they return to that which they were forbidden and converse among themselves about sin and aggression and disobedience to the Messenger? And when they come to you, they greet you with that [word] by which Allah does not greet you and say among themselves, \"Why does Allah not punish us for what we say?\" Sufficient for them is Hell, which they will [enter to] burn, and wretched is the destination.",
    "O you who have believed, when you converse privately, do not converse about sin and aggression and disobedience to the Messenger but converse about righteousness and piety. And fear Allah, to whom you will be gathered.",
    "Private conversation is only from Satan that he may grieve those who have believed, but he will not harm them at all except by permission of Allah. And upon Allah let the believers rely.",
    "O you who have believed, when you are told, \"Space yourselves\" in assemblies, then make space; Allah will make space for you. And when you are told, \"Arise,\" then arise; Allah will raise those who have believed among you and those who were given knowledge, by degrees. And Allah is Acquainted with what you do.",
    "O you who have believed, when you [wish to] privately consult the Messenger, present before your consultation a charity. That is better for you and purer. But if you find not [the means] - then indeed, Allah is Forgiving and Merciful.",
    "Have you feared to present before your consultation charities? Then when you do not and Allah has forgiven you, then [at least] establish prayer and give zakah and obey Allah and His Messenger. And Allah is Acquainted with what you do.",
    "Have you not considered those who make allies of a people with whom Allah has become angry? They are neither of you nor of them, and they swear to untruth while they know [they are lying].",
    "Allah has prepared for them a severe punishment. Indeed, it was evil that they were doing.",
    "They took their [false] oaths as a cover, so they averted [people] from the way of Allah, and for them is a humiliating punishment.",
    "Never will their wealth or their children avail them against Allah at all. Those are the companions of the Fire; they will abide therein eternally",
    "On the Day Allah will resurrect them all, and they will swear to Him as they swear to you and think that they are [standing] on something. Unquestionably, it is they who are the liars.",
    "Satan has overcome them and made them forget the remembrance of Allah. Those are the party of Satan. Unquestionably, the party of Satan - they will be the losers.",
    "Indeed, the ones who oppose Allah and His Messenger - those will be among the most humbled.",
    "Allah has written, \"I will surely overcome, I and My messengers.\" Indeed, Allah is Powerful and Exalted in Might.",
    "You will not find a people who believe in Allah and the Last Day having affection for those who oppose Allah and His Messenger, even if they were their fathers or their sons or their brothers or their kindred. Those - He has decreed within their hearts faith and supported them with spirit from Him. And We will admit them to gardens beneath which rivers flow, wherein they abide eternally. Allah is pleased with them, and they are pleased with Him - those are the party of Allah. Unquestionably, the party of Allah - they are the successful."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al__mujadila);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_al_mujadila);
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
