package com.vosmann.practice.ac;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BallTest {

    @Test
    public void test1() throws Exception {
        testPerformSetOnFile("src/test/resources/ac/ball-input-01", "1 4 2 3 5 6 7 8");
    }

    @Test
    public void test2() throws Exception {
        testPerformSetOnFile("src/test/resources/ac/ball-input-02", "1 8 3 4 5 2 7 6");
    }

    public void testPerformSetOnFile(String path, String expected) throws Exception {
        String result = Ball.performSetOnFile(path);
        assertThat(result, is(expected));
    }

}
