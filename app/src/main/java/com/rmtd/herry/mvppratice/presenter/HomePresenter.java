package com.rmtd.herry.mvppratice.presenter;

import com.rmtd.herry.mvppratice.base.BasePresenter;
import com.rmtd.herry.mvppratice.bean.HomeBean;
import com.rmtd.herry.mvppratice.model.HomeModel;
import com.rmtd.herry.mvppratice.view.impl.IHomeView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by meloDu on 2017/1/11.
 */
public class HomePresenter extends BasePresenter<IHomeView> {
    private HomeModel mHomeModel;
    private IHomeView mIHomeView;

    public HomePresenter(IHomeView mIHomeView) {
        this.mIHomeView = mIHomeView;
        mHomeModel = new HomeModel();
    }

    public void getHomeData() {
        mHomeModel.getHomeData(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                if (response.isSuccessful()) {
                    HomeBean homeBean = response.body();
                    if (homeBean != null) {
                        mIHomeView.getHomeDataSuccess(homeBean);
                    } else {
                        mIHomeView.OnFail("err");
                    }

                }
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                mIHomeView.OnFail("err");
            }
        });
    }
}
