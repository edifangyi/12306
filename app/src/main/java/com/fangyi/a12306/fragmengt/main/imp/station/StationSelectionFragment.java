package com.fangyi.a12306.fragmengt.main.imp.station;

import android.support.v4.app.Fragment;

import com.fangyi.a12306.R;
import com.fangyi.a12306.fragmengt.FragmentFactory;
import com.fangyi.a12306.fragmengt.base.BasePagerFragment;
import com.fangyi.a12306.utils.CommonUtils;

/**
 * Created by FANGYI on 2016/8/17.
 */

public class StationSelectionFragment extends BasePagerFragment {
    @Override
    protected Fragment setFragment(int position) {
        return FragmentFactory.createForStation(position);
    }


    @Override
    protected String[] setTitles() {
        return CommonUtils.getStringArray(R.array.station_selection);
    }

    @Override
    protected void setActionBar() {
        CommonUtils.setTitle(getActivity(), "车站选择");
    }
}
