package by.jonline.lec07.array;

import java.util.Random;
import java.util.Scanner;

public class Task05 {

	public static void main(String[] args) {
		// Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для
		// которых аi > i.

		int n;
		int[] a;

		n = enterIntFromConsole("n >> ");
		while (n < 1) {
			System.out.println("?wtf?");
			n = enterIntFromConsole("n >> ");
		}

		a = new int[n];

		initArray(a);
		printArray(a);
		checkComponent(a);

	}

	private static void checkComponent(int[] a) {
		if (a == null) {
			return;
		}
		String component;
		component = new String("-");
		System.out.print("[");

		for (int i = 0; i < a.length; i++) {
			component = new String("-");
			if (a[i] > i) {
				Integer value = Integer.valueOf(a[i]);
				component = value.toString();
			}
			if (i == a.length - 1) {
				break;
			}
			System.out.print(component + ", ");
		}
		System.out.println(component + "]");
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
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(10);
		}

	}

	private static int enterIntFromConsole(String message) {
		@SuppressWarnings({ "resource" })
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		while (!sc.hasNextInt()) {
			System.out.print(message);
		}
		return sc.nextInt();
	}

}
