package com.company;

import java.util.Arrays;

public class NumberOfWeakCharacters {

    public int numberOfWeakCharacters(int[][] properties) {
        int result = 0;
        Arrays.sort(properties, (o1, o2) -> {
            int result2 = o2[0] - o1[0];

            if (result2 == 0) {
                result2 = o2[1] - o1[1];
            }

            return result2;
        });

        int upLeft = properties[0][0];
        int upRight = properties[0][1];
        int downLeft = properties[0][0];
        int downRight = properties[0][1];

        for(int i = 1; i < properties.length; i++) {
            if (properties[i][0] == downLeft) {
                if (properties[i][0] < upLeft && properties[i][1] < upRight) {
                    result++;
                }
                continue;
            }

            upLeft = downLeft;
            downLeft = properties[i][0];
            upRight = downRight;

            if (properties[i][1] > downRight) {
                downRight = properties[i][1] ;
            } else if (properties[i][1] < downRight) {
                result++;
            }
        }
        return result;
    }
}
