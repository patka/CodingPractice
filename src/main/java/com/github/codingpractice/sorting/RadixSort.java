package com.github.codingpractice.sorting;

import java.util.LinkedList;

/**
 * @author Patrick Kranz
 */
public class RadixSort {

	public static void sort(int[] numbersToSort) {
		if (numbersToSort == null || numbersToSort.length == 0) return;

		boolean sorted = false;
		int modulo = 10, divisor = 1;
		while (!sorted) {
			sorted = true;
			LinkedList<Integer>[] listArray = (LinkedList<Integer>[]) new LinkedList[10];
			
			// sort into list array
			for (int i = 0; i<numbersToSort.length; i++) {
				int digit = (numbersToSort[i] % modulo) / divisor;
				if (digit < 0)
					throw new IllegalArgumentException("Radix Sort only works with positiv numbers");
				if (listArray[digit] == null)
					listArray[digit] = new LinkedList<Integer>();
				listArray[digit].add(numbersToSort[i]);
			}

			// merge into original array
			int toSortIndex = 0, previous = 0;
			for (int i = 0; i<listArray.length; i++) {
				if (listArray[i] == null) continue;
				for (Integer number : listArray[i]) {
					numbersToSort[toSortIndex++] = number;
					sorted = sorted && previous <= number;
					previous = number;
				}
			}
			modulo *= 10;
			divisor *= 10;
		}
	}
}
