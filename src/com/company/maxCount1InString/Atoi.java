package com.company.maxCount1InString;

public class Atoi {
    public static int get(String str) {
        long result = 0;
        boolean isNegative = false;
        boolean hasSign = false;

        for (var i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case ' ':
                    if (hasSign){
                        return (int) result;
                    }
                    break;
                case '-':
                    if (hasSign) {
                        return 0;
                    }
                    hasSign = true;
                    isNegative = true;
                    break;
                case '+':
                    if (hasSign) {
                        return 0;
                    }
                    hasSign = true;
                    break;
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    hasSign = true;
                    int a = Character.getNumericValue(str.charAt(i));
                    if (result == 0) {
                        result = isNegative ? -1 * a : a;
                    } else if (result > 0) {
                        long t = result * 10 + a;
                        result = t > Integer.MAX_VALUE ? Integer.MAX_VALUE : t;
                    } else {
                        long t = result * 10 - a;
                        result = t < Integer.MIN_VALUE ? Integer.MIN_VALUE : t;
                    }
                    break;
                case '.':
                    return (int)result;
                default:
                    return 0;
            }
        }

        return (int) result;
    }
}


//    Map<Character, Integer> map = new HashMap<>();
//        map.put('0', 0);
//                map.put('1', 1);
//                map.put('2', 2);
//                map.put('3', 3);
//                map.put('4', 4);
//                map.put('5', 5);
//                map.put('6', 6);
//                map.put('7', 7);
//                map.put('8', 8);
//                map.put('9', 9);
