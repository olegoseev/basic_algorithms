package main;

import java.util.concurrent.ThreadLocalRandom;

public class FermasLittleTheorem {

	public static void main(String[] args) {

		
		for (long a = 3; a < 12; a ++) {
			int confidence = (int) a / 2;
			boolean prime = fml(a, confidence);
			System.out.println(a + " is prime " + prime);
		}
	}

	public static boolean fml(long a, int confidence) {

		boolean prime = true;
		for (int i = 0; i < confidence; i++) {
			long rnd = ThreadLocalRandom.current().nextLong(1, a);
			long b = (long) Math.pow(rnd, a - 1);
			if (b % a != 1) {
				prime = false;
			}
		}
		return prime;
	}
}
