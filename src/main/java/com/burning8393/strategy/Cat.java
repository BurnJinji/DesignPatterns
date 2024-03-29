package com.burning8393.strategy;

public class Cat implements Comparable<Cat>{
    int weight;
    int height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Cat cat) {
        if (this.weight < cat.weight) return -1;
        else if (this.weight > cat.weight) return 1;
        else return 0;
    }
}
