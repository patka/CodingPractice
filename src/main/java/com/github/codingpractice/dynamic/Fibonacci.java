package com.github.codingpractice.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Patrick Kranz
 */
public class Fibonacci {
    private static final Map<Integer, Long> resultCache = new HashMap<>();

    private Fibonacci() {
        // prevent instance creation
    }

    public static long getNthFibonacciNumberRecursive(int n) {
        if (n < 2) return n;

        return getNthFibonacciNumberRecursive(n - 1) + getNthFibonacciNumberRecursive(n - 2);
    }

    public static long getNthFibonacciNumberCaching(int n) {
        if (n < 2) return n;

        if (resultCache.containsKey(n)) {
            return resultCache.get(n);
        } else {
            long minusOne = getNthFibonacciNumberCaching(n-1);
            long minusTwo = getNthFibonacciNumberCaching(n-2);
            resultCache.put(n-1, minusOne);
            resultCache.put(n-2, minusTwo);
            return minusOne + minusTwo;
        }
    }

    public static long getNthFibonacciNumberIterative(int n) {
        long minusOne = 1;
        long minusTwo = 0;
        long result = 0;

        for (int i = 2; i <= n; i++) {
            result = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = result;
        }
        return result;
    }
}
