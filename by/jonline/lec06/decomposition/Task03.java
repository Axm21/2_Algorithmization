package by.jonline.lec06.decomposition;

public class Task03 {

	public static void main(String[] args) {
		// Написать метод (методы) для нахождения наибольшего общего делителя четырёх
		// натуральных чисел.

		int a;
		int b;
		int c;
		int d;
		int grComDiv;

		a = 100;
		b = 160;
		c = 160;
		d = 20;

		grComDiv = greatestCommonDivisorOfFour(a, b, c, d);

		System.out.print("НОД = " + grComDiv);

	}

	public static int greatestCommonDivisorOfFour(int a, int b, int c, int d) {
		int grComDivOfAB;
		int grComDivOfCD;

		grComDivOfAB = greatestCommonDivisorOfTwo(a, b); // разобъём по парам и найдём НОД среди них и общий НОД
		grComDivOfCD = greatestCommonDivisorOfTwo(c, d);

		return greatestCommonDivisorOfTwo(grComDivOfAB, grComDivOfCD);
	}

	public static int greatestCommonDivisorOfTwo(int n1, int n2) {
		int divisorN1 = 1;
		int divisorN2 = 2;
		for (int i1 = n1; i1 > 0; i1--) {
			if (n1 % i1 == 0) {
				divisorN1 = i1;
			}

			for (int i2 = n2; i2 > 0; i2--) {
				if (n2 % i2 == 0) {
					divisorN2 = i2;
				}
				if (divisorN1 == divisorN2) {
					break;
				}
			}
			if (divisorN1 == divisorN2) {
				break;
			}
		}
		return divisorN2;
	}

}
