package com.testapplication.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.testapplication.R;
import com.testapplication.base.BaseActivity;

/**
 * @author mjkj
 * @description
 * @data 2018/12/27 11:01
 */
public class AnimationActivity extends BaseActivity implements View.OnClickListener{
    public Button mAlpha_btn,mScale_btn,mRotate_btn,mTranslate_btn;
    public ImageView mTest_img;
    public LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mAlpha_btn=findViewById(R.id.alpha_bth);
        mAlpha_btn.setOnClickListener(this);
        mScale_btn=findViewById(R.id.scale_btn);
        mScale_btn.setOnClickListener(this);
        mRotate_btn=findViewById(R.id.rotate_btn);
        mRotate_btn.setOnClickListener(this);
        mTranslate_btn=findViewById(R.id.translate_btn);
        mTranslate_btn.setOnClickListener(this);
        mTest_img=findViewById(R.id.test_img);
        linearLayout=findViewById(R.id.hide_linearLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alpha_bth:
                showAlphaAnimation(mTest_img);
                break;
            case R.id.rotate_btn:
                showRotateAnimation(mTest_img);
                break;
            case R.id.translate_btn:
                showTransfomation(mTest_img);
                break;
            case R.id.scale_btn:
                ShowScaleAnimation(mTest_img);
                break;
                default:
                    break;
        }
    }
    public void showRotateAnimation(final ImageView imageView){
        RotateAnimation rotateAnimation=new RotateAnimation(0, 360, 1, 0.2F, 1, 0.2F);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.setAnimation(rotateAnimation);
        imageView.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
        rotateAnimation.start();

    }
    public void showAlphaAnimation(final ImageView imageview){
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setRepeatMode(Animation.INFINITE);
        alphaAnimation.setFillAfter(true);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageview.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageview.setAnimation(alphaAnimation);
        imageview.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
        alphaAnimation.start();

    }
    public void showTransfomation(final ImageView imageView){
        TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_PARENT,20,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_PARENT,20);
        translateAnimation.setDuration(2000);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.setAnimation(translateAnimation);imageView.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);

        translateAnimation.start();
    }
    public void  ShowScaleAnimation(final ImageView imageView){
        ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.setAnimation(scaleAnimation);
        imageView.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
        scaleAnimation.start();
    }
}
