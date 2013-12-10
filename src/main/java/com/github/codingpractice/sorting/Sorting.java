package com.github.codingpractice.sorting;

import static com.github.codingpractice.util.Assert.notNull;

/**
 * @author Patrick Kranz
 */
public class Sorting {
    public static void quickSort(int[] toSort) {
        if (toSort == null || toSort.length < 2)
            return;
        quickSort(toSort, 0, toSort.length - 1);
    }

    private static void quickSort(int[] toSort, int left, int right) {
        if (left >= right) return;

        int pivot = right;
        right = right - 1;
        while (left < right) {
            while (toSort[left] <= toSort[pivot] && left < right) {
                left++;
            }

            while(toSort[right] >= toSort[pivot] && right > left) {
                right --;
            }

            if (left < right) {
                swap(toSort, left, right);
                left++;
                right--;
            }
        }

        if (toSort[left] > toSort[pivot])
            swap(toSort, left, pivot);

        quickSort(toSort, 0, left);
        quickSort(toSort, left + 1, pivot);
    }

    public static void bubbleSort(int[] toSort) {
        notNull(toSort, "toSort");
        boolean unsorted = true;
        while(unsorted) {
            unsorted = false;
            for (int i = 0; i < toSort.length - 1; i++) {
                if (toSort[i] > toSort[i + 1]) {
                    swap(toSort, i, i+1);
                    unsorted = true;
                }
            }
        }
    }

    public static void selectionSort(int[] toSort) {
        if (toSort == null || toSort.length == 0) return;

        for (int i = 0; i < toSort.length; i++) {
            int minimumPosition =  i;
            for (int j = i; j < toSort.length; j++) {
                if (toSort[j] < toSort[minimumPosition]) {
                    minimumPosition = j;
                }
                swap(toSort, i, minimumPosition);
            }
        }
    }

    private static void swap(int[] array, int pos1, int pos2) {
        if (pos1 >= array.length || pos2 >= array.length)
            throw new IllegalArgumentException("Position arguments must be smaller then array size");
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
