package by.jonline.lec08.arraysOfArrays;

import java.util.Arrays;
import java.util.Random;

public class Task01 {

	public static void main(String[] args) {
		// Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент
		// больше последнего.

		int[][] array = new int[5][5];

		initArray(array);

		print(array);
		compare(array);

	}

	private static void initArray(int[][] arr) {
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rand.nextInt(10);
			}
		}

	}

	private static void compare(int[][] array) {
		boolean check = false;

		int[][] newArray;
		newArray = new int[array.length][0];

		for (int i = 0; i < array[0].length; i += 2) {

			int firstEl;
			firstEl = array[0][i];

			if (array[array.length - 1][i] < firstEl) {
				check = true;

				for (int j = 0; j < array.length; j++) {
					newArray[j] = addToArr(newArray[j], array[j][i]);
				}

			}

		}

		if (check == true) {
			print(newArray);
		}

	}

	private static void print(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {

			System.out.println(Arrays.toString(arr[i]));

			/*
			 * for (int j = 0; j < arr[i].length; j++) {
			 * 
			 * System.out.print(arr[i][j] + " "); } System.out.println();
			 */
		}

	}

	private static int[] addToArr(int[] arr, int n) {
		int[] newArr = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = n;

		return newArr;
	}

}
