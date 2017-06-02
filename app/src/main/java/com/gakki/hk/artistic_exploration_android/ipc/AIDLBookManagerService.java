package com.gakki.hk.artistic_exploration_android.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

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
    private CopyOnWriteArrayList<IOnNewBookArrivedListener> mListeners = new CopyOnWriteArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1, "Android"));
        mBookList.add(new Book(2, "iOS"));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private Binder mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
            for (IOnNewBookArrivedListener listener : mListeners) {
                listener.onNewBookArrived(book);
            }
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if (!mListeners.contains(listener)) {
                mListeners.add(listener);
            }
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
            if (mListeners.contains(listener)) {
                mListeners.remove(listener);
            }
        }
    };

}
