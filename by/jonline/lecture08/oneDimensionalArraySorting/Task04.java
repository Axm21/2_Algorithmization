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
		int[] arr = { 10, 8, 5, 2, 9, 4, 7, 1, 6, 3 };

		replCount = exchangeSort(arr);
		
		printArr(arr);
		System.out.println("Number of replacement by sorting: " + replCount);
	}

	private static void printArr(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	private static int exchangeSort(int[] arr) {
		int count;
		boolean needIteration;
		
		count = 0;
		needIteration = true;
		
		while (needIteration) {
			needIteration = false;
			
			for (int i = 0; i + 1 < arr.length; i++) {
				if (arr[i] > arr[i + 1]) {
					int add;
					add = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = add;
					count++;
					needIteration = true;
				}
			}
		}
		return count;

	}

}
