package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class App {

	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("Initial array of integers: " + Arrays.toString(a));
		a = randomizingArray(a, a.length);
		System.out.println("Array of integers after randomizing" + Arrays.toString(a));
		
		String[] s = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P" };
		
		System.out.println("Initial array of strings: " + Arrays.toString(s));
		String[] o = pickNRandomItemsFromArray(s, s.length, 5);
		System.out.println("Randomly selected 5 strings: " + Arrays.toString(o));
		
		System.out.println("Initial array of strings: " + Arrays.toString(s));
		String[] p = pickNRandomItemsFromArrayPartly(s, s.length, 5);
		System.out.println("Randomly selected 5 strings: " + Arrays.toString(p));
	}
	
	/**
	 * 
	 * @param a array of integers
	 * @param size array size
	 * @return randomized array
	 */
	public static int[] randomizingArray(int[] a, int size) {
		int j, temp;
		
		for (int i = 0; i < size; i++) {
			j = ThreadLocalRandom.current().nextInt(i, size);
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		return a;
	}
	
	/**
	 * 
	 * @param a initial array
	 * @param size size of array
	 * @param n number of random items need to pick
	 * @return array of n random items
	 */
	public static String[] pickNRandomItemsFromArray(String[] a, int size, int n) {
		HashSet<String> set = new HashSet<>();
		int picked = 0;
		int i = 0;
		while (picked < n) {
			i = ThreadLocalRandom.current().nextInt(size);
			if (set.contains(a[i])) continue;
			set.add(a[i]);
			picked ++;
		}
		return set.toArray(new String[0]);
	}
	
	/**
	 * 
	 * @param a initial array
	 * @param size size of array
	 * @param n number of random items need to pick
	 * @return array of n random items
	 */
	public static String[] pickNRandomItemsFromArrayPartly(String[] a, int size, int n) {
		int j;
		String[] o = new String[n];
		for (int i = 0; i < n; i++) {
			j = ThreadLocalRandom.current().nextInt(i, size);
			o[i] = a[j];
			a[j] = a[i];
			a[i] = o[i];
		}
		return o;
	}
}
