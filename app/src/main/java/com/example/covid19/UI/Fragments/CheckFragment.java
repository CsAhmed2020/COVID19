package com.example.covid19.UI.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.covid19.R;
import com.example.covid19.UI.Activites.NewsActivity;
import com.example.covid19.Utils.GifImageView;

public class CheckFragment extends Fragment {

    private static final String TAG = "CheckFragment";
    Button startbtn;
    int counter=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_check_fragment,container,false);
        startbtn=view.findViewById(R.id.start_btn);
        GifImageView gifImageView, gifImageView2;
        gifImageView= (GifImageView) view.findViewById(R.id.GifImageView);
        gifImageView2=(GifImageView) view.findViewById(R.id.GifImageView2);
        gifImageView.setGifImageResource(R.drawable.covid);
        gifImageView2.setGifImageResource(R.drawable.breaking_news);
        CardView cardView=view.findViewById(R.id.card_news);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NewsActivity.class));
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Adel");
                AlertDialog.Builder builderSingle =new AlertDialog.Builder(view.getContext());
                builderSingle.setIcon(R.drawable.ic_warning);
                builderSingle.setTitle(R.string.warning_title);
                builderSingle.setMessage(R.string.warning);
                builderSingle.setPositiveButton("البدء", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog1();
                    }
                });

                builderSingle.show();
            }

        });


        return view;
    }

    public void customDialog1(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques1_ar);

        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customDialog2();
                    }
                });

        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter+=20;
                        customDialog2();
                    }
                });


        alertDialog.show();


    }


    public void customDialog2(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques2_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques3_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques4_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques5_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques6_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques7_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques8_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques9_ar);

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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques10_ar);
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
        alertDialog.setTitle(R.string.ques_title_ar);
        alertDialog.setMessage(R.string.ques11_ar);
        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(getCounter()>=20){
                            positiveCustomDialog();
                            counter=0;
                        }else
                        {
                            negativeCustomDialog();
                            counter=0;
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
                            counter=0;
                        }else
                        {
                            negativeCustomDialog();
                            counter=0;
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
        alertDialog.setMessage(R.string.positive_result);
        alertDialog.show();
    }

    public void negativeCustomDialog(){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this.getContext());
        alertDialog.setIcon(R.drawable.ic_checklist);
        alertDialog.setTitle(R.string.end_msg);
        alertDialog.setMessage(R.string.negative_result);
        alertDialog.show();
    }


}
