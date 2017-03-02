package AlgorithmMath;

public class MathNormal {
	public static void main(String[] args) {
		int[] arry={12,4,8,4,100};
		int a = Euclids(arry);
		System.out.println(a);
	}

	/* Giai thừa n! */
	public static int Factorial(int n) {
		if (n < 0)
			return -1;
		else if (n == 0)
			return 1;
		else
			return n * Factorial(n - 1);
	}

	/* Dãy Fibonacci */
	public static int[] Fibonaccis(int n) {
		int[] F = new int[n];
		for (int i = 0; i < n; i++) {
			F[i] = Fibonacci(i);
		}
		return F;
	}

	public static int Fibonacci(int n)

	{
		if (n < 0)
			return -1;
		else if (n <= 1)
			return n;
		else
			return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	/* Thuật toán Euclid */
	public static int Euclid(int a, int b) {
		if (b == 0)
			return a;
		else
			return Euclid(b, a % b);
	}

	public static int Euclids(int[] a) {
		int[] b = new int[a.length - 1];
		if (a.length <= 1)
			return -1;
		else if (a.length == 2)
			return Euclid(a[0], a[1]);
		else {
			for (int i = 0; i < a.length - 2; i++) {
				b[i] = a[i];
			}
			b[a.length - 2] = Euclid(a[a.length - 2], a[a.length - 1]);
			return Euclids(b);
		}
	}
}
