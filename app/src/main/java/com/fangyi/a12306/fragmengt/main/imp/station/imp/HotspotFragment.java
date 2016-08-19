package com.fangyi.a12306.fragmengt.main.imp.station.imp;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.fangyi.a12306.fragmengt.base.BaseFragment;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class HotspotFragment extends BaseFragment {
    @Override
    protected View getSuccessView() {
        TextView view = new TextView(getActivity());
        view.setText("热点车站");
        view.setTextColor(Color.RED);
        view.setTextSize(50);
        return view;
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
}
