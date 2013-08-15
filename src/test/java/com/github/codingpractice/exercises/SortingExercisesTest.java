package com.github.codingpractice.exercises;

import org.junit.Test;

import static com.github.codingpractice.exercises.SortingExercises.sortAnagramsNextToEachOtherWithoutWhitespace;
import static com.github.codingpractice.exercises.SortingExercises.sortAnagramsNextToEachOtherBruteForce;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author Patrick Kranz
 */
public class SortingExercisesTest {
    @Test
    public void shouldReturnUntouchedArrayWhenArrayWithoutAnagramGiven() {
        String[] toSort = new String[] { "a", "b", "c" };
        sortAnagramsNextToEachOtherBruteForce(toSort);
        assertArrayEquals(new String[] { "a", "b", "c" }, toSort);
    }

    @Test
    public void shouldReturnUntouchedArrayWhenArrayWithTwoAnagramsInFrontGiven() {
        String[] toSort = new String[] { "ab", "ba", "c" };
        sortAnagramsNextToEachOtherBruteForce(toSort);
        assertArrayEquals(new String[] { "ab", "ba", "c" }, toSort);
    }

    @Test
    public void shouldReturnArrayWithAnagramsWhenArrayWithTwoAnagramsGiven() {
        String[] toSort = new String[] { "ab", "c", "ba" };
        sortAnagramsNextToEachOtherBruteForce(toSort);
        assertArrayEquals(new String[] { "ab", "ba", "c" }, toSort);
    }

    @Test
    public void shouldReturnArrayWithAnagramsInFrontWhenArrayWithTwoAnagramGroupsGiven() {
        String[] toSort = new String[] { "c", "ba", "ad", "ab", "da", "abc", "cba", "bac" };
        sortAnagramsNextToEachOtherBruteForce(toSort);
        assertArrayEquals(new String[] { "ba", "ab", "ad", "da", "abc", "cba", "bac", "c" }, toSort);
    }

    @Test
    public void shouldReturnArrayWithAnagramsInFrontWhenArrayWithNoAnagramMatchInFirstPositionGiven() {
        String[] toSort = new String[] { "c", "ba", "ab" };
        sortAnagramsNextToEachOtherBruteForce(toSort);
        assertArrayEquals(new String[] { "ba", "ab", "c" }, toSort);
    }

    @Test
    public void shouldReturnArrayWithGroupedAnagramsWhenArrayWithTwoAnagramGroupsGiven() {
        String[] toSort = new String[] { "c", "ba", "ad", "ab", "da", "abc", "cba", "bac" };
        String[] result = sortAnagramsNextToEachOtherWithoutWhitespace(toSort);
        assertArrayEquals(new String[] { "ba", "ab", "abc", "cba", "bac", "ad", "da", "c" }, result);
    }
}
