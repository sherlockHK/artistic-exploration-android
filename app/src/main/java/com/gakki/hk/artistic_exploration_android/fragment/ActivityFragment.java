package com.gakki.hk.artistic_exploration_android.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页模块主界面
 */
public class ActivityFragment extends Fragment implements View.OnClickListener {


  private Button btn;

  public static ActivityFragment newInstance() {

    return new ActivityFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_home, null);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    btn = (Button) view.findViewById(R.id.btn_intent_filter);
    btn.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent();

    intent.setAction("artistic_exploration_android");
    /**
     * intent会自动加一个默认的categotry:android.intent.category.DEFAULT
     * */
    intent.addCategory("android.intent.category.DEFAULT_1");

    /**
     * data由URI和mimetype组成
     * URI: scheme://host:port/path/pathPrefix/pathPattern
     */
    intent.setDataAndType(Uri.parse("http://abc"), "video/mpeg");

    startActivity(intent);
  }
}
