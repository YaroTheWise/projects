package com.hackerrank.oneweek;

import java.util.List;

public class DnaHealth {

    public static void run(Node node, List<Model> models) {
        long minValue = Long.MAX_VALUE;
        long maxValue = Long.MIN_VALUE;

        for(Model model : models) {
            long localSum = 0;

            for(int i = 0; i < model.getD().length(); i++) {
                Node current = node;
                int j = i;

                while ( j < model.getD().length() &&
                        current.getNextNode(model.getD().charAt(j)) != null) {

                    current = current.getNextNode(model.getD().charAt(j));
                    localSum += current.getSum(model.getFirst(), model.getLast());
                    j++;
                }

            }

            minValue = Math.min(localSum, minValue);
            maxValue = Math.max(localSum, maxValue);

        }

        System.out.printf("%d %d", minValue, maxValue);
    }
}
//12317773616 12317773616
//40124729287 61265329670