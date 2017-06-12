package com.gakki.hk.artistic_exploration_android.view_event_mechanism;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/6/7.
 * Email: kaihu1989@gmail.com.
 */

public class BasicScrollActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_basic_scroll);
    }
}
