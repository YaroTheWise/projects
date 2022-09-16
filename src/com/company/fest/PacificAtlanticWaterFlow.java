package com.company.fest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PacificAtlanticWaterFlow {
    private int[][] steps = new int[][]{
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;


        List<List<Integer>> result = new ArrayList<>();

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (check(heights, i, j)) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }


    private boolean check(int[][] heights, int i, int j) {
        boolean p = false;
        boolean a = false;
        int m = heights.length - 1;
        int n = heights[0].length - 1;

        int[][] ints = new int[m + 1][n + 1];

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{i, j});
        ints[i][j] = 1;

        while (!stack.isEmpty() && !(p && a)) {
            int[] cell = stack.pop();

            if (cell[0] == 0 || cell[1] == 0) {
                p = true;
            }

            if (cell[0] == m || cell[1] == n) {
                a = true;
            }

            for (var step : steps) {

                var x = cell[0] + step[0];
                var y = cell[1] + step[1];

                if (x < 0 || x > m || y < 0 || y > n) {
                    continue;
                }

                if (heights[cell[0]][cell[1]] >= heights[x][y] && ints[x][y] == 0) {
                    stack.push(new int[]{x, y});
                    ints[x][y] = 1;
                }
            }
        }

        return p && a;
    }
}
