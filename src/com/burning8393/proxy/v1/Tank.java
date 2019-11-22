package com.burning8393.proxy.v1;

import java.util.Random;

/**
 * 问题： 记录坦克的移动时间
 */
public class Tank implements Moveable {
    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("tank kalakala...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface Moveable {
    void move();
}