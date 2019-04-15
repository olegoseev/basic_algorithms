package main;

import java.util.concurrent.ThreadLocalRandom;

public class OneDimArray {

	public static void main(String[] args) {
		int[] arr = new int[100];

		System.out.println("Generating array of 100 integers between 0 and 999");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ThreadLocalRandom.current().nextInt(999);
		}
		
		printArr(arr, arr.length);
		
		System.out.println();
		System.out.println("================================");
		
		System.out.println("Minimum number in the array: " + minimum(arr, arr.length));
		System.out.println("Maximum number in the array: " + maximum(arr, arr.length));
		System.out.println("Total (sum): " + total(arr, arr.length));
		System.out.println("Array's mean: " + mean(arr, arr.length));
		System.out.println("Array's variance: " + variance(arr, arr.length));
		System.out.println("Array's standard deviation: " + stdDev(arr, arr.length));
		
	}

	public static void printArr(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.printf("%4d", arr[i]);
		}
		System.out.println();
	}
	
	public static int minimum(int[] arr, int size) {
		int min = arr[0];

		for (int i = 0; i < size; i++) {
			min = Math.min(min, arr[i]);
		}
		return min;
	}

	public static int maximum(int[] arr, int size) {
		int max = arr[0];

		for (int i = 0; i < size; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

	public static int total(int[] arr, int size) {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += arr[i];
		}
		return total;
	}

	public static int mean(int[] arr, int size) {
		return total(arr, size) / size;
	}

	public static double variance(int[] arr, int size) {
		double var = 0;
		int mean = mean(arr, size);

		for (int i = 0; i < size; i++) {
			var = Math.pow((arr[i] - mean), 2);
		}

		return var / size;
	}
	
	public static double stdDev (int[] arr, int size) {
		double var = variance (arr, size);
		return Math.sqrt(var);
	}
}
