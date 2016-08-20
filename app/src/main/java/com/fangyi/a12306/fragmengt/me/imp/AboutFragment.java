package com.fangyi.a12306.fragmengt.me.imp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;
import com.fangyi.a12306.view.TvEtView;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class AboutFragment extends BaseFragment {

    @BindView(R.id.evet_username)
    TvEtView evetUsername;
    @BindView(R.id.evet_password)
    TvEtView evetPassword;



    @Override
    protected View getSuccessView() {
        CommonUtils.setTitle(getActivity(), "登陆");
        View view = View.inflate(getActivity(), R.layout.fragment_me_login, null);
        ButterKnife.bind(this, view);
        setTvEtTitle();
        setListener();
        return view;
    }

    private void setListener() {

    }

    private void setTvEtTitle() {
        evetUsername.setTitle("用户名");
        evetUsername.setHint("请输入用户名");
        evetPassword.setTitle("密    码");
        evetPassword.setHint("请输入密码");
        evetPassword.setInputTypePassWord();

        String a = evetUsername.getInput();

        KLog.e(a);
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
