package com.gakki.hk.artistic_exploration_android.android.view_event_mechanism;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.gakki.hk.artistic_exploration_android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HK on 2017/6/12.
 * Email: kaihu1989@gmail.com.
 */

public class ScrollConflictActivity extends Activity {

    private ScrollView scrollView;
    private ListView listview;
    private boolean isScrolledToBottom;
    private float mLastY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_conflict);

        scrollView = (ScrollView) findViewById(R.id.sv_out_scroll_view);
        listview = (ListView) findViewById(R.id.lv_inner_scroll_view);

        List<Map<String, String>> mData = getListData();
        String[] from = {"left", "right"};
        int[] to = {R.id.tv_left, R.id.tv_right};
        listview.setAdapter(new SimpleAdapter(this, mData, R.layout.item_inner_scroll_view, from, to));

        resolveScrollConflict();
    }

    /**
     * 解决scrollview嵌套listview滑动冲突
     * 在scrollview滑到底部且listview未滑动到顶部，禁止scrollview截止滑动事件
     * */
    private void resolveScrollConflict() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//                @Override
//                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                    //scrollview滑动到了底部
//                    int realViewHeight = scrollView.getChildAt(0).getMeasuredHeight();
//                    isScrolledToBottom = scrollY + scrollView.getHeight() >= realViewHeight;
//                }
//            });
//        }

        listview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                if (action == MotionEvent.ACTION_DOWN){
                    mLastY = event.getY();
                }
                if (action == MotionEvent.ACTION_MOVE){
                    int top = listview.getChildAt(0).getTop();
                    float nowY = event.getY();
                    if (!isScrollToBottom()){
                        //scrollview未滑倒底部，拦截触摸事件
                        scrollView.requestDisallowInterceptTouchEvent(false);
                    }else if (/*top == 0 && */ nowY - mLastY > 0 && !ViewCompat.canScrollVertically(listview, -1)){
                        //scrollview滑到底部且listview在顶部，继续向下滑动，则拦截事件
                        scrollView.requestDisallowInterceptTouchEvent(false);
                    }else {
                        scrollView.requestDisallowInterceptTouchEvent(true);
                    }
                }
                return false;
            }
        });
    }

    private boolean isScrollToBottom(){
        return !ViewCompat.canScrollVertically(scrollView, 1);
    }

    @NonNull
    private List<Map<String, String>> getListData() {
        List<Map<String, String>> mData = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("left", "1");
        map1.put("right", "aaaaaaa");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("left", "2");
        map2.put("right", "bbbbbbb");
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("left", "3");
        map3.put("right", "ccccccc");
        HashMap<String, String> map4 = new HashMap<>();
        map4.put("left", "4");
        map4.put("right", "dddddddd");
        HashMap<String, String> map5 = new HashMap<>();
        map5.put("left", "5");
        map5.put("right", "eeeeeeeee");
        HashMap<String, String> map6 = new HashMap<>();
        map6.put("left", "6");
        map6.put("right", "fffffff");
        HashMap<String, String> map7 = new HashMap<>();
        map7.put("left", "7");
        map7.put("right", "gggggggg");
        mData.add(map1);
        mData.add(map2);
        mData.add(map3);
        mData.add(map4);
        mData.add(map5);
        mData.add(map6);
        mData.add(map7);
        return mData;
    }
}
