package test;

//求数组中两两相加等于20的组合数的种类
public class findSum {

	public static void getFindSum(int[] arr) {
		for(int i = 0;i < arr.length;i++) {
			for(int j = i + 1;j < arr.length;j++) {
				if(arr[i] + arr[j] == 20)
					System.out.println("组合数为：" + arr[i] + "," + arr[j]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,7,17,2,6,3,14};
		getFindSum(array);
	}
}
