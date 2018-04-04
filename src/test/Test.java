package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//while (sc.hasNextLine()) {
			String str1 = new String(sc.next());
			String str2 = new String(sc.next());
			spiltStr(str1);
			spiltStr(str2);
		//}
		
	}
	
	public static void spiltStr(String str) {
		List<String> list = new ArrayList();
		int size = 0;
		int yu = 0;
		if (str.length() >= 8) {
			size = str.length() / 8;
			yu = str.length() % 8;
			for (int i = 0; i < size; i++) {
				list.add(str.substring(i * size, i * size + 8));
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			String lastStr = str.substring(size * 8);
			if (yu != 0) {
				for (int j = 0; j < (8 - yu); j++) {
					lastStr = lastStr + "0";
				}
				System.out.println(lastStr);
			}
		} else {
			yu = str.length() % 8;
			for (int j = 0; j < (8 - yu); j++) {
				str = str + "0";
			}
			System.out.println(str);
		}
	}
	
}
