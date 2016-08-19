package com.fangyi.a12306.fragmengt.order.imp.com;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.StartUtils;
import com.fangyi.a12306.view.BtnClickView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/19.
 */

public class CompletedOrderFragment extends BaseFragment {


    @BindView(R.id.bcv_today)
    BtnClickView bcvToday;
    @BindView(R.id.bcv_not_travel)
    BtnClickView bcvNotTravel;
    @BindView(R.id.bcv_history)
    BtnClickView bcvHistory;
    @BindView(R.id.tv_tip)
    TextView tvTip;


    @Override
    protected View getSuccessView() {
        View view = View.inflate(getActivity(), R.layout.fragment_order_completed, null);
        ButterKnife.bind(this, view);

        tvTip.setText(Html.fromHtml("<font color='#ff0000'>*</font>温馨提示："));


        setBcvTitle();
        setListener();
        return view;

    }

    private void setBcvTitle() {
        bcvToday.setTitle("今日订单");
        bcvNotTravel.setTitle("未出行订单");
        bcvHistory.setTitle("历史订单");
    }

    private void setListener() {
        bcvToday.setOnClickListener(this);
        bcvNotTravel.setOnClickListener(this);
        bcvHistory.setOnClickListener(this);
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View v) {
        StartUtils.startActivityById(getActivity(), v.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
