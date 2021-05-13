package com.gakki.hk.artistic_exploration_android.android.ipc.content_provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.Log;

/**
 * Created by HK on 2017/6/5.
 * Email: kaihu1989@gmail.com.
 */

public class BookContentProvider extends ContentProvider {
    private final static String TAG = "BookContentProvider";
    public static final String AUTHORITY = "com.gakki.hk.artistic_exploration_android.provider";

    public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
    public static final Uri USER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/user");
    public static final int BOOK_URI_CODE = 0;
    public static final int USER_URI_CODE = 1;

    private static final UriMatcher mUriMather = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        mUriMather.addURI(AUTHORITY, "book", BOOK_URI_CODE);
        mUriMather.addURI(AUTHORITY, "user", USER_URI_CODE);
    }

    private Context mContext;
    private SQLiteDatabase mDb;

    @Override
    public boolean onCreate() {
        Log.i(TAG, "onCreate current thread is:" + Thread.currentThread());
        mContext = getContext();

        mDb = new DbOpenHelper(mContext).getWritableDatabase();
        mDb.execSQL("DELETE FROM " + DbOpenHelper.BOOK_TABLE_NAME);
        mDb.execSQL("DELETE FROM " + DbOpenHelper.USER_TABLE_NAME);
        mDb.execSQL("INSERT INTO book VALUES(1, 'Android')");
        mDb.execSQL("INSERT INTO book VALUES(2, 'iOS')");
        mDb.execSQL("INSERT INTO book VALUES(3, 'HTML5')");
        mDb.execSQL("INSERT INTO user VALUES(1, 'gakki', 1)");
        mDb.execSQL("INSERT INTO user VALUES(2, 'toda', 0)");

        return true;
    }

    private String getTableName(Uri uri){
        String tableName = null;
        switch (mUriMather.match(uri)){
            case BOOK_URI_CODE:
                tableName = DbOpenHelper.BOOK_TABLE_NAME;
                break;
            case USER_URI_CODE:
                tableName = DbOpenHelper.USER_TABLE_NAME;
                break;
            default:
                break;
        }
        return tableName;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.i(TAG, "getType current thread is:" + Thread.currentThread());
        return null;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.i(TAG, "query current thread is:" + Thread.currentThread());
        String table = getTableName(uri);
        if (table == null){
            throw new IllegalArgumentException("unsupported uri:" + uri);
        }
        return mDb.query(table, projection, selection, selectionArgs, null,null,sortOrder,null);
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.i(TAG, "insert current thread is:" + Thread.currentThread());

        String table = getTableName(uri);
        if (table == null){
            throw new IllegalArgumentException("unsupported uri:" + uri);
        }
        mDb.insert(table, null, values);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i(TAG, "delete current thread is:" + Thread.currentThread());
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i(TAG, "update current thread is:" + Thread.currentThread());
        return 0;
    }
}
