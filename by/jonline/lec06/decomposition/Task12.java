package by.jonline.lec06.decomposition.copy;

import java.util.Arrays;

public class Task12 {

	public static void main(String[] args) {
		// Даны натуральные числа K и N. Написать метод (методы) формирования массива A,
		// элементами которого являются числа, сумма цифр которых равна K и которые не
		// больше N.

		int N = 560;
		int K = 20;
		
		int [] array;
		array = new int [0];

		array = initArray(array, K, N);
		printArray(array);

	}
	
	private static int [] initArray (int[] array, int K, int maxNum) {
		for (int i = 1; i <= maxNum; i++) {
			if (sumOfDigit(i) == K) {
				array = addElement(array, i);
			}
		}
		return array;
	}

	private static void printArray(int[] array) {
		if (Arrays.equals(array, new int[0]) || array == null) {
			System.out.println("¯\\_(ツ)_/¯");
			return;
		}
		System.out.print(Arrays.toString(array));
	}
		

	private static int  sumOfDigit(int x) {
		int sum = 0;

		while (x > 0) {
			sum += x % 10;

			x = (int) (x / 10);
		}
		return sum;
	}
	
	private static int[] addElement (int[] arr, int n) {
		int [] newArr = new int[arr.length+1];
		
		for (int i=0; i < arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = n;
		
		return newArr;
	}
}
