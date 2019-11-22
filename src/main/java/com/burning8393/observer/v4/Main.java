package com.burning8393.observer.v4;

/**
 * 加入多个观察者
 */
class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        dad.feed();
        mum.hug();
        dog.bark();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}

class Mum {
    public void hug() {
        System.out.println("mum hugging...");
    }
}

class Dog {
    public void bark() {
        System.out.println("dog barking....");
    }
}


public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        // do sth
        child.wakeUp();
    }
}
