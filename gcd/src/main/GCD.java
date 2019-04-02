package main;

public class GCD {

	public static void main(String[] args) {
		int r = euclid_gcd(78, 66);
		System.out.println("GCD of 78 and 66 is " + r);

		r = euclid_gcd_r(78, 66);
		System.out.println("recurcive GCD of 78 and 66 is " + r);

		r = binary_gcd(78, 66);
		System.out.println("binary GCD of 78 and 66 is " + r);

		r = binary_gcd_b(78, 66);
		System.out.println("binary GCD (bitwise) of 78 and 66 is " + r);
	}

	// Euclid's algorigthm - Greatest Common Divisor - GCD
	public static int euclid_gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	// Euclid's algorigthm - Greatest Common Divisor - GCD
	public static int euclid_gcd_r(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return euclid_gcd_r(b, a % b);
		}
	}

	public static int binary_gcd(int a, int b) {
		if (a < 0 || b < 0)
			return 1;

		int d = 0;
		while ((a % 2) == 0 && (b % 2) == 0) {
			a /= 2;
			b /= 2;
			d++;
		}

		while (a != b) {
			if ((a % 2) == 0) {
				a /= 2;
			} else if ((b & 1) == 0) {
				b /= 2;
			} else if (a > b) {
				a = (a - b) / 2;
			} else {
				b = (b - a) / 2;
			}
		}
		return a * (int) Math.pow(2, d);
	}

	public static int binary_gcd_b(int a, int b) {
		if (a < 0 || b < 0)
			return 1;

		int d = 0;
		while ((a & 1) == 0 && (b & 1) == 0) {
			a >>= 1;
			b >>= 1;
			d++;
		}

		while ((a & 1) == 0) {
			a >>= 1;
		}

		while (b != 0) {
			while ((b & 1) == 0) {
				b >>= 1;
			}
			if (a > b) {
				a = (a - b) / 2;
			} else {
				b = (b - a) / 2;
			}
		}
		return a << d;
	}

}
