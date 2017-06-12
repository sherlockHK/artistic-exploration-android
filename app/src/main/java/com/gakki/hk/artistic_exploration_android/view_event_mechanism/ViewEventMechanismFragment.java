package com.gakki.hk.artistic_exploration_android.view_event_mechanism;

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
public class ViewEventMechanismFragment extends Fragment implements View.OnClickListener {


    public static ViewEventMechanismFragment newInstance() {
        return new ViewEventMechanismFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_event_mechanism, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button basicScroll = (Button) view.findViewById(R.id.btn_basic_scroll);
        basicScroll.setOnClickListener(this);
        Button conflictScroll = (Button) view.findViewById(R.id.btn_conflict_scroll);
        conflictScroll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_basic_scroll:
                startActivity(new Intent(getContext(), BasicScrollActivity.class));
                break;
            case R.id.btn_conflict_scroll:
                startActivity(new Intent(getContext(), ScrollConflictActivity.class));
                break;
            default:
                break;
        }
    }
}
