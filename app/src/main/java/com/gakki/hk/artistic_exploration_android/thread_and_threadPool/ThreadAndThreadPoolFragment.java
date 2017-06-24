package com.gakki.hk.artistic_exploration_android.thread_and_threadPool;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.blankj.utilcode.utils.LogUtils;
import com.blankj.utilcode.utils.TimeUtils;
import com.gakki.hk.artistic_exploration_android.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ThreadAndThreadPoolFragment extends Fragment implements View.OnClickListener {


    private Runnable mRunnable1;
    private Runnable mRunnable2;
    private Runnable mRunnable3;
    private Runnable mRunnable4;

    public static ThreadAndThreadPoolFragment newInstance() {
        return new ThreadAndThreadPoolFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thread_and_thread_pool, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button asyncBtn = (Button) view.findViewById(R.id.btn_async_task);
        Button handlerThreadBtn = (Button) view.findViewById(R.id.btn_handler_thread);
        Button intentServiceBtn = (Button) view.findViewById(R.id.btn_intent_service);
        Button threadPool = (Button) view.findViewById(R.id.btn_thread_pool);
        asyncBtn.setOnClickListener(this);
        handlerThreadBtn.setOnClickListener(this);
        intentServiceBtn.setOnClickListener(this);
        threadPool.setOnClickListener(this);

        init();
    }

    private void init() {
        mRunnable1 = new Runnable() {
            @Override
            public void run() {
                LogUtils.i("fixedThreadPool execute: " + TimeUtils.getCurTimeString());
                SystemClock.sleep(3000);
            }
        };
        mRunnable2 = new Runnable() {
            @Override
            public void run() {
                LogUtils.i("cachedThreadPool execute: " + TimeUtils.getCurTimeString());
                SystemClock.sleep(3000);
            }
        };
        mRunnable3 = new Runnable() {
            @Override
            public void run() {
                LogUtils.i("scheduledExecutorService execute: " + TimeUtils.getCurTimeString());
                SystemClock.sleep(0);
            }
        };
        mRunnable4 = new Runnable() {
            @Override
            public void run() {
                LogUtils.i("singleThreadExecutor execute: " + TimeUtils.getCurTimeString());
                SystemClock.sleep(3000);
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_async_task:
                startActivity(new Intent(getActivity(), AsyncTaskActivity.class));
                break;
            case R.id.btn_handler_thread:
                startActivity(new Intent(getActivity(), HandlerThreadActivity.class));
                break;
            case R.id.btn_intent_service:
                startActivity(new Intent(getActivity(), IntentServiceActivity.class));
                break;
            case R.id.btn_thread_pool:
                ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
                fixedThreadPool.execute(mRunnable1);
                fixedThreadPool.execute(mRunnable1);
                fixedThreadPool.execute(mRunnable1);
                fixedThreadPool.execute(mRunnable1);
                fixedThreadPool.execute(mRunnable1);

                ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
                cachedThreadPool.execute(mRunnable2);
                cachedThreadPool.execute(mRunnable2);
                cachedThreadPool.execute(mRunnable2);
                cachedThreadPool.execute(mRunnable2);
                cachedThreadPool.execute(mRunnable2);

                ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
                scheduledExecutorService.scheduleAtFixedRate(mRunnable3, 100l, 3000l, TimeUnit.MILLISECONDS);

                ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
                singleThreadExecutor.execute(mRunnable4);
                singleThreadExecutor.execute(mRunnable4);
                singleThreadExecutor.execute(mRunnable4);
                singleThreadExecutor.execute(mRunnable4);
                singleThreadExecutor.execute(mRunnable4);
                break;
            default:
                break;
        }
    }
}
