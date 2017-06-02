// IBookManager.aidl
package com.gakki.hk.artistic_exploration_android;

// Declare any non-default types here with import statements
import com.gakki.hk.artistic_exploration_android.ipc.model.Book;
import com.gakki.hk.artistic_exploration_android.IOnNewBookArrivedListener;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
    void registerListener(IOnNewBookArrivedListener listener);
    void unregisterListener(IOnNewBookArrivedListener listener);
}
