package com.company.sortingandsearching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TopKFrequentElements {

    private int[] unique;
    private Map<Integer, Integer> map;

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();

        for (var i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        unique = new int[map.size()];
        var i = 0;
        for (var key : map.keySet()) {
            unique[i] = key;
            i++;
        }

        sort(0, unique.length - 1, unique.length - k);

        return Arrays.copyOfRange(unique, unique.length - k, unique.length);
    }

    private void sort(int left, int right, int k) {

        if (left == right) return;

        Random random = new Random();
        int pivot = left + random.nextInt(right - left);

        pivot = partition(left, right, pivot);

        if (pivot == k) {
            return;
        } else if (pivot < k) {
            sort(pivot + 1, right, k);
        } else {
            sort(left, pivot - 1, k);
        }
    }

    private int partition(int left, int right, int pivot) {
        int pivotFrequency = map.get(unique[pivot]);
        int link = left;
        swap(right, pivot);

        for (var i = left; i <= right; i++) {
            if (map.get(unique[i]) < pivotFrequency) {
                swap(link, i);
                link++;
            }
        }

        swap(link, right);

        return link;
    }


    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }
}
