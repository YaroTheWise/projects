package com.company.sortingandsearching;

public class GetPeak {

    public int get(int[] values) {
        var left = 0;
        var right = values.length - 1;

        while (true) {
            if (right == left || values[right] > values[left]) {
                return right;
            }

            var mid = left + (right - left) / 2;

            if (values[left] > values[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
    }

//    private boolean check(int[] values, int link) {
//        if (link == values.length - 1) {
//            return values[link] > values[0];
//        } else {
//            return values[link - 1] < values[link];
//        }
//    }


}
