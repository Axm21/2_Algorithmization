package by.jonline.lec08.arraysOfArrays;

public class Task12 {

	public static void main(String[] args) {
		// Отсортировать строки матрицы по возрастанию и убыванию значений элементов.

		int n;
		int m;
		int[][] arr;

		m = 15;
		n = 25;
		arr = new int[m][n];

		initArr(arr);
		printArr(arr);
		System.out.println("the rows of the array are sorted in ascending order of the values of the elements");
		sortLineAscend(arr);
		printArr(arr);
		System.out.println("the rows of the array are sorted in descending order of the values of the elements:");
		sortLineDescend(arr);
		printArr(arr);

	}

	private static void sortLineAscend(int[][] arr) {
		if (arr == null) {
			return;
		}
		sortLineDescend(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				int add;
				add = arr[i][j];
				arr[i][j] = arr[i][arr[i].length - 1 - j];
				arr[i][arr[i].length - 1 - j] = add;
			}
		}
	}

	private static void sortLineDescend(int[][] arr) {
		if (arr == null) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int max;
				max = arr[i][j];

				for (int k = j; k < arr[i].length; k++) {
					if (arr[i][k] > max) {
						max = arr[i][k];
					}
				}
				for (int k = j; k < arr[i].length; k++) {
					if (arr[i][k] == max) {
						arr[i][k] = arr[i][j];
						arr[i][j] = max;
					}
				}

			}
		}
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
		for (int j = 0; j < arr[0].length; j++) {
			System.out.print("___");
		}
		System.out.println("\n");

	}

	private static void initArr(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = (int) (Math.random() * 100);
			}
		}

	}

}
