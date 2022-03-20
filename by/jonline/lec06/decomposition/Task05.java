package by.jonline.lec06.decomposition;

public class Task05 {

	public static void main(String[] args) {
		// Написать метод (методы) для нахождения суммы большего и меньшего из трёх
		// чисел.

		int a;
		int b;
		int c;
		int sum;

		a = 50;
		b = 10;
		c = 8;

		sum = sumMaxMin(a, b, c);

		System.out.print("Sum of min and max numbers: " + sum);
	}

	public static int max(int a, int b, int c) {
		int max;

		max = a;

		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}

	public static int min(int a, int b, int c) {
		int min;

		min = a;

		if (b < min) {
			min = b;
		}
		if (c < min) {
			min = c;
		}
		return min;
	}

	public static int sumMaxMin(int a, int b, int c) {
		int sum;

		sum = max(a, b, c) + min(a, b, c);

		return sum;
	}

}
