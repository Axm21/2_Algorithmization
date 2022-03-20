package by.jonline.lec07.array;

import java.util.Random;
import java.util.Scanner;

public class Task01 {

	public static void main(String[] args) {
		// В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые
		// кратны данному К.
		int N;
		int[] A;
		int K;

		N = enterIntFromConsole("N >> ");
		while (N < 1) {
			N = enterIntFromConsole("N >> ");
		}

		A = new int[N];
		initArray(A);
		printArray(A);

		K = enterIntFromConsole("K >> ");

		System.out.println(sumOfMultiple(A, K));

	}

	private static int sumOfMultiple(int[] A, int K) {
		int sum = 0;

		for (int i : A) {
			if (i % K == 0) {
				sum += i;
			}
		}

		return sum;
	}

	public static void printArray(int[] A) {
		if (A == null) {
			return;
		}
		System.out.print("[");
		for (int i = 0; i < A.length - 1; i++) {
			System.out.print(A[i] + ", ");

		}
		System.out.println(A[A.length - 1] + "]");

	}

	public static void initArray(int[] A) {
		if (A == null) {
			return;
		}
		Random rand = new Random();
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(100);
		}
	}

	public static int enterIntFromConsole(String message) {
		int n;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println(message);
		}
		n = sc.nextInt();

		return n;
	}

}
