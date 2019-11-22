package com.burning8393.abstractfactory;

public class ModernFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    @Override
    Food createFood() {
        return new Bread();
    }
}
