package by.jonline.lec08.arraysOfArrays;

public class Task15 {

	public static void main(String[] args) {
		// Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
		
		int m;
		int n;
		int[][] arr;
		
		n = 5;
		m = 8;
		
		arr = new int[n][m];
		initArr(arr);
		printArr(arr);
		changeArr(arr);
		printArr(arr);
	}

	private static void changeArr(int[][] arr) {
		int max;
		max = maxInArr(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 2 != 0) {
					arr[i][j] = max;
				}
			}
		}
		
	}

	private static int maxInArr(int[][] arr) {
		int max;
		max = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}
		return max;
	}

	private static void printArr(int[][] arr) {
		if (arr == null) {
			return;
		}
		for(int i[]: arr) {
			for (int j: i) {
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
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (Math.random()*100);
			}
		}
		
	}

}
