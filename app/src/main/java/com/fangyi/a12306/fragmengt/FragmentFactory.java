package com.fangyi.a12306.fragmengt;

import android.support.v4.app.Fragment;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.main.MainFragment;
import com.fangyi.a12306.fragmengt.main.imp.query.RegionFragment;
import com.fangyi.a12306.fragmengt.main.imp.station.StationSelectionFragment;
import com.fangyi.a12306.fragmengt.main.imp.station.imp.HotspotFragment;
import com.fangyi.a12306.fragmengt.main.imp.station.imp.LatelyFragment;
import com.fangyi.a12306.fragmengt.main.imp.station.imp.ListStationFragment;
import com.fangyi.a12306.fragmengt.me.MeFragment;
import com.fangyi.a12306.fragmengt.me.imp.AboutFragment;
import com.fangyi.a12306.fragmengt.me.imp.LoginFragment;
import com.fangyi.a12306.fragmengt.me.imp.RegisterFragment;
import com.fangyi.a12306.fragmengt.me.imp.SystemInformsFragment;
import com.fangyi.a12306.fragmengt.me.imp.TourismLeisureFragment;
import com.fangyi.a12306.fragmengt.me.imp.TripGuidanceFragment;
import com.fangyi.a12306.fragmengt.me.imp.WarmServiceFragment;
import com.fangyi.a12306.fragmengt.order.OrderFragment;
import com.fangyi.a12306.fragmengt.order.imp.com.CompletedOrderFragment;
import com.fangyi.a12306.fragmengt.order.imp.com.imp.HistoryFragment;
import com.fangyi.a12306.fragmengt.order.imp.com.imp.NotTravelFragment;
import com.fangyi.a12306.fragmengt.order.imp.com.imp.TodayFragment;
import com.fangyi.a12306.fragmengt.order.imp.incom.IncompleteOrderFragment;
import com.fangyi.a12306.fragmengt.order.imp.incom.imp.IncompleteOrderNumFragment;

/**
 * Created by FANGYI on 2016/8/17.
 */

public class FragmentFactory {

    /**
     * main
     *
     * @param position
     * @return
     */
    public static Fragment createForMain(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:// 车票预定
                fragment = new MainFragment();
                break;
            case 1:// 订单查询
                fragment = new OrderFragment();
                break;
            case 2:// 我的12306
                fragment = new MeFragment();
                break;
        }
        return fragment;
    }

    /**
     * 车票预订、订单查询、我的12306
     * @param resId
     * @return
     */
    public static Fragment createById(int resId) {
        Fragment fragment = null;
        switch (resId) {
            //车票预订
            case R.id.btn_start_station:// 车站选择
            case R.id.btn_arrived_station://车站选择
                fragment = new StationSelectionFragment();
                break;
            case R.id.btn_regional_trips_query://查询
                fragment = new RegionFragment();
                break;


            //订单查询
            case R.id.bcv_today://今日订单
                fragment = new TodayFragment();
                break;
            case R.id.bcv_not_travel://未出行订单
                fragment = new NotTravelFragment();
                break;
            case R.id.bcv_history://历史订单
                fragment = new HistoryFragment();
                break;
            case R.id.bcv_incomplete_order_num://未完成订单
                fragment = new IncompleteOrderNumFragment();
                break;

            //我的12306
            case R.id.bcv_login://登陆
                fragment = new LoginFragment();
                break;
            case R.id.bcv_register://注册
                fragment = new RegisterFragment();
                break;
            case R.id.bcv_trip_guidance://出行导向
                fragment = new TripGuidanceFragment();
                break;
            case R.id.bcv_warm_service://温馨服务
                fragment = new WarmServiceFragment();
                break;
            case R.id.bcv_tourism_leisure://旅行休闲
                fragment = new TourismLeisureFragment();
                break;
            case R.id.bcv_system_informs://系统通知
                fragment = new SystemInformsFragment();
                break;
            case R.id.bcv_about://关于
                fragment = new AboutFragment();
                break;
        }
        return fragment;
    }

    /**
     * 车站选择 Fragment
     * @param position
     * @return
     */
    public static Fragment createForStation(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:// 最近常用
                fragment = new LatelyFragment();
                break;

            case 1:// 热点车站
                fragment = new HotspotFragment();
                break;

            case 2:// 车站列表
                fragment = new ListStationFragment();
                break;
        }
        return fragment;
    }


    /**
     * 订单查询
     * @param position
     * @return
     */
    public static Fragment createForOrder(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:// 已完成订单
                fragment = new CompletedOrderFragment();
                break;

            case 1://未完成订单
                fragment = new IncompleteOrderFragment();
                break;
        }
        return fragment;
    }
}
