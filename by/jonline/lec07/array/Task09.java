package by.jonline.lec07.array;

import java.util.Random;
import java.util.Scanner;

public class Task09 {

	public static void main(String[] args) {
		// В массиве целых чисел с количеством элементов n найти наиболее часто
		// встречающееся число. Если таких чисел несколько, то определить наименьшее из
		// них.

		int n;
		int[] a;
		int mostComNum;

		n = enterFromConsole("n >> ");
		while (n < 1) {
			System.out.println("?wtf?");
			n = enterFromConsole("n >> ");
		}

		a = new int[n];

		initArray(a);
		printArray(a);
		mostComNum = counter(a);

		System.out.println("The most common number is " + mostComNum);

	}

	private static int counter(int[] a) {
		int countMax;
		int numMax;

		countMax = 0;
		numMax = a[0];

		for (int i = 0; i < a.length; i++) {
			int count;
			count = 0;
			for (int k = 0; k < a.length; k++) {
				if (i == k) {
					continue;
				}
				if (a[i] == a[k]) {
					count++;
				}
			}
			if (count > countMax) {
				countMax = count;
				numMax = a[i];
			} else if (count == countMax) {
				if (a[i] < numMax) {
					numMax = a[i];
				}
			}
		}
		return numMax;

	}

	private static void printArray(int[] a) {
		if (a == null) {
			return;
		}
		System.out.print("[");
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[a.length - 1] + "]");

	}

	private static void initArray(int[] a) {
		if (a == null) {
			return;
		}
		int n;
		n = 10; // [-n; n)

		Random rand = new Random();

		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(n) * 2 - n;
		}

	}

	private static int enterFromConsole(String string) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print(string);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(string);
		}
		return sc.nextInt();
	}

}
