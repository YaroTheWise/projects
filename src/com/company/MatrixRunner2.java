package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

public class MatrixRunner2 {

    private static final int START_VALUE = -1;

    public static int[][] start(int m, int n, Collection<Point> startPoints) {
        int[][] matrix = new int[m][n];

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                matrix[i][j] = START_VALUE;
            }
        }

        Queue<Point> queue = new ArrayDeque<>();

        for (Point point : startPoints) {
            matrix[point.getX()][point.getY()] = 0;
            queue.add(point);
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (var i = -1; i < 3; i++) {
                int stepX = i % 2 != 0 ? i : 0;
                int stepY = i % 2 == 0 ? i - 1 : 0;

                Point newPoint = new Point(point.getX() + stepX, point.getY() + stepY);
                if (check(matrix, newPoint)) {
                    matrix[newPoint.getX()][newPoint.getY()] = matrix[point.getX()][point.getY()] + 1;
                    queue.add(newPoint);
                }
            }
        }

        return matrix;
    }

    private static boolean check(int[][] matrix, Point point) {
        return point.getX() >= 0 && point.getX() < matrix.length &&
                point.getY() >= 0 && point.getY() < matrix[0].length &&
                matrix[point.getX()][point.getY()] == START_VALUE;
    }
}
