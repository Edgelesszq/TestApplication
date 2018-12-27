package com.testapplication.base;

/**
 * @author mjkj
 * @description
 * @data 2018/12/26 17:18
 */

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 *
 * 将一些重复的操作提出来，放到父类以免Loader 里每个接口都有重复代码
 * Created by zhouwei on 16/11/10.
 *
 */
public abstract class ObjectLoader {
    /**
     *
     * @param observable
     * @param <T>
     * @return
     */
    protected abstract   <T> Observable<T> getTop250(Observable<T> observable);
}


