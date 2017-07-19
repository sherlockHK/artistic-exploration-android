package com.gakki.hk.artistic_exploration_android.ipc.AIDL;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/14.
 */

public class MyRemoteService extends Service {
    private static final String TAG = "MyRemoteService";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");

//        stopSelf(startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return mIbinder;
    }

    private final IBinder mIbinder = new LocalBinder();
    public class LocalBinder extends Binder{
        MyRemoteService getService(){
            return MyRemoteService.this;
        }
    }
    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind: ");
        super.onRebind(intent);
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
