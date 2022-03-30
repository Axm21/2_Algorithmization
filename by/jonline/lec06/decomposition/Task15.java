package by.jonline.lec06.decomposition.copy;

import java.util.Scanner;

public class Task15 {

	public static void main(String[] args) {
		// Найти все натуральные n-значные числа, цифры в которых образуют строго
		// возрастающую последовательность(например, 1234, 5789). Для решения задачи
		// использовать декомпозицию.

		int n;
		int firstNum;

		n = enterIntFromConsole("n >> ");
		firstNum = (int) Math.pow(10, n - 1);
		number(firstNum);

	}

	private static void digit(int n) {
		boolean check = true;
		for (int i = n; i > 0; i = (int) (i / 10)) {
			int digit = i % 10;
			int digitPrev = (i % 100 - digit) / 10;

			if (digit <= digitPrev) {
				check = false;
			}
		}
		if (check == true) {
			System.out.println(n);
		}
	}

	private static void number(int n) {

		for (int i = n; i < (10 * n); i++) {
			digit (i);
		}

	}

	public static int enterIntFromConsole(String message) {
		int n;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(message);
		}
		n = sc.nextInt();

		return n;
	}

}
