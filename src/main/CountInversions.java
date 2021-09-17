package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CountInversions {
    private static long countInversion = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int countNumbers = sc.nextInt();
        int[] numbers = new int[countNumbers];
        for (int i = 0; i < countNumbers; i++) {
            numbers[i] = sc.nextInt();
        }
        mergeSort(numbers);
        System.out.println(countInversion);
    }

    private static int[] mergeSort(int[] numbers) {
        int len = numbers.length;
        if (len == 1) {
            return numbers;
        }
        int[] arrayLeft = Arrays.copyOfRange(numbers, 0, len / 2);
        int[] arrayRight = Arrays.copyOfRange(numbers, len / 2, len);
        return merge(mergeSort(arrayLeft), mergeSort(arrayRight));
    }

    private static int[] merge(int[] arrayLeft, int[] arrayRight) {
        int[] resultArr = new int[arrayLeft.length + arrayRight.length];
        int i = 0;
        int l = 0;
        int r = 0;
        while (l < arrayLeft.length && r < arrayRight.length) {
            if (arrayRight[r] < arrayLeft[l]) {
                countInversion += arrayLeft.length - l;
                resultArr[i] = arrayRight[r];
                r++;
            } else {
                resultArr[i] = arrayLeft[l];
                l++;
            }
            i++;
        }
        if (l < arrayLeft.length) {
            while (l < arrayLeft.length) {
                resultArr[i] = arrayLeft[l];
                l++;
                i++;
            }
        } else {
            while (r < arrayRight.length) {
                resultArr[i] = arrayRight[r];
                r++;
                i++;
            }
        }
        return resultArr;
    }
}
