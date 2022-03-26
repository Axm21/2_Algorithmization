package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task02 {

	public static void main(String[] args) {
		// Даны две последовательностиmn a1<=a2<=...<=an и b1<=b2<=...<=bm. Образовать из них
		// новую последовательность чисел так, чтобы она тоже была неубывающей.
		// Примечание. Дополнительный массив не использовать

		int [] a = {1, 2, 3, 8, 12, 20};
		int [] b = {2, 4, 9, 14, 19, 21, 34};
		
		a = uniteArr(a, b);
		printArr(a);
	}

	private static void printArr(int[] a) {
		for (int value: a) {
			System.out.printf("%2d ", value);
		}
		System.out.println();
	}

	private static int[] uniteArr(int[] a, int[] b) {
		for (int value: b) {
			a = addToArr(a, value);
		}
		return a;
	}

	private static int[] addToArr(int[] arr, int n) {
		int[] newArr;
		
		newArr = new int[arr.length+1];
		
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		int i;
		i = newArr.length-1;
		while (newArr[i-1] > n) {
			newArr[i] = newArr[i-1];
			i--;
		}
		newArr[i] = n;
		
		return newArr;
	}

}
