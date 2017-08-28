package com.gakki.hk.artistic_exploration_android.algorithm;

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
public class AlgorithmFragment extends Fragment {


    public static AlgorithmFragment newInstance() {
        return new AlgorithmFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_algorithm, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button string = (Button) view.findViewById(R.id.btn_string);
        Button array = (Button) view.findViewById(R.id.btn_array);
        string.setOnClickListener(v -> stringTest());
        array.setOnClickListener(v -> arrayTest());
    }

    //字符串
    private void stringTest() {

    }

    //数组
    private void arrayTest() {

    }
}
