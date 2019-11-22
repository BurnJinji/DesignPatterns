package com.burning8393.factorymethod;

public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().createCar();
        m.go();
    }
}
