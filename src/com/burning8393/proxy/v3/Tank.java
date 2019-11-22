package com.burning8393.proxy.v3;

import java.util.Random;

/**
 * 问题：记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？ benchmark
 * 用继承?
 */
public class Tank implements Moveable {

    @Override
    public void move() {
        System.out.println("tank kalakala...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}

class Tank2 extends Tank {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Moveable {
    void move();
}
