package com.testapplication.login;

import com.testapplication.base.BaseModel;
import com.testapplication.base.CallBack;
import com.testapplication.bean.UserBean;

/**
 * @author mjkj
 * @description
 * @data 2018/12/25 17:32
 */
public class LoginModelImpl extends BaseModel {
    @Override
    public void login(String username, String password, final CallBack<String> userBeanCallBack) {
        if(username.equals("1234")&&password.equals("1234")){
            userBeanCallBack.onSuccess("yes");
        }else{
            userBeanCallBack.onFailure("no");
        }
    }

    @Override
    public void saveLoginstatus(UserBean userBean) {

    }
}
