package com.burning8393.iterator.v3;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
public class LinkedList_ implements Collection_ {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    @Override
    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if (head == null) {
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

}
