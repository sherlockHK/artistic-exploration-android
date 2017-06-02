// IOnNewBookArrivedListener.aidl
package com.gakki.hk.artistic_exploration_android;

import com.gakki.hk.artistic_exploration_android.ipc.model.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}