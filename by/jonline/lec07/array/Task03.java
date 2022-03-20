package by.jonline.lec07.array;

import java.util.Random;
import java.util.Scanner;

public class Task03 {

	public static void main(String[] args) {
		// Дан массив действительных чисел, размерность которого N. Подсчитать, сколько
		// в нем отрицательных, положительных и нулевых элементов.
		
		int N;
		int pos;
		int neg;
		int zero;
		double[] array;

		N = enterIntFromConsole("N >> ");
		while (N <= 0) {
			N = enterIntFromConsole("?wtf? \nN >> ");
		}
		array = new double[N];

		initArray(array);
		printArray(array);

		pos = counter("positive", array);
		neg = counter("negative", array);
		zero = counter("zero", array);
		printAnswer("Positive array components:", pos);
		printAnswer("Negative array components:", neg);
		printAnswer("Zero value array components:", zero);

	}

	public static void printAnswer(String text, int value) {
		text = String.format("%-30s %s;%n", text, value);

		System.out.print(text);
	}

	public static int counter(String S, double[] array) {
		int positive = 0;
		int negative = 0;
		int zero = 0;
		int exit = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				positive++;
			} else if (array[i] == 0) {
				zero++;

			} else
				negative++;
		}
		switch (S) {
		case "positive":
			exit = positive;
			break;
		case "negative":
			exit = negative;
			break;
		case "zero":
			exit = zero;
			break;
		default:
			System.out.println("Error");
		}

		if (positive + negative + zero != array.length) {
			System.out.println("error");
		}
		return exit;
	}

	public static void printArray(double[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1] + "]");
	}

	public static void initArray(double[] array) {
		if (array == null) {
			return;
		}
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			int n = 100;// [-n; n)
			array[i] = (rand.nextDouble() * 2 * n) - n;
		}
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

}
