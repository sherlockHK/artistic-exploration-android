package com.gakki.hk.artistic_exploration_android.thread_and_threadPool;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;

/**
 *
 */
public class ThreadAndThreadPoolFragment extends Fragment implements View.OnClickListener {


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
        asyncBtn.setOnClickListener(this);
        handlerThreadBtn.setOnClickListener(this);
        intentServiceBtn.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
