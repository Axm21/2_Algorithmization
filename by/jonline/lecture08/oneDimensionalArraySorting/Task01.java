package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task01 {

	public static void main(String[] args) {
		// Заданы два одномерных массива с различным количеством элементов и натуральное
		// число k. Объединить их в один массив, включив второй массив между k-м и (k+1)
		// - м элементами первого, при этом не используя дополнительный массив.
		
		int k;
		int i;
		int j;
		int[] arr1;
		int[] arr2;
		
		k = 5;
		i = 8;
		j = 12;
		
		arr1 = new int [i];
		arr2 = new int [j];
		
		initArr(arr1);
		initArr(arr2);
		
		printArr(arr1);
		printArr(arr2);
		
		arr1 = uniteArr(arr1, arr2, k);
		
		printArr(arr1);

	}

	private static int[] uniteArr(int[] arr1, int[] arr2, int k) {
		int position;
		position = k+1;
		
		for (int i = arr2.length-1; i >= 0; i--) {
			arr1 = addToArr(arr1, arr2[i], position);
		}
		return arr1;
	}

	private static int[] addToArr(int[] arr, int n, int position) {
		int[] newArr;
		newArr = new int[arr.length+1];
		
		for (int i = 0, j = i; i < newArr.length; i++) {
			if (i == position) {
				newArr[i] = n;
				continue;
		}
			newArr[i] = arr[j];
			j++;
		}
		return newArr;
	}

	@SuppressWarnings("unused")
	private static int[] changeArrAlternative(int[] arr1, int[] arr2, int k) {
		int [] arr;
		arr = new int[arr1.length+arr2.length];
		
		for(int i = 0; i <= k; i++) {
			arr[i] = arr1[i];
		}
		for (int j = 0; j < arr2.length; j++) {
			arr[k+1+j] = arr2[j];
		}
		for (int j = k + arr2.length+1, i = k+1; j < arr.length; j++, i++) {
			arr[j] = arr1[i];
		}
		return arr;
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%2d ", arr[i]);
		}
		System.out.println();
	}

	private static void initArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*100);
		}
	}

}
