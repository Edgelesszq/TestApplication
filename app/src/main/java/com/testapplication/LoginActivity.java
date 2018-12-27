package com.testapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.testapplication.R;
import com.testapplication.base.BaseActivity;
import com.testapplication.login.LoginContact;
import com.testapplication.login.LoginModelImpl;
import com.testapplication.login.LoginPresenterImpl;
import com.vondear.rxtool.RxKeyboardTool;
import com.vondear.rxtool.view.RxToast;

/**
 * @author mjkj
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener,LoginContact.View{
    public LinearLayout mLogin_layout;
    public EditText mUsernameEdit,mPasswordEdit;
    public Button mButton;
    public LoginPresenterImpl loginPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext=this;
        init();
        loginPresenter=new LoginPresenterImpl();
        loginPresenter.attachView(this);
    }
    public void init(){
        mLogin_layout=findViewById(R.id.login_layout);
        mLogin_layout.requestFocus();
        mUsernameEdit=findViewById(R.id.login_edit_usernmae);
        mPasswordEdit=findViewById(R.id.login_edit_password);
        mButton=findViewById(R.id.login_btn_submit);
        mButton.setOnClickListener(this);
        mPasswordEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    RxKeyboardTool.showSoftInput(mContext,mPasswordEdit);
                }else{
                    RxKeyboardTool.hideSoftInput(mContext,mPasswordEdit);
                }
            }
        });
        mUsernameEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    RxKeyboardTool.showSoftInput(mContext,mUsernameEdit);
                }else{
                    RxKeyboardTool.hideSoftInput(mContext,mUsernameEdit);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn_submit:
                loginPresenter.login();
                break;
                default:
                    break;
        }
    }

    @Override
    public void loginsuccess() {
        RxToast.showToast("yes");
    }

    @Override
    public void loginfailed() {
        RxToast.showToast("faild");

    }

    @Override
    public void loginOutsuccess() {

    }

    @Override
    public void loginoutfailed() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }
}
