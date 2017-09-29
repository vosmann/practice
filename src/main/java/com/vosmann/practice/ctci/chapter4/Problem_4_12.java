package com.vosmann.practice.ctci.chapter4;

import com.vosmann.practice.ctci.Utils.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem_4_12 {

    int count(TreeNode root, int t) {
        if (root == null) return 0;
        AtomicInteger c = new AtomicInteger(0);
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, null);
        r(root, c, 0, m, t);
        return c.intValue();
    }

    void r(TreeNode n, AtomicInteger c, int sum, Map<Integer, Integer> m, int t) {
        if (n == null) return;

        int s = sum + n.data;
        if (m.containsKey(s - t)) c.incrementAndGet();
        m.put(s, null);
        r(n.l, c, s, m, t);
        r(n.r, c, s, m, t);
        m.remove(s);
    }

    @Test
    public void test1() {
        // valueDepth

        TreeNode minusTwo3Left = new TreeNode(-2);
        TreeNode three3Left = new TreeNode(3);
        TreeNode one3Left = new TreeNode(1);
        TreeNode two3Left = new TreeNode(2);

        TreeNode two3Right = new TreeNode(2);
        TreeNode three3Right = new TreeNode(3);
        TreeNode zero3Right = new TreeNode(0);
        TreeNode one3Right = new TreeNode(1);

        TreeNode one2Left = new TreeNode(1, minusTwo3Left, three3Left);
        TreeNode minusOne2Left = new TreeNode(-1, one3Left, two3Left);
        TreeNode minusOne2Right = new TreeNode(-1, two3Right, three3Right);
        TreeNode one2Right = new TreeNode(1, zero3Right, one3Right);

        TreeNode two1 = new TreeNode(2, one2Left, minusOne2Left);
        TreeNode three1 = new TreeNode(3, one2Right, minusOne2Right);

        TreeNode one0 = new TreeNode(1, two1, three1);

        assertThat(count(one0, 4), is(7));
    }

}

