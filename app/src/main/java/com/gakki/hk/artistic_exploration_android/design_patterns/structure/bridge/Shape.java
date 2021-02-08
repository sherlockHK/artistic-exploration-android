package com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge;

/**
 * @author : hukai50
 * @date : 2021/2/5 下午4:34
 * @desc :
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
