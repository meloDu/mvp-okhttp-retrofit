package com.rmtd.herry.mvppratice.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by meloDu on 2017/1/11.
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    public T presenter;
    public static final String FRAGMENT_OUT_STATE = "outState";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attachView((V) this);
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(FRAGMENT_OUT_STATE)) {
                getFragmentManager().beginTransaction().show(this).commit();
            } else {
                getFragmentManager().beginTransaction().hide(this).commit();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(FRAGMENT_OUT_STATE, isVisible());
    }

    public abstract T initPresenter();

    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }



    public final void init() {
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }
}
