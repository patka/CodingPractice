package com.github.codingpractice.sorting;

import java.lang.reflect.Array;

/**
 * @author Patrick Kranz
 */
public class MergeSort {
    private MergeSort() {
        // prevent instance creation
    }

    public static <T extends Comparable<T>> void sort(T[] toSort) {
        if (toSort != null) {
            mergeSort(toSort, 0, toSort.length - 1);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void mergeSort(T[] toSort, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;
        int startSecondHalf = middle + 1;

        mergeSort(toSort, start, middle);
        mergeSort(toSort, startSecondHalf, end);

        // plus one because the values are zero based
        int numberOfElementsToSort = end - start + 1;

        T[] helperArray = (T[]) Array.newInstance(toSort.getClass().getComponentType(), numberOfElementsToSort);

        // copy values to sort in this recursion to helper array
        // to avoid shifting during the sorting process
        System.arraycopy(toSort, start, helperArray, 0, (middle - start) + 1);
        // copy the second half of elements in reverse order
        // so merging is easier
        for (int i = end; i >= startSecondHalf; i--) {
            int indexInHelperArray = helperArray.length - 1 - (i - startSecondHalf);
            helperArray[indexInHelperArray] = toSort[i];
        }

        // now merge the values
        int right = 0;
        int left = helperArray.length - 1;
        for (int i = 0; i < helperArray.length; i++) {
            if (helperArray[right].compareTo(helperArray[left]) <= 0) {
                toSort[start + i] = helperArray[right];
                right++;
            } else {
                toSort[start + i] = helperArray[left];
                left--;
            }
        }
    }
}
