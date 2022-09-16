package com.company.sortingandsearching;

public class BinarySearch {


    public int searchNew(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                result = mid;
                break;
            }
        }
        return result;
    }

    public int searchNewRecursion(int[] nums, int target) {
        return recursionImpl(nums, target, 0, nums.length - 1);
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

    public int search(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        int link = nums.length / 2;

        while (true) {

            if ((link == 0 && nums[link] > nums[link + 1]) ||
                    (link == nums.length - 1 && nums[link] > nums[link - 1]) ||
                    (nums[link] > nums[link - 1] && nums[link] > nums[link + 1])) {
                return link;
            } else {
                if (right - left == 1) {
                    return nums[left] > nums[right] ? left : right;
                } else if (link < nums.length - 1 && nums[link] < nums[link + 1]) {
                    left = link;
                    link = link + (right - link) / 2;

                } else {
                    right = link;
                    link = link - (link - left) / 2;
                }
            }
        }
    }


}
