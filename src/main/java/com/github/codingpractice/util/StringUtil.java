package com.github.codingpractice.util;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.toLowerCase;

/**
 * @author Patrick Kranz
 */
public final class StringUtil {
    private StringUtil() {
        // prevent object creation
    }

    public static boolean isAnagram(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        Map<Character, Integer> characterCount = new HashMap<>();
        for (int i = 0; i<first.length(); i++) {
            Character current = toLowerCase(first.charAt(i));
            if (current >= 'a' && current <= 'z') {
                incrementCharacter(characterCount, toLowerCase(current));
            }
        }

        for (int i=0; i<second.length(); i++) {
            Character current = toLowerCase(second.charAt(i));
            if (current >= 'a' && current <= 'z') {
                if (characterCount.containsKey(current)) {
                    Integer newValue = characterCount.get(current) - 1;
                    if (newValue == 0) {
                        characterCount.remove(current);
                    } else {
                        characterCount.put(current, newValue);
                    }
                } else {
                    return false;
                }
            }
        }

        return characterCount.isEmpty();
    }

    private static void incrementCharacter(Map<Character, Integer> characters,
                                           Character toIncrement) {
        if (characters.containsKey(toIncrement)) {
            characters.put(toIncrement, characters.get(toIncrement) + 1);
        } else {
            characters.put(toIncrement, 1);
        }
    }
}
