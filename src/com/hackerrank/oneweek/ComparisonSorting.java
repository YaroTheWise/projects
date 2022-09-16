package com.hackerrank.oneweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ComparisonSorting {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        Optional<Integer> max = arr.stream().max((a, b) -> a - b);
        if (max.isEmpty()) {
            return new ArrayList<>();
        }

        int[] ints = new int[max.get() + 1];
        for (Integer integer : arr) {
            ints[integer]++;
        }

        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

}
