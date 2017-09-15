package com.vosmann.practice.ctci.chapter5;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem_5_3 {

    public int longestFlip(int n) {
        if (n == 0) return 1;

        int max = Integer.MIN_VALUE;
        boolean flipped = false;
        int currLen = 0;

        while (n != 0) {
            while (n % 2 == 1) {
                ++currLen;
                if (currLen > max) max = currLen;
                n /= 2;
            }

            if (!flipped) {
                flipped = true;
                ++currLen;
                if (currLen > max) max = currLen;
                n /= 2;
                if (n % 2 == 0) {
                    flipped = false;
                    currLen = 0;
                }
            } else {
                n /= 2;
                if (n % 2 == 0) {
                    flipped = false;
                    currLen = 0;
                }
            }
        }

        return max;
    }

    @Test
    public void test0() {
        // 00000
        int input = 0;
        assertThat(longestFlip(input), is(1));
    }

    @Test
    public void test29() {
        // 011101
        int input = 29;
        assertThat(longestFlip(input), is(5));
    }

    @Test
    public void test56() {
        // 0111000
        int input = 56;
        assertThat(longestFlip(input), is(4));
    }

    @Test
    public void test31() {
        // 11111
        int input = 31;
        assertThat(longestFlip(input), is(6));
    }

    @Test
    public void test923() {
        // 1110011011
        int input = 923;
        assertThat(longestFlip(input), is(5));
    }

}

