package com.gakki.hk.artistic_exploration_android.android.view_theory;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.blankj.utilcode.util.SizeUtils;
import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/6/14.
 * Email: kaihu1989@gmail.com.
 * 1.继承view，重写onDraw()
 */

public class CircleView extends View {
    private Context context;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context) {
        super(context);
        init(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs){
        this.context = context;

        int color = context.getResources().getColor(R.color.colorPrimary);
        if (attrs != null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
            color = typedArray.getColor(R.styleable.CircleView_circleColor, color);
            typedArray.recycle();
        }
        mPaint.setColor(color);

    }

    /**
     * 对wrap_content（即MeasureSpec.AT_MOST）做特殊处理，否则wrap_content和match_parent(MeasureSpec.EXACTLY)效果一样
     * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int wrapContentWidth = SizeUtils.dp2px(100f);
        int wrapContentHeight = SizeUtils.dp2px(100f);
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(wrapContentWidth, wrapContentHeight);
        }else if (widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(wrapContentWidth, heightSize);
        }else if (heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize, wrapContentHeight);
        }
    }

    /**
     * 对padding做特殊处理，否则不生效
     * */
    @Override
    protected void onDraw(Canvas canvas) {
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft -paddingRight;
        int height = getHeight() - paddingTop -paddingBottom;
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(paddingLeft + width/2 ,paddingTop + height/2, radius, mPaint);
    }
}
