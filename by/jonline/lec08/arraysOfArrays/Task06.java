package by.jonline.lec08.arraysOfArrays;

import java.util.Scanner;

public class Task06 {

	public static void main(String[] args) {
		/*Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		/*	[ 1   1   1   . . .   1   1   1 ]
		 * 	[ 0   1   1   . . .   1   1   0 ]
		 * 	[ 0   0   1   . . .   1   0   0 ]
		 * 	[ .   .   .   .       .   .   . ]
		 * 	[ .   .   .     .     .   .   . ]
		 * 	[ .   .   .       .   .   .   . ]
		 *	[ 0   1   1   . . .   1   1   0 ]
		 *	[ 1   1   1   . . .   1   1   1 ]
		 */

		int n;
		int[][] arr;
		
		n = enterFromConsole("enter positive even n >> ");
		while (n < 0 || n % 2 != 0) {
			n = enterFromConsole("enter positive even n >> ");
		}
		arr = new int[n][n];
		initArray(arr);
		printArr(arr);
	}

	private static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}

	private static void initArray(int[][] arr) {

		int m = arr.length / 2 - 1;
		for (int i = 0; i < arr.length; i++) {

			if (i < arr.length / 2) {
				for (int j = 0; j < arr[i].length / 2; j++) {

					if (i <= j) {
						arr[i][j] = 1;
					}
				}
				for (int k = arr[i].length - 1, j = 0; k >= arr[i].length / 2; k--, j++) {
					arr[i][k] = arr[i][j];
				}
			} else {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = arr[m][j];
				}
				m--;
			}
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
