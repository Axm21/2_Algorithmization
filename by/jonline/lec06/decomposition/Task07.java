package by.jonline.lec06.decomposition.copy;

public class Task07 {

	public static void main(String[] args) {
		// написать метод (методы) для вычисления суммы факториалов всех нечётных чисел
		// от 1 до 9.

		int n = 1;
		long sumFactorial = 0;

		while (n <= 9) {
			
			sumFactorial += factorialOfEven(n);
			n+=1;
		}
		System.out.print("Sum of factorials of even numbers = " + sumFactorial);

	}

	public static int factorialOfEven(int n) {
		int factorial = 1;

		if (n % 2 != 0) {
			factorial = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

}
