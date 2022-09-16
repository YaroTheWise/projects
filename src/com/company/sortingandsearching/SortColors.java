package com.company.sortingandsearching;

public class SortColors {
    public static void sortColors(int[] nums) {
        int zero = -1;
        //int one = 0;
        int two = nums.length;
        int curr = 0;


        for (var i = 0; i < two; i++) {
            if (nums[i] == 0) {
                if (zero + 1 != i) {
                    curr = nums[zero+1];
                    nums[zero+1] = nums[i];
                    nums[i] = curr;
                    i = i - 1;
                }
                zero++;
            } else if (nums[i] == 1) {
//                if (one == 0) {
//                    one = zero + 1;
//                }
//
//                if (one != i) {
//                    curr = nums[one+1];
//                    nums[one+1] = nums[i];
//                    nums[i] = curr;
//                    i = i - 1;
//                }
//                one++;
            } else if (nums[i] == 2) {
                curr = nums[two - 1];
                nums[two - 1] = nums[i];
                nums[i] = curr;
                two--;
                i--;
            }
        }
    }
}
