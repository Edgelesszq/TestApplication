package com.testapplication;

import android.os.Bundle;

import com.testapplication.base.BaseActivity;


public class MainActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
    }


}
