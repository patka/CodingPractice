package com.github.codingpractice.sorting;

import org.junit.Assert;
import org.junit.Test;

import static com.github.codingpractice.sorting.MergeSort.sort;

/**
 * @author Patrick Kranz
 */
public class MergeSortTest {
    @Test
    public void shouldSortArrayWithEvenNumberOfElementsWhenUnsortedArrayGiven() {
        Integer[] toSort = new Integer[] { 24, 13, 98, 99, 7, 0 };
        sort(toSort);
        Assert.assertArrayEquals(new Integer[] { 0, 7, 13, 24, 98, 99}, toSort);
    }

    @Test
    public void shouldSortArrayWithOddNumberOfElementsWhenUnsortedArrayGiven() {
        Integer[] toSort = new Integer[] { 9, 5, 7 };
        sort(toSort);
        Assert.assertArrayEquals(new Integer[] { 5, 7, 9 }, toSort);
    }

    @Test
    public void shouldReturnWhenNullArrayGiven() {
        sort(null);
    }
}
