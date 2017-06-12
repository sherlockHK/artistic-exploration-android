package com.gakki.hk.artistic_exploration_android.view_event_mechanism;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ListView;
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

    private ScrollConflictHorizonalView outScrollView;
    private ListView innerScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_conflict);

//        outScrollView = (ScrollConflictHorizonalView) findViewById(R.id.sv_out_scroll_view);
        innerScrollView = (ListView) findViewById(R.id.lv_inner_scroll_view);

        List<Map<String, String>> mData = getListData();
        String[] from = {"left", "right"};
        int[] to = {R.id.tv_left, R.id.tv_right};
        innerScrollView.setAdapter(new SimpleAdapter(this, mData, R.layout.item_inner_scroll_view, from, to));
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
        mData.add(map1);
        mData.add(map2);
        mData.add(map3);
        mData.add(map4);
        mData.add(map5);
        return mData;
    }
}
