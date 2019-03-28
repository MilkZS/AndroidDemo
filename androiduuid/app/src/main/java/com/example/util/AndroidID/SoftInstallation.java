package com.example.util.AndroidID;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

public class SoftInstallation {
    private static String sID = null;
    private static final String INSTALLATION = "INSTALLATION";
    private static final String INSTALLATION_FILE = "INSTALLATION_FILE_SHARE";

    public synchronized static String softUUID(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(INSTALLATION_FILE, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(INSTALLATION)) {
            return sharedPreferences.getString(INSTALLATION, "");
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String id = UUID.randomUUID().toString();
            editor.putString(INSTALLATION, id);
            editor.apply();
            editor.commit();
            return id;
        }
    }

    public synchronized static String softUUID() {
        String add = Environment.getDataDirectory().getPath();
        if (sID == null) {
            File installation = new File(add, INSTALLATION);
            try {
                if (!installation.exists())
                    writeInstallationFile(installation);
                sID = readInstallationFile(installation);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sID;
    }

    private static String readInstallationFile(File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, "r");
        byte[] bytes = new byte[(int) f.length()];
        f.readFully(bytes);
        f.close();
        return new String(bytes);
    }

    private static void writeInstallationFile(File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        String id = UUID.randomUUID().toString();
        out.write(id.getBytes());
        out.close();
    }
}
