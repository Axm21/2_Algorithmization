package by.jonline.lec06.decomposition;

public class Task06 {

	public static void main(String[] args) {
		// вычислить площадь правильного шестиугольника со стороной a, используя метод
		// вычисления площади треугольника.

		double side;
		double Area;
		
		side = 3;

		Area = 6 * AreaOfRegularTriangle(side);
		
		System.out.print("Area of Hexagon = " + Area);
	}

	public static double AreaOfRegularTriangle(double a) {
		double S;

		S = Math.sqrt(3) * a * a / 4;
		return S;
	}

}
