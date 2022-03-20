package by.jonline.lec08.arraysOfArrays;

import java.util.Scanner;

public class Task05 {

	public static void main(String[] args) {
		// Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		/*	[ 1   1   1   . . .   1   1   1 ]
		 * 	[ 2   2   2   . . .   2   2   0 ]
		 * 	[ 3   3   3   . . .   3   0   0 ]
		 * 	[ .   .   .   .       .   .   . ]
		 * 	[ .   .   .     .     .   .   . ]
		 * 	[ .   .   .       .   .   .   . ]
		 *	[n-1 n-1  0   . . .   0   0   0 ]
		 *	[ n   0   0   . . .   0   0   0 ]
		 */

		int n;
		int[][] arr;
		
		n = enterFromConsole("enter positive even n >> ");
		while (n < 0 || n % 2 != 0) {
			n = enterFromConsole("n >> ");
		}
		
		arr = new int[n][n];
		
		initArr(arr);
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

	private static void initArr(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				if (i + j < arr[i].length) {
					arr[i][j] = i + 1;
				} else {
					arr[i][j] = 0;
				}
			}
		}

	}

	private static int enterFromConsole(String message) {
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
