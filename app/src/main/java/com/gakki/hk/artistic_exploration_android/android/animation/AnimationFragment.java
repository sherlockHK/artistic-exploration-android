package com.gakki.hk.artistic_exploration_android.android.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
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
    private Button propertyAnimationBtn;

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
        propertyAnimationBtn = (Button) view.findViewById(R.id.btn_property_animation);
        LinearLayout container = (LinearLayout) view.findViewById(R.id.ll_animation_container);
        demo1 = (ImageView) view.findViewById(R.id.iv_demo1);
        demo2 = (ImageView) view.findViewById(R.id.iv_demo2);
        demo3 = (ImageView) view.findViewById(R.id.iv_demo3);
        demo4 = (ImageView) view.findViewById(R.id.iv_demo4);
        viewAnimation.setOnClickListener(this);
        frameAnimation.setOnClickListener(this);
        propertyAnimationBtn.setOnClickListener(this);

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
        //1.属性动画：改变颜色
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(demo3, "backgroundColor", /*red*/0XFFFF8080, /*blue*/0xFF8080FF);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new ArgbEvaluator());  //设置Argb估值器
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();

        //2.属性动画（translationX/Y, rotationX/Y, scaleX/Y, alpha等等）
        AnimatorSet animatorSet = new AnimatorSet();
        //添加属性动画监听
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ToastUtils.showShort("onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ToastUtils.showShort("onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                ToastUtils.showShort("onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                ToastUtils.showShort("onAnimationRepeat");
            }
        });
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(demo4, "translationX", 0, 200, 0);
        //属性动画更新监听
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                LogUtils.i("getAnimatedValue:" + animation.getAnimatedValue());
                LogUtils.i("getAnimatedFraction:" + animation.getAnimatedFraction());
            }
        });
        animatorSet.playTogether(
                objectAnimator,  //位移
                ObjectAnimator.ofFloat(demo4, "rotationX", 0, 50,0),      //x轴旋转
                ObjectAnimator.ofFloat(demo4, "rotation", 0, 90,0),       //旋转
                ObjectAnimator.ofFloat(demo4, "scaleX", 0.5f, 1.5f, 1f),  //放大缩小
                ObjectAnimator.ofFloat(demo4, "alpha", 1f, 0.5f, 1f)      //透明度
        );
        animatorSet.setDuration(1000).start();

        //3.属性动画：改变button的width属性，但是button的setWidth方法不能真的改变width属性
        ObjectAnimator.ofInt(new ViewWrapper(propertyAnimationBtn), "width", SizeUtils.dp2px((360))).setDuration(1000).start();
    }

    private static class ViewWrapper{
        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public int getWidth(){
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width){
            ViewGroup.LayoutParams layoutParams = mTarget.getLayoutParams();
            layoutParams.width = width;
            mTarget.setLayoutParams(layoutParams);
        }
    }
}
