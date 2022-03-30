package by.jonline.lec06.decomposition.copy;

import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
		// Написать программу, определяющую сумму n-значных чисел, содержащих только
		// нечётные цифры. Определить также, сколько чётных цифр в данной сумме. Для
		// решения использовать декомпозицию.

		int n;
		int sum;
		int amountOfEvenDigitsInSum;

		n = enterIntFromConsole("n >> ");
		while (n < 1) {
			n = enterIntFromConsole("n >> ");
		}

		sum = SumOfEvenNum(n);
		amountOfEvenDigitsInSum = countOfEvenDigit(sum);

		System.out.println("Sum of even n-digit numbers is " + sum);
		System.out.println("Amount of even digits in this sum is " + amountOfEvenDigitsInSum);

	}

	private static int countOfEvenDigit(int n) {
		int count = 0;

		for (int i = n; i > 0; i = (int) (i / 10)) {
			int digit;

			digit = i % 10;

			if (evenCheck(digit) == true) {
				count++;
			}
		}

		return count;
	}

	private static boolean evenCheck(int n) {
		boolean check = false;

		if (n % 2 == 0) {
			check = true;
		}

		return check;
	}

	private static int SumOfEvenNum(int n) {
		int sum = 0;

		for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
			if (evenCheck(i) == true) {
				sum += i;
			}
		}
		return sum;
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
