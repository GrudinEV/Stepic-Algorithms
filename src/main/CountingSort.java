package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }
        sc.close();
        int[] arrB = new int[10];
        for (int i = 0; i < n; i++) {
            arrB[arrN[i] - 1]++;
        }
        for (int i = 1; i < arrB.length; i++) {
            arrB[i] += arrB[i - 1];
        }
        int[] newArrN = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            newArrN[--arrB[arrN[i] - 1]] = arrN[i];
        }
        Arrays.stream(newArrN).forEach(x -> System.out.print(x + " "));
    }
}
