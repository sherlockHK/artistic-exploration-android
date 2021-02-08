package com.gakki.hk.artistic_exploration_android;

import com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge.Circle;
import com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge.Green;
import com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge.Rect;
import com.gakki.hk.artistic_exploration_android.design_patterns.structure.bridge.Red;

import org.junit.Test;

/**
 * @author : hukai50
 * @date : 2021/2/5 下午4:39
 * @desc :
 */
public class DesignPatternsTest {
    /**
     * 桥接模式：把抽象化与实现化解耦，使得二者可以独立变化
     *
     * 主要解决：在有多种可能会变化的情况下，用继承会造成类爆炸问题，扩展起来不灵活。
     * 何时使用：实现系统可能有多个角度分类，每一种角度都可能变化。
     * 如何解决：把这种多角度分类分离出来，让它们独立变化，减少它们之间耦合。
     * */
    @Test
    public void bridge() {
        Red r = new Red();
        Green g = new Green();
        Circle redCircle = new Circle(r);
        Circle greenCircle = new Circle(g);
        Rect redRect = new Rect(r);
        Rect greenRect = new Rect(g);
        redCircle.draw();
        greenCircle.draw();
        redRect.draw();
        greenRect.draw();
    }
}
