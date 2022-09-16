package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main2(String[] args) {
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        fourSum(arr, 0);
    }


    private static boolean check(List<Integer> nums, int i, int j, int k, int l, int target) {
        return nums.stream()
                .reduce(0, Integer::sum) == target;
    }

    private static void t(int[] nums, List<Integer> local, int position) {
        if (local.size() == 4) {

        } else {
            for (var i = local.size() + position; i < nums.length - 2 + local.size(); i++) {
                var newLocal = new ArrayList<>(local);
                newLocal.add(nums[i]);
                t(nums, newLocal, position);
            }
        }
    }


    private static boolean test(List<List<Integer>> result, List<Integer> nums, int level, int position, int target) {
        if (level == 4) {
            if (nums.stream().reduce(0, Integer::sum) == target) {
                result.add(nums);
            }
        } else {
            for (var i = 0; i < nums.size() + level - 3; i++) {
                //todo disch
                test(result, nums, level++, 123, 123);
            }
        }
        //todo disch
        return false;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<Pair> pairs = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer sum = nums[i] + nums[j];
                Set<Integer> positions = Set.of(i, j);
                List<Integer> elements = List.of(nums[i], nums[j]);
                pairs.add(new Pair(sum, positions, elements));
            }
        }

        for (int i = 0; i < pairs.size() - 1; i++) {
            for (int j = i + 1; j < pairs.size(); j++) {
                if (pairs.get(i).getSum() + pairs.get(j).getSum() == target) {
                    //Set<Integer> intersection = new HashSet<>(pairs.get(i).getPositions());
                    //if (!intersection.retainAll(pairs.get(j).getPositions())) {
                    Set<Integer> rightPositions = pairs.get(j).getPositions();
                    Set<Integer> positions = pairs.get(i).getPositions();
                    boolean anyMatch = positions.stream().anyMatch(rightPositions::contains);
                    if (!anyMatch) {
                        List<Integer> list = new ArrayList<>(pairs.get(i).getElements());
                        list.addAll(pairs.get(j).getElements());
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }

    private static class Pair {
        private final int sum;
        private final Set<Integer> positions;
        private final List<Integer> elements;

        private Pair(Integer sum, Set<Integer> positions, List<Integer> elements) {
            this.sum = sum;
            this.positions = positions;
            this.elements = elements;
        }

        public int getSum() {
            return sum;
        }

        public List<Integer> getElements() {
            return elements;
        }

        public Set<Integer> getPositions() {
            return positions;
        }
    }
}
