package by.jonline.lec07.array;

import java.util.Random;

public class Task07 {

	public static void main(String[] args) {
		// Даны действительные числа a1, a2, ..., an.Найти max (a1 + a(2n), a2 +
		// a(2n-1), ...,a1 + a(n+1)

		int N;
		N = 11;
		double maxOfSum;
		double[] a;
		a = new double[N];

		initArray(a);
		printArray(a);

		maxOfSum = maxOfSum(a);
		System.out.println("Max = " + maxOfSum);
	}

	private static double maxOfSum(double[] a) {
		int n;
		double sum;
		double max;

		max = 0;
		n = a.length / 2;

		for (int i = 0; i <= n; i++) {
			sum = a[i] + a[n * 2 - 1 - i];
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	private static void printArray(double[] a) {
		if (a == null) {
			return;
		}
		System.out.print("[");
		for (int i = 0; i < a.length - 1; i++) {
			System.out.printf("%.3f, ", a[i]);
		}
		System.out.printf("%.3f]%n", a[a.length - 1]);
	}

	private static void initArray(double[] a) {
		if (a == null) {
			return;
		}
		Random rand = new Random();
		int n = 10; // [-n;n)
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextDouble() * 2 * n - n;
		}

	}

}
