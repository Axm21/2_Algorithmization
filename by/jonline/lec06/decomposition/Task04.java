package by.jonline.lec06.decomposition;

public class Task04 {

	public static void main(String[] args) {
		// Написать метод (методы) для нахождения наименьшего общего кратного для трёх натуральных чисел.
		
		int a;
		int b;
		int c;
		int leastComMult;
		
		a = 80;
		b = 12;
		c = 48;
		
		leastComMult = leastCommonMultiple(a, b, c);
		
		System.out.print("НОК = " + leastComMult);

	}
	
	public static int leastCommonMultiple (int a, int b, int c) {
		int lComMultAB;
		int lComMult;
		
		lComMultAB =leastCommonMultipleOfTwo(a, b);
		lComMult = leastCommonMultipleOfTwo(lComMultAB, c);
		
		return lComMult;
	}
	
	public static int greatestCommonDivisorOfTwo (int n1, int n2) {
		int divisor1 = 1;
		int divisor2 = 1;
		
		for (int i1 = n1; i1 >0; i1--) {
			if (n1 % i1 == 0) {
				divisor1 = i1;
			}
			for (int i2 = n2; i2 > 0; i2--) {
				if (n2 % i2 == 0) {
					divisor2 = i2;
				}
				if (divisor2 == divisor1) {
					break;
				}
			}
			if (divisor2 == divisor1) {
				break;
			}
		}
		return divisor1;
	}

	public static int leastCommonMultipleOfTwo (int n1, int n2) {
		return n1 * n2 / greatestCommonDivisorOfTwo(n1, n2);
	}
}
