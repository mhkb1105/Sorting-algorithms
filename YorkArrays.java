package A4Q1;

import java.util.*;

/**
 *
 * Provides two static methods for sorting Integer arrays (heapSort and
 * mergeSort)
 */
public class YorkArrays {

	public static void heapSort(Integer[] a) throws NullPointerException {

		if (a == null) {
			throw new NullPointerException();
		}

		PriorityQueue<Integer> heapQueue = new PriorityQueue<Integer>();

		for (int i = 0; i < a.length; i++) {
			heapQueue.add(a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = heapQueue.poll();
		}
	}

	public static Integer[] mergeSort(Integer[] a) throws NullPointerException {

		if (a == null) {
			throw new NullPointerException();
		}

		return (mergeSort(a, 0, a.length - 1));

	}

	private static Integer[] mergeSort(Integer[] a, int p, int q) {

		if (q - p < 1) {
			Integer[] newArray = new Integer[1];
			newArray[0] = a[q];
			return newArray;
		}

		int midpoint = (q + p) / 2;

		Integer[] partition1 = mergeSort(a, p, midpoint);
		Integer[] partition2 = mergeSort(a, midpoint + 1, q);
		return merge(partition1, partition2);
	}

	private static Integer[] merge(Integer[] a, Integer[] b) {

		Integer[] sortedArray = new Integer[a.length + b.length];

		int i = 0;
		int j = 0;

		while (i < a.length && j < b.length) {

			if (a[i] < b[j]) {
				sortedArray[i + j] = a[i];
				i++;
			} else {
				sortedArray[i + j] = b[j];
				j++;
			}
		}

		while (i < a.length) {
			sortedArray[i + j] = a[i];
			i++;
		}

		while (j < b.length) {
			sortedArray[i + j] = b[j];
			j++;
		}
		return sortedArray;
	}

}
