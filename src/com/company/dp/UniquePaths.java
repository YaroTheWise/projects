package com.company.dp;

import java.util.ArrayDeque;
import java.util.Queue;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            //down
            if (pair[0] + 1 < m) {
                if (matrix[pair[0] + 1][pair[1]] == 0) {
                    queue.add(new int[]{pair[0] + 1, pair[1]});
                }
                matrix[pair[0] + 1][pair[1]] += matrix[pair[0]][pair[1]];
            }
            //left
            if (pair[1] + 1 < n) {
                if (matrix[pair[0]][pair[1] + 1] == 0) {
                    queue.add(new int[]{pair[0], pair[1] + 1});
                }
                matrix[pair[0]][pair[1] + 1] += matrix[pair[0]][pair[1]];
            }
        }

        return matrix[m - 1][n - 1];
    }
}
