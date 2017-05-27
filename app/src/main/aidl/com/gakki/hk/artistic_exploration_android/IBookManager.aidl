// IBookManager.aidl
package com.gakki.hk.artistic_exploration_android;

// Declare any non-default types here with import statements
import com.gakki.hk.artistic_exploration_android.model.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
