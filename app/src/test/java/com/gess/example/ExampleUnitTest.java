package com.gess.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        int a = 10;
        System.out.println("a1 = " + a);
        int b = ++a;
        System.out.println("a2 = " + a);
        System.out.println("b = " + b);
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHash(){
        System.out.println("hello world".hashCode());
    }
}