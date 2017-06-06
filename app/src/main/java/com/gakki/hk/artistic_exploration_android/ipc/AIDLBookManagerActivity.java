package com.gakki.hk.artistic_exploration_android.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.utils.LogUtils;
import com.blankj.utilcode.utils.TimeUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.gakki.hk.artistic_exploration_android.IBookManager;
import com.gakki.hk.artistic_exploration_android.IOnNewBookArrivedListener;
import com.gakki.hk.artistic_exploration_android.R;
import com.gakki.hk.artistic_exploration_android.ipc.model.Book;

import java.util.List;

/**
 * Created by HK on 2017/6/2.
 * Email: kaihu1989@gmail.com.
 */

public class AIDLBookManagerActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "AIDLBookManagerActivity";
    private static final int MSG_NEW_BOOK_ARRIVED = 0x01;
    private IBookManager mRemoteBookManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_aidl_book_manager);
        Button getBook = (Button) findViewById(R.id.btn_get_book_list);
        Button addBook = (Button) findViewById(R.id.btn_add_book);
        getBook.setOnClickListener(this);
        addBook.setOnClickListener(this);

        Intent intent = new Intent(this, AIDLBookManagerService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteBookManager = IBookManager.Stub.asInterface(service);
            try {
                mRemoteBookManager.registerListener(mOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mRemoteBookManager = null;
        }
    };

    // TODO: 2017/6/2  IOnNewBookArrivedListener的onNewBookArrived方法是在运行在客户端的binder线程池中，用handler将它切换到主线程执行???
    // TODO: 2017/6/6  Binder连接池:多个aidl一个remote service
    private IOnNewBookArrivedListener mOnNewBookArrivedListener = new IOnNewBookArrivedListener.Stub(){
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            Message msg = Message.obtain(mHandler, MSG_NEW_BOOK_ARRIVED, newBook);
            mHandler.sendMessage(msg);
        }
    };


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_NEW_BOOK_ARRIVED:
                    Book book = (Book) msg.obj;
                    ToastUtils.showLongToast(AIDLBookManagerActivity.this, "received new book:" + book.toString());
                    break;
            }
        }
    };

    private void getBookList() {
        try {
            List<Book> bookList = mRemoteBookManager.getBookList();
            ToastUtils.showLongToast(this,"class: " +  bookList.getClass().getCanonicalName() + " size:" + bookList.size());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void addBook() {
        try {
            mRemoteBookManager.addBook(new Book(3, "Android artistic exploration" + TimeUtils.getCurTimeString()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        if (mRemoteBookManager != null && mRemoteBookManager.asBinder().isBinderAlive()){
            try {
                LogUtils.i("unregister listener:" + mOnNewBookArrivedListener);
                mRemoteBookManager.unregisterListener(mOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        unbindService(mServiceConnection);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get_book_list:
                getBookList();
                break;
            case R.id.btn_add_book:
                addBook();
                break;
        }
    }



}
