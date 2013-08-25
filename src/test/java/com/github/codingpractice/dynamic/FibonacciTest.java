package com.github.codingpractice.dynamic;

import org.junit.Test;

import static com.github.codingpractice.dynamic.Fibonacci.getNthFibonacciNumberCaching;
import static com.github.codingpractice.dynamic.Fibonacci.getNthFibonacciNumberIterative;
import static com.github.codingpractice.dynamic.Fibonacci.getNthFibonacciNumberRecursive;
import static junit.framework.Assert.assertEquals;

/**
 * @author Patrick Kranz
 */
public class FibonacciTest {
    @Test
    public void shouldReturnInputValueWhenNegativeInputValueGiven() {
        assertEquals(-1, getNthFibonacciNumberRecursive(-1));
    }

    @Test
    public void shouldReturnOneWhenGiven() {
        assertEquals(1, getNthFibonacciNumberRecursive(1));
    }

    @Test
    public void shouldReturnZeroWhenZeroGiven() {
        assertEquals(0, getNthFibonacciNumberRecursive(0));
    }

    @Test
    public void shouldReturnCorrectFibonacciValueWhenNumberGreaterOneGiven() {
        assertEquals(8, getNthFibonacciNumberRecursive(6));
    }

    @Test
    public void testTimeRecursive() {
        long start = System.currentTimeMillis();
        getNthFibonacciNumberRecursive(45);
        long end = System.currentTimeMillis();
        System.out.println("Recursive way took for 45 numbers: " + (end - start) + " ms");
    }

    @Test
    public void testTimeCaching() {
        long start = System.currentTimeMillis();
        getNthFibonacciNumberCaching(500);
        long end = System.currentTimeMillis();
        System.out.println("Caching way took for 500 numbers: " + (end - start) + " ms");
    }

    @Test
    public void testTimeIterative() {
        long start = System.currentTimeMillis();
        getNthFibonacciNumberIterative(500);
        long end = System.currentTimeMillis();
        System.out.println("Iterative way took for 500 numbers: " + (end - start) + " ms");
    }
}
