package com.fangyi.a12306.fragmengt.me.imp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.base.BaseFragment;
import com.fangyi.a12306.utils.CommonUtils;
import com.fangyi.a12306.view.BtnRadioView;
import com.fangyi.a12306.view.TvEtView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fangyi.a12306.R.id.br_reg_passenger_type;

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
    @BindView(R.id.br_reg_id_type)
    BtnRadioView brRegIdType;
    @BindView(R.id.evet_reg_id_num)
    TvEtView evetRegIdNum;
    @BindView(R.id.evet_reg_phone_number)
    TvEtView evetRegPhoneNumber;
    @BindView(R.id.evet_reg_mail)
    TvEtView evetRegMail;
    @BindView(br_reg_passenger_type)
    BtnRadioView brRegPassengerType;
    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_agreement)
    TextView btnAgreement;


    @BindView(R.id.br_reg_id_sex)
    BtnRadioView brRegIdSex;
    @BindView(R.id.br_reg_id_birth_date)
    BtnRadioView brRegIdBirthDate;
    @BindView(R.id.br_reg_id_country)
    BtnRadioView brRegIdCountry;
    @BindView(R.id.ll_reg_country)
    LinearLayout llRegCountry;
    @BindView(R.id.ll_reg_other)
    LinearLayout llRegOther;

    private int idTypeNum = 0;
    private int passengerTypeNum = 0;
    private int sexTypeNum = 0;

    @Override
    protected View getSuccessView() {
        CommonUtils.setTitle(getActivity(), "注册");
        View view = View.inflate(getActivity(), R.layout.fragment_me_register, null);
        ButterKnife.bind(this, view);
        getSystemData();
        setTvEtTitle();
        setListener();
        return view;
    }

    private void setTvEtTitle() {
        evetRegUsername.setTitle("用  户  名");
        evetRegUsername.setHint("字母、数字或“_”，6-30位");
        evetRegPassword.setTitle("密       码");
        evetRegPassword.setHint("不少于6位");
        evetRegPasswordConfirm.setTitle("密码确认");
        evetRegPasswordConfirm.setHint("请在此输入密码");
        evetRegIdName.setTitle("姓       名");
        evetRegIdName.setHint("请输入真实姓名,以便购票");
        brRegIdType.setTitle("证件类型");
        brRegIdType.setContent("二代身份证");
        evetRegIdNum.setTitle("证件号码");
        evetRegIdNum.setHint("请准确完整填写");
        evetRegPhoneNumber.setTitle("手机号码");
        evetRegPhoneNumber.setHint("请准确填写您的手机号");
        evetRegMail.setTitle("电子邮件");
        evetRegMail.setHint("请准确填写您的邮箱地址");
        brRegIdSex.setTitle("姓       别");
        brRegIdSex.setContent("男");
        brRegIdBirthDate.setTitle("出生日期");
        brRegIdBirthDate.setContent("1900-01-01");
        brRegIdCountry.setTitle("国家地区");
        brRegIdCountry.setContent("中国CHINA");
        brRegPassengerType.setTitle("旅客类型");
        brRegPassengerType.setContent("成人");
    }

    private void setListener() {
        brRegIdType.setOnClickListener(this);
        brRegIdSex.setOnClickListener(this);
        brRegIdBirthDate.setOnClickListener(this);
        brRegIdCountry.setOnClickListener(this);

        brRegPassengerType.setOnClickListener(this);
        btnAgreement.setOnClickListener(this);

    }

    @Override
    protected Object requestData() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.br_reg_id_type:
                setIdType();
                break;
            case R.id.br_reg_id_sex:
                setIdSex();
                break;
            case R.id.br_reg_id_birth_date:
                setIdBirthDate();
                break;
            case R.id.br_reg_id_country:
                setIdCountry();
                break;


            case br_reg_passenger_type:
                setPassengerType();
                break;
            case R.id.btn_agreement:
                Toast.makeText(getContext(), "服务条款", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //设置国家
    private void setIdCountry() {
        Toast.makeText(getContext(), "选择护照", Toast.LENGTH_SHORT).show();

    }

    private int sysYear;
    private int sysMonth;
    private int sysDay;
    int temY, temM, temD;//临时日期

    //设置年龄
    private void setIdBirthDate() {
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
                brRegIdBirthDate.setContent(temY + "-" + (temM + 1) + "-" + temD);
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

    //设置性别
    private void setIdSex() {
        final String items[] = CommonUtils.getStringArray(R.array.id_sex);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setSingleChoiceItems(items, sexTypeNum, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //1.保存
                //2.设置
                sexTypeNum = which;
                brRegPassengerType.setContent(items[which].toString());
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(null, null);

        builder.show();
    }

    //设置旅客类型
    private void setPassengerType() {
        final String items[] = CommonUtils.getStringArray(R.array.passenger_type);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setSingleChoiceItems(items, passengerTypeNum, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //1.保存
                //2.设置
                passengerTypeNum = which;
                brRegPassengerType.setContent(items[which].toString());
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(null, null);

        builder.show();
    }

    //设置证件类型
    private void setIdType() {
        final String items[] = CommonUtils.getStringArray(R.array.id_type);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setSingleChoiceItems(items, idTypeNum, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //1.保存
                //2.设置
                idTypeNum = which;

                if (which != 0) {
                    getSystemData();
                    llRegOther.setVisibility(View.VISIBLE);
                    llRegCountry.setVisibility(View.GONE);
                    brRegIdBirthDate.setContent(sysYear + "-" + (sysMonth + 1) + "-" + sysDay);
                }

                if (which == 3) {
                    getSystemData();
                    llRegOther.setVisibility(View.VISIBLE);
                    llRegCountry.setVisibility(View.VISIBLE);
                }

                brRegIdType.setContent(items[which].toString());
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(null, null);

        builder.show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
