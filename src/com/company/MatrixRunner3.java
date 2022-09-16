package com.company;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class MatrixRunner3 {

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
            for (var stepX = -2; stepX < 3; stepX++) {
                if (stepX == 0) {
                    continue;
                }
                for (var stepY = -2; stepY < 3; stepY++) {
                    if (stepY == 0 || Math.abs(stepX) == Math.abs(stepY)) {
                        continue;
                    }

                    Point newPoint = new Point(point.getX() + stepX, point.getY() + stepY);
                    if (check(matrix, newPoint)) {
                        matrix[newPoint.getX()][newPoint.getY()] = matrix[point.getX()][point.getY()] + 1;
                        queue.add(newPoint);
                    }
                }
            }
        }


        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (matrix[i][j] == START_VALUE) {
                    throw new IllegalArgumentException(String.format("There are unreachable cells. For example x:%d " +
                                    "y%d",
                            i, j));
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
