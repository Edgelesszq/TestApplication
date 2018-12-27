package com.testapplication.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author mjkj
 * @description
 * @data 2018/12/26 16:31
 */
public class RetrofitServiceManager {
    private static final int DEFAULT_TIME_OUT = 5;
    //超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    //读取超出时间
    private Retrofit mRetrofit;


    public RetrofitServiceManager() {
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);
        HttpCommonInterceptor interceptor=new HttpCommonInterceptor.Builder().build();
        builder.addInterceptor(interceptor);
        mRetrofit=new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
    }
    public static class RetrofitHolder{
        public static final RetrofitServiceManager retrofitServiceManager=new RetrofitServiceManager();
    }
    public static RetrofitServiceManager getsingleton(){
        return RetrofitHolder.retrofitServiceManager;
    }

    public <T> T getservice(Class<T> service){
            return mRetrofit.create(service);
    }
}
