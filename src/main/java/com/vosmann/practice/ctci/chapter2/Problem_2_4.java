package com.vosmann.practice.ctci.chapter2;

import com.vosmann.practice.ctci.Utils.Node;
import org.junit.Test;

import static com.vosmann.practice.ctci.Utils.generateList;
import static com.vosmann.practice.ctci.Utils.print;

public class Problem_2_4 {

    static Node partition(final Node head, final int x) {
        Node result = head;
        Node oth = null;
        Node prev = null;

        for (Node curr = head; curr != null; ) {
            if (curr.data >= x) {
                final Node rest = curr.next;

                // remove
                if (prev == null) {
                    result = curr.next;
                } else {
                    prev.next = curr.next;
                }

                // add to other
                curr.next = oth;
                oth = curr;

                // move along
                curr = rest;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        prev.next = oth;
        return result;
    }

    @Test
    public void test() {
        test(3,
             1, 2, 3, 4, 5);

    }

    @Test
    public void test2() {
        test(3,
             5, 4, 3, 2, 1);
    }

    @Test
    public void test3() {
        test(3,
             2, 8, 1);
    }

    @Test
    public void test4() {
        test(3,
             4, 6, 2, 1, 8);
    }

    private void test(int x, int... data) {
        Node list = generateList(data);
        print("Original:    ", list);

        Node partitioned = partition(list, x);
        print("Partitioned: ", partitioned);

        System.out.println();
    }

}
