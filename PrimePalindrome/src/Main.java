public class Main {

	public static void main(String[] args) {
		int n = 0;
		for (int i = 1; i < 1000; i++) {
			int reverse = reverse(i);
			if (i == reverse && isPrime(i)) {
				n = reverse;
			}
		}
		System.out.println(n);
	}

	private static int reverse(int i) {
		int reverse = 0;

		while (i > 0) {
			reverse *= 10;
			reverse += i % 10;
			i /= 10;
		}

		return reverse;
	}

	private static boolean isPrime(int n) {
		for (int i = 1; i < n; i++)
			if (n != i && i != 1)
				if (n % i == 0)
					return false;
		return true;
	}
}
