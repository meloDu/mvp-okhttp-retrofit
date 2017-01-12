package com.rmtd.herry.mvppratice.view;

import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.rmtd.herry.mvppratice.R;
import com.rmtd.herry.mvppratice.base.BaseActivity;
import com.rmtd.herry.mvppratice.utils.BottomTabManager;
import com.rmtd.herry.mvppratice.view.fragment.HomeFragment;

import java.util.ArrayList;

import butterknife.Bind;

//控制主页，two，three，four四个fragment的切换
public class MainActivity extends BaseActivity implements BottomTabManager.OnBottomTabSelectListener {
    private static final String TAG = "MainActivity";
    public static final int CHECK_HOME_INDEX = 0;
    @Bind(R.id.radiogroup_bottom)
    RadioGroup mRadiogroupBottom;

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        new BottomTabManager(
                fragments,
                mRadiogroupBottom,
                getSupportFragmentManager(),
                R.id.layout_content
                , this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onBottomTabSelectListener(RadioGroup group, int checkedId, int index) {
        switch (index) {
            case CHECK_HOME_INDEX:
                break;
        }
    }

}
