package com.company.sortingandsearching;

import java.util.Random;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {

        sort(nums, 0, nums.length - 1, nums.length - k);

        return nums[k-1];
    }

    private void sort(int[] nums, int left, int right, int k) {

        if (left == right) return;

        Random random = new Random();
        int pivot = left + random.nextInt(right - left);

        pivot = partition(nums, left, right, pivot);

        if (pivot == k) {
            return;
        } else if (pivot < k) {
            sort(nums, pivot + 1, right, k);
        } else {
            sort(nums, left, pivot - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right, int pivot) {
        int pivotFrequency = nums[pivot];
        int link = left;
        swap(nums, right, pivot);

        for (var i = left; i <= right; i++) {
            if (nums[i] < pivotFrequency) {
                swap(nums, link, i);
                link++;
            }
        }

        swap(nums, link, right);

        return link;
    }


    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
