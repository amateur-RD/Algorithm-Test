package test;

import java.util.Scanner;

public class Meitu {

	public static int get(int n) {

		if (n >= 10 && n <= 100) {

			int count = n / 10;
			if (n % 10 == 6) {
				count = count + 1;
				return count;
			} else {
				return -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(get(n));

	}
}
