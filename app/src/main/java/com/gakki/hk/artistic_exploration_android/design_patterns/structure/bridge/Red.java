package com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge;

import android.util.Log;

/**
 * @author : hukai50
 * @date : 2021/2/5 下午4:38
 * @desc :
 */
public class Red implements Color {
    @Override
    public void drawColor() {
        System.out.println("draw red");
    }
}
