package com.gakki.hk.artistic_exploration_android.android.thread_and_threadPool;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gakki.hk.artistic_exploration_android.R;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by HK on 2017/6/22.
 * Email: kaihu1989@gmail.com.
 * 1.The AsyncTask class must be loaded on the UI thread. This is done
 * automatically as of {@link android.os.Build.VERSION_CODES#JELLY_BEAN}.
 * 2.The task instance must be created on the UI thread.{@link #execute} must be invoked on the UI thread.
 * 3.Do not call {@link #onPreExecute()}, {@link #onPostExecute}, {@link #doInBackground}, {@link #onProgressUpdate} manually.
 * 4.The task can be executed only once (an exception will be thrown if a second execution is attempted.
 */

public class AsyncTaskActivity extends Activity implements View.OnClickListener {

    private SeekBar seekBar;
    private UpdateUIAsyncTask updateUIAsyncTask;
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        Button btn1 = (Button) findViewById(R.id.btn_update_ui);
        Button btn2 = (Button) findViewById(R.id.btn_cancel);
        Button btn3 = (Button) findViewById(R.id.btn_serial);
        Button btn4 = (Button) findViewById(R.id.btn_parallel);
        textView1 = (TextView) findViewById(R.id.tv_serial_execute);
        textView2 = (TextView) findViewById(R.id.tv_parallel_execute);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        updateUIAsyncTask = new UpdateUIAsyncTask(seekBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update_ui:
                //AsyncTask更新UI
                updateUIAsyncTask.execute(100);
                break;
            case R.id.btn_cancel:
                updateUIAsyncTask.cancel(true);
                break;
            case R.id.btn_serial:
                //asyncTask 串行执行
                textView1.setText("");
                new MyAsyncTask("AsyncTask #1:", textView1).execute("");
                new MyAsyncTask("AsyncTask #2:", textView1).execute("");
                new MyAsyncTask("AsyncTask #3:", textView1).execute("");
                new MyAsyncTask("AsyncTask #4:", textView1).execute("");
                new MyAsyncTask("AsyncTask #5:", textView1).execute("");
                break;
            case R.id.btn_parallel:
                //asyncTask 并行执行
                textView2.setText("");
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;
                //默认corePoolSize 2-5
                threadPoolExecutor.setCorePoolSize(3);
                new MyAsyncTask("AsyncTask #1:", textView2).executeOnExecutor(threadPoolExecutor,"");
                new MyAsyncTask("AsyncTask #2:", textView2).executeOnExecutor(threadPoolExecutor,"");
                new MyAsyncTask("AsyncTask #3:", textView2).executeOnExecutor(threadPoolExecutor,"");
                new MyAsyncTask("AsyncTask #4:", textView2).executeOnExecutor(threadPoolExecutor,"");
                new MyAsyncTask("AsyncTask #5:", textView2).executeOnExecutor(threadPoolExecutor,"");
                break;
        }
    }

    /**
     * AsyncTask更新UI
     * */
    private static class UpdateUIAsyncTask extends AsyncTask<Integer, Integer, Boolean> {
        private final SeekBar seekBar;
        private final Context context;

        public UpdateUIAsyncTask(SeekBar seekBar) {
            this.seekBar = seekBar;
            this.context = seekBar.getContext();
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {

            Integer count = integers[0];
            int i;
            for (i = 0; i < count; i++) {
                publishProgress(i);
                SystemClock.sleep(50);
                //被取消则终止循环
                if (isCancelled()) {
                    break;
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            seekBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
        }
    }

    private static class MyAsyncTask extends AsyncTask<String, Integer, String>{
        private final String name;
        private final TextView textview;

        public MyAsyncTask(String name, TextView textView) {
            this.name = name;
            this.textview = textView;
        }

        @Override
        protected String doInBackground(String... strings) {
            SystemClock.sleep(1000);
            return name;
        }

        @Override
        protected void onPostExecute(String s) {
        }
    }
}
