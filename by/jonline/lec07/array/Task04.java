package by.jonline.lec07.array;

import java.util.Random;
import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
		// Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и
		// наименьший элементы.

		int n;
		double[] a;

		n = enterIntFromConsole("n >> ");
		while (n < 1) {
			System.out.println("?wtf?");
			n = enterIntFromConsole("n >> ");
		}

		a = new double[n];
		initArray(a);
		printArray(a);
		replaceComponent(a);
		printArray(a);

	}

	public static void replaceComponent(double[] a) {
		if (a == null) {
			return;
		}

		double max;
		double min;
		double repl;
		max = a[0];
		min = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}
		}
		repl = max;
		max = min;
		min = repl;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == min) {
				a[i] = max;
				continue;
			}
			if (a[i] == max) {
				a[i] = min;
			}
		}
	}

	public static void printArray(double[] a) {
		if (a == null) {
			return;
		}
		System.out.print("[");
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[a.length - 1] + "]");
	}

	public static void initArray(double[] a) {
		if (a == null) {
			return;
		}
		int limit;
		limit = 20; // [-limit;limit)
		Random rand = new Random();

		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextDouble() * 2 * limit - limit;
		}
	}

	public static int enterIntFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println(message);
		}
		return sc.nextInt();
	}

}
