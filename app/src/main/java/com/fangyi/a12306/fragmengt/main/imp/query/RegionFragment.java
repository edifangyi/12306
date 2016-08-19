package com.fangyi.a12306.fragmengt.main.imp.query;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fangyi.a12306.activity.ClickButtonActivity;
import com.fangyi.a12306.fragmengt.base.BaseListFragment;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class RegionFragment extends BaseListFragment {
    @Override
    protected View setView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(getActivity());
        view.setText("热点车站");
        view.setTextColor(Color.RED);
        view.setTextSize(50);
        return view;
    }

    @Override
    protected void setRefresh() {

    }

    @Override
    protected void loadMore() {

    }

    @Override
    protected void setActionBar() {
        ClickButtonActivity activity = (ClickButtonActivity) getActivity();
        activity.tvTitle.setText("区间选择");
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
}
