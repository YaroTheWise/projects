package com.company;

public class IntToRoman {
    public static String intToRoman(int num) {

        StringBuilder result = new StringBuilder();

        result.append("M".repeat(Math.max(0, num / 1000)));

        num = num % 1000;

        result.append(getValue(num, 100, "M","D","C"));

        num = num % 100;

        result.append(getValue(num, 10, "C","L","X"));

        num = num % 10;

        result.append(getValue(num, 1, "X","V","I"));

        return result.toString();
    }


    private static String getValue(int num, int del, String ten, String five, String one){
        var c = num/del;

        StringBuilder result = new StringBuilder();

        if (c == 9) {
            result.append(one);
            result.append(ten);
        } else if (c >= 5) {
            result.append(five);
            result.append(String.valueOf(one).repeat(c - 5));
        } else if (c == 4) {
            result.append(one);
            result.append(five);
        } else {
            result.append(String.valueOf(one).repeat(Math.max(0, c)));
        }

        return result.toString();
    }
}
