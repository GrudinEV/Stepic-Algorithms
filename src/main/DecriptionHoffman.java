package main;

import java.util.HashMap;
import java.util.Scanner;

public class DecriptionHoffman {

	public static void main(String[] args) {
		HashMap<String, Character> codeMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int l = sc.nextInt();
		for (int i = 0; i < k; i++) {
			char ch = sc.next().charAt(0);
			String code = sc.next();
			codeMap.put(code, ch);
		}
		String str = sc.next();
		sc.close();
		String code = "";
		for (int i = 0; i < l; i++) {
			code += str.charAt(i);
			if (codeMap.containsKey(code)) {
				System.out.print(codeMap.get(code));
				code = "";
			}
		}
	}

}
