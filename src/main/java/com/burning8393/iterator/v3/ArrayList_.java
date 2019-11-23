package com.burning8393.iterator.v3;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
public class ArrayList_ implements Collection_ {
    private Object[] objs = new Object[10];
    private int index;
    @Override
    public void add(Object o) {
        if (index == objs.length) {
            Object[] newObjs = new Object[objs.length * 2];
            System.arraycopy(objs, 0, newObjs, 0, objs.length);
            objs = newObjs;
        }
        objs[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }
}
