package com.vosmann.practice.ctci.chapter2;

public class Utils {

    public static class Node {

        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    public static Node generateList(int... data) {
        if (data == null) return null;
        Node list = null;
        for (int i = 0; i < data.length; ++i) {
            Node n = new Node(data[i]);
            n.next = list;
            list = n;
        }
        return list;
    }

    public static void print(String prefix, Node list) {
        System.out.print(prefix);
        for (Node n = list; n != null; n = n.next) {
            System.out.print(n.data + " -> ");
        }
        System.out.println("null");
    }
}
