package com.burning8393.strategy;

public interface Comparator<T extends Comparable> {
    int compare(T t1, T t2);
}
