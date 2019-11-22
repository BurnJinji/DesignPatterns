package com.burning8393.observer.v2;

/**
 * 面向对象的傻等
 */
class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Waked Up! Crying wuwuwuwuwu....");
        cry = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            child.wakeUp();
        }).start();
        while (!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing....");
        }
    }
}
