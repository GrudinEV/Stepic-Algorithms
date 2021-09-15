package main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class SetPoints {
	private static Line[] lines;
	private static int countLines;
	private static int countPoints = 0;
	private static TreeSet<Integer> setPoints = new TreeSet<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		countLines = sc.nextInt();
		lines = new Line[countLines];
		
		for (int i = 0; i < countLines; i++) {
			int startPoint = sc.nextInt();
			int endPoint = sc.nextInt();
			lines[i] = new Line(startPoint, endPoint);
		}
		
		lines = mergeSort(lines);
		
		initialSetPoints();
		
		printSetPoints();
	}
	
	private static void initializeLines(int countLines) {
		for (int i = 0; i < countLines; i++) {
			int startPoint = (int) (Math.random() * 999999999);
			int endPoint = startPoint + (int) (Math.random() * (1000000000 - startPoint)) + 1;
			lines[i] = new Line(startPoint, endPoint);
		}
	}
	
	private static void initialSetPoints() {
		int lastPoint = 0;
		for (int i = 0; i < countLines; i++) {
			if (i == 0) {
				countPoints++;
				lastPoint = lines[i].endPoint;
				setPoints.add(lastPoint);
			} else {
				if (lastPoint < lines[i].startPoint) {
					countPoints++;
					lastPoint = lines[i].endPoint;
					setPoints.add(lastPoint);
				}
			}
		}
	}
	
	private static void printSetPoints() {
		System.out.println(countPoints);
		setPoints.forEach(x -> System.out.print(x + " "));
	}
	
	private static Line[] mergeSort(Line[] array) {
		int n = array.length;
		if (n == 1) {
			return array;
		}
		int m = n / 2;
		Line[] firstArray = Arrays.copyOfRange(array, 0, m);
		Line[] secondArray = Arrays.copyOfRange(array, m, n);
		return merge(mergeSort(firstArray), mergeSort(secondArray));
	}
	
	private static Line[] merge(Line[] arrA, Line[] arrB) {
		if (arrA.length == 0) {
			return arrB;
		}
		if (arrB.length == 0) {
			return arrA;
		}
		Line[] resArr = new Line[arrA.length + arrB.length];
		if (arrA[0].compareTo(arrB[0]) < 0) {
			resArr[0] = arrA[0];
			System.arraycopy(merge(Arrays.copyOfRange(arrA, 1, arrA.length), arrB), 0, resArr, 1, arrA.length + arrB.length - 1);
		} else {
			resArr[0] = arrB[0];
			System.arraycopy(merge(Arrays.copyOfRange(arrB, 1, arrB.length), arrA), 0, resArr, 1, arrA.length + arrB.length - 1);
		}
		return resArr;
	}
	
	private static class Line implements Comparable {
		private int startPoint, endPoint;
		
		Line(int startPoint, int endPoint) {
			this.startPoint = startPoint;
			this.endPoint = endPoint;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			if (o instanceof Line) {
				return this.endPoint - ((Line) o).endPoint;
			}
			return 0;
		}
	}
	
}
