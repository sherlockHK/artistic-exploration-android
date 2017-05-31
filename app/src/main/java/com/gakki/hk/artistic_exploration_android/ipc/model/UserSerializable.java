package com.gakki.hk.artistic_exploration_android.ipc.model;

import java.io.Serializable;

/**
 * Created by HK on 2017/5/27.
 * Email: kaihu1989@gmail.com.
 */

public class UserSerializable implements Serializable {
    private String name;
    private String age;

    private static final long serialVersionUID = 1213123123L;

    public UserSerializable(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
