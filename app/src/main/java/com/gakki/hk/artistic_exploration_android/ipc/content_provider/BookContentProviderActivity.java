package com.gakki.hk.artistic_exploration_android.ipc.content_provider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.TimeUtils;
import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by HK on 2017/6/5.
 * Email: kaihu1989@gmail.com.
 */

public class BookContentProviderActivity extends Activity implements View.OnClickListener {

    private TextView queryResult;
    private int i =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_content_provider);

        Button insert = (Button) findViewById(R.id.btn_insert);
        Button query = (Button) findViewById(R.id.btn_query);
        queryResult = (TextView) findViewById(R.id.tv_query_result);
        insert.setOnClickListener(this);
        query.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Uri bookUri = Uri.parse("content://" + BookContentProvider.AUTHORITY + "/book");
        switch (v.getId()){
            case R.id.btn_insert:
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", 4 + i);
                contentValues.put("name", "Refactor" + TimeUtils.getCurTimeString());
                getContentResolver().insert(bookUri, contentValues);
                i++;
                break;
            case R.id.btn_query:
                Cursor bookCursor = getContentResolver().query(bookUri, new String[] {"_id", "name"}, null, null, null);
                StringBuilder result = new StringBuilder();
                while (bookCursor.moveToNext()){
                    int id = bookCursor.getInt(0);
                    String name = bookCursor.getString(1);
                    result.append("id:").append(id).append(" name:").append(name).append("\n");
                }
                bookCursor.close();
                queryResult.setText(result.toString());
                break;
            default:
                break;
        }
    }
}
