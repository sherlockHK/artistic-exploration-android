package com.gakki.hk.artistic_exploration_android.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.utils.ToastUtils;
import com.gakki.hk.artistic_exploration_android.IBookManager;
import com.gakki.hk.artistic_exploration_android.R;
import com.gakki.hk.artistic_exploration_android.ipc.model.Book;

import java.util.List;

/**
 * Created by HK on 2017/6/2.
 * Email: kaihu1989@gmail.com.
 */

public class AIDLBookManagerActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "AIDLBookManagerActivity";
    private IBookManager mBookManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_aidl_book_manager);
        Button getBook = (Button) findViewById(R.id.btn_get_book_list);
        getBook.setOnClickListener(this);

        Intent intent = new Intent(this, AIDLBookManagerService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBookManager = IBookManager.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void getBookList() {
        try {
            List<Book> bookList = mBookManager.getBookList();
            ToastUtils.showLongToast(this,"class: " +  bookList.getClass().getCanonicalName() + " list:" + bookList.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(mServiceConnection);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get_book_list:
                getBookList();
                break;
        }
    }

}
