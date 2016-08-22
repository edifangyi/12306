package com.fangyi.a12306.fragmengt.me.imp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;
import com.fangyi.a12306.view.BtnClickView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by FANGYI on 2016/8/18.
 */

public class TripGuidanceFragment extends BaseFragment {
    @BindView(R.id.bcv_positive_delay_query)
    BtnClickView bcvPositiveDelayQuery;
    @BindView(R.id.bcv_trips_query)
    BtnClickView bcvTripsQuery;
    @BindView(R.id.bcv_fare_query)
    BtnClickView bcvFareQuery;
    @BindView(R.id.bcv_qutlets_query)
    BtnClickView bcvQutletsQuery;
    @BindView(R.id.bcv_station_number_inquiry)
    BtnClickView bcvStationNumberInquiry;
    @BindView(R.id.bcv_sale_time_query)
    BtnClickView bcvSaleTimeQuery;

    @Override
    protected View getSuccessView() {
        CommonUtils.setTitle(getActivity(), "出行导向");
        View view = View.inflate(getActivity(), R.layout.fragment_me_trip_guidance, null);
        ButterKnife.bind(this, view);

        setBcvTitle();
        setListener();
        return view;
    }

    private void setListener() {
        bcvPositiveDelayQuery.setOnClickListener(this);
        bcvTripsQuery.setOnClickListener(this);
        bcvFareQuery.setOnClickListener(this);
        bcvQutletsQuery.setOnClickListener(this);
        bcvStationNumberInquiry.setOnClickListener(this);
        bcvSaleTimeQuery.setOnClickListener(this);

    }

    private void setBcvTitle() {
        bcvPositiveDelayQuery.setTitle("正晚点查询");
        bcvTripsQuery.setTitle("车次查询");
        bcvFareQuery.setTitle("票价查询");
        bcvQutletsQuery.setTitle("代售点查询");
        bcvStationNumberInquiry.setTitle("车站车次查询");
        bcvSaleTimeQuery.setTitle("起售时间查询");
    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bcv_positive_delay_query:
                Toast.makeText(getContext(), "正晚点查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bcv_trips_query:
                Toast.makeText(getContext(), "车次查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bcv_fare_query:
                Toast.makeText(getContext(), "票价查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bcv_qutlets_query:
                Toast.makeText(getContext(), "代售点查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bcv_station_number_inquiry:
                Toast.makeText(getContext(), "车站车次查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bcv_sale_time_query:
                Toast.makeText(getContext(), "起售时间查询", Toast.LENGTH_SHORT).show();
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
