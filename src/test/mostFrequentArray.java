package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//找出数组中重复元素最多的数
public class mostFrequentArray {
	
	public static int getMostFrequentArray(int[] arr) {
		
		int result = 0;
		//统计每个元素出现的次数，存到HashMap中，key为元素值  value为元素出现次数
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i = 0;i < arr.length;i++) {
			if(m.containsKey(arr[i])) {
				m.put(arr[i], m.get(arr[i]) + 1);
			}else {
				m.put(arr[i], 1);
			}
		}
		
		int most = 0;
		//遍历HashMap
		Iterator iterator = m.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			int key = (int) entry.getKey();
			int value = (int) entry.getValue();
			if(value > most) {
				result = key;
				most = value;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		//int[] array = {1,1,2,2,2,2,5,5,2,6,4,7,4,3};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0;i < n;i++) {
			array[i] = sc.nextInt();
		}
		System.out.println(getMostFrequentArray(array));
	}

}
