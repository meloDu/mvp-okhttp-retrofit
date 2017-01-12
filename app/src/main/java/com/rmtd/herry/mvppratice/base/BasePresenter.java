package com.rmtd.herry.mvppratice.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by meloDu on 2017/1/11.
 *
 */
public class BasePresenter<IV> {
    private Reference<IV> view;

    public void attachView(IV v) {
        view = new WeakReference<>(v);
    }

    public IV getView() {
        return view.get();
    }


    public boolean isAdd() {
        return view != null && view.get() != null;
    }

    public void detachView() {
        if (view != null) {
            view.clear();
            view = null;
        }
    }
}
