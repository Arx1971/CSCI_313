package project_103;

import java.util.*;

public class HW3 {
	static Random rand = new Random();
	static int numComparisons = 0;

	// Swaps the elements at indices i and j.
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Sorts the elements in the range a[low..high].
	private static void insertionsort(int[] a, int low, int high) {
		for (int i = low + 1; i <= high; ++i) {
			int temp = a[i], j = i - 1; // Save the current element
			while (j >= low && a[j] > temp) { // Shift all elements greater than it to the right
				a[j + 1] = a[j];
				--j;
			}
			a[j + 1] = temp; // Insert the current element into the correct spot
		}
	}

	public static void quicksort(int[] a) {
		quicksort(a, 0, a.length - 1);
	}

	// ***Modify this method to use insertion sort for small subarrays***
	// Sorts the elements in the range a[low..high].
	private static void quicksort(int[] a, int low, int high) {
		if (low >= high)
			return;
		int pivot = partition(a, low, high); // Partition the array into two halves

		if (pivot - low < 64) {
			insertionsort(a, low, pivot - 1);
		} else
			quicksort(a, low, pivot - 1); // Sort the left half

		if (high - pivot < 64) {
			insertionsort(a, pivot + 1, high);
		} else
			quicksort(a, pivot + 1, high); // Sort the right half
	}

	// ***Modify this method to choose a random pivot***
	// Partitions the array and returns pivot such that a[low..pivot-1] <= a[pivot]
	// <= a[pivot+1..high].
	// This implementation uses Lomuto's partitioning scheme.

	private static int partition(int a[], int low, int high) {
		int index = rand.nextInt(high - low + 1) + low; // choosing random pivot index
		int pivot = a[index]; // pivot

		swap(a, index, high); // move pivot element to the high

		index = high;

		int i = low;
		for (int j = low; j < high; j++) {	// Compare each element to the pivot
			if (a[j] < pivot) {		// If it's less than the pivot, move it to the left half by swapping
				swap(a, i++, j);
			}
		}

		swap(a, i, index);
		return i;
	}

	// Returns true if the array is sorted. Otherwise returns false.
	private static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; ++i)
			if (a[i] > a[i + 1])
				return false;
		return true;
	}

	// Sorts each row of the 2D array and measures the average runtime and number of
	// comparisons.
	private static void runTest(int[][] arrays) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < NUM_ARRAYS; ++i) // Sort each array
			quicksort(arrays[i]);
		long end = System.currentTimeMillis();
		System.out.println("Average runtime in seconds: " + (end - start) / 1000.0 / NUM_ARRAYS);

		if (numComparisons != 0) { // numComparisons will be 0 if ++numComparisons is commented-out
			System.out.println("Average number of comparisons: " + (double) numComparisons / NUM_ARRAYS);
			numComparisons = 0; // Reset counter
		}

		for (int i = 0; i < NUM_ARRAYS; ++i) { // Verify that all arrays are sorted
			if (!isSorted(arrays[i])) {
				System.out.println("The arrays are not sorted");
				return;
			}
		}
	}

	static final int ARRAY_SIZE = 100000, NUM_ARRAYS = 100;

	public static void main(String[] args) {
		// Create the arrays
		int[][] randomArray = new int[NUM_ARRAYS][ARRAY_SIZE];
		int[][] sortedArray = new int[NUM_ARRAYS][ARRAY_SIZE];
		int[][] allZero = new int[NUM_ARRAYS][ARRAY_SIZE];

		// Fill the arrays with values
		for (int i = 0; i < NUM_ARRAYS; ++i) {
			for (int j = 0; j < ARRAY_SIZE; ++j) {
				randomArray[i][j] = rand.nextInt();
				sortedArray[i][j] = j;
				allZero[i][j] = 0;
			}
		}

		System.out.println("***Random arrays***");
		runTest(randomArray);

		System.out.println("\n***Already-sorted arrays***");
		runTest(sortedArray);

		System.out.println("\n***All-zero arrays***");
		runTest(allZero);
	}
}