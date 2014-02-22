package com.github.codingpractice.exercises;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Patrick Kranz
 */
public class SearchingExercisesTest {

    @Test
    public void shouldReturnZeroWhenNullArrayGiven() {
        assertEquals(0, SearchingExcercises.biggestSubSum(null));
    }

    @Test
    public void shouldReturnCorrectResultWhenArrayWithPositiveAndNegativeNumbersGiven() {
        assertEquals(9, SearchingExcercises.biggestSubSum(new int[] { 3, 4, -6, 5, -10, 5, 4} ));
    }

    @Test
    public void shouldReturnSumOfArrayWhenOnlyPositiveIntegersGiven() {
        assertEquals(16, SearchingExcercises.biggestSubSum(new int[] { 3, 4, 5, 4} ));
    }

}
