package com.vosmann.practice.hackerrank;

import com.google.common.collect.Lists;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SwapNodesTest {

    @Test
    public void testSample02() throws IOException {

        // String path = "practice/src/test/resources/hackerrank/swapnodes/sample-02-input";
        String path = "src/test/resources/hackerrank/swapnodes/sample-02-input";
        List<String> swapped = SwapNodes.swapFromFile(path);

        List<String> expected = Lists.newArrayList("2 9 6 4 1 3 7 5 11 8 10", "2 6 9 4 1 3 7 5 10 8 11");
        assertThat(swapped, is(expected));
    }

}