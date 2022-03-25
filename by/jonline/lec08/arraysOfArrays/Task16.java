package by.jonline.lec08.arraysOfArrays;

import java.util.Scanner;

public class Task16 {

	public static void main(String[] args) {
		// Магическим квадратом порядка n называется квадратная матрица размера nxn,
		// составленная из чисел 1, 2, 3...,n^2 так, что суммы по каждому столбцу,
		// каждой строке и каждой из двух больших диагоналей равны между собой.
		// Построить такой квадрат. Пример магического квадрата порядка 3:
		// 6 1 8
		// 7 5 3
		// 2 9 4

		int n;
		int[][] arr;
		n = enterLength("n >>  ");

		arr = new int[n][n];

		initArr(arr);
		printArr(arr);

	}

	private static int enterLength(String string) {
		int n;
		n = enterFromConsole(string);
		
		while (n < 1 || n == 2) {
			System.out.printf("Magic square with lateral length '%d' soesn't exist. Try agayn.\n", n);
			n = enterFromConsole(string);
		}
		
		return n;
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

	private static void initArr(int[][] arr) {
		if (arr.length % 2 == 0) {
			if (arr.length % 4 == 0) {
				squareEvenEvenOrder(arr);
			} else {
				squareEvenOddOrder(arr);
			}
		} else {
			squareOddOrder(arr);
		}
	}

	private static void squareEvenOddOrder(int[][] arr) {
		// воспользуемся методом окаймленных квадратов. Мы сделаем чётно-четный квадрат,
		// поместим его в центре и окаймуем его скаждой стороны
		int nAdd;
		int[][] arrAdd;

		nAdd = arr.length - 2;
		arrAdd = new int[nAdd][nAdd];
		// Построим любой магический квадрат порядка n - 2
		// Увеличим все элементы этого магического квадрата на величину 2(n - 1) и
		// поместим полученный нетрадиционный магический квадрат в матрицу n*n так,
		// чтобы с каждой стороны квадрата был свободный столбец (свободная строка).

		squareEvenEvenOrder(arrAdd);
		for (int i = 0; i < arrAdd.length; i++) {
			for (int j = 0; j < arrAdd[0].length; j++) {
				arrAdd[i][j] += 2 * (arr.length - 1);
				arr[i + 1][j + 1] = arrAdd[i][j];
			}
		}
		int m; // расчётные величины по методу: m = n / 2
		int halfM; // M = m / 2;
		int d; // d = n^2 + 1

		m = arr.length / 2;
		d = arr.length * arr.length + 1;
		halfM = m / 2;
		/*
		 * Заполним угловые ячейки матрицы n*n следующим образом: в левую верхнюю ячейку
		 * запишем число 3m - 1, в верхнюю правую – число 1, в нижнюю левую – число d -
		 * 1, в нижнюю правую - число d - 3m + 1, где m = n/2, d = n2 + 1
		 */
		arr[0][0] = 3 * m - 1;
		arr[0][arr[0].length - 1] = 1;
		arr[arr.length - 1][0] = d - 1;
		arr[arr.length - 1][arr[0].length - 1] = d - 3 * m + 1;
		/*
		 * В оставшиеся свободными ячейки верхней строки поместим (произвольным образом)
		 * числа {2i + 1} и {d – 2j}, где i = 1, 2, …, m – 2, а j = 1, 2, …, m.
		 */
		for (int i = 1; i <= m; i++) {
			arr[0][i] = 2 * i + 1;
		}
		for (int j = 1; j <= m; j++) {// прошлый цикл заполнил половину, поэтому начинаем со второй половины
			arr[0][m - 1 + j] = d - 2 * j;
		}
		/*
		 * В оставшиеся свободные клетки левого столбца поместим (произвольным образом)
		 * числа 2m – 1, {d – 4m + 1 + j}, {3m – 1 – i}, {3m – 1 + q, d – 2m – q}, где j
		 * = 1, 2, …, M + 1, i = 1, 2, …, M, q = 1, 2, …, M – 1, M = [m/2].
		 */
		arr[1][0] = 2 * m - 1;

		int i1;
		i1 = 2;

		for (int j = 1; j <= halfM + 1; j++, i1++) {
			arr[i1][0] = d - 4 * m + 1 + j;
		}
		for (int k = 1; k <= halfM; k++, i1++) {
			arr[i1][0] = 3 * m - 1 - k;
		}
		for (int q1 = 1; q1 < halfM; q1++, i1++) {
			arr[i1][0] = 3 * m - 1 + q1;
		}
		for (int q2 = 1; q2 < halfM; q2++, i1++) {
			arr[i1][0] = d - 2 * m - q2;
		}
		/*
		 * Оставшиеся свободными ячейки нижней строки (правого столбца) заполним
		 * числами, комплементарными числам в противоположных ячейках верхней строки
		 * (левого столбца), то есть дающими в сумме (n2 + 1).
		 */
		for (int i = 1; i < arr.length; i++) {
			arr[i][arr[0].length-1] = d -arr[i][0];
		}
		for (int j = 1; j < arr[0].length; j++) {
			arr[arr.length - 1][j] = d - arr[0][j];
		}

	}

	private static void squareEvenEvenOrder(int[][] arr) {
		// используем здесь метод квадратных рамок, упрощаем его смещением координат на
		// длину порядка квадрата в случае выхода за пределы
		int i;
		int j;
		int i0;
		int j0;
		int loop;

		i = 0;
		j = 0;

		i0 = -1;
		j0 = 1; /*
				 * i0 и j0 мы используем в качестве показателя отрицательности или
				 * положительности движения вектора при заполнении, фиксируем критические
				 * значения для смены знаков внутри цикла
				 */
		loop = 0; // индекс цикла. критичная точка цикла 2n.

		for (int k = 1; k <= arr.length * arr[0].length; k++) {

			int halfLength;

			halfLength = arr.length / 2;

			arr[i][j] = k;

			if (k - loop * arr.length * 2 == halfLength * 1) { // критичнеские точки для поворота вектора помещаям в
				// ветвление. вектор меняет своё направление после n/2
				i0 *= -1;
				i -= i0;
			}
			if (k - loop * arr.length * 2 == halfLength * 2) {
				j0 *= -1;
				j -= j0;
			}
			if (k - loop * arr.length * 2 == halfLength * 3) {
				i0 *= -1;
				i -= i0;
			}
			if (k - loop * arr.length * 2 == halfLength * 4) {
				i -= i0 - 1;
			}
			i += i0;
			j += j0;

			if (i > arr.length - 1 || i < 0) { // ловим выход за выходы матрицы и переносим
				i -= i0 * arr.length; // направления векторов i0 и j0 помогают программе понять за какие именно
										// пределы "хочет" выбраться число
			}
			if (j > arr[0].length - 1 || j < 0) {
				j -= j0 * arr[0].length;
			}

			if (k % (arr.length * 2) == 0) { // когда число достигает значения 2n фиксируем 1 пройденый цикл
				loop++;
			}
		}

	}

	private static void squareOddOrder(int[][] arr) { // строим с помощью индийского (сиамского) метода
		int i;
		int j;

		i = 0;
		j = arr[0].length / 2;
		
		for (int k = 1; k <= arr.length * arr[0].length; k++) {

			arr[i][j] = k;

			if (k % arr.length == 0) { // при значении k, равном величине порядка квадрата, происходит сещение вниз
				i++;
			} else {
				i--;
				j++;

				if (i < 0) { // ловим выход за пределы квадрата, перемещаем в противоположную точку
					i += arr.length;
				}
				if (j > arr[0].length - 1) {
					j -= arr[0].length;
				}
			}
		}
	}

	private static void printArr(int[][] arr) {
		for (int[] i : arr) {
			for (int j : i) {
				System.out.printf("%3d ", j);
			}
			System.out.println();

		}
	}

}
