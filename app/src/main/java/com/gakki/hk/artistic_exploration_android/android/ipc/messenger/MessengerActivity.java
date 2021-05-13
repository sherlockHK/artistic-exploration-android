package com.gakki.hk.artistic_exploration_android.android.ipc.messenger;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/6/2.
 * Email: kaihu1989@gmail.com.
 */

public class MessengerActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MessengerActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_messenger);

        Button btn = (Button) findViewById(R.id.btn_messenger);
        btn.setOnClickListener(this);

        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private Messenger mService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected");
            mService = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {}
    };

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_messenger:
                sendMessage();
                break;
        }
    }

    private void sendMessage() {
        Message msg = Message.obtain(null, MessengerService.MSG_FROM_CLIENT);
        Bundle bundle  = new Bundle();
        bundle.putString("msg", "this is client!");
        msg.setData(bundle);

        //指定客户端接收服务端reply的messenger
        msg.replyTo = mGetReplyMessenger;
        Log.i(TAG, "sendMessage");
        try {
            mService.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收服务端消息的messenger
     * */
    private final Messenger mGetReplyMessenger = new Messenger(new MessengerHandler());

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MessengerService.MSG_FROM_SERVER:
                    Log.i(TAG, msg.getData().getString("reply"));
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }
}
