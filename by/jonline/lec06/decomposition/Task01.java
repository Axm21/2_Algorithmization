package by.jonline.lec06.decomposition;

import static java.lang.Math.*;

import java.util.Scanner;

public class Task01 {

	public static void main(String[] args) {
		// Треугольник задан координатами своих вершин.Написать метод для вычисления его
		// площади.

		double x1 = enterFromConsole("x1 >> ");
		double y1 = enterFromConsole("y1 >> ");

		double x2 = enterFromConsole("x2 >> ");
		double y2 = enterFromConsole("y2 >> ");

		double x3 = enterFromConsole("x3 >> ");
		double y3 = enterFromConsole("y3 >> "); //координаты вершин

		double area;

		double sideA;
		double sideB;
		double sideC;

		sideA = sideOfTriangle(x1, y1, x2, y2);
		sideB = sideOfTriangle(x2, y2, x3, y3);
		sideC = sideOfTriangle(x1, y1, x3, y3);

		area = areaOfTriangle(sideA, sideB, sideC);
		
		System.out.print("Area of triangle: " +area);

	}

	public static double sideOfTriangle(double x1, double y1, double x2, double y2) {
		double side;

		side = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));// находим через проекции на оси

		return side;
	}

	public static double areaOfTriangle(double A, double B, double C) {
		double area;
		double halfPerimeter;

		// формула герона S = √(p(p-a)(p-b)(p-c)), где p - полупериметр

		halfPerimeter = (A + B + C) / 2;
		area = sqrt(halfPerimeter * (halfPerimeter - A) * (halfPerimeter - B) * (halfPerimeter - C));

		return area;

	}
	
	public static double enterFromConsole (String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double value;
		
		System.out.print(message);
		while (!sc.hasNextDouble()) {
			sc.next();
			System.out.print(message);
		}
		value = sc.nextDouble();
		
		return value;
	}

}
