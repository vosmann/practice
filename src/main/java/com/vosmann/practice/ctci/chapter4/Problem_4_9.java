package com.vosmann.practice.ctci.chapter4;

import com.vosmann.practice.ctci.Utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.ImmutableSet.of;
import static com.google.common.collect.Sets.difference;
import static com.google.common.collect.Sets.union;

public class Problem_4_9 {

    void printArrays(TreeNode n) {
        if (n == null) return;
        p(of(n), new ArrayList<>());
    }

    void p(Set<TreeNode> toExpand, List<TreeNode> toPrint) {
        if (toExpand.isEmpty()) System.out.println(toPrint);
        for (TreeNode e : toExpand) {
            // if (e == null) System.out.println("e is null");
            // Set<TreeNode> childrenOfE = of(e.l, e.r).stream().filter(el -> el != null).collect(toSet());
            Set<TreeNode> childrenOfE = new HashSet<>();
            if (e.l != null) childrenOfE.add(e.l);
            if (e.r != null) childrenOfE.add(e.r);

            // System.out.println("childrenOfE: " + childrenOfE);
            Set<TreeNode> te = union(difference(toExpand, of(e)),
                                     childrenOfE);

            List<TreeNode> tp = new ArrayList<>();
            tp.addAll(toPrint);
            tp.add(e);

            p(te, tp);
        }
    }

    @Test
    public void test1() {
        // create tree
        TreeNode two = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode five = new TreeNode(5, null, new TreeNode(6));
        TreeNode root = new TreeNode(4, two, five);

        printArrays(root);
    }

    @Test
    public void test2() {
        // create tree
        TreeNode eight = new TreeNode(8, new TreeNode(5), new TreeNode(9));
        TreeNode root = new TreeNode(4, new TreeNode(1), eight);

        printArrays(root);
    }

}

