package com.gakki.hk.artistic_exploration_android.android.ipc;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/5/27.
 * Email: kaihu1989@gmail.com.
 */

public class IpcTestActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(View.inflate(this, R.layout.activity_ipctest,null));
    }
}
