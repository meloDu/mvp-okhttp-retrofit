package com.rmtd.herry.mvppratice.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by meloDu on 2017/1/11.
 * mainactivity的fragment管理类
 */
public class BottomTabManager implements RadioGroup.OnCheckedChangeListener {
    FragmentManager fm;
    RadioGroup rgs;
    List<Fragment> fragments = new ArrayList<>();
    private int containerId;

    private OnBottomTabSelectListener onBottomTabSelectListener;


    public BottomTabManager(List<Fragment> fragments, RadioGroup rgs, FragmentManager fm, int containerId) {
        this.rgs = rgs;
        this.fm = fm;
        this.fragments = fragments;
        this.containerId = containerId;
        rgs.setOnCheckedChangeListener(this);
        setCheckPosition(0);
        getFragmentTransaction().add(containerId,fragments.get(0)).commit();
    }

    public BottomTabManager(List<Fragment> fragments, RadioGroup rgs, FragmentManager fm, int containerId, OnBottomTabSelectListener onBottomTabSelectListener) {
        this(fragments, rgs, fm, containerId);
        this.onBottomTabSelectListener = onBottomTabSelectListener;
    }


    public BottomTabManager addFragment(Fragment fragment) {
        fragments.add(fragment);
        return this;
    }

    public void setCheckPosition(int position) {
        RadioButton rbtn = (RadioButton) rgs.getChildAt(position);
        rbtn.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //获得容器控件的所有子类
        for (int i = 0; i < group.getChildCount(); i++) {
            Fragment fragment = fragments.get(i);

            //如果被选中显示
            if (group.getChildAt(i).getId() == checkedId) {
                //fragment是否被添加
                if (!fragment.isAdded()) {
                    getFragmentTransaction().add(containerId, fragment).commit();
                }
                if (fragment.isHidden()) {
                    getFragmentTransaction().show(fragment).commit();
                }
                if (onBottomTabSelectListener != null) {
                    onBottomTabSelectListener.onBottomTabSelectListener(group, checkedId, i);
                }
            } else {
                //隐藏
                getFragmentTransaction().hide(fragment).commit();
            }

        }
    }

    private FragmentTransaction getFragmentTransaction()

    {
        FragmentTransaction ft = fm.beginTransaction();
        return ft;
    }

    public interface OnBottomTabSelectListener {
        void onBottomTabSelectListener(RadioGroup group, int checkedId, int index);

    }


}
