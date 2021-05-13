package com.gakki.hk.artistic_exploration_android.android.thread_and_threadPool;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.LogUtils;
import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/6/22.
 * Email: kaihu1989@gmail.com.
 */

public class IntentServiceActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        Button btn = (Button) findViewById(R.id.btn_intent_service);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MyIntentService.class);
        //启动3个IntentService后台任务，串行执行，执行完自动stop
        intent.putExtra("key", "task1");
        startService(intent);
        intent.putExtra("key", "task2");
        startService(intent);
        intent.putExtra("key", "task3");
        startService(intent);
    }

    public static class MyIntentService extends IntentService{
        public MyIntentService() {
            super("MyIntentService");
        }

        @Override
        protected void onHandleIntent(@Nullable Intent intent) {
            Bundle extras = intent.getExtras();
            String task = extras.getString("key");

            LogUtils.i("receive intent: " +task);
            if ("task2".equals(task)){
                LogUtils.i("handle intent: " + task);
            }

            //模拟耗时任务
            SystemClock.sleep(2000);
        }

        @Override
        public void onDestroy() {
            LogUtils.i("IntentService onDestroy");
            super.onDestroy();
        }
    }
}
