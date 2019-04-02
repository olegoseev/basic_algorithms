package main;

// Least Common Multiple -LCM
public class App {

	public static void main(String[] args) {
		
		int a = 15;
		int b = 12;
		
		System.out.println("LCM of 12 and 15 is " + lcm(a, b));
	}
	
	//Greatest Common Divisor - GCD
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static int lcm(int a, int b) {
		return (a / gcd(a, b)) * b;
	}

}
