package com.company.backtracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombinationsPhoneNum {

    private Map<Character, String[]> map = new HashMap<>() {{
        put('2', new String[]{"a", "b", "c"});
        put('3', new String[]{"d", "e", "f"});
        put('4', new String[]{"g", "h", "i"});
        put('5', new String[]{"j", "k", "l"});
        put('6', new String[]{"m", "n", "o"});
        put('7', new String[]{"p", "q", "r", "s"});
        put('8', new String[]{"t", "u", "v"});
        put('9', new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }

        return combine(List.of(map.get(digits.charAt(0))), digits, 1);
    }


    private List<String> combine(List<String> list, String digits, int step) {

        if (step == digits.length()) {
            return list;
        }
        ArrayList<List<String>> lists = new ArrayList<>();

        ArrayList<Integer> ints = new ArrayList<>();
        ints.stream().reduce(0, Integer::sum);

        String[] strings = map.get(digits.charAt(step));

        for (var str : strings) {
            List<String> newList = new ArrayList<>();
            for (var l : list) {
                newList.add(l + str);
            }

            lists.add(combine(newList, digits, step + 1));
        }

        return lists.stream()
                .flatMap(x->x.stream())
                .collect(Collectors.toList());
    }
}
