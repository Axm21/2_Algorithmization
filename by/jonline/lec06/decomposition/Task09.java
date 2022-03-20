package by.jonline.lec06.decomposition;

public class Task09 {

	public static void main(String[] args) {
		// Написать метод (методы), проверяющий, являются ли три числа взаимно простыми.

		int a = 15;
		int b = 8;
		int c = 49;

		if (greatestCommonDevisorOfTwo(a, b) == 1 && greatestCommonDevisorOfTwo(b, c) == 1
				&& greatestCommonDevisorOfTwo(a, c) == 1) {
			System.out.print("yes");
		} else
			System.out.print("no");

	}

	public static int greatestCommonDevisorOfTwo(int N1, int N2) {

		int GCD = 1;
		int devisorN1 = 1;
		int devisorN2 = 1;

		for (int i1 = N1; i1 > 0; i1--) {
			if (N1 % i1 == 0) {
				devisorN1 = i1;
			}
			for (int i2 = N2; i2 > 0; i2--) {
				if (N2 % i2 == 0) {
					devisorN2 = i2;
				}
				if (devisorN1 == devisorN2) {
					GCD = devisorN2;
					break;
				}
			}
			if (devisorN1 == devisorN2) {
				break;
			}
		}
		return GCD;

	}
}
