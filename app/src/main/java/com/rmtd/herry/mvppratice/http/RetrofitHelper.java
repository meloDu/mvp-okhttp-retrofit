package com.rmtd.herry.mvppratice.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by meloDu on 2017/1/11.
 * 定义retrofit类
 */
public class RetrofitHelper {
    private static volatile RetrofitHelper instance = null;

    private RetrofitHelper() {

    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitHelper.class) {
                if (instance == null) {
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }
    public Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(UrlConfig.RequestUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build();
    }

    public Api getService() {
        Retrofit retrofit = createRetrofit();
        Api apiService = retrofit.create(Api.class);
        return apiService;
    }

    /**
     * @return
     */
    public Gson createGson() {
        return new GsonBuilder()
                .serializeNulls()
                .enableComplexMapKeySerialization()
//                .setDateFormat("")
                .create();
    }

    public OkHttpClient createHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        return client;


    }

}
