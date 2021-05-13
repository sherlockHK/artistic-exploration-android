package com.gakki.hk.artistic_exploration_android.android.thread_and_threadPool;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/6/22.
 * Email: kaihu1989@gmail.com.
 */

public class HandlerThreadActivity extends Activity implements View.OnClickListener {

    private HandlerThread mHandlerThread;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hander_thread);
        Button btn1 = (Button) findViewById(R.id.btn_send_main_thread);
        Button btn2 = (Button) findViewById(R.id.btn_send_sub_thread);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        initThreadAndHandler();
    }

    private void initThreadAndHandler() {
        mHandlerThread = new HandlerThread("handler thread");
        //开启一个handler thread线程
        mHandlerThread.start();

        //传入handlerThread的looper
        handler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                //运行在handlerThread线程中
                ToastUtils.showShort( "handleMessage" + "msg: " + msg.what + "运行在线程:" + Thread.currentThread().getName());
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_main_thread:
                //在主线程发送消息
                handler.sendEmptyMessage(1);
                break;
            case R.id.btn_send_sub_thread:
                //在子线程发送消息
                new Thread(){
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(2);
                    }
                }.start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mHandlerThread.quit();
        super.onDestroy();
    }
}
