package com.burning8393.iterator.v6;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
public class ArrayList_<E> implements Collection_<E> {
    private E[] objs = (E[]) new Object[10];
    private int index;
    @Override
    public void add(E e) {
        if (index == objs.length) {
            E[] newObjs = (E[]) new Object[objs.length * 2];
            System.arraycopy(objs, 0, newObjs, 0, objs.length);
            objs = newObjs;
        }
        objs[index] = e;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator_ {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public E next() {
            E o = (E)objs[currentIndex];
            currentIndex++;
            return o;
        }
    }

}
