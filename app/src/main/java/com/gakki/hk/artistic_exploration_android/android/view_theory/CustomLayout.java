package com.gakki.hk.artistic_exploration_android.android.view_theory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HK on 2017/6/14.
 * Email: kaihu1989@gmail.com.
 * 自定义布局：子view分别layout在东西南北
 */

public class CustomLayout extends ViewGroup {
    public CustomLayout(Context context) {
        super(context);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //子view自己measure
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();

        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < childCount; i++) {
            int childLeft = 0;
            int childTop = 0;
            int childRight;
            int childBottom;
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (i == 0) {
                childLeft = (width - childWidth) / 2;
                childTop = 0;
            }

            if (i == 1) {
                childLeft = width - childWidth;
                childTop = (height - childHeight) / 2;

            }
            if (i == 2) {
                childLeft = (width - childWidth) / 2;
                childTop = height - childHeight;
            }

            if (i == 3){
                childLeft = 0;
                childTop = (height - childHeight) /2;
            }

            childRight = childLeft + childWidth;
            childBottom = childTop + childHeight;

            child.layout(childLeft, childTop, childRight, childBottom);
        }
    }
}
