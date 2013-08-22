package com.github.codingpractice.searching;

import org.junit.Test;

import static com.github.codingpractice.searching.BinarySearch.search;
import static junit.framework.Assert.assertEquals;

/**
 * @author Patrick Kranz
 */
public class BinarySearchTest {
    @Test
    public void shouldReturnCorrectPositionWhenSortedArrayWithOddNumberOfElementsGiven() {
        int[] haystack = new int[] { 2, 3, 4, 5, 6, 7, 8 };
        assertEquals(2, search(haystack, 4));
    }

    @Test
    public void shouldReturnCorrectPositionWhenSortedArrayWithEvenNumberOfElementsGiven() {
        int[] haystack = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };
        assertEquals(2, search(haystack, 4));
    }

    @Test
    public void shouldReturnMinusOneWhenHaystackWithoutNeedleGiven() {
        int[] haystack = new int[] { 2, 3, 4, 5, 6, 7, 8 };
        assertEquals(-1, search(haystack, 1));
    }

    @Test
    public void shouldReturnCorrectValueWhenHaystackWithOneElementGiven() {
        int[] haystack = new int[] { 2 };
        assertEquals(0, search(haystack, 2));
    }

    @Test
    public void shouldReturnMinusOneWhenOneElementHaystackWithoutNeedleGiven() {
        int[] haystack = new int[] { 2 };
        assertEquals(-1, search(haystack, 3));
    }

    @Test
    public void shouldReturnMinuseOneWhenEmptyHaystackGiven() {
        int[] haystack = new int[] { 2 };
        assertEquals(-1, search(haystack, 3));
    }
}
