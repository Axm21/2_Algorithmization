package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task06 {

	public static void main(String[] args) {
		/*
		 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить
		 * его по возрастанию. Делается это следующим образом: сравниваются два соседних
		 * элемента ai и a(i+1) . Если ai <= a(i+1), то продвигаются на один элемент
		 * вперед. Если ai > a(i+1), то производится перестановка и сдвигаются на один
		 * элемент назад. Составить алгоритм этой сортировки.
		 */

		int[] arr = { 10, 8, 5, 2, 9, 4, 7, 1, 6, 3 };

		shellSort(arr);
		printArray(arr);
	}

	private static void shellSort(int[] arr) {
		// по условию не сортировка шелла, пропишем оба метода

		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			
			for (int i = gap; i < arr.length; i++) {
				int temp;
				int j;
				
				temp = arr[i];
				
				for (j = i; j >= gap && temp < arr[j-gap]; j -= gap) {
					arr[j] = arr[j-gap];
				}
				arr[j] = temp;
				printArray(arr);
			}
		}

	}

	private static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	@SuppressWarnings("unused")
	private static void gnomeSort(int[] arr) {
		boolean needIteration;
		needIteration = true;

		while (needIteration) {
			needIteration = false;

			for (int i = 0; i + 1 < arr.length; i++) {

				if (arr[i] <= arr[i + 1]) {

				} else {
					needIteration = true;
					swap(arr, i, i + 1);
					if (i > 0) {
						i--;

					}
				}
			}
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int add;
		add = arr[j];
		arr[j] = arr[i];
		arr[i] = add;

	}

}
