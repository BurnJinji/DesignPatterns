package com.burning8393.iterator.v6;

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

    @Override
    public Iterator_ iterator() {
        return new LinkedIterator();
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    private class LinkedIterator implements Iterator_ {
        private int pos = 0;
        private Node currentNode = head;

        @Override
        public boolean hasNext() {
            return pos < size - 1;
        }

        @Override
        public Object next() {
            currentNode = currentNode.next;
            pos++;
            return currentNode.o;
        }
    }
}
