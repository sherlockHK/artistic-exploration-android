package com.gakki.hk.artistic_exploration_android.android.ipc.socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.gakki.hk.artistic_exploration_android.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Administrator on 2017/6/5 0005.
 * Email: kaihu1989@gmail.com.
 */

public class TcpClientActivity extends Activity implements View.OnClickListener {
    private static final int MESSAGE_SOCKET_CONNECTED = 0x01;
    private static final int MESSAGE_RECEIVE_NEW_MSG = 0x02;

    private Socket mClientSocket;
    private PrintWriter mPrintWriter;
    private TextView chatContent;
    private Button sendBtn;
    private EditText etSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcp_client);
        chatContent = (TextView) findViewById(R.id.tv_chat_content);
        sendBtn = (Button) findViewById(R.id.btn_send_msg);
        etSend = (EditText) findViewById(R.id.et_send);
        sendBtn.setOnClickListener(this);

        Intent intent = new Intent(this, TcpServerService.class);
        startService(intent);

        new Thread(){
            @Override
            public void run() {
                try {
                    connectTCPServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        if(mClientSocket != null){
            try {
                mClientSocket.shutdownInput();
                mClientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }

    @SuppressWarnings("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MESSAGE_RECEIVE_NEW_MSG:
                    chatContent.setText(chatContent.getText().toString() + msg.obj);
                    break;
                case MESSAGE_SOCKET_CONNECTED:
                    sendBtn.setEnabled(true);
                    break;
                default:
                    break;
            }
        }
    };

    private void connectTCPServer() throws IOException {
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

        //接收服务器端的消息
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (!TcpClientActivity.this.isFinishing()){
            String msgFromServer = in.readLine();
            LogUtils.i("receive msg from server:" + msgFromServer);
            if (!StringUtils.isEmpty(msgFromServer)){
                String showedMsg = "server time " + TimeUtils.getNowString() + msgFromServer + "\n";
                mHandler.obtainMessage(MESSAGE_RECEIVE_NEW_MSG, showedMsg).sendToTarget();
            }
        }
        LogUtils.i("quit...");
        mPrintWriter.close();
        in.close();
        socket.close();
    }

    @Override
    public void onClick(View v) {
        //向服务器发送消息
        final String msg = etSend.getText().toString();
        if (!StringUtils.isEmpty(msg) && mPrintWriter != null){
            new Thread(){
                @Override
                public void run() {
                    mPrintWriter.println(msg);
                }
            }.start();
            etSend.setText("");
            String showedMsg = "client time:" + TimeUtils.getNowString() + msg + "\n";
            chatContent.setText(chatContent.getText().toString() + showedMsg);
        }
    }
}
