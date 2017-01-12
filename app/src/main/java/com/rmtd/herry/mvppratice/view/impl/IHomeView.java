package com.rmtd.herry.mvppratice.view.impl;

import com.rmtd.herry.mvppratice.bean.HomeBean;

/**
 * Created by meloDu on 2017/1/11.
 */
public interface IHomeView {
    void getHomeDataSuccess(HomeBean homeBean);
    void OnFail(String msg);
}
