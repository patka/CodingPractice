package com.github.codingpractice.searching;

import org.junit.Test;

import static com.github.codingpractice.searching.TextSearch.searchBruteForce;
import static junit.framework.Assert.assertEquals;

/**
 * @author Patrick Kranz
 */
public class TextSearchTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNullHaystackGiven() {
        searchBruteForce(null, "ab");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNullNeedleGiven() {
        searchBruteForce("ababab", null);
    }

    @Test
    public void shouldReturnMinusOneWhenHaystackWithoutNeedleGiven() {
        assertEquals(-1, searchBruteForce("ababcbaababc", "cde"));
    }

    @Test
    public void shouldReturnPositionOfNeedleWhenHaystackWithNeedleGiven() {
        assertEquals(2, searchBruteForce("ababcbaababc", "abc"));
    }

    @Test
    public void shouldReturnPositionZeroWhenHaystackEqualsNeedleGiven() {
        assertEquals(0, searchBruteForce("abc", "abc"));
    }

    @Test
    public void shouldReturnPositionOfNeedleWhenHaystackWithNeedleAtTheEndGiven() {
        assertEquals(6, searchBruteForce("ababcbaababc", "aababc"));
    }
}
