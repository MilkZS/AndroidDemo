package com.example.util.AndroidID;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;

public class HardWareInstallation {

    private static final String TAG = "hardWareInfo";

    public static String getHardWareInfo(Context mContext){

        @SuppressLint("HardwareIds") String ser = Build.SERIAL;
        if (ser == null || ser.equals("")){
            WifiManager wm = (WifiManager)mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            @SuppressLint("HardwareIds") String macAddress = wm.getConnectionInfo().getMacAddress();
            return macAddress;
        }else {
            return ser;
        }
    }

}
