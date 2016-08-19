package com.fangyi.a12306.fragmengt.main;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;
import com.fangyi.a12306.utils.StartUtils;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fangyi.a12306.R.id.cb_passenger_student;

/**
 * Created by FANGYI on 2016/8/17.
 */

public class MainFragment extends BaseFragment {


    @BindView(R.id.btn_start_station)   //起始站
            TextView btnStartStation;
    @BindView(R.id.btn_exchange)        //交换
            ImageView btnExchange;
    @BindView(R.id.btn_arrived_station) //终点站
            TextView btnArrivedStation;

    @BindView(R.id.btn_start_date)      //出发日期
            TextView btnStartDate;
    @BindView(cb_passenger_student)//乘客-学生
            CheckBox cbPassengerStudent;
    @BindView(R.id.btn_start_time)      //出发时间
            TextView btnStartTime;
    @BindView(R.id.btn_seat)            //席别
            TextView btnSeat;

    //车次选择
    @BindView(R.id.cb_type_whole)
    CheckBox cbTypeWhole;
    @BindView(R.id.cb_type_GDC)
    CheckBox cbTypeGDC;
    @BindView(R.id.cb_type_Z)
    CheckBox cbTypeZ;
    @BindView(R.id.cb_type_T)
    CheckBox cbTypeT;
    @BindView(R.id.cb_type_K)
    CheckBox cbTypeK;
    @BindView(R.id.cb_type_other)
    CheckBox cbTypeOther;

    //乘客名单
    @BindView(R.id.btn_passenger_0)
    TextView btnPassenger0;
    @BindView(R.id.btn_passenger_1)
    TextView btnPassenger1;
    @BindView(R.id.btn_passenger_2)
    TextView btnPassenger2;
    @BindView(R.id.btn_passenger_3)
    TextView btnPassenger3;
    @BindView(R.id.btn_passenger_4)
    TextView btnPassenger4;

    @BindView(R.id.btn_regional_trips_query)//查询
            Button btnRegionalTripsQuery;

    private String startName;//起始站名字
    private String arriveName;//终点站名字
    private int timeNum = 0;
    private int seatNum = 0;
    private int sysYear;
    private int sysMonth;
    private int sysDay;
    int temY, temM, temD;//临时日期


    @Override
    protected View getSuccessView() {
        View view = View.inflate(getActivity(), R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        getSystemData();
        setInitView();
        setListener();
        return view;

    }


    /**
     * 点击列表
     */
    private void setListener() {
        btnStartStation.setOnClickListener(this);
        btnArrivedStation.setOnClickListener(this);
        btnExchange.setOnClickListener(this);

        btnStartDate.setOnClickListener(this);
        btnStartTime.setOnClickListener(this);
        btnSeat.setOnClickListener(this);
        cbPassengerStudent.setOnClickListener(this);

        cbTypeWhole.setOnClickListener(this);
        cbTypeGDC.setOnClickListener(this);
        cbTypeZ.setOnClickListener(this);
        cbTypeT.setOnClickListener(this);
        cbTypeK.setOnClickListener(this);
        cbTypeOther.setOnClickListener(this);

        btnPassenger0.setOnClickListener(this);
        btnPassenger1.setOnClickListener(this);
        btnPassenger2.setOnClickListener(this);
        btnPassenger3.setOnClickListener(this);
        btnPassenger4.setOnClickListener(this);

        btnRegionalTripsQuery.setOnClickListener(this);


    }

    /**
     * 获取服务器数据
     * @return
     */
    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 设置点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_start_station:
                StartUtils.startActivityById(getActivity(), R.id.btn_start_station);
                break;
            case R.id.btn_arrived_station:
                StartUtils.startActivityById(getActivity(), R.id.btn_arrived_station);
                break;
            case R.id.btn_exchange:
                setExchangeStation();
                break;

            case R.id.btn_start_date:
                setStratData();
                break;
            case R.id.btn_start_time:
                setStartTime();
                break;
            case R.id.cb_type_whole:
                setCheckBoxWhole();
                break;
            case R.id.cb_passenger_student:
                Toast.makeText(getContext(), "乘客是学生", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cb_type_GDC:
            case R.id.cb_type_Z:
            case R.id.cb_type_T:
            case R.id.cb_type_K:
            case R.id.cb_type_other:
                cbTypeWhole.setChecked(false);
                break;

            case R.id.btn_seat:
                setSeat();
                break;
            case R.id.btn_passenger_0:
                Toast.makeText(getContext(), "乘客1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_passenger_1:
                Toast.makeText(getContext(), "乘客2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_passenger_2:
                Toast.makeText(getContext(), "乘客3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_passenger_3:
                Toast.makeText(getContext(), "乘客4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_passenger_4:
                Toast.makeText(getContext(), "乘客5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_regional_trips_query:
                StartUtils.startActivityById(getActivity(), R.id.btn_regional_trips_query);
                break;
        }
    }



    /**
     * 车次复选框
     */
    private void setCheckBoxWhole() {

        if (cbTypeWhole.isChecked() == true) {
            cbTypeGDC.setChecked(false);
            cbTypeZ.setChecked(false);
            cbTypeT.setChecked(false);
            cbTypeK.setChecked(false);
            cbTypeOther.setChecked(false);
        }
    }



    /**
     * 设置席别
     */
    private void setSeat() {
        final String items[] = CommonUtils.getStringArray(R.array.seat_items);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setSingleChoiceItems(items, seatNum, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //1.保存
                //2.设置
                seatNum = which;
                btnSeat.setText(items[which].toString());
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(null, null);

        builder.show();
    }

    /**
     * 设置出发时间
     */
    private void setStartTime() {
        final String items[] = CommonUtils.getStringArray(R.array.start_time_items);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setSingleChoiceItems(items, timeNum, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //1.保存
                //2.设置
                timeNum = which;
                btnStartTime.setText(items[which].toString());
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(null, null);

        builder.show();
    }

    /**
     * 设置出发日期
     */
    private void setStratData() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final DatePicker picker = new DatePicker(getContext());

        picker.init(sysYear, sysMonth, sysDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                temY = year;
                temM = monthOfYear;
                temD = dayOfMonth;
            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sysYear = temY;
                sysMonth = temM;
                sysDay = temD;
                btnStartDate.setText(temY + "年" + (temM + 1) + "月" + temD + "日");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                temY = sysYear;
                temM = sysMonth;
                temD = sysDay;
            }
        });
        builder.setCancelable(false);
        builder.setView(picker);
        builder.show();
    }

    /**
     * 交换起始站和终点站
     */
    private void setExchangeStation() {
        startName = btnStartStation.getText().toString();
        arriveName = btnArrivedStation.getText().toString();

        btnStartStation.setText(arriveName);
        btnArrivedStation.setText(startName);
    }


    /**
     * 获取系统时间
     */
    private void getSystemData() {
        Calendar calendar = Calendar.getInstance();
        sysYear = calendar.get(Calendar.YEAR);
        sysMonth = calendar.get(Calendar.MONTH);
        sysDay = calendar.get(Calendar.DAY_OF_MONTH);

        temY = sysYear;
        temM = sysMonth;
        temD = sysDay;
    }

    /**
     * 初始化一些部件
     */
    private void setInitView() {
        cbTypeWhole.setChecked(true);
        btnStartDate.setText(sysYear + "年" + (sysMonth + 1) + "月" + sysDay + "日");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
