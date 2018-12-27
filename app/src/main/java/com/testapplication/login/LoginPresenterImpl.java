package com.testapplication.login;

import com.testapplication.base.BasePresenter;
import com.testapplication.base.CallBack;
import com.testapplication.base.DataModel;
import com.testapplication.base.ModelToken;
import com.vondear.rxtool.RxNetTool;

/**
 * @author mjkj
 * @description
 * @data 2018/12/25 17:14
 */
public class LoginPresenterImpl extends BasePresenter<LoginContact.View> implements LoginContact.Presenter {




    @Override
    public void login() {
        DataModel.request(ModelToken.API_USER_DATA).login("1234", "1234", new CallBack<String>() {
            @Override
            public void onSuccess(String data) {
                if(isViewAttached()){
                    getView().loginsuccess();

                }
            }

            @Override
            public void onFailure(String msg) {
                if(isViewAttached()){
                    getView().loginfailed();

                }
            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void loginOut() {

    }
}
