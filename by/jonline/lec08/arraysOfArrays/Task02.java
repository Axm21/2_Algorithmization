package by.jonline.lec08.arraysOfArrays;

import java.util.Random;
import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
		// Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.

		int n;

		n = enterIntFromConsole("Ведите размер стороны квадратной матрицы >> ");
		while (n < 0) {
			System.out.println("Не отрицательное число!!!");
			n = enterIntFromConsole("Ведите размер стороны квадратной матрицы >> ");
		}

		int[][] sqArr = new int[n][n];
		ArrSize sqArrWithSize;	//	создаём этот класс, чтобы вместе с массивом хранить максимальный расмер его значений
		ArrSize diagonArr;

		sqArrWithSize = initArrayOfArraysRandom(sqArr);
		printArrayOfArrays(sqArrWithSize);

		diagonArr = newArrayWithOnlyDiagonalElements(sqArr);
		
		printArrayOfArrays(diagonArr);

	}

	private static ArrSize newArrayWithOnlyDiagonalElements(int[][] arr) {
		int[][] newArr = new int [arr.length][];
		int maxSize;
		maxSize = 0;
		
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = new int [arr[i].length];

			for (int j = 0; j < arr[i].length; j++) {
				if (i == j || i + j == arr.length - 1) {
					int size;
					size = String.valueOf(arr[i][j]).length();	//размер ячейки
					if (size > maxSize) {
						maxSize = size;
					}
					newArr[i][j] = arr[i][j];
				} 
			}
		}
		ArrSize newArrSize = new ArrSize();
		newArrSize.arrOfArr = newArr;
		newArrSize.size = maxSize;

		return newArrSize;
	}

	private static void printArrayOfArrays(ArrSize arrWithSize) {
		// печатаем двумерный массив "красиво"
		
		int [][] arr = arrWithSize.arrOfArr;
		int size = arrWithSize.size;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				int numberSize; // будем сравнивать размер кадого значения с заранее заданным размером
								// ячейки(=макс.значение диапазона+знак минус)
				numberSize = String.valueOf(Integer.toString(arr[i][j])).length();

				if (arr[i][j] >= 0) { // если нет знака минус, то добавляем пропуск, чтобы выровнять
					System.out.print(" ");
					numberSize++; // чтобы учесть наш пропуск в качестве знака числа
				}
				System.out.printf("%d ", arr[i][j]);

				for (int k = numberSize; k < size; k++) { // теперь догоняем размеры числа до рпзмеров ячейки
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < arr[0].length; i++) { // чтоб разделить изначальную матрицу и результат задачи
			for (int k = 0; k < size+1; k++) {	//	ставим подчёркивание на каждый символ, не забывя про пробелы между столбцами
				System.out.print("_");
			}
		}
		System.out.println("\n");
	}

	private static ArrSize initArrayOfArraysRandom(int[][] arr) {
		// заполняем двумерный массив рандомными числами
		Random rand = new Random();
		int n;
		int sizeOfCell;
		ArrSize arrWithSize = new ArrSize();

		n = Math.abs(
				enterIntFromConsole("Введите число, которое будет определять диапазон значений матрицы [-n; n] >> ")); // [-|n|;
																														// |n|)

		sizeOfCell = String.valueOf(Integer.toString(n)).length() + 1;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				if (n != 0) {
					arr[i][j] = rand.nextInt(n) * 2 - n;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		arrWithSize.arrOfArr = arr;
		arrWithSize.size = sizeOfCell;

		return arrWithSize;
	}

	private static int enterIntFromConsole(String message) {
		// вводим int с консоли
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(message);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(message);
		}

		return sc.nextInt();
	}

}
