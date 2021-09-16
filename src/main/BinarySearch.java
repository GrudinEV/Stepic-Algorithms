package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int n = scanner.nextInt();
		int[] arrayN = new int[n];
		for (int i = 0; i < n; i++) {
			arrayN[i] = scanner.nextInt();
		}
		int k = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			int num = scanner.nextInt();
			int leftEl = 0;
			int rightEl = n - 1;
			int ind = 0;
			while (true) {
				if (leftEl == rightEl) {
					if (arrayN[leftEl] == num) {
						ind = leftEl;
					} else {
						ind = -2;
					}
					break;
				}
//				if (leftEl + 1 == rightEl) {
//					if (arrayN[leftEl] == num) {
//						ind = leftEl;
//					} else {
//						if (arrayN[rightEl] == num) {
//							ind = rightEl;
//						} else {
//							ind = -2;
//						}
//					}
//					break;
//				}
				int index = (leftEl + (rightEl - leftEl) / 2) ;
				if (arrayN[index] == num) {
					ind = index;
					break;
				} else {
					if (arrayN[index] < num) {
						leftEl = index + 1;
					} else {
						rightEl = Math.max(leftEl, index - 1);
					}
				}				
				
			}
			sb.append(++ind);
			sb.append(" ");
		}
		System.out.println(sb.toString());
		scanner.close();		
	}

}
