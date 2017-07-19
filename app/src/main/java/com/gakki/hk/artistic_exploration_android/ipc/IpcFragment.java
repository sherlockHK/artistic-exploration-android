package com.gakki.hk.artistic_exploration_android.ipc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gakki.hk.artistic_exploration_android.R;
import com.gakki.hk.artistic_exploration_android.ipc.AIDL.AIDLBookManagerActivity;
import com.gakki.hk.artistic_exploration_android.ipc.AIDL.RemoteServiceActivity;
import com.gakki.hk.artistic_exploration_android.ipc.content_provider.BookContentProviderActivity;
import com.gakki.hk.artistic_exploration_android.ipc.messenger.MessengerActivity;
import com.gakki.hk.artistic_exploration_android.ipc.model.UserSerializable;
import com.gakki.hk.artistic_exploration_android.ipc.socket.TcpClientActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
        Button activityProcess = (Button) view.findViewById(R.id.btn_activity_process);
        Button serialize = (Button) view.findViewById(R.id.btn_serialize);
        Button messenger = (Button) view.findViewById(R.id.btn_messenger);
        Button aidl = (Button) view.findViewById(R.id.btn_aidl);
        Button service = (Button) view.findViewById(R.id.btn_service_practice);
        Button contentProvider = (Button) view.findViewById(R.id.btn_content_provider);
        Button socket = (Button) view.findViewById(R.id.btn_socket);
        activityProcess.setOnClickListener(this);
        serialize.setOnClickListener(this);
        messenger.setOnClickListener(this);
        aidl.setOnClickListener(this);
        service.setOnClickListener(this);
        contentProvider.setOnClickListener(this);
        socket.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity_process:
                startActivity(new Intent(getContext(), IpcTestActivity.class));
                break;
            case R.id.btn_serialize:
                tesSerialize();
                break;
            case R.id.btn_messenger:
                startActivity(new Intent(getContext(), MessengerActivity.class));
                break;
            case R.id.btn_aidl:
                startActivity(new Intent(getContext(), AIDLBookManagerActivity.class));
                break;
            case R.id.btn_service_practice:
                startActivity(new Intent(getContext(), RemoteServiceActivity.class));
                break;
            case R.id.btn_content_provider:
                startActivity(new Intent(getContext(), BookContentProviderActivity.class));
                break;
            case R.id.btn_socket:
                startActivity(new Intent(getContext(), TcpClientActivity.class));
                break;
            default:
                break;
        }
    }

    private void tesSerialize() {
        UserSerializable hk = new UserSerializable("hk", "18");
        try {
            ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(getActivity().getExternalCacheDir() + "/user.txt"));
            obs.writeObject(hk);
            obs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream obi = new ObjectInputStream(new FileInputStream(getActivity().getExternalCacheDir() + "/user.txt"));
            UserSerializable user = (UserSerializable) obi.readObject();
            obi.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
