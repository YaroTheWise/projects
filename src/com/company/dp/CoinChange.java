package com.company.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] counts = new int[coins.length];

        counts[counts.length - 1] = amount / coins[coins.length - 1];
        ;

        return check(coins, counts, amount % coins[coins.length - 1]) ? Arrays.stream(counts).sum() : -1;
        ///[ 9, 3, 2, 1, 6] -> [ 0, 0, 0, 0, 10]
    }

    private boolean check(int[] coins, int[] counts, int value) {
        if (value == 0) {
            return true;
        }



        return false;
    }


    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);

        return change(coins, amount, coins.length - 1, 0);
    }

    private int change(int[] coins, int amount, int level, int count) {
        for (var i = level; i >= 0; i--) {
            var newAmount = amount % coins[i];
            var newCount = count + amount / coins[i];

            if (newAmount == 0) {
                return newCount;
            }

            var value = change(coins, newAmount, i - 1, newCount);
            if (value != -1) {
                return value;
            }

        }

        return -1;
    }
}
