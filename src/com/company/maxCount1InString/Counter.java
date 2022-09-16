package com.company.maxCount1InString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import com.company.Point;

public class Counter {


    public static int start(String str, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int result = 0;
        int currentLength = 0;

        for (var i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                queue.add(i);

                if (queue.size() <= k) {
                    currentLength++;
                } else {
                    if (result < currentLength) {
                        result = currentLength;
                    }

                    currentLength = i - queue.poll();
                }
            } else {
                currentLength++;
            }
        }

        return Math.max(result, currentLength);
    }

}
