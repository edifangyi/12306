package com.fangyi.a12306.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fangyi.a12306.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by FANGYI on 2016/5/29.
 */
public class BtnClickView extends RelativeLayout {


    @BindView(R.id.bcv_title)
    TextView bcvTitle;

    @BindView(R.id.iv_click_status)
    ImageView ivClickStatus;
    private String title;


    /**
     * 初始化布局文件
     */
    private void initView(Context context) {
        //inflate方法的作用：把布局文件--》View
        //最后一个参数：添加谁进来，谁就是setting_item_view的父亲，布局文件挂载在传进来的这个控件上
        View view = View.inflate(context, R.layout.btn_click_view, BtnClickView.this);
        ButterKnife.bind(this, view);
//        bcvTitle = (TextView) findViewById(R.id.bcv_title);
    }


    //在代码中实例化的时候使用
    public BtnClickView(Context context) {
        super(context);
        initView(context);
    }

    //在布局文件实例化的时候使用
    public BtnClickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        title = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "title");

        bcvTitle.setText(title);
        //设置描述信息

    }

    //要这只样式的时候使用
    public BtnClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 设置组合控件的标题
     */
    public void setTitle(String title) {
        bcvTitle.setText(title);
    }


}
