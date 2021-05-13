package com.gakki.hk.artistic_exploration_android.android.handler;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.gakki.hk.artistic_exploration_android.R;

/**
 *
 */
public class HandlerMechanismFragment extends Fragment implements View.OnClickListener {


    public static HandlerMechanismFragment newInstance() {
        return new HandlerMechanismFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_handler_mechanism, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        testThreadLocal();
    }

    private ThreadLocal<Boolean> threadLocal = new ThreadLocal<>();

    private void testThreadLocal() {
        threadLocal.set(true);
        LogUtils.i("MainThread: threadLocal=" + threadLocal.get());

        new Thread() {
            @Override
            public void run() {
                threadLocal.set(false);
                LogUtils.i("Thread1: threadLocal=" + threadLocal.get());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                LogUtils.i("Thread2: threadLocal=" + threadLocal.get());
            }
        }.start();
    }

    @Override
    public void onClick(View v) {

    }
}
