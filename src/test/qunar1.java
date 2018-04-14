package test;

import java.util.ArrayList;
import java.util.Scanner;

public class qunar1 {
	// 邻接矩阵
	static int[][] matrix;
	// 单词个数
	static int len;
	static ArrayList<Integer> path;// 单条路径记录
	static ArrayList<ArrayList<Integer>> paths;// 所有路径

	public static void main(String[] args) {
		// 接收输入参数
		Scanner scanner = new Scanner(System.in);
		String init = scanner.nextLine();
		//String end = scanner.nextLine();
		String list = scanner.nextLine();
		scanner.close(); 
		// 将所有单词存入数组
		len = list.split(" ").length + 1;
		String[] vocabulary = new String[len];
		vocabulary[0] = init;
		int start = 0;
		// 最终词所在的索引
		for (int i = 1; i < len; i++) {
			vocabulary[i] = list.split(" ")[i - 1];
			//System.out.println("逆序："+swapWord(init));
			if (vocabulary[i].equals(swapWord(init))) {
				start = i;
			}
		} 
		// 构建邻接矩阵
		matrix = nearMatrix(vocabulary);
		path = new ArrayList<Integer>();
		paths = new ArrayList<ArrayList<Integer>>(); 
		// 开始搜索 
		look(start); 
		// 寻找最短路径
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < paths.size(); i++) {
			int k = paths.get(i).size();
			if (k < min && paths.get(i).get(k - 1) == 0) {
				min = k;
			}
		}
		System.out.println(min + 1);
	}

	public static void look(int start) {
		for (int i = 0; i < len; i++) {
			if (matrix[start][i] == 1 && !path.contains(i)) {
				path.add(i);
				if (i != 0) {
					look(i);
				} else {
					break;
				}
			}
		} // 添加路径
		paths.add(path);
		path = new ArrayList<Integer>();
		int length = paths.get(paths.size() - 1).size();
		for (int i = 0; i < length - 1; i++) {
			path.add(paths.get(paths.size() - 1).get(i));
		}
	} 
	// 构建邻接矩阵 public static

	static int[][] nearMatrix(String[] vac) {
		int[][] matrix = new int[vac.length][vac.length];
		for (int i = 0; i < vac.length; i++) {
			for (int j = 0; j < vac.length; j++) {
				matrix[i][j] = compare(vac[i], vac[j]);
			}
		}
		return matrix;
	} 
	// 比较两个单词是否可变换
	public static int compare(String s1, String s2) {
		int k = 0;
		for (int i = 0; i < s1.length(); i++) {
			if ((s1.charAt(i) + "").compareTo((s2.charAt(i) + "")) != 0) {
				k++;
				if (k > 1) {
					return Integer.MAX_VALUE;
				}
			}
		}
		return k;
	}
	
	//求逆序
	public static String swapWord(String s) {
		char[] cArr = s.toCharArray();
		swap(cArr,0,cArr.length - 1);
//		int begin = 0;
//		for(int i = 0;i<cArr.length;i++) {
//			if(cArr[i] == ' ') {
//				swap(cArr,begin,i - 1);
//				begin = i + 1;
//			}
//		}
//		swap(cArr,begin,cArr.length - 1);
		return new String(cArr);
 	}
	
	public static void swap(char[] cArr,int front,int end) {
		while(front < end) {
			char tmp = cArr[end];
			cArr[end] = cArr[front];
			cArr[front] = tmp;
			front++;
			end--;
		}
	}
}
