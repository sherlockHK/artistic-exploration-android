package com.gakki.hk.artistic_exploration_android.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by HK on 2017/6/2.
 * Email: kaihu1989@gmail.com.
 */

public class MessengerService extends Service {
    public static final int MSG_FROM_CLIENT = 0x01;
    public static final int MSG_FROM_SERVER = 0x02;
    private static final String TAG = "MessengerService";

    /**
     * 接收客户端消息的messenger
     * */
    private final Messenger mMessenger = new Messenger(new MessengerHandler());

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
               case MSG_FROM_CLIENT:
                   Log.i(TAG, "receive msg from client: " + msg.getData().getString("msg"));

                   Messenger client = msg.replyTo;
                   Message replyMsg = Message.obtain(null, MSG_FROM_SERVER);
                   Bundle bundle = new Bundle();
                   bundle.putString("reply", "the server had received your msg， will reply later");
                   replyMsg.setData(bundle);
                   try {
                       client.send(replyMsg);
                   } catch (RemoteException e) {
                       e.printStackTrace();
                   }
                   break;
                default:
                super.handleMessage(msg);
                    break;
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return mMessenger.getBinder();
    }
}
