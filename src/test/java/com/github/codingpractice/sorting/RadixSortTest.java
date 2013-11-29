package com.github.codingpractice.sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Patrick Kranz
 */
public class RadixSortTest {

    @Test
    public void shouldSortArrayWhenUnsortedArrayGiven() {
        int[] toSort = new int[] { 15, 3, 97, 88, 13, 333, 1075 };
        RadixSort.sort(toSort);
        Assert.assertArrayEquals(new int[] { 3, 13, 15, 88, 97, 333, 1075}, toSort);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativeValueGiven() {
        int[] toSort = new int[] { 15, 3, 97, 88, -13, 333, 1075 };
        RadixSort.sort(toSort);
    }

}
