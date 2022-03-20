package by.jonline.lec06.decomposition;

public class Task12 {

	public static void main(String[] args) {
		// Даны числа X, Y, Z, T - длины сторон четырёхугольника. Написать метод
		// (методы) для вычисления его площади, если угол между его сторонами X и Y -
		// прямой.
		
		double X = 3;
		double Y = 4;
		double Z = 5;
		double T = 6;
		double S;
		double diagonal;
		
		diagonal = Math.sqrt(X*X + Y*Y);
		
		S = AreaOfTriangle(X, Y, diagonal) + AreaOfTriangle(Z, T, diagonal);

		System.out.println("Area = " +S);
	}
	
	public static double AreaOfTriangle(double a, double  b, double c) {
		
		double p;
		double S;
		
		p = (a+b+c)/2;
		S = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		
		return S;
	}

}
