package by.jonline.lec08.arraysOfArrays;

import java.util.Random;
import java.util.Scanner;

public class Task03 {

	public static void main(String[] args) {
		// Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
		
		int k;
		int p;
		
		int length;
		int hight;
		
		int[][]array;
		
		length = enterFromConsoleAbs("length of array >> ");
		hight = enterFromConsoleAbs("hight of array >> ");

		array = new int[hight][length];
		
		ArrSize cell = new ArrSize ();
		
		cell = initArrayRand(array);
		printArrOfArr(cell);
		
		k = enterFromConsoleAbs("k line >> ");
		printLine (cell, k-1);
		
		p = enterFromConsoleAbs("p column >> ");
		printColumn(cell, p-1);
	}

	private static void printColumn(ArrSize cell, int p) {

		for (int i = 0; i < cell.arrOfArr.length; i++) {
			if (cell.arrOfArr[i][p] >= 0) {
				System.out.print(" ");
			}
			System.out.println(cell.arrOfArr[i][p]);
		}
		
	}

	private static void printLine(ArrSize cell, int k) {
		for (int i = 0; i < cell.arrOfArr[k].length; i++) {
			int size;
			size = String.valueOf(cell.arrOfArr[k][i]).length();
			
			if (cell.arrOfArr[k][i] >= 0) {
				System.out.print(" ");
				size++;
			}
			System.out.print(cell.arrOfArr[k][i] + " ");
			
			while (size < cell.size) {
				System.out.print(" ");
				size++;
			}
		}
		System.out.println();
		
	}

	private static void printArrOfArr(ArrSize cell) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < cell.arrOfArr.length; i++) {
			
			printLine(cell, i);
		}
		for (int j = 0; j < cell.arrOfArr[0].length; j++) {
			for (int k = 0; k < cell.size+1; k++) {
				System.out.print("_");
			}
		}
		System.out.println();
		
	}

	private static ArrSize initArrayRand(int[][] array) {
		// наполняем рандомными значениями [-n; n)
		int n;
		n = enterFromConsoleAbs("range of matrix values [-n; n). n >> ");
		
		Random rand = new Random();
		
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = rand.nextInt(n)*2-n;
			}
		}
		ArrSize cell = new ArrSize();
		cell.arrOfArr = array;
		cell.size = String.valueOf(n).length()+1;
		
		return cell;
	}

	private static int enterFromConsoleAbs(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(message);
		}
		return Math.abs(sc.nextInt());
	}
	
	

}
