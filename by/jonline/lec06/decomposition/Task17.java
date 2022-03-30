package by.jonline.lec06.decomposition.copy;

public class Task17 {

	public static void main(String[] args) {
		// Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его
		// цифр и т.д. Сколько таких действий надо произвести, чтобы получился нуль? Для
		// решения задачи использовать декомпозицию.

		int n;
		
		n = by.jonline.lec06.decomposition.Task18.enterIntFromConsole("n >> ");
		
		counter(n);

	}

	private static void counter(int n) {
		int count = 0;

		while (n > 0) {
			n = subtractionOfDigitsSum(n);
			count++;
		}
		System.out.println(count);
	}

	private static int subtractionOfDigitsSum(int n) {
		int subtr;

		subtr = n - sumOfDigit(n);

		return subtr;
	}

	private static int sumOfDigit(int n) {
		int sum = 0;

		for (int i = n; i > 0; i = (int) (i / 10)) {
			int digit;

			digit = i % 10;
			sum += digit;
		}

		return sum;
	}

}
