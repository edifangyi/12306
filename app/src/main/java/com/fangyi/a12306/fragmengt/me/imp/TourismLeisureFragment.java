package com.fangyi.a12306.fragmengt.me.imp;

import android.view.View;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;

import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class TourismLeisureFragment extends BaseFragment {
    @Override
    protected View getSuccessView() {
        CommonUtils.setTitle(getActivity(), "旅行休闲");
        View view = View.inflate(getActivity(), R.layout.fragment_me_trip_guidance, null);
        ButterKnife.bind(this, view);
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
