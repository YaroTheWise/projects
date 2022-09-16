package com.hackerrank.oneweek;

import java.util.List;

public class MatrixRotation {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        int m = matrix.size();
        if (m == 0) {
            return;
        }

        int n = matrix.get(0).size();
        int k = m > n ? n / 2 : m / 2;

        for (int i = 0; i < m; i++) {
            for (int j=0; j <n; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }

                System.out.print(matrix.get(i).get(j));
            }

            System.out.println();
        }

        for (int i=0; i < k; i++) {
            rotation(matrix, r, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j=0; j <n; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }

                System.out.print(matrix.get(i).get(j));
            }

            System.out.println();
        }
    }

    private static void rotation(List<List<Integer>> matrix, int r, int step) {
        int m = matrix.size() - 2 * step;
        int n = matrix.get(0).size() - 2 * step;

        int k = 2 * m + 2 * n - 4;

        r = r % k;
        if (r == 0) {
            return;
        }

        Integer[] arr = new Integer[k];
        for (int i = 0; i < k; i++) {
            int index = r + i > k - 1 ? r + i - k : r + i;

            int x;
            int y;

            if (i < m) {
                x = step + i;
                y = step;
            } else if (i < m + n - 1) {
                x = matrix.size() - step - 1;
                y = step + i - m + 1;
            } else if (i < 2*m + n - 2) {
                x = matrix.size() - step - 1 + m + n - i - 2;
                y = matrix.get(0).size() - step - 1;
            } else {
                x = step;
                y = matrix.get(0).size() - step - 1 - i + 2 * m + n - 3;
            }

            arr[index] = matrix.get(x).get(y);
        }

        for (int i = 0; i < k; i++) {
            int x;
            int y;

            if (i < m) {
                x = step + i;
                y = step;
            } else if (i < m + n - 1) {
                x = matrix.size() - step - 1;
                y = step + i - m + 1;
            } else if (i < 2*m + n - 2) {
                x = matrix.size() - step - 1 + m + n - i - 2;
                y = matrix.get(0).size() - step - 1;
            } else {
                x = step;
                y = matrix.get(0).size() - step - 1 - i + 2 * m + n - 3;
            }

            List<Integer> integers = matrix.get(x);
            integers.set(y, arr[i]);
        }
    }
}
