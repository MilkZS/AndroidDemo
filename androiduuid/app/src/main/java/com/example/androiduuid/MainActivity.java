package com.example.androiduuid;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.util.AndroidID.Installation;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_create_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Installation.id(MainActivity.this);
                Log.i("Android ID","id = " + id);
            }
        });


        String board = Build.BOARD;
        Log.d("phone-board",board);
        Log.d("phone-brand",Build.BRAND);
        Log.d("phone-hardware",Build.HARDWARE);
        Log.d("phone-MANUFACTURER",Build.MANUFACTURER);
        Log.d("phone-SERIAL",Build.SERIAL);

    }
}
