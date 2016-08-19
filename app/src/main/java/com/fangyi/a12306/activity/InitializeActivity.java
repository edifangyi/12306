package com.fangyi.a12306.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.fangyi.a12306.R;


/**
 * Created by FANGYI on 2016/8/15.
 */

public class InitializeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                startActivity(new Intent(InitializeActivity.this, MainActivity.class));
                finish();
            }
        }.sendEmptyMessageDelayed(0, 2000);
    }
}
