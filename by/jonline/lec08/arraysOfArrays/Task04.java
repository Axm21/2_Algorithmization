package by.jonline.lec08.arraysOfArrays;

import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
		// Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
		//	[1   2   3   . . .   n]
		// 	[n  n-1 n-2  . . .   1]
		// 	[1   2   3   . . .   n]
		//	[n  n-1 n-2  . . .   1]
		// 	[.   .   .   .       .]
		// 	[.   .   .     .     .]
		// 	[.   .   .       .   .]
		//	[n  n-1 n-2  . . .   .]
		
		int n;
		int[][] sqArr;
		
		n = enterFromConsole("enter even positive n >> ");
		while (n % 2 !=0 || n < 0) {
			n = enterFromConsole("enter even positive n >> ");
		}
		
		sqArr = new int[n][n];
		initArr(sqArr);
		printArr(sqArr);
		
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
		int n;
		n = arr.length;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				if (i % 2 == 0) {
					arr[i][j] = j + 1;
				} else {
					arr[i][j] = n - j;
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
