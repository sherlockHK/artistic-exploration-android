package com.gakki.hk.artistic_exploration_android.util;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by HK on 2017/5/27.
 * Email: kaihu1989@gmail.com.
 */

public class Util {
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
