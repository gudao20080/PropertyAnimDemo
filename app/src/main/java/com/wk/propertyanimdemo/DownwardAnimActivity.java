package com.wk.propertyanimdemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ViewAnimator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DownwardAnimActivity extends Activity {

    @BindView(R.id.iv_1)
    ImageView mIv1;
    @BindView(R.id.iv_2)
    ImageView mIv2;
    @BindView(R.id.iv_3)
    ImageView mIv3;
    @BindView(R.id.iv_4)
    ImageView mIv4;
    @BindView(R.id.iv_5)
    ImageView mIv5;
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downward_anim);
        ButterKnife.bind(this);

        mIv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandImages();
            }
        });
    }

    public void expandImages() {
        ObjectAnimator objectAnimator1 = new ObjectAnimator();
        objectAnimator1.setTarget(mIv1);
        objectAnimator1.setDuration(2500);
        objectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator1.setPropertyName("translationY");
        objectAnimator1.setFloatValues(0, 200f);
//        objectAnimator1.start();
       ObjectAnimator objectAnimator2 = new ObjectAnimator();
        objectAnimator2.setTarget(mIv2);
        objectAnimator2.setDuration(2000);
        objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator2.setPropertyName("translationY");
        objectAnimator2.setFloatValues(0, 400f);
//        objectAnimator2.start();
       ObjectAnimator objectAnimator3 = new ObjectAnimator();
        objectAnimator3.setTarget(mIv3);
        objectAnimator3.setDuration(1500);
        objectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator3.setPropertyName("translationY");
        objectAnimator3.setFloatValues(0, 600f);
//        objectAnimator3.start();
       ObjectAnimator objectAnimator4 = new ObjectAnimator();
        objectAnimator4.setTarget(mIv4);
        objectAnimator4.setDuration(1000);
        objectAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator4.setPropertyName("translationY");
        objectAnimator4.setFloatValues(0, 800f);
//        objectAnimator4.start();
       ObjectAnimator objectAnimator5 = new ObjectAnimator();
        objectAnimator5.setTarget(mIv5);
        objectAnimator5.setDuration(500);
        objectAnimator5.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator5.setPropertyName("translationY");
        objectAnimator5.setFloatValues(0, 1000f);

        objectAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float translationY = (float) animation.getAnimatedValue("translationY");
                Log.d(TAG, "onAnimationUpdate: " + translationY + " time: " + animation.getCurrentPlayTime());


            }
        });

        List<Animator> animators = new ArrayList<>();
        animators.add(objectAnimator1);
        animators.add(objectAnimator2);
        animators.add(objectAnimator3);
        animators.add(objectAnimator4);
        animators.add(objectAnimator5);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animators);
        animatorSet.start();
    }

    public void shrinkImages() {

    }
}
