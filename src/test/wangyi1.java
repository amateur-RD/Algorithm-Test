package test;

import java.util.Scanner;

public class wangyi1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		com(n,k);
	}
	
	public static void com(int n, int k) {
		int count = 0;
		for(int i = k; i <= n;i++) {
			for(int j = k+1;j <= n;j++) {
				if(i % j >= k)
					count++;
			}
		}
		System.out.println(count);
	}
	
}
