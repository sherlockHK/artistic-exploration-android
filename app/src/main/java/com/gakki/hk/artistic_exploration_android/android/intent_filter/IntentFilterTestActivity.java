package com.gakki.hk.artistic_exploration_android.android.intent_filter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
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
        LogUtils.d("test","onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("test","onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("test","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("test","onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //锁屏和配置改变都会走onSaveInstanceState
        LogUtils.d("test","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.d("test","onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("test","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("test","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("test","onDestroy");
    }
}
