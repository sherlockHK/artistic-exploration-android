package com.gakki.hk.artistic_exploration_android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;
import com.gakki.hk.artistic_exploration_android.activity.IpcTestActivity;

/**
 * Created by hcc on 16/8/4 21:18
 * 100332338@qq.com
 * <p/>
 * 首页模块主界面
 */
public class IpcFragment extends Fragment implements View.OnClickListener {


  public static IpcFragment newInstance() {
    return new IpcFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_ipc, null);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    Button btn = (Button) view.findViewById(R.id.btn_activity_process);
    btn.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    startActivity(new Intent(getContext(), IpcTestActivity.class));
  }
}
