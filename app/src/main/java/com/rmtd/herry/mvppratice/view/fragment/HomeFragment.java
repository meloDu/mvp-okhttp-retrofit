package com.rmtd.herry.mvppratice.view.fragment;

import android.os.Bundle;

import com.rmtd.herry.mvppratice.R;
import com.rmtd.herry.mvppratice.base.BaseFragment;
import com.rmtd.herry.mvppratice.bean.HomeBean;
import com.rmtd.herry.mvppratice.presenter.HomePresenter;
import com.rmtd.herry.mvppratice.view.impl.IHomeView;

/**
 * Created by meloDu on 2017/1/11.
 */
public class HomeFragment extends BaseFragment<IHomeView, HomePresenter> implements IHomeView {
    private HomePresenter homePresenter;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public HomePresenter initPresenter() {
        homePresenter = new HomePresenter(this);
        return homePresenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        //访问数据
//        homePresenter.getHomeData();

    }

    @Override
    protected void initView() {
        //UI布局

    }

    @Override
    public void getHomeDataSuccess(HomeBean homeBean) {
        //拿到json数据

    }

    @Override
    public void OnFail(String msg) {

    }
}
