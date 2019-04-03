package main;

public class FindingPrimes {

	public static void main(String[] args) {
		

	}
	
	public static long[] eratosthenes (long a) {
		return null;
	}
	
	public void eratosthenesSieve(int upperBound) {

	      int upperBoundSquareRoot = (int) Math.sqrt(upperBound);

	      boolean[] isComposite = new boolean[upperBound + 1];

	      for (int m = 2; m <= upperBoundSquareRoot; m++) {

	            if (!isComposite[m]) {

	                  System.out.print(m + " ");

	                  for (int k = m * m; k <= upperBound; k += m)

	                        isComposite[k] = true;

	            }

	      }

	      for (int m = upperBoundSquareRoot; m <= upperBound; m++)

	            if (!isComposite[m])

	                  System.out.print(m + " ");

	}

}
