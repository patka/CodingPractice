package com.github.codingpractice.sorting;

import org.junit.Test;

import static com.github.codingpractice.sorting.Sorting.bubbleSort;
import static com.github.codingpractice.sorting.Sorting.quickSort;
import static com.github.codingpractice.sorting.Sorting.selectionSort;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author Patrick Kranz
 */
public class SortingTest {
    @Test
    public void shouldSelectionSortArrayWhenUnsortedArrayGiven() {
        int[] toSort = new int[] { 19, 4, 7, 1, 34, -9, -67 };
        selectionSort(toSort);
        assertArrayEquals(new int[] { -67, -9, 1, 4, 7, 19, 34}, toSort);
    }

    @Test
    public void shouldBubbleSortArrayWhenUnsortedArrayGiven() {
        int[] toSort = new int[] { 19, 4, 7, 1, 34, -9, -67 };
        bubbleSort(toSort);
        assertArrayEquals(new int[] { -67, -9, 1, 4, 7, 19, 34}, toSort);
    }

    @Test
    public void shouldQuickSortArrayWhenUnsortedArrayWithOddNumberOfNumbersGiven() {
        int[] toSort = new int[] { 19, 4, 7, 1, 34, -9, -67 };
        quickSort(toSort);
        assertArrayEquals(new int[] { -67, -9, 1, 4, 7, 19, 34}, toSort);
    }

    @Test
    public void shouldQuickSortArrayWhenUnsortedArrayWithEvenNumberOfNumbersGiven() {
        int[] toSort = new int[] { 19, 4, 7, 1, 34, -9 };
        quickSort(toSort);
        assertArrayEquals(new int[] { -9, 1, 4, 7, 19, 34}, toSort);
    }
}
