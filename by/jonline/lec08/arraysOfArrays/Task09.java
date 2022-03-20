package by.jonline.lec08.arraysOfArrays;

import java.util.Random;
import java.util.Scanner;

public class Task09 {

	public static void main(String[] args) {
		// Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом
		// столбце. Определить, какой столбец содержит максимальную сумму.

		int i;
		int j;
		int indexOfMax;
		double[][] arr;
		double[] sumOfColumn;

		i = entPosIntFrConsole("enter hight of array >> ");
		j = entPosIntFrConsole("enter width of array >> ");

		arr = new double[i][j];

		initArrayRandNotNeg(arr);
		printArray(arr);

		sumOfColumn = countSum(arr);
		printLineOfArr(sumOfColumn);
		indexOfMax = maxOfColumn(sumOfColumn);
		System.out.printf("\nThe column with index #%d contains the maximum sum of elements (%.3f).\n", indexOfMax,
				sumOfColumn[indexOfMax]);
	}

	private static int entIntFrConsole(String mes) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(mes);
		while (!sc.hasNextInt()) {
			System.out.print("INTEGER, please\n" + mes);
			sc.next();
		}

		return sc.nextInt();
	}

	private static int entPosIntFrConsole(String mes) {
		int n;
		n = entIntFrConsole(mes);
		while (n <= 0) {
			System.out.println("POSITIVE integer, please");
			n = entIntFrConsole(mes);
		}
		return n;
	}

	private static int maxOfColumn(double[] arr) {
		int maxIndex;

		maxIndex = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}

		return maxIndex;
	}

	private static void printLineOfArr(double[] sumOfColumn) {
		for (double i : sumOfColumn) {
			System.out.printf("%7.3f ", i);
		}
		System.out.println();
	}

	private static double[] countSum(double[][] arr) {
		double[] sum;
		sum = new double[arr[0].length];

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				sum[j] += arr[i][j];
			}
		}
		return sum;

	}

	private static void printArray(double[][] arr) {
		for (double[] i : arr) {
			printLineOfArr(i);
		}
		for (int j = 0; j < arr[0].length; j++) {
			System.out.print("________");
		}
		System.out.println("\n");
	}

	private static void initArrayRandNotNeg(double[][] arr) {
		if (arr == null) {
			return;
		}
		Random rand = new Random();
		int n;
		n = 25; // [0;n)
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = Math.round(rand.nextDouble() * n * 1000) / 1000.0;
			}
		}

	}

}
