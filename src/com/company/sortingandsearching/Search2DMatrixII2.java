package com.company.sortingandsearching;

import java.util.Stack;

public class Search2DMatrixII2 {
    public boolean searchMatrix(int[][] matrix, int target) {

        Stack<Rectangle> stack = new Stack<Rectangle>();

        stack.push(new Rectangle(0, 0, matrix.length - 1, matrix[0].length - 1));

        while (!stack.isEmpty()) {

            Rectangle rectangle = stack.pop();

            if (matrix[rectangle.x][rectangle.y] > target ||
                    matrix[rectangle.m][rectangle.n] < target) {
                continue;
            }

            int midX = rectangle.x + (rectangle.m - rectangle.x) / 2;
            int midY = rectangle.y + (rectangle.n - rectangle.y) / 2;

            if (matrix[midX][midY] == target) {
                return true;
            } else if (matrix[midX][midY] > target) {
                if (midX > rectangle.x) {
                    stack.push(new Rectangle(rectangle.x, rectangle.y, midX - 1, rectangle.n));
                }

                if (midY > rectangle.y) {
                    stack.push(new Rectangle(midX, rectangle.y, rectangle.m, midY - 1));
                }
            } else {
                //matrix to right top
                if (midY < rectangle.n) {
                    stack.push(new Rectangle(rectangle.x, midY + 1, midX, rectangle.n));
                }
                //matrix to bottom
                if (midX < rectangle.m) {
                    stack.push(new Rectangle(midX + 1, rectangle.y, rectangle.m, rectangle.n));
                }
            }
        }

        return false;
    }

    private static class Rectangle {
        private final int x;
        private final int y;
        private final int m;
        private final int n;

        public Rectangle(int x, int y, int m, int n) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.n = n;
        }
    }
}
