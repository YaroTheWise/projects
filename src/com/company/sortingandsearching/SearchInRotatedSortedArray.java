package com.company.sortingandsearching;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int peak = getPeak(nums);

        if (nums[0] <= target && target <= nums[peak]) {
            return recursionImpl(nums, target, 0, peak);
        } else {
            return recursionImpl(nums, target, peak + 1, nums.length - 1);
        }
    }

    private int getPeak(int[] values) {
        var left = 0;
        var right = values.length - 1;

        while (true) {

            var mid = left + (right - left) / 2;

            if (mid < values.length && values[mid] > values[mid + 1]) {
                return mid;
            }

            if (right == left || values[right] > values[left]) {
                return right;
            }

            if (values[left] > values[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
    }

    private int recursionImpl(int[] nums, int target, int left, int right) {
        var mid = left + (right - left) / 2;

        if (right < left) {
            return -1;
        }

        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return recursionImpl(nums, target, left, mid - 1);
        } else {
            return recursionImpl(nums, target, mid + 1, right);
        }
    }
}
