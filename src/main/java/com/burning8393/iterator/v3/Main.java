package com.burning8393.iterator.v3;

/**
 * 构建一个容器，可以添加对象
 * 用链表来实现一个容器
 * 添加容器的共同接口，实现容器的转换
 */
public class Main {
    public static void main(String[] args) {
        Collection_ linkedList = new LinkedList_();
        Collection_ arrayList = new ArrayList_();

        for (int i = 0; i < 15; i++) {
            linkedList.add("s" + i);
            arrayList.add("s" + i);
        }
        System.out.println("linkedlist: " + linkedList.size());
        System.out.println("arraylist: " + arrayList.size());
    }

}
