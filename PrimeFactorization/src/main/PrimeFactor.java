package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactor {

	public static void main(String[] args) {
		long a = 123456789012345678L;
		int[] factors = primeFactor(a);

		System.out.println("Prime factors of " + a + " are " + Arrays.toString(factors));
	}

	public static int[] primeFactor(long a) {
		int factor = 2;
		List<Integer> factors = new ArrayList<>();

		while (a % factor == 0) {
			a /= factor;
			factors.add(factor);
		}

		factor = 3;
		int stop = (int) Math.sqrt(a);
		while (factor < stop) {
			while (a % factor == 0) {
				a /= factor;
				factors.add(factor);
			}
			factor += 2;
		}

		if (a > 1) {
			factors.add((int) a);
		}
		return factors.stream().mapToInt(i -> i).toArray();
	}
}
