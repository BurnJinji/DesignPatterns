package com.burning8393.iterator.v6;

/**
 * 构建一个容器，可以添加对象
 * 用链表来实现一个容器
 * 添加容器的共同接口，实现容器的转换
 * 如何对容器遍历
 * 用一种统一的遍历方式，要求每一个容器都要提供Iterator的实现类
 */
public class Main {
    public static void main(String[] args) {
        Collection_<String> list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add("s" + i);
        }
        System.out.println(list.size());

        Iterator_<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String o = iterator.next();
            System.out.println(o);
        }
    }
}
