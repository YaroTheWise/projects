package com.company.fest;

import java.util.Stack;

public class AF {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();


        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder(stack.toString());
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        sb.reverse();
        return sb.toString();
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        for (var i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        int m = 0, p = 0, g = 0;
        int result = 0;

        for (var i = 0; i < garbage.length; i++) {
            for (var c : garbage[i].toCharArray()) {

                switch (c) {
                    case 'M':
                        m = i;
                        break;
                    case 'P':
                        p = i;
                        break;
                    case 'G':
                        g = i;
                        break;
                }
            }

            result += garbage[i].length();
        }

        if (m != 0) {
            result += travel[m - 1];
        }
        if (p != 0) {
            result += travel[g - 1];
        }
        if (g != 0) {
            result += travel[g - 1];
        }


        return result;
    }
}
