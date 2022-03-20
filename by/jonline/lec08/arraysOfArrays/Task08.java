package by.jonline.lec08.arraysOfArrays;

import java.util.Random;
import java.util.Scanner;

public class Task08 {

	public static void main(String[] args) {
		/*
		 * В числовой матрице поменять местами два столбца любых столбца, т.е. все
		 * элементы одного столбца поставить на соответствующие им позиции другого, а
		 * его элементы второго переместить в первый. Номера столбцов вводит
		 * пользователь с клавиатуры.
		 */

		int width;
		int hight;
		int[][] arr;
		
		width = enterPosIntFromConsole("enter width of array >> ");
		hight = enterPosIntFromConsole("enter height of array >> ");
		arr = new int[hight][width];
		
		initArray(arr);
		printArray(arr);
		replaceColumn(arr);
		printArray(arr);
	}

	private static void replaceColumn(int[][] arr) {
		if (arr == null) {
			return;
		}
		int[] colAdditional;
		int col1Num;
		int col2Num;
		String enterNum = "enter the number of the %s column you want to replace ";
		String doNotEx = "column #%d doesn't exist!\nremember that the numbering starts from 0\n";
		String sameColumn = "are you sure? It's the same. You can choose another column ...\nenter number >> ";
		
		col1Num = enterNotNegativeIntFromConsole(String.format(enterNum, "first"));
		while(col1Num >= arr[0].length) {
			System.out.printf(doNotEx, col1Num);
			col1Num = enterNotNegativeIntFromConsole(String.format(enterNum, "first"));	//ловим превышение указанного столбца над длиноой массива
		}
		col2Num = enterNotNegativeIntFromConsole(String.format(enterNum, "second"));
		while(col2Num >= arr[0].length) {
			System.out.printf(doNotEx, col2Num);
			col2Num = enterNotNegativeIntFromConsole(String.format(enterNum, "second"));
		}
		if (col2Num == col1Num) {
			col2Num = enterNotNegativeIntFromConsole(sameColumn);
		}
		colAdditional = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			colAdditional[i] = arr[i][col1Num];
			arr[i][col1Num] = arr[i][col2Num];
			arr[i][col2Num] = colAdditional[i];
		}
		
	}

	private static void printArray(int[][] arr) {
		if (arr == null) {
			return;
		}
		for (int i[]: arr) {
			for (int j: i) {
				System.out.printf("%2d ", j);
			}
			System.out.println();
		}
		
	}

	private static void initArray(int[][] arr) {
		if (arr == null) {
			return;
		}
		int n;
		n = 100; //[0;100)
		Random rand = new Random ();
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				arr[i][j] = rand.nextInt(n);
			}
		}
		
	}
	
	private static int enterNotNegativeIntFromConsole(String string) {
		int notNegative;
		
		notNegative = enterIntFromConsole(string);
		
		while (notNegative < 0) {
			System.out.println("It must not be negative");
			notNegative = enterIntFromConsole(string);
		}
		return notNegative;
	}

	private static int enterPosIntFromConsole(String string) {
		int positive;
		
		positive = enterIntFromConsole(string);
		
		while (positive < 1) {
			System.out.print("It must be positive integer");
			positive = enterIntFromConsole(string);
		}
		return positive;
	}

	private static int enterIntFromConsole(String string) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		
		System.out.printf(string);
		while(!sc.hasNextInt()) {
			sc.next();
			
			System.out.printf("integer, please\n" +string);
		}
		return sc.nextInt();
	}

}
