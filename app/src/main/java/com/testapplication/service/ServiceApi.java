package com.testapplication.service;

import com.testapplication.bean.UserBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author mjkj
 * @description
 * @data 2018/12/26 15:01
 */
public interface ServiceApi {
    @GET("top250")
    Observable<UserBean> getTop250(@Query("start") int start,@Query("count") int count);

}
