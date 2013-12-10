package com.github.codingpractice.util;

/**
 * @author Patrick Kranz
 */
public class Assert {
    public static void notNull(Object toCheck, String parameterName) {
        if (toCheck == null) {
            throw new IllegalArgumentException("Parameter " + parameterName + " should not be null");
        }
    }
}
