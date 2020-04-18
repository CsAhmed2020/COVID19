package com.example.covid19.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    public static int getConnectivityStatus(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo=null;
        if(connectivityManager!=null){
            activeNetworkInfo=connectivityManager.getActiveNetworkInfo();
        }
        if (activeNetworkInfo!=null){
            if(activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if(activeNetworkInfo.getType()==ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {
        int con = NetworkUtils.getConnectivityStatus(context);
        String status = null;
        if (con == NetworkUtils.TYPE_WIFI) {
            status = "Wifi enabled";
        } else if (con == NetworkUtils.TYPE_MOBILE) {
            status = "Mobile data enabled";
        } else if (con == NetworkUtils.TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet";
        }
        return status;
    }
}
