package by.jonline.lec06.decomposition;

import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
		// написать метод (методы) для нахождения наибольшего общего делителя и
		// наименьшего общего кратного двух натуральных чисел:
		// ( HOK (A,B) = (A*B) / НОД (A,B) )

		int A;
		int B;
		int greatestComDiv;
		int leastComMult;

		A = enterPositiveIntFromConsole("A >> ");
		B = enterPositiveIntFromConsole("B >> ");

		greatestComDiv = greatestCommonDiviser(A, B);
		leastComMult = leastCommonMultiple(A, B, greatestComDiv);
		System.out.println("НОД = " + greatestComDiv);
		System.out.println("НОК = " + leastComMult);
	}
	
	public static int greatestCommonDiviser (int A, int B) {
		
		int divisorA = 1;
		int divisorB = 1;

		for (int i = A; i > 0; i--) {

			if (A % i == 0) {
				divisorA = i;
			}
			for (int k = B; k > 0; k--) {

				if (B % k == 0) {
					divisorB = k;
				}
				if (divisorB == divisorA) {
					break;
				}
			}
			if (divisorB == divisorA) {
				break;
			}
		}
		
		return (divisorA);
	}

	public static int leastCommonMultiple (int A, int B, int GCD) {
		int LCM;
		
		LCM = (A * B) / GCD;
		
		return LCM;
	}

	public static int enterPositiveIntFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		int value;
		
		System.out.print(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(message);
		}
		value = Math.abs(sc.nextInt());
		
		return value;
	}

	
}
