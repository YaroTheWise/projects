package com.company.maxCount1InString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, ArrayList<String>>();

        for (var str : strs) {
            var key = getKey(str);
            ArrayList<String> strings = map.containsKey(key)
                    ? map.get(key)
                    : new ArrayList<>();

            strings.add(str);
            map.put(key, strings);
        }

        return new ArrayList<>(map.values());

    }

    private static String getKey(String first) {
        var map = new HashMap<Character, Integer>();

        for (var i = 0; i < first.length(); i++) {
            var key = first.charAt(i);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map.keySet().stream()
                .sorted()
                .map(x -> x.toString() + map.get(x))
                .collect(Collectors.joining());
    }
}
