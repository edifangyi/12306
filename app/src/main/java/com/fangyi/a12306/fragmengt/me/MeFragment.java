package com.fangyi.a12306.fragmengt.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.StartUtils;
import com.fangyi.a12306.view.BtnClickView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/17.
 */

public class MeFragment extends BaseFragment {
    @BindView(R.id.bcv_login)
    BtnClickView bcvLogin;
    @BindView(R.id.bcv_register)
    BtnClickView bcvRegister;
    @BindView(R.id.bcv_trip_guidance)
    BtnClickView bcvTripGuidance;
    @BindView(R.id.bcv_warm_service)
    BtnClickView bcvWarmService;
    @BindView(R.id.bcv_tourism_leisure)
    BtnClickView bcvTourismLeisure;
    @BindView(R.id.bcv_system_informs)
    BtnClickView bcvSystemInforms;
    @BindView(R.id.bcv_about)
    BtnClickView bcvAbout;

    @Override
    protected View getSuccessView() {
        View view = View.inflate(getActivity(), R.layout.fragment_me_unknown, null);
        ButterKnife.bind(this, view);
        setBcvTitle();
        setListener();
        return view;
    }

    private void setBcvTitle() {
        bcvLogin.setTitle("登陆");
        bcvRegister.setTitle("注册");
        bcvTripGuidance.setTitle("出行导向");
        bcvWarmService.setTitle("温馨服务");
        bcvTourismLeisure.setTitle("旅行休闲");
        bcvSystemInforms.setTitle("系统通知");
        bcvAbout.setTitle("关于");

    }

    private void setListener() {
        bcvLogin.setOnClickListener(this);
        bcvRegister.setOnClickListener(this);
        bcvTripGuidance.setOnClickListener(this);
        bcvWarmService.setOnClickListener(this);
        bcvTourismLeisure.setOnClickListener(this);
        bcvSystemInforms.setOnClickListener(this);
        bcvAbout.setOnClickListener(this);
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
