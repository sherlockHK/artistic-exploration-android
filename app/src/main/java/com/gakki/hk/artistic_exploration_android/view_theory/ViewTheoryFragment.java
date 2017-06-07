package com.gakki.hk.artistic_exploration_android.view_theory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gakki.hk.artistic_exploration_android.R;

/**
 *
 */
public class ViewTheoryFragment extends Fragment {


  public static ViewTheoryFragment newInstance() {
    return new ViewTheoryFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_view_theory, null);
  }
}
