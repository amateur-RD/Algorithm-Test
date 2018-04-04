package test;

import java.util.Scanner;

//�����������֮��

public class maxSubArray {

	public static int getMaxSubArray(int[] arr) {
		
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0;i < arr.length;i++) {
			int sum = 0;
			for(int j = i;j < arr.length;j++) {
				sum += arr[j];
				if(sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		//int[] array = {1,-2,4,8,-4,7,-1,-5};
		
		Scanner sc = new Scanner(System.in);
		//�������鳤��
		int n = sc.nextInt();
		int array[] = new int[n];
		for(int i = 0;i < n;i++) {
			array[i] = sc.nextInt();
		}
		System.out.println(getMaxSubArray(array));
	}
}
