package com.testapplication.login;

import com.testapplication.base.DataModel;
import com.testapplication.base.ModelToken;
import com.testapplication.base.ObjectLoader;
import com.testapplication.service.RetrofitServiceManager;
import com.testapplication.service.ServiceApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author mjkj
 * @description
 * @data 2018/12/27 14:43
 */
public class LoginLoader extends ObjectLoader{

    @Override
    protected <T> Observable<T> getTop250(Observable<T> observable) {
        return (Observable<T>) RetrofitServiceManager.getsingleton().getservice(ServiceApi.class).getTop250(1,200)
                .observeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
