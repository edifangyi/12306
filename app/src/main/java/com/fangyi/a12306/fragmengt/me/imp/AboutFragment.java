package com.fangyi.a12306.fragmengt.me.imp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;

import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class AboutFragment extends BaseFragment {


    @Override
    protected View getSuccessView() {
        CommonUtils.setTitle(getActivity(), "关于");
        TextView view = new TextView(getActivity());
        view.setText("关于");
        view.setTextColor(Color.RED);
        view.setTextSize(50);
        return view;
    }

    private void setListener() {

    }

    private void setTvEtTitle() {
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
