package com.company;

import java.util.ArrayList;

public class Main2 {
    public static void main2(String[] args) {

        for (var i = -4; i < 4; i++) {
            var x = i % 2 == 0 ? i < 0 ? -2 : 2 : i >= 0 ? -1 : 1;
            var y = i % 2 != 0 ? i < 0 ? -2 : 2 : i >= 0 ? -1 : 1;

            System.out.printf("%d %d%n", x, y);
        }


        int m = 5;
        int n = 5;

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0, 0));
//        points.add(new Point(0, 0));
//        points.add(new Point(8, 8));
//        points.add(new Point(3, 6));

        int[][] result = MatrixRunner3.start(m, n, points);

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
