package com.vosmann.practice.ac;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RotationTest {

    @Test
    public void testPerformRotationOnfile1() throws Exception {
        String path = "src/test/resources/ac/rotation-input-01";

        String expected = "ceadb";
        String result = Rotation.performRotationOnfile(path);

        assertThat(result, is(expected));
    }

    @Test
    public void testPerformRotationOnfile2() throws Exception {
        String path = "src/test/resources/ac/rotation-input-02";

        String expected = "vkidskofbk";
        String result = Rotation.performRotationOnfile(path);

        assertThat(result, is(expected));
    }

}