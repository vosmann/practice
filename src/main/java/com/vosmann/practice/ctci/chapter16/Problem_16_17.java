package com.vosmann.practice.ctci.chapter16;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem_16_17 {

    int maxSum(int[] d) {
        if (d == null || d.length == 0) return Integer.MIN_VALUE;
        if (d.length == 1) return d[0];

        int end = 0;
        int max = d[0];
        int sum = d[0];

        for (int i = 1; i < d.length; ++i) {
            if (sum + d[i] > max) {
                max = sum + d[i];
                end = i;
            }
            sum += d[i];
        }

        int start = 0;

        for (int i = 0; i <= (end - 1); ++i) {

            if (i == 0) sum = d[0];
            else sum += d[i];

            if (max - sum > max) {
                max -= sum;
                start = i + 1;
            }
        }

        System.out.println("start=" + start + ", end=" + end + ", max=" + max);

        return max;
    }

    @Test
    public void testSingle() {
        assertThat(maxSum(new int[]{1}), is(1));
    }

    @Test
    public void test1() {
        assertThat(maxSum(new int[]{1, 0, -2, 4, -1, 10, -5}), is(13));
    }

    @Test
    public void test2() {
        assertThat(maxSum(new int[]{2, -8, 3, -2, 4, -10}), is(5));
    }

}

