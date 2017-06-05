package com.gakki.hk.artistic_exploration_android.ipc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.blankj.utilcode.utils.LogUtils;
import com.gakki.hk.artistic_exploration_android.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Administrator on 2017/6/5 0005.
 * Email: kaihu1989@gmail.com.
 */

public class TcpClientActivity extends Activity {
    private static final int MESSAGE_SOCKET_CONNECTED = 0x01;
    private static final int MESSAGE_RECEIVE_NEW_MSG = 0x02;

    private Socket mClientSocket;
    private PrintWriter mPrintWriter;

    @SuppressWarnings("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MESSAGE_RECEIVE_NEW_MSG:
                    break;
                case MESSAGE_SOCKET_CONNECTED:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcp_client);

        connectTCPServer();
    }

    private void connectTCPServer() {
        Socket socket = null;
        //连接tcp服务器
        while (socket == null) {
            try {
                socket = new Socket("localhost", 8688);
                mClientSocket = socket;
                mPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                mHandler.sendEmptyMessage(MESSAGE_SOCKET_CONNECTED);
                LogUtils.i("connect server success!");
            } catch (IOException e) {
                e.printStackTrace();
                SystemClock.sleep(1000);
                LogUtils.i("connect tcp server failed, retry...");
            }
        }

        // TODO: 2017/6/5 0005
        //接收服务器端的消息
    }
}
