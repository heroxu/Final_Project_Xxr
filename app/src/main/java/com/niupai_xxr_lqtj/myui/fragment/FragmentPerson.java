package com.niupai_xxr_lqtj.myui.fragment;

import android.os.Bundle;

import com.niupai_xxr_lqtj.R;
import com.niupai_xxr_lqtj.base.BaseFragment;


/**
 * Created by xuxiarong on 2016/5/4.
 */
public class FragmentPerson extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        init();

    }

    public static FragmentPerson newInstance() {
        return new FragmentPerson();
    }

    private void init() {
    }

}
