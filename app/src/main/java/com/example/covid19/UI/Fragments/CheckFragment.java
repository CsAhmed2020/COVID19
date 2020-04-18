package com.example.covid19.UI.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.covid19.R;

public class CheckFragment extends Fragment {

    private static final String TAG = "CheckFragment";
    Button startbtn;
    int counter=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_check_fragment,container,false);
        startbtn=view.findViewById(R.id.start_btn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Adel");
                AlertDialog.Builder builderSingle =new AlertDialog.Builder(view.getContext());
                builderSingle.setIcon(R.drawable.ic_checklist);
                builderSingle.setTitle("أجب عن السؤال الآتي ");
                builderSingle.setMessage("هل كنت على احتكاك مباشر مع شخص تبيّن لاحقاً أنه مصاب بفيروس كورونا؟");
                builderSingle.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        counter+=20;
                        customDialog();
                    }
                });

                builderSingle.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog();
                    }
                });
                builderSingle.show();
            }

        });

        return view;
    }

    public void customDialog(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل تعاني من الحمى أو إرتفاع درجة الحرارة؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog3();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=20;
                        customDialog3();
                    }
                });


        alertDialog.show();


    }

    public void customDialog3(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل سافرت إلى أي دولة خلال الأسبوعين الماضيين؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog4();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=19;
                        customDialog4();
                    }
                });


        alertDialog.show();
    }

    public void customDialog4(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل تعاني من سعال جاف؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog5();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=2;
                        customDialog5();
                    }
                });


        alertDialog.show();
    }

    public void customDialog5(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل تعاني من صعوبة في التنفس؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog6();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=4;
                        customDialog6();

                    }
                });


        alertDialog.show();
    }

    public void customDialog6(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل تشعر بوخز في الحلق أو إلتهاب في الحلق؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog7();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=2;
                        customDialog7();

                    }
                });


        alertDialog.show();
    }

    public void customDialog7(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل تعاني من العطس باستمرار؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog8();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=2;
                        customDialog8();
                    }
                });


        alertDialog.show();
    }

    public void customDialog8(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل لديك سيلان أنف؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog9();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=2;
                        customDialog9();
                    }
                });


        alertDialog.show();
    }

    public void customDialog9(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل تشعر بتعب عام وفتور بالهمة والنشاط؟");

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog10();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=1;
                        customDialog10();
                    }
                });


        alertDialog.show();
    }

    public void customDialog10(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل لديك صداع مستمر؟");
        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog11();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=2;
                        customDialog11();
                    }
                });


        alertDialog.show();
    }


    public void customDialog11(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("أجب عن السؤال الآتي");
        alertDialog.setMessage("هل لديك آلام بالعضلات؟");
        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(getCounter()>=20){
                            positiveCustomDialog();
                        }else
                        {
                            negativeCustomDialog();
                        }
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=2;
                        if (getCounter()>=20){
                            positiveCustomDialog();
                        }else
                        {
                            negativeCustomDialog();
                        }

                    }
                });


        alertDialog.show();
    }

    public int getCounter() {
        return counter;
    }

    public void positiveCustomDialog(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle(getCounter()+" النتيجة ");
        alertDialog.setMessage("قد تكون مصاباً بفيروس كورونا، اعزل نفسك في المنزل ولا تذهب إلى المستشفى أو المراكز الصحية وعليك أن تبادر فوراً للاتصال بالجهات الصحية المختصة في بلدك لاتخاذ الإجراءات اللازمة.");
        alertDialog.show();
    }

    public void negativeCustomDialog(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle("انتهت");
        alertDialog.setMessage("أنت بأمان، برجاء الإلتزام بالإرشادات الوقائية والبقاء بالمنزل.");
        alertDialog.show();
    }

}
