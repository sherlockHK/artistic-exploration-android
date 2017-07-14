package com.gakki.hk.artistic_exploration_android.ipc.AIDL;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gakki.hk.artistic_exploration_android.IBookManager;
import com.gakki.hk.artistic_exploration_android.IOnNewBookArrivedListener;
import com.gakki.hk.artistic_exploration_android.ipc.model.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by HK on 2017/6/2.
 * Email: kaihu1989@gmail.com.
 */

public class AIDLBookManagerService extends Service {
    private static final String TAG = "AIDLBookManagerService";
    //CopyOnWriteArrayList支持并发读/写
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();
    //使用RemoteCallbackList存listener
    private RemoteCallbackList<IOnNewBookArrivedListener> remoteCallbackList = new RemoteCallbackList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1, "Android"));
        mBookList.add(new Book(2, "iOS"));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        /**
         * AIDL权限验证
         * */
        int check = checkCallingOrSelfPermission("com.gakki.hk.artistic_exploration_android.permission.ACCESS_BOOK_SERVICE");
        Log.d(TAG, "onbind check=" + check);
        if (check == PackageManager.PERMISSION_DENIED) {
            return null;
        }
        return mBinder;
    }

    private Binder mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            /**
             * 客户端调用远程服务方法，被调用的addBook运行在服务端的binder线程池中，同时客户端线程会被挂起，
             * 如果服务端执行耗时操作，会导致客户端线程长时间阻塞，如果客户端线程是UI线程，会导致ANR。
             *
             * SystemClock.sleep(10 * 1000);
             * */

            mBookList.add(book);

            notifyAllObserver(book);
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
            remoteCallbackList.register(listener);
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
            remoteCallbackList.unregister(listener);
        }
    };

    //通知所有的订阅者
    private void notifyAllObserver(Book book) throws RemoteException {
        int n = remoteCallbackList.beginBroadcast();
        for (int i = 0; i < n; i++) {
            IOnNewBookArrivedListener listener = remoteCallbackList.getBroadcastItem(i);
            if (listener != null){
                listener.onNewBookArrived(book);
            }
        }
        remoteCallbackList.finishBroadcast();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
