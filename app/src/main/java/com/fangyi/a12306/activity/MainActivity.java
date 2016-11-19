package com.fangyi.a12306.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.fangyi.a12306.R;
import com.fangyi.a12306.adapter.MainPagerAdapter;
import com.fangyi.a12306.view.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fangyi.a12306.R.id.bottom_order;

public class MainActivity extends BaseActivity {

    @BindView(R.id.home_title)
    TextView homeTitle;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    @BindView(R.id.bottom_main)
    RadioButton bottomMain;
    @BindView(bottom_order)
    RadioButton bottomOrder;
    @BindView(R.id.bottom_me)
    RadioButton bottomMe;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomMain.setTypeface(Typeface.DEFAULT_BOLD);
        bottomOrder.setTypeface(Typeface.DEFAULT_BOLD);
        bottomMe.setTypeface(Typeface.DEFAULT_BOLD);
        initView();
    }

    private void initView() {
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(5);
        viewpager.setCurrentItem(0);
        homeTitle.setText("车票预订");
        bottomMain.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bottom_main:
                        viewpager.setCurrentItem(0,false);
                        homeTitle.setText("车票预订");
                        break;
                    case bottom_order:
                        viewpager.setCurrentItem(1,false);
                        homeTitle.setText("订单查询");
                        break;
                    case R.id.bottom_me:
                        viewpager.setCurrentItem(2,false);
                        homeTitle.setText("我的12306");
                        break;
                }
            }
        });
    }


}
