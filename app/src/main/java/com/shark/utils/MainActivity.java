package com.shark.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.shark.utils.library.core.SLog;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SLog.e(this,"SLog引用成功");
        String s="I LOVE YOU";
        s.getBytes();

    }
}
