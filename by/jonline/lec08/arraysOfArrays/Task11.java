package by.jonline.lec08.arraysOfArrays;

import java.util.Random;

public class Task11 {

	public static void main(String[] args) {
		// Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму
		// матрицу и номера строк, в которых число 5 встречается три и более раз.

		int[][] arr;
		int[] lineIndex;

		arr = new int[10][20];

		initArr(arr);
		printArr(arr);
		lineIndex = lineWith5More3Times(arr);
		printLineIndex(lineIndex);

	}

	private static void printLineIndex(int[] lineIndex) {
		// разные варианты по количеству строк

		if (lineIndex.length == 0) {
			System.out.println("The line that contains number \"5\" 3 or more times doesn't exist");
		} else if (lineIndex.length > 1){
			System.out.print("The lines with index ");
			printLine(lineIndex);
			System.out.println(" contain number \"5\" 3 or more times");
		} else {
			System.out.print("The line with index ");
			printLine(lineIndex);
			System.out.println(" contains number \"5\" 3 or more times");
		}
	}

	private static void printLine(int[] arr) {
		for (int j : arr) {
			System.out.printf("%2d ", j);
		}

	}

	private static int[] lineWith5More3Times(int[][] arr) {
		int num;
		int frequency;
		num = 5; // вынесем сюда условия поиска для удобства поддержания кода
		frequency = 3;
		int[] lineIndex;
		lineIndex = new int[0];

		for (int i = 0; i < arr.length; i++) {
			int count;
			count = 0;

			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == num) {
					count++;
				}
			}
			if (count >= frequency) {
				lineIndex = addToArr(lineIndex, i);
			}
		}
		return lineIndex;
	}

	private static int[] addToArr(int[] arr, int n) {
		int[] newArr;
		newArr = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = n;

		return newArr;
	}

	private static void printArr(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int[] i : arr) {
			printLine(i);
			System.out.println();
		}
		for (int j = 0; j < arr[0].length; j++) {
			System.out.print("___");
		}
		System.out.println("\n");
	}

	private static void initArr(int[][] arr) {
		if (arr == null) {
			return;
		}
		Random rand = new Random();
		int n;
		n = 15;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = rand.nextInt(n);
			}
		}

	}

}
