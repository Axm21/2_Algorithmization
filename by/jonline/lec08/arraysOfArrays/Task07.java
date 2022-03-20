package by.jonline.lec08.arraysOfArrays;

import java.util.Scanner;

public class Task07 {

	public static void main(String[] args) {
		//Сформировать квадратную матрицу порядка N по правилу: 
		//A [I,J] = sin ((I^2 - J^2) / N) и подсчитать количество положительных элементов в ней.
		
		int N;
		int countPos;
		double[][] A;
		
		N = enterFromConsole("N >> ");
		while (N < 0) {
			N = enterFromConsole("N >> ");
		}
		
		A = new double[N][N];
		initArr(A);
		printArr(A);
		countPos = countPositiveElement(A);
		System.out.println("Number of positive elements in the array: " + countPos);

	}

	private static int countPositiveElement(double[][] a) {
		int count;
		count = 0;
		for (double[] n: a) {
			for (double m: n) {
				if (m > 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static void printArr(double[][] a) {

		for (double[] i: a) {
			
			for (double j: i) {
				System.out.printf("% -2.3f ", j);
			}
			System.out.println();
		}
		
	}

	private static void initArr(double[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				int I;
				int J;
				I = i+1;	// в математике нумерация матрицы с 1
				J = j+1;
				arr[i][j] = Math.sin((I*I - J*J) * 1.0 / arr.length);
			}
		}
		
	}

	private static int enterFromConsole(String string) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print(string);
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.print(string);
		}
		return sc.nextInt();
	}

}
