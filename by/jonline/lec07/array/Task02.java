package by.jonline.lec07.array;

import java.util.Random;
import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
		// Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее
		// члены, большие данного Z, этим числом. Подсчитать количество замен.

		double Z;
		int n;
		int replacement;
		double[] a;

		n = enterIntFromConsole("n >> ");
		while (n <= 0) {
			n = enterIntFromConsole("n >> ");
		}

		a = new double[n];

		initArray(a);
		printArray(a);

		Z = enterDoubleFromConsole("Z >> ");

		replacement = changeArray(a, Z);// ���������� ���������� �����

		printArray(a);
		System.out.println("replacements in array: " + replacement);

	}

	public static int changeArray(double[] a, double Z) {
		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > Z) {
				a[i] = Z;
				counter += 1;
			}
		}
		return counter;

	}

	public static double enterDoubleFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		while (!sc.hasNextDouble()) {
			sc.next();
			System.out.print(message);
		}
		return sc.nextInt();
	}

	public static int enterIntFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(message);
		}
		return sc.nextInt();
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
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextDouble() * 20;
		}
	}

}
