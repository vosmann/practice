package com.vosmann.practice.ctci;

import java.util.Objects;

public class Utils {

    public static class Node {

        public Node next;
        public int data;

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

    public static class TreeNode {

        public int data;
        public TreeNode l;
        public TreeNode r;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode l, TreeNode r) {
            this(data);
            this.l = l;
            this.r = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return data == treeNode.data &&
                    Objects.equals(l, treeNode.l) &&
                    Objects.equals(r, treeNode.r);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, l, r);
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }
}
