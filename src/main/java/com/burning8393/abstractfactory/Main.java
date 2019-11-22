package com.burning8393.abstractfactory;

public class Main {
    public static void main(String[] args) {
//        AbstractFactory factory = new ModernFactory();
        AbstractFactory factory = new MagicFactory();

        Vehicle v = factory.createVehicle();
        v.go();
        Weapon w = factory.createWeapon();
        w.shoot();
        Food f = factory.createFood();
        f.printName();
    }
}
