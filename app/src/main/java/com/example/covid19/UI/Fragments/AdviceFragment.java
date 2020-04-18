package com.example.covid19.UI.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.covid19.Adapter.AdviceAdapter;
import com.example.covid19.Model.Advice;
import com.example.covid19.R;


import java.util.ArrayList;
import java.util.List;


public class AdviceFragment extends Fragment {


    RecyclerView recyclerView;
    AdviceAdapter adviceAdapter;
    List<Advice> adviceList;
    ConstraintLayout rootLayout ;
    Context context;

    public AdviceFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_advice_fragment,container,false);


        rootLayout=view.findViewById(R.id.root_layout);
        recyclerView = view.findViewById(R.id.advice_recyclerview);


        adviceList= new ArrayList<>();


        adviceList.add(new Advice(R.drawable.ic_stay_at_home,"البقاء في المنزل","إذا أصيب شخص فسيكون قادر على نقل العدوى إلى شخصين وكل حالتين يمكنها إصابة 4 أشخاص وكل 4 أشخاص يمكنهم إصابة 16 شخص،لذا على الجميع المكوث في منازلهم لمنع انتشار الفيروس."));
        adviceList.add(new Advice(R.drawable.ic_wash_hand,"إغسل يديك بانتظام بالماء والصابون","إستخدام المياه والصابون باستمرار على مدار اليوم بمعدل كل ساعة."));
        adviceList.add(new Advice(R.drawable.ic_crowding,"تجنب الأماكن المزدحمة","قد يبدو الشخص الحامل لفيروس كورونا سليماً حيث قد لا تبدو عليه أعراض المرض، وذلك طول فترة حضانة الفيروس والتي تبلغ 14 يوماً. ولأنه لا يمكن تنبؤ بمن يحمل الفيروس ومن لا يحمله، وبسبب إمكانية نقل العدوى للآخرين حتى مع عدم ظهور أعراض المرض على حامل الفيروس، فينصح بتجنب التواجد في الأماكن المزدحمة قدر الإمكان، مع الالتزام باتباع الإجراءات الوقائية اللازمة في حالات الضرورة."));
        adviceList.add(new Advice(R.drawable.ic_mask_protection_wearing,"تغطية الفم والأنف وعدم لمس الكمامة","من الضروري أن يقوم كل من يلاحظ أن لديه أعراضا تشبه أعراض الأنفلونزا، أن يستخدم بشكل دائم المناديل الورقية , كما يُنصح من يعاني من السعال والعطس بارتداء كمامة لتغطية منطقة الفم والأنف. وبمجرد ارتداء الكمامة، يجب عدم لمسها لتجنب انتقال مسببات العدوى إلى أصابع اليدين ومنها إلى أسطح قد يلمسها أشخاص آخرون فيصابون بالعدوى."));
        adviceList.add(new Advice(R.drawable.ic_avoid_handshake,"لقوا التحية دون المصافحة بالأيدي، وتجنّبوا تقبيل الآخرين أو معانقتهم","يجب التوقف عن عادات المصافحة باليدين وتبادل القبلات والأحضان عند لقاء الأقارب والأصدقاء لتجنب انتقال العدوى من شخص لآخر،وتجنب البصق في الأماكن العامة نظراً لأن القطرات الناقلة للعدوى ربما تنقل المرض إلى شخص آخر في حالة ملامسته الأسطح التي انتقل لها الفيروس."));
        adviceList.add(new Advice(R.drawable.ic_avoid_traveling,"إلغاء أي خطط للسفر في هذه الفترة.","يُفضّل على أي شخص يعاني من أعراض تشبه الإصابة بالأنفلونزا (مثل السعال والحمى وسيلان الأنف أو العطس) إلغاء أي خطط للسفر في هذه الفترة."));
        adviceList.add(new Advice(R.drawable.ic_uncooked_food,"تناول الوجبات الغذائية المطهية بشكل صحيح","يجب الحرص على تناول الوجبات الغذائية المطهية بشكل صحيح وتجنب تناول الأطعمة غير المطهية، أو المطهية لدرجة أقل من الاستواء. ويجب غسل اليدين جيداً وفوراً بالماء والصابون بعد لمس اللحوم النيئة أو أي جزء من الحيوانات المذبوحة."));
        adviceList.add(new Advice(R.drawable.ic_cleaning_tools,"تنظيف وتطهير الأسطح التي يتم ملامستها بكثرة جيدا.","يجب استخدام المطهرات لتنظيف الأسطح المختلفة بالمنزل ومكان العمل يومياً، بما يشمل الأبواب ومقابض الأبواب والطاولات ودورات المياه وأجهزة الكمبيوتر وأجهزة الكمبيوتر المحمولة والمفاتيح والقرطاسية المكتبية."));
        adviceList.add(new Advice(R.drawable.ic_avoid_patients,"تجنب المخالطة اللصيقة مع أي شخص مريض أو لديه أعراض.","ينبغي الابتعاد لمسافات مناسبة عن أي أشخاص تظهر عليهم أعراض نزلات البرد أو أي من أعراض كورونا. وتقدر المسافات المناسبة تقريباً بحوالي نصف متر إلى مترين لتجنب التعرض لأي قطرات أو رذاذ يصدر عن الشخص المريض."));
        adviceList.add(new Advice(R.drawable.ic_immunity_advice,"إهتم بتناول الأطعمة والمشروبات التي تقوي جهاز المناعة","النوم لفترات كافية وممارسة الرياضة واتباع نظام غذائي صحيوالإقلاع عن التدخين والتقليل من الكحوليات والمشروبات المنبهة وتجنب الإجهاد والتعرض لأشعة الشمس يعملوا على رفع كفاءة جهاز المناعة."));

        adviceAdapter=new AdviceAdapter(this.getContext(),adviceList);
        recyclerView.setAdapter(adviceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return view;
    }

  /*  private void saveThemeStatePre(boolean isDark) {
        SharedPreferences preferences= Objects.requireNonNull(getContext()).getSharedPreferences("my pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("isDark",isDark);
        editor.apply();
    }
    private boolean getThemeStatePref() {
        SharedPreferences preferences= Objects.requireNonNull(getContext()).getSharedPreferences("my pref",MODE_PRIVATE);
        boolean isDark=preferences.getBoolean("isDark",false);
        return isDark;
    }*/
}
