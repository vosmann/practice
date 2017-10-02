package com.vosmann.practice.ctci.chapter8;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static com.google.common.collect.ImmutableSet.of;
import static com.google.common.collect.Sets.difference;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Problem_8_11 {

    int count(int n) {
        int[] c = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            c[i] = -1;
        }

        return c(n, c, of(25, 10, 5, 1));
    }

    private int c(int n, int[] c, Set<Integer> a) {
        if (c[n] != -1) return c[n];

        if (a.size() == 1) return 1;

        int maxcoin = Collections.max(a);
        int result = 0;

        for (int i = n / maxcoin; i >= 0; --i) {
            int newN = n - i * maxcoin;
            if (c[newN] != -1) result += c[newN];
            else {
                int r = c(newN, c, difference(a, of(maxcoin)));
                result += r;
                c[newN] = r;
            }
        }

        c[n] = result;
        return c[n];
    }

    @Test
    public void test() {
        assertThat(count(7), is(2));
        assertThat(count(6), is(2));
        assertThat(count(5), is(2));
        assertThat(count(4), is(1));
        assertThat(count(1), is(1));
    }

}

