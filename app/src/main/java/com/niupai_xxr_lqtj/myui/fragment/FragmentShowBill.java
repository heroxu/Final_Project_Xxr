package com.niupai_xxr_lqtj.myui.fragment;

import android.os.Bundle;

import com.niupai_xxr_lqtj.R;
import com.niupai_xxr_lqtj.base.BaseFragment;


/**
 * Created by xuxiarong on 2016/5/4.
 */
public class FragmentShowBill extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show_bill;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        init();

    }

    public static FragmentShowBill newInstance() {
        return new FragmentShowBill();
    }

    private void init() {
    }
}
