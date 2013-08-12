package com.github.codingpractice.exercises;

import static com.github.codingpractice.util.StringUtil.isAnagram;

/**
 * @author Patrick Kranz
 */
public final class SortingExercises {
    private SortingExercises() {
        // prevent instance creation
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
}
