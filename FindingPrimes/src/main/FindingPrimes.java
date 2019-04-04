package main;

import java.util.Arrays;

public class FindingPrimes {

	public static void main(String[] args) {

		eratosthenes(99);
		System.out.println();
		eratosthenes2(99);

	}

	public static void eratosthenes(int upperBound) {
		int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
		boolean[] isPrime = new boolean[upperBound + 1];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;
		
		long startTime = System.nanoTime();
		
		for (int i = 4; i < upperBound; i += 2) {
			isPrime[i] = false;
		}

		for (int i = 3; i < upperBoundSquareRoot; i += 2) {
			if (isPrime[i]) {
				for (int j = i * i; j < upperBound; j += i * 2) {
					isPrime[j] = false;
				}
			}
		}
		
		long stopTime = System.currentTimeMillis();
		System.out.println();
		System.err.println("eratosthenes execution time: " + (startTime - stopTime));
		
		for (int i = 0; i < upperBound; i++) {
			if (isPrime[i]) {
				System.out.print(i + " ");
			}
		}
	}

	public static void eratosthenes2(int upperBound) {

		int upperBoundSquareRoot = (int) Math.sqrt(upperBound);

		boolean[] isComposite = new boolean[upperBound + 1];
		

		long startTime = System.nanoTime();
		
		for (int m = 2; m <= upperBoundSquareRoot; m++) {

			if (!isComposite[m]) {

				for (int k = m * m; k <= upperBound; k += m)

					isComposite[k] = true;
			}

		}
		long stopTime = System.currentTimeMillis();
		
		System.out.println();
		System.err.println("eratosthenesSieve execution time: " + (startTime - stopTime));

		for (int m = 2; m <= upperBound; m++)

			if (!isComposite[m])

				System.out.print(m + " ");

	}

}
