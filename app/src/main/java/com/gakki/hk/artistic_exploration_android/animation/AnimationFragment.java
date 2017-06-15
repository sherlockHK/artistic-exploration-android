package com.gakki.hk.artistic_exploration_android.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.utils.ToastUtils;
import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/6/15.
 * Email: kaihu1989@gmail.com.
 */

public class AnimationFragment extends Fragment implements View.OnClickListener {

    private ImageView demo1;
    private ImageView demo2;
    private ImageView demo3;
    private ImageView demo4;

    public static AnimationFragment newInstance() {
        return new AnimationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animation, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button viewAnimation = (Button) view.findViewById(R.id.btn_view_animation);
        Button frameAnimation = (Button) view.findViewById(R.id.btn_frame_animation);
        Button propertyAnimation = (Button) view.findViewById(R.id.btn_property_animation);
        LinearLayout container = (LinearLayout) view.findViewById(R.id.ll_animation_container);
        demo1 = (ImageView) view.findViewById(R.id.iv_demo1);
        demo2 = (ImageView) view.findViewById(R.id.iv_demo2);
        demo3 = (ImageView) view.findViewById(R.id.iv_demo3);
        demo4 = (ImageView) view.findViewById(R.id.iv_demo4);
        viewAnimation.setOnClickListener(this);
        frameAnimation.setOnClickListener(this);
        propertyAnimation.setOnClickListener(this);

        //设置layoutAnimation
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_item);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        controller.setInterpolator(new AccelerateDecelerateInterpolator());
        container.setLayoutAnimation(controller);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_animation:
                //view动画
                viewAnimation();
                break;
            case R.id.btn_frame_animation:
                //帧动画
                frameAnimation();
                break;
            case R.id.btn_property_animation:
                //属性动画
                propertyAnimation();
                break;
        }
    }

    private void frameAnimation() {
        demo2.setBackgroundResource(R.drawable.frame_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) demo2.getBackground();
        animationDrawable.start();
    }

    private void viewAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.view_animation);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        demo1.startAnimation(animation);
    }

    private void propertyAnimation() {
        ObjectAnimator.ofFloat(demo3, "translationX", demo3.getWidth()).start();
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(demo3, "backgroundColor", /*red*/0XFFFF8080, /*blue*/0xFF8080FF);
        valueAnimator.setDuration(3000);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();

        AnimatorSet animatorSet = new AnimatorSet();
        //添加属性动画监听
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ToastUtils.showShortToast(getContext(), "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ToastUtils.showShortToast(getContext(), "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                ToastUtils.showShortToast(getContext(), "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                ToastUtils.showShortToast(getContext(), "onAnimationRepeat");
            }
        });


        animatorSet.playSequentially(
                ObjectAnimator.ofFloat(demo4, "translationX", 0, 100,0),
                ObjectAnimator.ofFloat(demo4, "rotationX", 0, 50,0),
                ObjectAnimator.ofFloat(demo4, "rotation", 0, 90,0),
                ObjectAnimator.ofFloat(demo4, "scaleX", 0.8f, 1.2f, 1f),
                ObjectAnimator.ofFloat(demo4, "alpha", 1f, 0.5f, 1f)
        );
        animatorSet.setDuration(1000).start();

    }
}
