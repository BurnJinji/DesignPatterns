package com.burning8393.proxy.v5;

import java.util.Random;

/**
 * 问题：记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？ benchmark
 * 用继承?
 * 使用代理
 * 代理有各种类型
 * 问题：如何实现代理的各种组合？ 继承？ Decorator？
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
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Moveable {
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Moveable {
    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        tank.move();
        System.out.println("stop moving...");
    }
}

interface Moveable {
    void move();
}
