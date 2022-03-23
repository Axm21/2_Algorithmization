package by.jonline.lec08.arraysOfArrays;

import java.util.Random;
import java.util.Scanner;

public class Task14 {

	public static void main(String[] args) {
		// Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в
		// каждом столбце число единиц равно номеру столбца.

		int m;
		int n;
		int[][] arr;

		n = enterPosIntFrConsole("enter width of array >> ");
		m = enterHight("enter hight of array >> ", n);

		arr = new int[m][n];

		initArr(arr);
		printArr(arr);
	}

	private static int enterHight(String string, int n) {
		int m;
		m = enterPosIntFrConsole(string);
		while (m < n) {
			System.out.println("hight can't be less than width according to the task condition.");// тогда в столбце '1'
																									// должно быть
																									// больше чем ячеек
			m = enterPosIntFrConsole(string);

		}
		return m;
	}

	private static int enterPosIntFrConsole(String string) {
		int n;

		n = enterIntFrConsole(string);
		while (n < 1) {
			System.out.println("Error :(\nit should be positive. Try again.");
			n = enterIntFrConsole(string);
		}
		return n;
	}

	private static int enterIntFrConsole(String string) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(string);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("Error :(\nit should be integer. Try again.");
			System.out.print(string);
		}
		return sc.nextInt();
	}

	private static void printArr(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int[] i : arr) {
			for (int j : i) {
				System.out.printf("%2d ", j);
			}
			System.out.println();
		}
	}

	private static void initArr(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int j = 0; j < arr[0].length; j++) {
			for (int count = 0; count < j + 1; count++) {
				Random rand = new Random();

				int I;
				I = rand.nextInt(arr.length);

				while (arr[I][j] == 1) {
					I = rand.nextInt(arr.length);
				}
				arr[I][j] = 1;
			}
		}
	}

}
