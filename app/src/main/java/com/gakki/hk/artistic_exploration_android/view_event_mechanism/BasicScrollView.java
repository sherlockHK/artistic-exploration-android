package com.gakki.hk.artistic_exploration_android.view_event_mechanism;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;


/**
 * Created by HK on 2017/6/7.
 * Email: kaihu1989@gmail.com.
 */

public class BasicScrollView extends View {
    private int mLastx;
    private int mLastY;

    public BasicScrollView(Context context) {
        super(context);
    }

    public BasicScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasicScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastx;
                int deltaY = y -mLastY;
                int translationX = (int) (getTranslationX() + deltaX);
                int translationY = (int) (getTranslationY() + deltaY);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(
                        ObjectAnimator.ofFloat(this, "translationX", translationX),
                        ObjectAnimator.ofFloat(this, "translationY", translationY)
                );
                animatorSet.setDuration(0).start();
                LogUtils.i("deltaY" + deltaX + "deltaY:" + deltaY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        mLastx = x;
        mLastY = y;
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
