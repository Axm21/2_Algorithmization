package by.jonline.lec08.arraysOfArrays;

public class Task13 {

	public static void main(String[] args) {
		// Отсотрировать стобцы матрицы по возрастанию и убыванию значений элементов.

		int n;
		int m;
		int[][] arr;

		n = 10;
		m = 20;

		arr = new int[n][m];

		initArr(arr);
		printArr(arr);
		descendingSort(arr);
		System.out.println("the columns of the array are sorted in descending order of the values of the elements: ");
		printArr(arr);
		ascendingSort(arr);
		System.out.println("the columns of the array are sorted in ascending order of the values of the elements:");
		printArr(arr);

	}

	private static void descendingSort(int[][] arr) {
		if (arr == null) {
			return;
		}
		ascendingSort(arr);
		int add;
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length / 2; i++) {
				add = arr[i][j];
				arr[i][j] = arr[arr.length - 1 - i][j];
				arr[arr.length - 1 - i][j] = add;
			}
		}

	}

	private static void ascendingSort(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				int min;
				int minIndex;

				min = arr[i][j];
				minIndex = i;

				for (int k = i; k < arr.length; k++) {
					if (arr[k][j] < min) {
						min = arr[k][j];
						minIndex = k;
					}
				}
				arr[minIndex][j] = arr[i][j];
				arr[i][j] = min;
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
		for (int i = 0; i < arr[0].length; i++) {
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
