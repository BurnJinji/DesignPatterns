package com.burning8393.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed");

        for (Observer observer : observers) {
            observer.actionOnWeakUp(event);
        }
    }
}

// 事件类 fire event
class WakeUpEvent {
    private long timestamp;
    private String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

interface Observer {
    void actionOnWeakUp(WakeUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWeakUp(WakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWeakUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
    public void bark() {
        System.out.println("dog barking...");
    }

    @Override
    public void actionOnWeakUp(WakeUpEvent event) {
        bark();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
