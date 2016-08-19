package com.fangyi.a12306.fragmengt.order.imp.incom;

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

public class IncompleteOrderFragment extends BaseFragment {
    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.bcv_incomplete_order_num)//未完成订单
    BtnClickView bcvIncompleteOrderNum;

    @Override
    protected View getSuccessView() {
        View view = View.inflate(getActivity(), R.layout.fragment_order_incomplete, null);
        ButterKnife.bind(this, view);

        tvTip.setText(Html.fromHtml("<font color='#ff0000'>*</font>温馨提示："));
        setBcvTitle();
        setListener();
        return view;
    }

    private void setBcvTitle() {
        bcvIncompleteOrderNum.setTitle("未完成订单(0)");
    }

    private void setListener() {
        bcvIncompleteOrderNum.setOnClickListener(this);
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
