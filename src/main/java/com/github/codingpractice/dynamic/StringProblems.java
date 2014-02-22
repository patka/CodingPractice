package com.github.codingpractice.dynamic;

import java.util.*;

import static java.lang.System.out;

/**
 * @author Patrick Kranz
 */
public class StringProblems {
    // a => a
    // ab => ab, ba
    // abc => abc, acb, cab, bac, bca, cba

    private List<String> permutate(char toAppend, List<String> permutations) {
        if (permutations.size() == 0) return Arrays.asList(Character.toString(toAppend));
        List<String> result = new ArrayList<>();

        for (String permutation : permutations) {
            char[] chars = permutation.toCharArray();
            for(int i = 0; i<=chars.length; i++) {
                StringBuilder builder = new StringBuilder(permutation);
                builder.insert(i, toAppend);
                result.add(builder.toString());
            }
        }

        return result;
    }

    public List<String> permutate(String input) {
        List<String> result = new ArrayList<>();
        for (char character : input.toCharArray()) {
            result = permutate(character, result);
        }
        return result;
    }

    // () => ()
    // ()() => ()(), (())
    // ()()() => ()()(), (())(), ()(()), ((())), (()())
    private Set<String> parenthesisCombinations(int number, Set<String> combinations) {
        if (number == 0) {
            Set<String> result = new HashSet<>();
            result.add("()");
            return result;
        }

        combinations = parenthesisCombinations(number - 1, combinations);
        Set<String> newCombinations = new HashSet<>();
        for (String parenthesis : combinations) {
            for (int i = 0; i<parenthesis.length(); i++) {
                StringBuilder builder = new StringBuilder(parenthesis);
                builder.insert(i, "()");
                newCombinations.add(builder.toString());
            }
        }
        return newCombinations;
    }

    public Set<String> parenthesisCombinations(int number) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i<number; i++) {
            result = parenthesisCombinations(i, result);
        }
        return result;
    }

    public void parenthesis(List<String> result, String soFar, int leftToGo, int rightToGo) {
        if (leftToGo == 0 && rightToGo == 0) {
            result.add(soFar);
            return;
        }
        if (leftToGo == rightToGo) {
            parenthesis(result, soFar + "(", leftToGo - 1, rightToGo);
            return;
        }
        if (leftToGo < rightToGo) {
            parenthesis(result, soFar + ")", leftToGo, rightToGo - 1);
            if (leftToGo > 0) {
                parenthesis(result, soFar + "(", leftToGo - 1, rightToGo);
            }
        }

    }

    public List<String> parenthesis(int numberOfParenthesis) {
        List<String> result = new ArrayList<String>();
        parenthesis(result, "", numberOfParenthesis, numberOfParenthesis);
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        if (args.length == 0) return;
        List<String> result = new StringProblems().parenthesis(13);
        long end = System.currentTimeMillis();
        out.println("Number of results: " + result.size());
        out.println("It took " + (end - start) + "ms");
    }
}
