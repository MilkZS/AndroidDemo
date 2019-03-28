package com.example.util.AndroidID;

import android.app.Activity;
import android.util.Base64;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Installation {

    public static synchronized String id(Activity activity){
        String hard = HardWareInstallation.getHardWareInfo(activity);
        String sim = SimInstallation.getSimNO(activity);
        String soft = SoftInstallation.softUUID(activity);
        String id = "1" + hard + "#" + sim + "#" + soft;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return Base64.encodeToString(md5.digest(id.getBytes(Charset.forName("UTF-8"))),Base64.DEFAULT);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return id;
    }

}
