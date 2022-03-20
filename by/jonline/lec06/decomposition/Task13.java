package by.jonline.lec06.decomposition;

public class Task13 {

	public static void main(String[] args) {
		// Дано натуральное число N. Написать метод (методы) для формирования массива,
		// элементами которого являются цифры числа N.

		int N = 568867;
		
		for (int i = length(N) - 1; i >= 0; i--) {

			System.out.println(numbersOfDigit(N)[i]);

		}
	}

	private static int[] numbersOfDigit(int N) {
		int digit;
		int[] numbersOfDigit = new int[length(N)];
		
		digit = N;

		for (int i = 0; i < length(N); i++) {
			int number;

			number = digit % 10;

			numbersOfDigit[i] = number;

			digit = (int) (digit / 10);

		}
		return numbersOfDigit;
	}

	private static int length(int N) {
		int length;

		length = String.valueOf(N).length();
		
		return length;
	}

}
