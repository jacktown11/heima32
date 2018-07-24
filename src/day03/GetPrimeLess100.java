package day03;
public class GetPrimeLess100 {

	public static void main(String[] args) {
		int primeCount = 0;
		for(int i = 1; i <= 100; i++) {
			if(isPrime(i)) {
				System.out.println(i);
				primeCount++;
			}
		}
		System.out.println("Total prime count: " + primeCount);
	}
	
	public static boolean isPrime(int i) {
		int maxFactor = (int)Math.sqrt(i);
		if(i <= 1) {
			return false;
		}else {
			int factor = 2;
			for(; factor <= maxFactor; factor++) {
				if(i % factor == 0) {
					return false;
				}
			}
			return true;
		}
	}
}

	