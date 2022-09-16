package com.company.sortingandsearching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        LinkedList<int[]> list = new LinkedList<>();

        for (var interval : intervals) {

            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }

        }


        return list.toArray(new int[list.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        boolean hasMerge;

        do {
            hasMerge = pair(intervals, 0);
        } while (hasMerge);

        List<int[]> collect = Arrays.stream(intervals)
                .filter(Objects::nonNull).collect(Collectors.toList());
        int[][] result = new int[collect.size()][];

        var i = 0;
        for (var c : collect) {
            result[i] = c;
            i++;
        }

        return result;
    }


    public int[][] mergeElements(int[] left, int[] right) {

        if (left[1] < right[0] || left[0] > right[1]) {
            return new int[][]{left, right};
        }

        return new int[][]{new int[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])}};
    }

    public boolean pair(int[][] intervals, int element) {
        boolean localFlag = false;
        boolean internalFlag = false;

        if (intervals[element] != null) {
            for (var i = element + 1; i < intervals.length; i++) {
                if (intervals[i] != null) {
                    int[][] result = mergeElements(intervals[element], intervals[i]);
                    if (result.length == 1) {
                        intervals[element] = result[0];
                        intervals[i] = null;
                        localFlag = true;
                    }
                }
            }
        }
        if (element < intervals.length - 1) {
            internalFlag = pair(intervals, element + 1);
        }

        return localFlag || internalFlag;
    }
}
