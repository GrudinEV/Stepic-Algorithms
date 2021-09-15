package main;

import java.util.Scanner;

public class NOD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		
		while (a != 0 && b != 0) {
			if (a >= b) {
				a %= b;
			} else {
				b %= a;
			}
		}
		
		System.out.println(Math.max(a, b));
	}

}
