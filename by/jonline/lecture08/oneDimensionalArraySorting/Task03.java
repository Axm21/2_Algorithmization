package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task03 {

	public static void main(String[] args) {
		/*
		 * Сортировка выбором. Дана последовательность чисел a1<=a2<=...<=an.Требуется
		 * переставить элементы так, чтобы они были расположены по убыванию. Для этого в
		 * массиве, начиная с первого, выбирается наибольший элемент и ставится на
		 * первое место, а первый - на место наибольшего. Затем, начиная со второго, эта
		 * процедура повторяется. Написать алгоритм сортировки выбором.
		 */

		int[] arr = { 1, 2, 2, 3, 4, 6, 8, 9 };

		selectionSort(arr);
		printArr(arr);

	}

	private static void printArr(int[] arr) {
		for (int value: arr) {
			System.out.print(value + " ");
		}
		System.out.println();
		
	}

	private static void selectionSort(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			int indexMax;
			int max;

			indexMax = j;

			for (int i = j; i < arr.length; i++) {

				if (arr[i] > arr[indexMax]) {
					indexMax = i;
				}
			}
			max = arr[indexMax];
			arr[indexMax] = arr[j];
			arr[j] = max;
		}

	}

}
