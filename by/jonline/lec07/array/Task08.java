package by.jonline.lec07.array;

import java.util.Random;

public class Task08 {

	public static void main(String[] args) {
		// Дана последовательность целых чисел a1, a2, ..., an . Образовать новую
		// последовательность, выбросив из исходной те члены, которые равны 
		// min(a1, a2, ..., an).

		int n;
		int min;
		int[] a;

		n = 10;
		a = new int[n];

		initArray(a);
		printArray(a);
		min = minComponent(a);
		a = removeComponent(a, min);
		printArray(a);
	}

	private static void printArray(int[] a) {
		if (a == null) {
			return;
		}

		System.out.print("[");
		for (int i = 0; i < a.length - 1; i++) {
			System.out.printf("%d, ", a[i]);
		}
		System.out.printf("%d]%n", a[a.length - 1]);

	}

	private static int[] removeComponent(int[] a, int n) {
		int[] newArray;
		int counter;
		counter = 0;

		for (int i : a) {
			if (n == i) {
				counter++;
			}
		}
		newArray = new int[a.length - counter];

		for (int i = 0, k = i; i < a.length; i++) {
			if (a[i] == n) {
				continue;
			}
			newArray[k] = a[i];
			k++;
		}
		return newArray;

	}

	private static int minComponent(int[] a) {
		int min;
		min = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	private static void initArray(int[] a) {
		if (a == null) {
			return;
		}
		int n;
		n = 10; // [-n;n)

		Random rand = new Random();

		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(n) * 2 - n;
		}

	}

}
