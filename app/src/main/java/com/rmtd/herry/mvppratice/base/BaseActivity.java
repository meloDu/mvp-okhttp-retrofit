package com.rmtd.herry.mvppratice.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by meloDu on 2017/1/11.
 * 初始化UI
 * 加载数据
 * 给控件赋值
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(getLayoutId());
            ButterKnife.bind(this);
            init();
        }
    }

    public final void init() {
        initView();
        initData();
    }

    public abstract void initData();

    public abstract void initView();

    public abstract int getLayoutId();
}
