package com.testapplication.login;

import com.testapplication.base.BasePresenter;
import com.testapplication.base.BaseView;
import com.testapplication.base.CallBack;
import com.testapplication.bean.UserBean;

/**
 * @author mjkj
 * @description
 * @data 2018/12/25 17:09
 */
public interface LoginContact {
     interface Presenter{
         void login();
         void loginOut();
    }
     interface View extends BaseView{
        void loginsuccess();
        void loginfailed();
        void loginOutsuccess();
        void loginoutfailed();
    }
    interface model{
         void login(String username,String password,CallBack<String> stringCallBack);
         void saveLoginstatus(UserBean userBean);
    }
    interface StringCallBack{
         void success();
         void failed();
         void success(Object object);
         void success(String string);
    }
}
