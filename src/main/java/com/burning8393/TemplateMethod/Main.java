package com.burning8393.TemplateMethod;

public class Main {
    public static void main(String[] args) {
        F f = new C1();
        f.m();
    }
}

abstract class F {
    public void m() {
        op1();
        op2();
    }

    public abstract void op1();

    public abstract void op2();
}

class C1 extends F {
    @Override
    public void op1() {
        System.out.println("op1");
    }

    @Override
    public void op2() {
        System.out.println("op2");
    }
}
