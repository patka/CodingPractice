package com.github.codingpractice.searching;

/**
 * @author Patrick Kranz
 */
public class BinarySearch {
    private BinarySearch() {
        // prevent instance creation
    }

    public static int search(int[] haystack, int needle) {
        return search(haystack, needle, 0, haystack.length - 1);
    }

    public static int search(int[] haystack, int needle, int lowerIndex, int upperIndex) {
        if (lowerIndex >= upperIndex) {
            return -1;
        }
        int middle = (lowerIndex + upperIndex) / 2;
        if (haystack[middle] == needle) {
            return middle;
        }

        if (needle > haystack[middle]) {
            return search(haystack, needle, middle + 1, upperIndex);
        } else {
            return search(haystack, needle, lowerIndex, middle - 1);
        }
    }
}
