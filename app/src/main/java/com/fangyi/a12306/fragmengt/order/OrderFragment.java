package com.fangyi.a12306.fragmengt.order;

import android.support.v4.app.Fragment;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.FragmentFactory;
import com.fangyi.a12306.fragmengt.base.BasePagerFragment;
import com.fangyi.a12306.utils.CommonUtils;

/**
 * Created by FANGYI on 2016/8/17.
 */

public class OrderFragment extends BasePagerFragment {


    @Override
    protected Fragment setFragment(int position) {
        return FragmentFactory.createForOrder(position);
    }

    @Override
    protected String[] setTitles() {
        return CommonUtils.getStringArray(R.array.order_inquiry);
    }

    @Override
    protected void setActionBar() {
        //不写
    }
}
