package com.github.codingpractice.exercises;

import com.github.codingpractice.sorting.MergeSort;

import java.util.*;

import static com.github.codingpractice.util.StringUtil.isAnagram;
import static java.util.Arrays.sort;

/**
 * @author Patrick Kranz
 */
public final class SortingExercises {
    private SortingExercises() {
        // prevent instance creation
    }

    public static String[] sortAnagramsNextToEachOtherWithoutWhitespace(String[] strings) {
        AnagramComparable[] toSort = new AnagramComparable[strings.length];
        for (int i = 0; i<strings.length; i++) {
            toSort[i] = new AnagramComparable(strings[i], i);
        }

        MergeSort.sort(toSort);

        String[] result = new String[strings.length];
        for(int i = 0; i < strings.length; i++) {
            result[i] = strings[toSort[i].originalPosition];
        }

        return result;
    }

    public static void sortAnagramsNextToEachOtherExpensive(String[] strings) {
        String[] sortedStrings = new String[strings.length];
        Set<String> anagrams = new HashSet<>();
        for (int i = 0; i<strings.length; i++) {
            char[] current = strings[i].toLowerCase().toCharArray();
            sort(current);
            sortedStrings[i] = new String(current);
        }
        Map<String, List<Integer>> valuePositionMap = new HashMap<>();
        for (int i = 0; i<sortedStrings.length; i++) {
            String current = sortedStrings[i];
            if (valuePositionMap.containsKey(current)) {
                if (!anagrams.contains(current)) {
                    anagrams.add(current);
                }
                valuePositionMap.get(current).add(i);
            } else {
                List<Integer> positions = new ArrayList<Integer>();
                positions.add(i);
                valuePositionMap.put(current, positions);
            }
        }

        for (String anagram : anagrams) {
            List<Integer> allPositions = valuePositionMap.get(anagram);
        }
    }

    public static void sortAnagramsNextToEachOtherBruteForce(String[] strings) {
        // handle moving to first position
        int nextFreePosition = 0;
        for (int i = 0; i < strings.length - 1; i++) {
            String currentString = strings[i];
            boolean firstResult = true;
            for (int j = i + 1; j < strings.length; j++) {
                if (isAnagram(currentString, strings[j])) {
                    // need to move i?
                    if (firstResult && i != nextFreePosition) {
                        swap(strings, i, nextFreePosition);
                        nextFreePosition++;
                        firstResult = false;
                    } else if (firstResult) {
                        nextFreePosition++;
                        firstResult = false;
                    }
                    if (j != nextFreePosition) {
                        swap(strings, j, nextFreePosition);
                    }
                    nextFreePosition++;
                }
            }
            if (nextFreePosition > i) {
                i = nextFreePosition - 1;
            }
        }
    }

    private static void swap(String[] array, int first, int second) {
        String tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    private static class AnagramComparable implements Comparable<AnagramComparable> {
        private String sortedString;
        private int originalPosition;

        public AnagramComparable(String toCheck, int originalPosition) {
            char[] chars = toCheck.toLowerCase().toCharArray();
            sort(chars);
            this.sortedString = new String(chars);
            this.originalPosition = originalPosition;
        }

        public int getOriginalPosition() {
            return originalPosition;
        }

        @Override
        public int compareTo(AnagramComparable other) {
            return sortedString.compareTo(other.sortedString);
        }
    }
}
