package com.github.codingpractice.sorting;

import org.junit.Test;

import static com.github.codingpractice.sorting.QuickSort.sort;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author Patrick Kranz
 */
public class QuickSortTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNullGiven() {
        sort(null);
    }

    @Test
    public void shouldSortNumbersCorrectlyWhenEvenAmountOfNumbersGiven() {
        int[] unsorted = new int[] {7, 3, 8, 12, 9, 10 };
        sort(unsorted);
        assertArrayEquals(new int[] {3, 7, 8, 9, 10, 12 }, unsorted);
    }

    @Test
    public void shouldSortNumbersCorrectlyWhenOddAmountOfNumbersGiven() {
        int[] unsorted = new int[] {8, 19, 12, 0, -4, 5, 3 };
        sort(unsorted);
        assertArrayEquals(new int[] {-4, 0, 3, 5, 8, 12, 19}, unsorted);
    }

    @Test
    public void shouldSortNumbersCorrectlyWhenArrayWithDuplicatesGiven() {
        int[] unsorted = new int[] {9, 3, 7, 3, 10, 11, 12, 9 };
        sort(unsorted);
        assertArrayEquals(new int[] {3, 3, 7, 9, 9, 10, 11, 12 }, unsorted);
    }
}
