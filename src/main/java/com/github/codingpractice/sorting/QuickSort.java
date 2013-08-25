package com.github.codingpractice.sorting;

/**
 * @author Patrick Kranz
 */
public class QuickSort {
    private QuickSort() {
        // prevent instance creation
    }

    public static void sort(int[] toSort) {
        if (toSort == null) {
            throw new IllegalArgumentException("Provide something to sort please.");
        }
        sort(toSort, 0, toSort.length - 1);
    }

    private static void sort(int[] toSort, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int pivotIndex = quickSort(toSort, leftIndex, rightIndex);
        sort(toSort, leftIndex, pivotIndex - 1);
        sort(toSort, pivotIndex + 1, rightIndex);
    }

    private static int quickSort(int[] toSort, int leftIndex, int rightIndex) {
        int pivot = toSort[rightIndex];
        int i = leftIndex;
        int j = rightIndex - 1;
        while(i < j) {
            while(i < j && toSort[i] <= pivot) {
                i++;
            }
            while(j > i && toSort[j] >= pivot) {
                j--;
            }
            // check if we really found something to swap
            if (i < j) {
                swap(toSort, i, j);
                i++;
                j--;
            }
        }

        // only do this if the value is bigger than the pivot element
        // => if the list is already sorted, runtime will be O(n^2)
        // because the pivot element will only move one left for every
        // iteration
        if (toSort[i] > pivot)
            swap(toSort, i, rightIndex);
        return i;
    }

    private static void swap(int[] toSort, int i, int j) {
        int tmp = toSort[i];
        toSort[i] = toSort[j];
        toSort[j] = tmp;
    }
}
