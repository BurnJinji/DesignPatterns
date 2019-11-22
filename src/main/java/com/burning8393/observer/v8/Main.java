package com.burning8393.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 * 事件也可以形成继承体系
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
        observers.add((e) -> {
            System.out.println("ppp");
        });
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        WakeUpEvent e = new WakeUpEvent(System.currentTimeMillis(), "bed", this);
        for (Observer observer : observers) {
            observer.actionOnWakeUp(e);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

class WakeUpEvent extends Event<Child> {

    private long timestamp;
    private String loc;
    private Child source;

    public WakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer {
    void actionOnWakeUp(Event e);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(Event e) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp(Event e) {
        hug();
    }
}

class Dog implements Observer {
    public void bark() {
        System.out.println("dog barking...");
    }

    @Override
    public void actionOnWakeUp(Event e) {
        bark();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
