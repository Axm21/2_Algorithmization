package by.jonline.lec08.arraysOfArrays;

import java.util.Random;

public class Task10 {

	public static void main(String[] args) {
		// Найти положительные элементы главной диагонали квадратной матрицы.

		int i;
		int[][] arr;
		int[] diagPos;

		i = 9;

		arr = new int[i][i];

		initArrRand(arr);
		printArr(arr);
		diagPos = posElemOfDiagonal(arr);
		printLine(diagPos);

	}

	private static void printLine(int[] arr) {
		for (int i: arr) {
			System.out.printf("%3d ", i);
		}
		System.out.println();
	}

	private static int[] posElemOfDiagonal(int[][] arr) {
		if (arr == null) {
			return null;
		}
		int minLength; // чтобы можно было использовать в прямоугольной матрице
		int diagLength;

		minLength = arr.length;
		diagLength = 0;

		if (arr[0].length < minLength) {
			minLength = arr[0].length;
		}
		int[] diagPos;

		for (int i = 0; i < minLength; i++) {
			if (arr[i][i] > 0) {
				diagLength++;
			}
		}
		diagPos = new int[diagLength];

		for (int i = 0, k = i; i < minLength; i++) {
			if (arr[i][i] > 0) {
				diagPos[k] = arr[i][i];
				k++;
			}
		}
		return diagPos;
	}

	private static void printArr(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int i[] : arr) {
			printLine(i);
		}
		for (int j = 0; j < arr[0].length; j++) {
			System.out.print("____");
		}
		System.out.println("\n");

	}

	private static void initArrRand(int[][] arr) {
		if (arr == null) {
			return;
		}
		Random rand = new Random();
		int n; // [-n; n)

		n = 99;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = rand.nextInt(n) * 2 - n;
			}
		}

	}

}
