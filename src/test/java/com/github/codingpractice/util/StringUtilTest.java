package com.github.codingpractice.util;

import org.junit.Test;

import static com.github.codingpractice.util.StringUtil.isAnagram;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * @author Patrick Kranz
 */
public class StringUtilTest {

    @Test
    public void shouldReturnFalseWhenNullAsParameterGiven() {
        assertFalse(isAnagram(null, ""));
        assertFalse(isAnagram(null, null));
        assertFalse(isAnagram("", null));
    }

    @Test
    public void shouldReturnFalseWhenTwoNonAnagramStringsGiven() {
        assertFalse(isAnagram("abc", "def"));
    }

    @Test
    public void shouldReturnTrueWhenTwoAnagramStringsGiven() {
        assertTrue(isAnagram("abc", "bca"));
    }

    @Test
    public void shouldReturnTrueWhenTwoAnagramStringsWithWhitespaceGiven() {
        assertTrue(isAnagram("abc cde", "cdeabc"));
    }

    @Test
    public void shouldReturnFalseWhenTwoWordsWithSameLettersButDifferentLetterCountGiven() {
        assertFalse(isAnagram("abbc", "abc"));
    }

    @Test
    public void shouldReturnTrueWhenTwoWordsWithSameLettersButDifferentCasingGiven() {
        assertTrue(isAnagram("Abc", "aBC"));
    }
}
