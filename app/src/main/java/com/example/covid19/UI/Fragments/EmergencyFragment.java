package com.example.covid19.UI.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.example.covid19.R;
import com.google.android.material.button.MaterialButton;


public class EmergencyFragment extends Fragment {

    int call_btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_emergency_fragment,container,false);

        Button firstCallBtn = view.findViewById(R.id.first_number_call);
        Button secondCallBtn = view.findViewById(R.id.second_number_call);
        Button thirdCallBtn = view.findViewById(R.id.third_number_call);
        Button fourthCallBtn = view.findViewById(R.id.fourth_number_call);

        firstCallBtn.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                call_btn = 1;
                requestPhoneCallPermission();
            }else{
                dialPhoneNumber("105");
            }
        });

        secondCallBtn.setOnClickListener(v ->{
            if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                call_btn=2;
                requestPhoneCallPermission();
            }else {
                dialPhoneNumber("123");
            }
        } );

        thirdCallBtn.setOnClickListener(v -> {
            if(ContextCompat.checkSelfPermission(requireActivity(),Manifest.permission.CALL_PHONE)
                    !=PackageManager.PERMISSION_GRANTED){
                call_btn=3;
                requestPhoneCallPermission();
            }else {
                dialPhoneNumber("122");
            }
        });

        fourthCallBtn.setOnClickListener(v ->{
            if(ContextCompat.checkSelfPermission(requireActivity(),Manifest.permission.CALL_PHONE)
                    !=PackageManager.PERMISSION_GRANTED){
                call_btn=4;
                requestPhoneCallPermission();
            }else{
                dialPhoneNumber("01221110000");
            }
        } );

        return view;
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void requestPhoneCallPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
            new AlertDialog.Builder(requireActivity())
                    .setTitle("Need Permission")
                    .setMessage("This Permission needed to call")
                    .setPositiveButton("OK", (dialog, which) -> requestPermissions(
                            new String[]{Manifest.permission.CALL_PHONE}, 70))
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .create().show();
        }else {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},70);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == 70) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (call_btn == 1) {
                    dialPhoneNumber("105");
                } else if (call_btn == 2) {
                    dialPhoneNumber("123");
                } else if (call_btn == 3) {
                    dialPhoneNumber("122");
                } else if (call_btn == 4) {
                    dialPhoneNumber("01221110000");
                }
                Toast.makeText(requireActivity(), "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireActivity(),"Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
