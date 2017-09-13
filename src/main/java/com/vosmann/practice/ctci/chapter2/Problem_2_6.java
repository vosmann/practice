package com.vosmann.practice.ctci.chapter2;

import com.vosmann.practice.ctci.chapter2.Utils.Node;
import org.junit.Test;

import static com.vosmann.practice.ctci.chapter2.Utils.generateList;
import static com.vosmann.practice.ctci.chapter2.Utils.print;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem_2_6 {

    static boolean isPalindrome(final Node head) {
        if (head == null) return true;
        Node result = r(head, head);
        return result != null;
    }

    static Node r(final Node head, final Node curr) {
        if (curr.next == null) { // last element
            System.out.println(String.format("Found last element. Head: %s, curr: %s", head, curr));
            if (head == curr) return head;
            if (head.data != curr.data) return null;
            return head.next;
        } else { // non-last element
            Node myH = r(head, curr.next);
            System.out.println(String.format("Got myH. myH: %s, curr: %s, curr.next: %s", myH, curr, curr.next));
            if (myH == null) return null;
            if (myH == curr
                    || myH == curr.next
                    || myH.data == -1) return new Node(-1); // special result value to indicate "done"
            if (myH.data != curr.data) {
                System.out.println(String.format("Mismatch. myH: %s, curr: %s, curr.next: %s", myH, curr, curr.next));
                return null;
            }
            return myH.next;
        }
    }

    @Test
    public void testNull() {
        test(true, null);
    }

    @Test
    public void testSingle() {
        test(true, 5);
    }

    @Test
    public void testPairSame() {
        test(true, 2, 2);
    }

    @Test
    public void testPairDifferent() {
        test(false, 2, 4);
    }

    @Test
    public void testOk4() {
        test(true, 1, 2, 2, 1);
    }

    @Test
    public void testBad4() {
        test(false, 2, 4, 4, 100);
    }

    @Test
    public void testOk5() {
        test(true, 1, 2, 3, 2, 1);
    }

    @Test
    public void testBad5() {
        test(false, 1, 4, 3, 2, 1);
    }

    private void test(boolean expectedResult, int... data) {
        Node list = generateList(data);
        print("Original: ", list);

        boolean palindrome = isPalindrome(list);
        print("After   : ", list);
        assertThat(palindrome, is(expectedResult));

        System.out.println();
    }

}
