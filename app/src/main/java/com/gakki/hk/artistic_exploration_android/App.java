package com.gakki.hk.artistic_exploration_android;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.gakki.hk.artistic_exploration_android.util.Util;

/**
 * Created by HK on 2017/5/27.
 * Email: kaihu1989@gmail.com.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("app onCreate: process=" , Util.getCurProcessName(this));
        Stetho.initializeWithDefaults(this);
    }
}
