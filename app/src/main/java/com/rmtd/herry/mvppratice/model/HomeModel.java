package com.rmtd.herry.mvppratice.model;

import com.rmtd.herry.mvppratice.bean.HomeBean;
import com.rmtd.herry.mvppratice.http.RetrofitHelper;

import retrofit2.Callback;

/**
 * Created by meloDu on 2017/1/11.
 */
public class HomeModel {
    public void getHomeData( Callback<HomeBean> callback) {
        RetrofitHelper.getInstance()
                .getService()
                .getHomeData().enqueue(callback);
    }

}
