package by.jonline.lec06.decomposition;

public class Task08 {

	public static void main(String[] args) {
		// Составить программу, которая в массиве A[N] находит второе по величине число
		// (вывести на печать число, которое меньше максимального элемента массива, но
		// больше всех других элементов)

		
		int[] A = new int [] {2, 19, 12, 20 ,18};
		
		int secondMax = 0;
		
		for (int N: A) {
			if (N > secondMax && N < max (A)) {
				secondMax = N;
			}
		}
		System.out.print(secondMax);
	}
	
	public static int max (int [] A){
		int max = 0;
		
		for (int N : A) {
			if (N > max){
				max = N;
			}
		}
		return max;
	}

}
