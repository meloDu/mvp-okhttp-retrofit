package com.rmtd.herry.mvppratice.http;

import com.rmtd.herry.mvppratice.bean.HomeBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by meloDu on 2017/1/11.
 * 定义接口
 */
public interface Api {
    @GET("/?cid=795033&uid=0&tms=20160627091106&sig=c6156d8324e49852&wssig=d8f59996d3c00f70&os_type=3&version=23&channel_name=qihoo&srv=2201")
    Call<HomeBean> getHomeData();

}
