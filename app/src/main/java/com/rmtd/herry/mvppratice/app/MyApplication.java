package com.rmtd.herry.mvppratice.app;

import android.app.Application;

import com.rmtd.herry.mvppratice.exception.HandlerException;
import com.rmtd.herry.mvppratice.utils.ThreadPoolManger;

/**
 * Created by meloDu on 2017/1/11.
 */
public class MyApplication extends Application {
    private static MyApplication myapp;
    private HandlerException handlerException;
    public static ThreadPoolManger sThreadPoolManger;


    // 获取application实例
    public static MyApplication getInstance() {
        return myapp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myapp = this;
        handlerException = HandlerException.getInstance();
        handlerException.init(getApplicationContext());
        sThreadPoolManger = new ThreadPoolManger(ThreadPoolManger.Type.CachedThread);
//        sThreadPoolUtils.execute();
    }
}
