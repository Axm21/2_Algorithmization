package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task05 {

	public static void main(String[] args) {
		/*
		 * Сортировка вставками. Дана последовательность чисел a1, a2, ... an. Требуется
		 * переставить числа в порядке возрастания. Делается это следующим образом.
		 * Пусть a1, a2, ...,ai - упорядоченная последовательность, т. е.
		 * a1<=a2<=...<=an. Берется следующее число a(i+1) и вставляется в
		 * последовательность так, чтобы новая последовательность была тоже
		 * возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
		 * не будут перебраны. Примечание. Место помещения очередного элемента в
		 * отсортированную часть производить с помощью двоичного поиска. Двоичный поиск
		 * оформить в виде отдельной функции.
		 */

		int[] arr = { 10, 8, 5, 2, 9, 4, 7, 1, 6, 3 };

		insertionSort(arr);
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) { // перебор несортированных элементов
			int j;
			int x;
			int location;

			x = arr[i];
			j = i - 1; // последный отсортированный элемент
			location = binarySearch(arr, x, j);

			while (j >= location) { //перемещаем элементы вправо до нащей ячейки, в которую поместим значение
				arr[j + 1] = arr[j];
				j--;

			}
			arr[location] = x;
		}

	}

	public static int binarySearch(int[] arr, int x, int high) {
		int location;
		int low;
		int middle;

		low = 0;
		while (low <= high) {

			middle = low + (high - low) / 2;
			if (x == arr[middle]) {
				location = middle + 1;
				break;
			} else if (x > arr[middle]) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		location = low;

		return location;

	}

}
