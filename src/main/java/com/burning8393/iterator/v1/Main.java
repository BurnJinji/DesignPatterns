package com.burning8393.iterator.v1;

/**
 * 构建一个容器，可以添加对象
 */
public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class ArrayList_ {
    Object[] list = new Object[10];

    private int index = 0;

    public void add(Object o) {
        if (index == list.length) {
            Object[] newObjs = new Object[list.length * 2];
            System.arraycopy(list, 0, newObjs, 0, list.length);
            list = newObjs;
        }
        list[index] = o;
        index++;
    }

    public int size() {
        return index;
    }
}
