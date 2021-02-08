// IOnNewBookArrivedListener.aidl
package com.gakki.hk.artistic_exploration_android.android.ipc;

import com.gakki.hk.artistic_exploration_android.android.ipc.model.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}