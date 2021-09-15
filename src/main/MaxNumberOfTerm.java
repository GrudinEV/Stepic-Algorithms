package main;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxNumberOfTerm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> terms = new LinkedList<>();
		for (int i = 1; i <= n && n != 0; i++) {
			if (2 * i + 1 <= n) {
				terms.add(i);
				n -= i;
			} else {
				terms.add(n);
				break;
			}			
		}
		System.out.println(terms.size());
		terms.forEach(x -> System.out.print(x + " "));
	}
}
