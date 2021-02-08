package com.gakki.hk.artistic_exploration_android.android.ipc.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/5 0005.
 * Email: kaihu1989@gmail.com.
 */

public class TcpServerService extends Service {
    private boolean mIsServiceDestroyed = false;
    private String[] mDefinedMessages = new String[]{
            "oh ha you!",
            "what's ur name, dude?",
            "balabala",
            "one piece",
            "nick robin",
            "a xi ba!!!"
    };

    @Override
    public void onCreate() {
        new Thread(new TcpServer()).start();
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mIsServiceDestroyed = true;
        super.onDestroy();
    }

    private class TcpServer implements Runnable {
        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8688);
            } catch (IOException e) {
                LogUtils.i("establish tcp server failed, port:8688");
                e.printStackTrace();
                return;
            }

            while (!mIsServiceDestroyed) {
                //接收客户端请求
                try {
                    final Socket client = serverSocket.accept();
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                responseClient(client);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void responseClient(Socket client) throws IOException {
            //用于接收客户端消息
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //用于向客户端发送消息
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            out.println("welcome to chatRoom！");

            while (!mIsServiceDestroyed) {
                String inMsg = in.readLine();
                LogUtils.i("msg from client: " + inMsg);
                if (inMsg == null){
                    //为null，说明客户端断开了连接
                    break;
                }

                int i = new Random().nextInt(mDefinedMessages.length);
                String responseMsg = mDefinedMessages[i];
                out.println(responseMsg);
                LogUtils.i("send: " +responseMsg);
            }

            LogUtils.i("client quit!");

            //关闭流
            out.close();
            in.close();
            client.close();
        }
    }
}
