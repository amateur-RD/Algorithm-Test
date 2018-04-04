package test;

import java.util.ArrayList;
import java.util.Scanner;

public class qunar1 {
	static int[][] matrix;// �ڽӾ���
	static int len;// ���ʸ���
	static ArrayList<Integer> path;// ����·����¼
	static ArrayList<ArrayList<Integer>> paths;// ����·��

	public static void main(String[] args) {
		// �����������
		Scanner scanner = new Scanner(System.in);
		String init = scanner.nextLine();
		//String end = scanner.nextLine();
		String list = scanner.nextLine();
		scanner.close(); 
		// �����е��ʴ�������
		len = list.split(" ").length + 1;
		String[] vocabulary = new String[len];
		vocabulary[0] = init;
		int start = 0;
		// ���մ����ڵ�����
		for (int i = 1; i < len; i++) {
			vocabulary[i] = list.split(" ")[i - 1];
			//System.out.println("����"+swapWord(init));
			if (vocabulary[i].equals(swapWord(init))) {
				start = i;
			}
		} 
		// �����ڽӾ���
		matrix = nearMatrix(vocabulary);
		path = new ArrayList<Integer>();
		paths = new ArrayList<ArrayList<Integer>>(); 
		// ��ʼ���� 
		look(start); 
		// Ѱ�����·��
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
		} // ���·��
		paths.add(path);
		path = new ArrayList<Integer>();
		int length = paths.get(paths.size() - 1).size();
		for (int i = 0; i < length - 1; i++) {
			path.add(paths.get(paths.size() - 1).get(i));
		}
	} 
	// �����ڽӾ��� public static

	static int[][] nearMatrix(String[] vac) {
		int[][] matrix = new int[vac.length][vac.length];
		for (int i = 0; i < vac.length; i++) {
			for (int j = 0; j < vac.length; j++) {
				matrix[i][j] = compare(vac[i], vac[j]);
			}
		}
		return matrix;
	} 
	// �Ƚ����������Ƿ�ɱ任
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
	
	//������
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