package com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge;

import android.util.Log;

/**
 * @author : hukai50
 * @date : 2021/2/5 下午4:34
 * @desc :
 */
public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("this is a circle");
        color.drawColor();
    }
}
