package com.fangyi.a12306.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fangyi.a12306.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by FANGYI on 2016/5/29.
 */
public class BtnRadioView extends LinearLayout {


    @BindView(R.id.br_title)
    TextView brTitle;
    @BindView(R.id.br_content)
    TextView brContent;


    private String title;
    private String content;

    /**
     * 初始化布局文件
     */
    private void initView(Context context) {
        //inflate方法的作用：把布局文件--》View
        //最后一个参数：添加谁进来，谁就是setting_item_view的父亲，布局文件挂载在传进来的这个控件上
        View view = View.inflate(context, R.layout.btn_radio_view, BtnRadioView.this);
        ButterKnife.bind(this, view);
    }


    //在代码中实例化的时候使用
    public BtnRadioView(Context context) {
        super(context);
        initView(context);
    }

    //在布局文件实例化的时候使用
    public BtnRadioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        title = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "title");
        content = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "hint");
    }

    //要这只样式的时候使用
    public BtnRadioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 设置组合控件的标题
     */
    public void setTitle(String title) {
        brTitle.setText(title);
    }

    public void setContent(String title) {
        brContent.setText(content);
    }


}
