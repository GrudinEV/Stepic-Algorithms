package main;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {2, 6, 8, 3, 1, 5, 3, 0};
		
		array = mergeSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}
	
	private static int[] mergeSort(int[] array) {
		int n = array.length;
		if (n == 1) {
			return array;
		}
		int m = n / 2;
		int[] firstArray = Arrays.copyOfRange(array, 0, m);
		int[] secondArray = Arrays.copyOfRange(array, m, n);
		return merge(mergeSort(firstArray), mergeSort(secondArray));
	}
	
	private static int[] merge(int[] arrA, int[] arrB) {
		if (arrA.length == 0) {
			return arrB;
		}
		if (arrB.length == 0) {
			return arrA;
		}
		int[] resArr = new int[arrA.length + arrB.length];
		if (arrA[0] < arrB[0]) {
			resArr[0] = arrA[0];
			System.arraycopy(merge(Arrays.copyOfRange(arrA, 1, arrA.length), arrB), 0, resArr, 1, arrA.length + arrB.length - 1);
		} else {
			resArr[0] = arrB[0];
			System.arraycopy(merge(Arrays.copyOfRange(arrB, 1, arrB.length), arrA), 0, resArr, 1, arrA.length + arrB.length - 1);
		}
		return resArr;
	}

}
