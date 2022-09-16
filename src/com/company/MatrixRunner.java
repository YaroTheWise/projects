package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MatrixRunner {

    private static final int START_VALUE = -1;

    public static int[][] start(int m, int n, Collection<Point> startPoints) {
        int[][] matrix = new int[m][n];
        //initialization matrix by start value, because startPoint has 0
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                matrix[i][j] = START_VALUE;
            }
        }
        //initialization startPoint
        for (Point point : startPoints) {
            matrix[point.getX()][point.getY()] = 0;
        }
        // m * n - size of matrix; m * n - startPoints.size() - count don't filled cells
        return step(matrix, startPoints, 1, m * n - startPoints.size());
    }

    /**
     *
     * @param matrix
     * @param points Cells has been filled on the previous step
     * @param level Number of step - like a wave
     * @param count Count don't filled cells
     * @return
     */
    private static int[][] step(int[][] matrix, Collection<Point> points, int level, int count) {
        // matrix has been filled
        if (count == 0) {
            return matrix;
        }

        List<Point> newPoints = new ArrayList<>();

        for (Point point : points) {
            // step by left, right, top, bottom
            for (var i = -1; i < 3; i++) {
                int stepX = i % 2 != 0 ? i : 0;
                int stepY = i % 2 == 0 ? i - 1 : 0;

                Point newPoint = new Point(point.getX() + stepX, point.getY() + stepY);
                if (check(matrix, newPoint)) {
                    matrix[newPoint.getX()][newPoint.getY()] = level;
                    newPoints.add(newPoint);
                }
            }
        }

        return step(matrix, newPoints, level + 1, count - newPoints.size());
    }

    private static boolean check(int[][] matrix, Point point) {
        return point.getX() >= 0 && point.getX() < matrix.length &&
                point.getY() >= 0 && point.getY() < matrix[0].length &&
                matrix[point.getX()][point.getY()] == START_VALUE;
    }
}
