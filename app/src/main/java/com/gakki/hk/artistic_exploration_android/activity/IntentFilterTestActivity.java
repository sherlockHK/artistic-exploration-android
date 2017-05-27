package com.gakki.hk.artistic_exploration_android.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/5/27.
 * Email: kaihu1989@gmail.com.
 */

public class IntentFilterTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(View.inflate(this, R.layout.activity_test, null));
    }
}
