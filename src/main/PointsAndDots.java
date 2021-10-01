package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PointsAndDots {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> countDotsPoints = new HashSet<>();
        int[] startPoint = new int[n];
        int[] endPoint = new int[n];
        for (int i = 0; i < n; i++) {
            startPoint[i] = sc.nextInt();
            endPoint[i] = sc.nextInt();
            countDotsPoints.add(startPoint[i]);
            countDotsPoints.add(endPoint[i]);
        }
        Arrays.sort(startPoint);
        Arrays.sort(endPoint);
        int[] points = new int[m];
        for (int i = 0; i < m; i++) {
            points[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < m; i++) {
            int point = points[i];
            int l = 0;
            int r = n - 1;
            int countStartLessOrEquelsPoint;
            if (point < startPoint[l]) {
                countStartLessOrEquelsPoint = 0;
            } else {
                if (point >= startPoint[n - 1]) {
                    countStartLessOrEquelsPoint = n;
                } else {
                    while (true) {
                        if (l == r) {
                            countStartLessOrEquelsPoint = l + 1;
                            break;
                        }
                        if (r - l == 1) {
                            if (startPoint[r] <= point) {
                                countStartLessOrEquelsPoint = r + 1;
                            } else {
                                countStartLessOrEquelsPoint = l + 1;
                            }
                            break;
                        }
                        int index = (l + (r - l) / 2);
                        if (startPoint[index] <= point) {
                            l = index;
                        } else {
                            r = index;
                        }
                    }
                }
            }
            l = 0;
            r = n - 1;
            int countEndPointLessPoint;
            if (countStartLessOrEquelsPoint == 0 || point <= endPoint[l]) {
                countEndPointLessPoint = 0;
            } else {
                if (point > endPoint[r]) {
                    countEndPointLessPoint = n;
                } else {
                    while (true) {
                        if (l == r) {
                            countEndPointLessPoint = l + 1;
                            break;
                        }
                        if (r - l == 1) {
                            if (endPoint[r] < point) {
                                countEndPointLessPoint = r + 1;
                            } else {
                                countEndPointLessPoint = l + 1;
                            }
                            break;
                        }
                        int index = (l + (r - l) / 2);
                        if (endPoint[index] < point) {
                            l = index;
                        } else {
                            r = index;
                        }
                    }
                }
            }
            System.out.print(countStartLessOrEquelsPoint - countEndPointLessPoint + " ");
        }
    }
}
