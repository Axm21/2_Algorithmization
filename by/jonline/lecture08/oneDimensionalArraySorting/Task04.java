package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task04 {

	public static void main(String[] args) {
		/*
		 * Сортировка обменами. Дана последовательность чисел a1<=a2<=...<=an.Требуется
		 * переставить числа в порядке возрастания. Для этого сравниваются два соседних
		 * числа ai и a(i+1) . Если ai > a(i+1), то делается перестановка. Так
		 * продолжается до тех пор, пока все элементы не станут расположены в порядке
		 * возрастания. Составить алгоритм сортировки, подсчитывая при этом количества
		 * перестановок.
		 */

		int replCount;
		int[] arr = { 9, 8, 20, 7, 6, 15, 5, 4, 3, 2, 18, 1, 0 };

		replCount = sortArr(arr);
		
		printArr(arr);
		System.out.println("Number of replacement by sorting: " + replCount);
	}

	private static void printArr(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	private static int sortArr(int[] arr) {
		int count;
		count = 0;
		
		for (int j = 0; j < arr.length - 1; j++) {
			
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int add;
					add = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = add;
					count++;
				}
			}
		}
		return count;

	}

}
