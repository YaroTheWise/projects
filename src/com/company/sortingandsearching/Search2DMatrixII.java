package com.company.sortingandsearching;

import java.util.Stack;

public class Search2DMatrixII {


    public boolean searchMatrix(int[][] matrix, int target) {

        Stack<Rectangle> stack = new Stack<>();

        stack.push(new Rectangle(0, 0, matrix.length - 1, matrix[0].length - 1));


        while (!stack.isEmpty()) {
            if (search(matrix, target, stack)) {
                return true;
            }
        }

        return false;
    }

    private boolean search(int[][] matrix, int target, Stack<Rectangle> stack) {
        Rectangle rectangle = stack.pop();

        int left = Math.min(rectangle.x, rectangle.y);
        int right = Math.max(rectangle.n, rectangle.m);
        int h;
        int v;

        int absM = rectangle.m - rectangle.x;
        int absN = rectangle.n - rectangle.y;

        while (left <= right) {
            var mid = left + (right - left) / 2;


            if (absM >= absN) {
                v = Math.min(mid, rectangle.n);
                h = mid;
            } else {
                h = Math.min(mid, rectangle.m);
                v = mid;
            }

            if (matrix[h][v] == target) {
                return true;
            }


            if (matrix[h][v] > target && (v == rectangle.y || h == rectangle.x || target > matrix[h - 1][v - 1])) {
                //top
                if (h > rectangle.x) {
                    stack.push(new Rectangle(rectangle.x, v, h - 1, rectangle.n));
                }
                //bottom
                if (v > rectangle.y) {
                    stack.push(new Rectangle(h, rectangle.y, rectangle.m, v - 1));
                }

                break;
            } else if (matrix[h][v] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return false;
    }

//    private int serchInMatrix2(int[][] matrix, int target, Rectangle rectangle) {
//        int left = m - x > n - y ? x : y; //  Math.min(x, y);
//        int right = Math.max(m - x, n - y); //Math.max(m, n);
//        int h;
//        int v;
//
//        while (left <= right) {
//            var mid = left + (right - left) / 2;
//
//            if (m - x >= n - y) {
//                v = Math.min(mid + y, n);
//                h = mid + x;
//            } else {
//                h = Math.min(mid + x, m);
//                v = mid + y;
//            }
//
//
//            if (matrix[h][v] >= target && (v == y || h == x || target > matrix[h - 1][v - 1])) {
//                return m - x >= n - y ? mid + x : mid + y;
//            } else if (matrix[h][v] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return -1;
//    }


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
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length - 1;
//        int n = matrix[0].length - 1;
//
//        int k = serchInMatrix(matrix, target);
//
//        if (k == -1) {
//            return false;
//        }
//
//        int h = 0;
//        int v = 0;
//
//        if (m >= n) {
//            if (k >= n) {
//                v = n;
//            } else {
//                v = k;
//            }
//            h = k;
//        } else {
//            if (k >= m) {
//                h = m;
//            } else {
//                h = k;
//            }
//            v = k;
//        }
//
//        return matrix[h][v] == target ||
//                serach(matrix, true, h, target, 0, v) ||
//                serach(matrix, false, v, target, 0, h);
//    }

//    private int serchInMatrix(int[][] matrix, int target) {
//        int m = matrix.length - 1;
//        int n = matrix[0].length - 1;
//
//        int left = 0;
//        int right = Math.max(m, n);
//        int h = 0;
//        int v = 0;
//
//        while (left <= right) {
//            var mid = left + (right - left) / 2;
//
//
//            if (m >= n) {
//                if (mid >= n) {
//                    v = n;
//                } else {
//                    v = mid;
//                }
//                h = mid;
//            } else {
//                if (mid >= m) {
//                    h = m;
//                } else {
//                    h = mid;
//                }
//                v = mid;
//            }
//
//
//            if (matrix[h][v] >= target && (v == 0 || h == 0 || target > matrix[mid - 1][mid - 1])) {
//                return mid;
//            } else if (matrix[h][v] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return -1;
//    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        //int m = matrix.length - 1;
        //int n = matrix[0].length - 1;

        Stack<Rectangle> stack = new Stack<>();

        Rectangle rectangle = new Rectangle(0, 0, matrix.length - 1, matrix[0].length - 1);
        stack.push(rectangle);

        while (!stack.isEmpty()) {
            var rec = stack.pop();

            int k = serchInMatrix(matrix, target, rec.x, rec.y, rec.m, rec.n);

            if (k != -1) {


                int h;
                int v;

                if (rec.m >= rec.n) {
                    v = Math.min(k, rec.n);
                    h = k;
                } else {
                    h = Math.min(k, rec.m);
                    v = k;
                }
                if (matrix[h][v] == target) {
                    return true;
                }
                //bottom
                stack.push(new Rectangle(h, rec.y, rec.m, v - 1));
                //top
                stack.push(new Rectangle(rec.x, v, h - 1, rec.n));
            }

        }

        return false;
    }

    private int serchInMatrix(int[][] matrix, int target, int x, int y, int m, int n) {
        int left = m - x > n - y ? x : y; //  Math.min(x, y);
        int right = Math.max(m - x, n - y); //Math.max(m, n);
        int h;
        int v;

        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (m - x >= n - y) {
                v = Math.min(mid + y, n);
                h = mid + x;
            } else {
                h = Math.min(mid + x, m);
                v = mid + y;
            }


            if (matrix[h][v] >= target && (v == y || h == x || target > matrix[h - 1][v - 1])) {
                return m - x >= n - y ? mid + x : mid + y;
            } else if (matrix[h][v] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


//    private boolean serach(int[][] matrix, boolean horizont, int i, int target, int left, int right) {
//        while (left <= right) {
//            var mid = left + (right - left) / 2;
//
//            int val = horizont ? matrix[i][mid] : matrix[mid][i];
//
//
//            if (val == target) {
//                return true;
//            } else if (val < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return false;
//    }
}
