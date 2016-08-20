package com.fangyi.a12306.fragmengt.me.imp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;
import com.fangyi.a12306.view.BtnRadioView;
import com.fangyi.a12306.view.TvEtView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class RegisterFragment extends BaseFragment {


    @BindView(R.id.evet_reg_username)
    TvEtView evetRegUsername;
    @BindView(R.id.evet_reg_password)
    TvEtView evetRegPassword;
    @BindView(R.id.evet_reg_password_confirm)
    TvEtView evetRegPasswordConfirm;
    @BindView(R.id.evet_reg_id_name)
    TvEtView evetRegIdName;
    @BindView(R.id.evet_reg_id_type)
    TvEtView evetRegIdType;
    @BindView(R.id.evet_reg_id_num)
    TvEtView evetRegIdNum;
    @BindView(R.id.evet_reg_phone_number)
    TvEtView evetRegPhoneNumber;
    @BindView(R.id.evet_reg_mail)
    TvEtView evetRegMail;
    @BindView(R.id.evet_reg_passenger_type)
    BtnRadioView evetRegPassengerType;
    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected View getSuccessView() {
        CommonUtils.setTitle(getActivity(), "注册");
        View view = View.inflate(getActivity(), R.layout.fragment_me_register, null);
        ButterKnife.bind(this, view);
        setTvEtTitle();
        setListener();
        return view;
    }

    private void setTvEtTitle() {
        evetRegUsername.setTitle("用 户 名");
        evetRegPassword.setTitle("密     码");
        evetRegPasswordConfirm.setTitle("密码确认");

    }

    private void setListener() {

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
