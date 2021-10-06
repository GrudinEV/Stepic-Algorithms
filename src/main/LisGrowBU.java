package main;

/* Программа находит длину максимальной невозрастающей последовательности за O(nlogn) в заданном массиве интов заданной длины n. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LisGrowBU {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        run();
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - start);
    }

    private static void run() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(bf.readLine());
        String[] arrStr = bf.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        bf.close();
        getLenFibFast(n, arr);
    }

    private static void getLenFibFast(int n, int[] arr) {
        int[] arrL = new int[n];
        int[] arrFibCounts = new int[n];
        for (int i = 0; i < n; i++) {
            arrL[i] = -1;
        }
        int maxLis = 1;
        for (int i = 0; i < n; i++) {
            int l = -1;
            int r = n;
            int m;
            int el = arr[i];
            while (r > l + 1) {
                m = r + l >> 1;
                if (arrL[m] >= el) {
                    l = m;
                } else {
                    r = m;
                }
            }
            arrL[r] = el;
            arrFibCounts[i] = r + 1;
            maxLis = Math.max(maxLis, r + 1);
        }
        System.out.println(maxLis);
        StringBuilder sb = new StringBuilder();
        int[] fib = new int[maxLis];
        for (int i = n - 1; i >= 0; i--) {
            if (arrFibCounts[i] == maxLis) {
                fib[--maxLis] = i;
            }
            if (maxLis == 0) {
                break;
            }
        }
        for (int i = 0; i < fib.length; i++) {
            sb.append(fib[i] + 1);
            sb.append(" ");
        }
        System.out.println(sb);

    }

    static class Element {
        private int value;
        private int fib;

        public Element(int index, int fib) {
            this.value = index;
            this.fib = fib;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "index=" + value +
                    ", fib=" + fib +
                    '}';
        }
    }
}
