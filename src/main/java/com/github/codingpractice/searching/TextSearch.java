package com.github.codingpractice.searching;

/**
 * @author Patrick Kranz
 */
public class TextSearch {
    public static int searchBruteForce(String haystack, String needle) {
        if (haystack == null) {
            throw new IllegalArgumentException("Need something to search in.");
        }
        if (needle == null) {
            throw new IllegalArgumentException("Need something to search for.");
        }

        char[] hayStackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i <= hayStackChars.length - needleChars.length; i++) {
            for (int j = 0; j < needleChars.length; j++) {
                if (hayStackChars[i+j] != needleChars[j]) {
                    break;
                }
                if ( j == needleChars.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
