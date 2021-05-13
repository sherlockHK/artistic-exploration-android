package com.gakki.hk.artistic_exploration_android.android.ipc.AIDL;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by Administrator on 2017/7/14.
 */

public class RemoteServiceActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "RemoteServiceActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_remote_service);

        Button start = (Button) findViewById(R.id.btn_start_service);
        Button stop = (Button) findViewById(R.id.btn_stop_service);
        Button bind = (Button) findViewById(R.id.btn_bind_service);
        Button unbind = (Button) findViewById(R.id.btn_unbind_service);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent serviceIntent = new Intent(this, MyRemoteService.class);
        switch (v.getId()) {
            case R.id.btn_start_service:
                startService(serviceIntent);
                break;
            case R.id.btn_stop_service:
                stopService(serviceIntent);
                break;
            case R.id.btn_bind_service:
                bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                unbindService(serviceConnection);
                break;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyRemoteService.LocalBinder localBinder = (MyRemoteService.LocalBinder) service;
            MyRemoteService remoteService = localBinder.getService();
            Log.i(TAG, "onServiceConnected: " + name + remoteService);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: " + name);
        }
    };
}
