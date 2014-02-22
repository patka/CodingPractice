package com.github.codingpractice.exercises;

/**
 * @author Patrick Kranz
 */
public class SearchingExcercises {

    public static int biggestSubSum(int[] array) {
        if (array == null) return 0;
        // this is the algorithm of Kadane
        int totalMaximum = 0;
        int totalSoFar = 0;
        for (int i = 0; i<array.length; i++) {
            totalSoFar += array[i];
            if (totalSoFar > totalMaximum) {
                totalMaximum = totalSoFar;
            } else if (totalSoFar < 0) {
                totalSoFar = 0;
            }
        }
        return totalMaximum;
    }
}
