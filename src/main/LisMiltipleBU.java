package main;

/* Программа для нахождения максимальной кратной подпоследовательности чисел в заданном массиве заданной длины*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LisMiltipleBU {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(bf.readLine());
        String[] arrStr = bf.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int[] arrFibCounts = new int[n];
        arrFibCounts[0] = 1;
        int maxFibMultipleBU = 1;
        for (int i = 1; i < n; i++) {
            int maxFib = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int maxI = arrFibCounts[j] + 1;
                    maxFib = Math.max(maxI, maxFib);
                }
            }
            arrFibCounts[i] = maxFib;
            maxFibMultipleBU = Math.max(maxFibMultipleBU, maxFib);
        }
        bf.close();
        System.out.println(maxFibMultipleBU);
    }
}
