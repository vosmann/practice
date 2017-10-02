package com.vosmann.practice.codility;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryGap {

    public int binaryGap(int n) {
        final int first = 1 << 31;
        int position = 31;
        while ((n & first) != first) {
            n <<= 1;
            --position;
        }
        int c = 0;
        int max = 0;
        n <<= 1;
        --position;

        while (position >= 0) {

            if ((n & first) == first) {
                c = 0;
            } else {
                ++c;
            }

            if (c > max) max = c;

            n <<= 1;
            --position;

        }

        return max;

    }

    @Test
    public void testOne() {
        assertThat(binaryGap(1), is(0));
    }

    @Test
    public void testMaxValue() {
        assertThat(binaryGap(Integer.MAX_VALUE), is(0));
    }

    @Test
    public void test() {
        assertThat(binaryGap(5), is(1));
        assertThat(binaryGap(1 << 4), is(4));
        assertThat(binaryGap(1 << 10), is(10));

        assertThat(binaryGap(1553), is(4));
    }

}

