package by.jonline.lec06.decomposition;

import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
		// Два простых числа называются "близнецами", если они отличаются друг от друга
		// на 2 (например 41 и 43). Найти и напечатать все пары близнецов из отрезка
		// [n,2n], где n - заданное натуральное число больше 2. Для решения задачи
		// использовать декомпозицию.

		int n;
		
		n = enterIntFromConsole("n >> ");
		while(n <= 2) {
			n = enterIntFromConsole("n >> ");
		}
		
		numberTwin(n);

	}
	
	private static int enterIntFromConsole (String message) {
		int n;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		
		System.out.print(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(message);
		}
		n = sc.nextInt();
		
		return n;
	}
	
	private static void numberTwin(int n) {
		for (int i = n; i <= 2 * n; i++) {
			int m;

			m = i + 2;

			if (primeNumberCheck(i) == i && primeNumberCheck(m) == m) {
				System.out.println("number-twins: " +i + " and " + m);
			}
		}
	}

	private static int primeNumberCheck(int n) {
		int i = 2;
		while (i <= n) {
			if (n % i == 0)
				break;
			i++;
		}

		return i;
	}

}
