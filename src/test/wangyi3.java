package test;

import java.util.Scanner;

public class wangyi3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int sum = 0;
		int[] v = new int[n];
		Scanner sc1 = new Scanner(System.in);
		
		for(int i = 0; i<n;i++) {
			v[i] =sc1.nextInt();	
		}
		
		for(int j = 0;j<v.length;j++) {
			sum += v[j];
			//System.out.println(sum);
		}
		
		if(sum < w) {
			System.out.println(Integer.valueOf((int) Math.pow(2,n)));
		}
		
	}

}
