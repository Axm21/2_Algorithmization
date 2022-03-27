package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task07 {

	public static void main(String[] args) {
		/*
		 * Пусть даны две неубывающие последовательности действительных чисел
		 * a1<=a2<=...<=an и b1<=b2<=...<=bm. Требуется указать те места, на которые
		 * нужно вставлять элементы последовательности b1<=b2<=...<=bm в первую
		 * последовательность так, чтобы новая последовательность оставалась
		 * возрастающей.
		 */

		int[] a = { 1, 2, 5, 6, 6, 8, 9 };
		int[] b = { 0, 2, 3, 4, 7, 8, 10, 12 };

		findplace(a, b);
	}

	private static void findplace(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			int place;
			String str;
			
			place = binarySearch(a, b[i]);
			str = new String ("before element with index %d in array a\n");
			if (a.length-1 < place) {
				str = new String("with index %d in array a\n");
			}
			System.out.printf("for '%d' is place " + str, b[i], place);
		}

	}

	private static int binarySearch(int[] a, int x) {
		int low;
		int high;
		int mid;

		low = 0;
		high = a.length - 1;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (x == a[mid]) {
				low = mid;
				break;
			}
			if (x > a[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

}
