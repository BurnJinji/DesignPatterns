package com.burning8393.iterator.v4;

/**
 * 构建一个容器，可以添加对象
 * 用链表来实现一个容器
 * 添加容器的共同接口，实现容器的转换
 * 如何对容器遍历
 * 用一种统一的遍历方式，要求每一个容器都要提供Iterator的实现类
 */
public class Main {
    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());

        Iterator_ iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }
    }
}
