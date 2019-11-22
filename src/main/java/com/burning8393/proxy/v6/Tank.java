package com.burning8393.proxy.v6;

import java.util.Random;

/**
 * 问题：记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？ benchmark
 * 用继承?
 * 使用代理
 * 代理有各种类型
 * 问题：如何实现代理的各种组合？ 继承？ Decorator？
 * 代理的对象改成Movable类型 越来越像Decorator
 */
public class Tank implements Movable {

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
        Tank tank = new Tank();
        TankTimeProxy ttp = new TankTimeProxy(tank);
        TankLogProxy tlp = new TankLogProxy(ttp);
        tlp.move();
    }
}

class TankTimeProxy implements Movable {
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        System.out.println("stop moving...");
    }
}

interface Movable {
    void move();
}
