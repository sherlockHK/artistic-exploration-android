package com.gakki.hk.artistic_exploration_android.view_event_architecture;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;

/**
 *
 */
public class ViewEventArchitectureFragment extends Fragment implements View.OnClickListener {


  public static ViewEventArchitectureFragment newInstance() {
    return new ViewEventArchitectureFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_view_event_architecture, null);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    Button basicScroll = (Button) view.findViewById(R.id.btn_basic_scroll);
    basicScroll.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.btn_basic_scroll:
        startActivity(new Intent(getContext(), BasicScrollActivity.class));
        break;
      default:
        break;
    }
  }
}
