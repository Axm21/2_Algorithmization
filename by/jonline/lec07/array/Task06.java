package by.jonline.lec07.array;

import java.util.Random;

public class Task06 {

	public static void main(String[] args) {
		// Задана последовательность N вещественных чисел. Вычислить сумму чисел,
		// порядковые номера которых являются простыми числами.

		int n = 10;
		double sum;
		double[] N;

		N = new double[n];

		initArray(N);
		printArray(N);
		sum = sumOfIndivisible(N);
		System.out.printf("Sum of component with indivisible ordinal numbers: %.3f.", sum);
	}

	private static double sumOfIndivisible(double[] a) {
		double sum;
		sum = 0;
		for (int i = 0; i < a.length; i++) {
			int number;
			number = i + 1;
			if (indivisibleCheck(number) == true) {
				sum += a[i];
			}
		}
		return sum;
	}

	private static boolean indivisibleCheck(int number) {
		boolean check = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				check = false;
				break;
			}
		}
		return check;
	}

	private static void printArray(double[] a) {
		if (a == null) {
			return;
		}
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1) {
				break;
			}
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[a.length - 1] + "]");

	}

	private static void initArray(double[] a) {
		if (a == null) {
			return;
		}
		Random rand = new Random();
		int n = 10; // [-n; n)

		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextDouble() * 2 * n - n;
		}
	}

}
