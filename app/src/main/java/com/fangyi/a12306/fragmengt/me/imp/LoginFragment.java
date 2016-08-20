package com.fangyi.a12306.fragmengt.me.imp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;
import com.fangyi.a12306.utils.StartUtils;
import com.fangyi.a12306.view.TvEtView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class LoginFragment extends BaseFragment {
    @BindView(R.id.evet_username)
    TvEtView evetUsername;
    @BindView(R.id.evet_password)
    TvEtView evetPassword;

    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    @BindView(R.id.cb_auto_Login)
    CheckBox cbAutoLogin;
    @BindView(R.id.btn_orget)
    TextView cbOrget;
    @BindView(R.id.btn_login)
    Button btnLogin;


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
        btnLogin.setOnClickListener(this);
        cbRemember.setOnClickListener(this);
        cbAutoLogin.setOnClickListener(this);
        cbOrget.setOnClickListener(this);
    }

    private void setTvEtTitle() {
        evetUsername.setTitle("用户名");
        evetUsername.setHint("请输入用户名");
        evetPassword.setTitle("密    码");
        evetPassword.setHint("请输入密码");
        evetPassword.setInputTypePassWord();

    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.cb_remember:
                Toast.makeText(getContext(), "记住密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cb_auto_Login:
                Toast.makeText(getContext(), "自动登陆", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_orget:
                Toast.makeText(getContext(), "忘记密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                StartUtils.startActivityById(getActivity(), R.id.btn_login);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
