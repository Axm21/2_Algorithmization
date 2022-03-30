package by.jonline.lec06.decomposition.copy;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
		// На плоскости заданы своими координатами n точек. Написать метод (методы),
		// определяющие между какими из пар точек самое большое расстояние.
		// Указание: координаты точек занести в массив.

		int n;
		double[] coordinate;
		double[] mostRemotePoints;

		n = enterFromConsole("n >> ");
		while (n < 4) {
			System.out.println("(」°ロ°)」 ?wtf?");
			n = enterFromConsole("n >> ");
		}
		coordinate = new double[n];

		initArray(coordinate);
		printArray(coordinate);

		mostRemotePoints = greatestDistance(coordinate);

		printArray(mostRemotePoints);
	}

	private static double[] greatestDistance(double[] point) {
		double grDist;
		double[] remotePoints = { 0, 0, 0, 0 };

		grDist = 0;

		for (int x1 = 0; x1 < point.length - 1; x1 += 2) {
			int y1;
			y1 = x1 + 1;
			for (int x2 = 0; x2 < point.length - 1; x2 += 2) {
				int y2;
				y2 = x2 + 1;
				if (distance(point[x1], point[y1], point[x2], point[y2]) > grDist) {
					grDist = distance(point[x1], point[y1], point[x2], point[y2]);

					remotePoints[0] = point[x1];
					remotePoints[1] = point[y1];
					remotePoints[2] = point[x2];
					remotePoints[3] = point[y2];
				}
			}
		}

		return remotePoints;
	}

	private static double distance(double x1, double y1, double x2, double y2) {
		double x;
		double y;
		double distance;

		x = Math.abs(x1 - x2);
		y = Math.abs(y1 - y2);
		distance = Math.sqrt(x * x + y * y);

		return distance;
	}

	private static void printArray(double[] a) {
		if (a == null || Arrays.equals(a, new double[0])) {
			return;
		}
		System.out.println(Arrays.toString(a));

	}

	private static void initArray(double[] a) {
		if (a == null) {
			return;
		}
		Random rand = new Random();
		int n;
		n = 10; // [-10; 10)
		for (int i = 0; i < a.length; i++) {
			//a[i] = rand.nextDouble() * n * 2 - n;
			a[i] = rand.nextInt(n)*2-n;
		}

	}

	private static int enterFromConsole(String string) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print(string);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print(string);
		}
		return sc.nextInt();
	}

}
