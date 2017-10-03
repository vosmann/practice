package com.vosmann.practice.codility;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UnpairedIntegerInArray {

    public int unpaired(int[] A) {
        Set<Integer> s = new HashSet<>(); // space: O(n)
        for (int a : A) {
            if (!s.contains(a)) s.add(a);
            else s.remove(a);
        }
        for (int x : s) return x;
        return 0;
    }

    public int unpairedSmall(int[] A) {
        int r = 0;
        for (int a : A) r = r ^ a;
        return r;
    }

    @Test
    public void test() {
        assertThat(unpaired(new int[]{9, 3, 9, 3, 9, 7, 9}), is(7));
        assertThat(unpairedSmall(new int[]{9, 3, 9, 3, 9, 7, 9}), is(7));
    }

    @Test
    public void testBig() {
        int size = 1 * 1000 - 1;
        int[] a = new int[size];
        for (int i = 0; i < size / 2; ++i) {
            a[i] = i;
            a[size - 2 - i] = i;
        }
        a[size - 1] = 42;

        System.out.println("a = ");
        for (int i = 0; i < size; ++i)
            System.out.print(a[i] + ", ");
        System.out.println("[end]");
        /*
        */

        assertThat(unpaired(a), is(42));
        assertThat(unpairedSmall(a), is(42));
    }

}

