package by.jonline.lec06.decomposition.copy;

import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
		// Натуральное число, в записи которого n цифр, называется числом Армстронга,
		// если сумма его цифр, возведённАЯ в степень n, равна самому числу. Найти все
		// числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.

		//*брал инфу из вики, поэтому возводятся цифры
		int k;

		k = enterIntFromConsole("k >> ");
		while (k < 1) {
			k = enterIntFromConsole("k >> ");
		}

		armstrongCheck(k);
	}

	private static void armstrongCheck(int k) {

		System.out.println("Числа Армстронга: ");
		for (int i = 1; i <= k; i++) {

			if (sumOfDigitsInPower(i) == i) {
				System.out.println(i);
			}

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

	private static int length(int n) {
		int length;

		length = String.valueOf(n).length();

		return length;

	}

	private static int sumOfDigitsInPower(int n) {
		int i = n;
		int sum = 0;

		while (i > 0) {
			int digit;
			digit = i % 10;

			sum += Math.pow(digit, length(n));
			
			i = i / 10;
		}
		return sum;
	}
}
