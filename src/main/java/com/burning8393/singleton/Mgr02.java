package com.burning8393.singleton;

/**
 * 跟01 一个意思
 */
public class Mgr02 {
    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {
    }

    public static Mgr02 getINSTANCE() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getINSTANCE();
        Mgr02 m2 = Mgr02.getINSTANCE();
        System.out.println(m1 == m2);
    }
}
