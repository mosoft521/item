package com.company.ch04String.item053;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringUtilsTest {
    @Test
    public void testRemove() {
        System.out.println(StringUtils.remove("$是$", "$"));
        assertTrue(StringUtils.remove("$是$", "$").equals("是"));
    }
}
