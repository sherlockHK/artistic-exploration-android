// IBookManager.aidl
package com.gakki.hk.artistic_exploration_android.android.ipc;

// Declare any non-default types here with import statements
import com.gakki.hk.artistic_exploration_android.android.ipc.model.Book;
import com.gakki.hk.artistic_exploration_android.android.ipc.IOnNewBookArrivedListener;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
    void registerListener(IOnNewBookArrivedListener listener);
    void unregisterListener(IOnNewBookArrivedListener listener);
}
