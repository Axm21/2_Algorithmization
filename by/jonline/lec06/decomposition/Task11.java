package by.jonline.lec06.decomposition.copy;

public class Task11 {

	public static void main(String[] args) {
		// Написать метод (методы) определяющий, в каком из данных двух чисел больше
		// цифр.
		
		int a = 54_687;
		int b = 489_326;
		
		if (length(a) > length(b)) {
			System.out.print(a);
		}else if (length(a) != length(b)) {
			System.out.print(b);
		}else {
			System.out.print("equal");

		}

	}
	
	private static int length (int N) {
		int length;
		
		length = String.valueOf(N).length();
		
		return length;
	}

}
