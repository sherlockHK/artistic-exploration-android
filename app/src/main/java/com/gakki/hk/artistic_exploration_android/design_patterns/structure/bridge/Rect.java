package com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge;

import android.util.Log;

/**
 * @author : hukai50
 * @date : 2021/2/5 下午4:37
 * @desc :
 */
public class Rect extends Shape {
    public Rect(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("this is a rect");
        color.drawColor();
    }
}
