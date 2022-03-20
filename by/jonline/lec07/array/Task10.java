package by.jonline.lec07.array;

import java.util.Random;
import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		// Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из
		// него каждый второй элемент (освободившиеся элементы заполнить нулями).
		// Примечание. Дополнительный массив не использовать.

		int n;
		int[] a;

		n = enterFromConsole("n >> ");

		a = new int[n];

		initArray(a);
		printArray(a);
		compressArray(a);
		printArray(a);

	}

	private static void compressArray(int[] a) {
		int count;
		count = 0;
		for (int i = 0, k = 0; k < a.length; i++, k += 2) {
			a[i] = a[k];
			count++;
		}
		for (int i = count; i < a.length; i++) {
			a[i] = 0;
		}

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
		Random rand = new Random();
		int n;
		n = 10; // [-n; n)
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
