package com.burning8393.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] cats = {new Cat(5, 5), new Cat(1, 1), new Cat(3, 3)};
        Dog[] dogs = {new Dog(5), new Dog(1), new Dog(3)};
        Sorter sorter = new Sorter();

        sorter.sort(cats);
        System.out.println(Arrays.toString(cats));
        sorter.sort(dogs);
        System.out.println(Arrays.toString(dogs));
        // 策略模式 需要什么样的模式就传什么样的方法
        sorter.sort(cats, (c1, c2) -> {
            if (c1.weight < c2.weight) return 1;
            if (c1.weight > c2.height) return -1;
            return 0;
        });
        System.out.println(Arrays.toString(cats));

    }
}
