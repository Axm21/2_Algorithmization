package by.jonline.lec06.decomposition;

public class Task11 {

	public static void main(String[] args) {
		// Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] +
		// D[5]; D[4] + D[5] + D [6]. Пояснение. Составить метод (методы) для вычисления
		// суммы трёх последовательно расположенных элементов массива от k до m.

		int[] D;
		int sumFrom1To3;
		int sumFrom3To5;
		int sumFrom4To6;

		D = new int[] { 10, 11, 12, 13, 14, 15, 16 };

		sumFrom1To3 = sumOf3(D, 1);
		sumFrom3To5 = sumOf3(D, 3);
		sumFrom4To6 = sumOf3(D, 4);

		System.out.println("D[1] + D[2] + D[3] = " +sumFrom1To3);
		System.out.println("D[3] + D[4] + D[5] = " +sumFrom3To5);
		System.out.println("D[4] + D[5] + D[6] = " +sumFrom4To6);
	}

	public static int sumOf3(int[] n, int k) {
		int m;
		int sum = 0;
		m = k + 2;

		for (int i = k; i <= m; i++) {
			sum += n[i];

		}
		return sum;
	}
}
