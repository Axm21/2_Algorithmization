package by.jonline.lecture08.oneDimensionalArraySorting;

public class Task08 {

	public static void main(String[] args) {
		/*
		 * Даны дроби p1/q1, p2/q2, ..., pn/qn (pi, qi - натуральные). Составить
		 * программу, которая приводит эти дроби к общему знаменателю и упорядочивает их
		 * в порядке возрастания.
		 */
		
		int [] p = {2, 3, 5, 8, 1, 7, 2};
		int [] q = {3, 2, 7, 4, 10, 3, 6};
		Fraction[] fr = new Fraction[p.length];
		
		for (int i = 0; i < p.length; i++) {
			fr[i] = new Fraction();
			fr[i].numerator = p[i];
			fr[i].denominator = q[i];
		}
		printFraction(fr);
		toCommonDenominator(fr);
		printFraction(fr);
		shellSortFraction(fr);
		printFraction(fr);
	}

	private static void shellSortFraction(Fraction[] fr) {
		int n = fr.length;
		
		for (int gap = n/2; gap > 0; gap /= 2) {
			
			for (int i = gap; i < n; i++) {
				int tempNum;
				int tempDen;
				
				tempNum = fr[i].numerator;
				tempDen = fr[i].denominator;
				
				int j;
				for (j = i; j >= gap && tempNum < fr[j-gap].numerator; j -= gap) {
					fr[j].numerator = fr[j-gap].numerator;
					fr[j].denominator = fr[j-gap].denominator;
				}
				fr[j].numerator = tempNum;
				fr[j].denominator = tempDen;
			}
		}
		
	}


	private static void printFraction(Fraction[] fr) {
		for (int i = 0; i < fr.length; i++) {
			System.out.printf("%d/%d ", fr[i].numerator, fr[i].denominator);
		}
		System.out.println();
	}

	private static void toCommonDenominator(Fraction[] fr) {
		int GCD;
		int LCM;
		
		LCM = fr[0].denominator;
		for (int i = 1; i < fr.length; i++) {
			GCD = greatComDiv(LCM, fr[i].denominator);
			LCM = LCM * fr[i].denominator / GCD;
		}
		for (int i = 0; i < fr.length; i++) {
			fr[i].numerator *= LCM / fr[i].denominator;
			fr[i].denominator = LCM;
		}
	}

	private static int greatComDiv(int a, int b) {
		//используем алгоритм евклида
		if (b > a) { // находим большее из чиле и помещаем его в a
			a += b; // делаем арифметическую замену без доп.переменной
			b = a - b;
			a -= b;
		}
		
		while (a % b != 0) {
			a = a % b;
			if (b > a) {
				a += b;
				b = a-b;
				a -= b;
			}
		}
		return b;
	}

}
