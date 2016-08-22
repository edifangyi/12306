package com.fangyi.a12306.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fangyi.a12306.R;
import com.fangyi.a12306.utils.CommonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by FANGYI on 2016/8/15.
 */

public class InitializeActivity extends AppCompatActivity {
//    @BindView(R.id.iv_splash_advertise)
//    ImageView ivSplashAdvertise;
    @BindView(R.id.ll)
    RelativeLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
        ButterKnife.bind(this);

        Display dp = getWindowManager().getDefaultDisplay();
        int sceenWidth = dp.getWidth();
        ImageView view = new ImageView(this);
        view.setBackgroundResource(R.drawable.splash_advertise);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(sceenWidth, CommonUtils.dip2px(this, 470));
        view.setLayoutParams(params);
        ll.addView(view);



        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                startActivity(new Intent(InitializeActivity.this, MainActivity.class));
                finish();
            }
        }.sendEmptyMessageDelayed(0, 2000);
    }
}
