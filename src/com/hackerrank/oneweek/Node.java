package com.hackerrank.oneweek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private List<Paar> paars = new ArrayList<>();
    private Map<Character, Node> node;

    public Node() {
        this.node = new HashMap<>();
    }

    public void addPaar(int val, int position) {
        long result = paars.isEmpty() ? val : paars.get(paars.size() - 1).val + val;
        paars.add(new Paar(result, position));
    }

    public long getSum(int first, int last) {
        if (paars.isEmpty() ||
                first > paars.get(paars.size() - 1).position ||
                last < paars.get(0).position) {
            return 0;
        }
        int start = -1;
        int finish = paars.size() - 1;
        for (int i = 0; i < paars.size(); i++) {
            if (first <= paars.get(i).position) {
                start = i - 1;
                break;
            }
        }

        for (int i = paars.size() - 1; i >= 0; i--) {
            if (last >= paars.get(i).position) {
                finish = i;
                break;
            }
        }

        return start == -1 ? paars.get(finish).val : paars.get(finish).val - paars.get(start).val;
    }

    public void createPath(char c) {
        if (!node.containsKey(c)) {
            node.put(c, new Node());
        }
    }

    public Node getNextNode(char c) {
        return node.getOrDefault(c, null);
    }

    class Paar {
        private final long val;
        private final int position;

        public Paar(long val, int position) {
            this.val = val;
            this.position = position;
        }

        public long getVal() {
            return val;
        }

        public int getPosition() {
            return position;
        }
    }
}

//public class Node {
//    private List<Paar> paars = new ArrayList<>();
//    private Map<Character, Node> node;
//
//    public Node() {
//        this.node = new HashMap<Character, Node>();
//    }
//
//    public void addPaar(int val, int position) {
//        if (val > 0) {
//            paars.add(new Paar(val, position));
//        }
//    }
//
//    public long getSum(int first, int last) {
//        long result = 0;
////
//        if (paars.size() == 0 ||
//                first > paars.get(paars.size() - 1).position ||
//                last < paars.get(0).position) {
//            return result;
//        }
//
////        int start = first <= paars.get(0).position ? 0 : getBorder(first, 0, paars.size() - 1, true);
////        int finish = last >= paars.get(paars.size() - 1).position ? paars.size() - 1 : getBorder(last, 0,
////                paars.size() - 1,
////                false
////        );
////
////        for (int i = start; i <= finish; i++) {
////            if (paars.get(i).getPosition() <= last) {
////                result += paars.get(i).getVal();
////            } else {
////                break;
////            }
////           // result += paars.get(i).getVal();
////        }
//
//
////        return paars.stream()//.parallelStream()
////                .filter(x -> x.position >= first && x.position <= last)
////                .map(x -> x.val)
////                .reduce(0L, Long::sum);
//
//        for (Paar paar : paars) {
//            if (paar.getPosition() >= first) {
//                if (paar.getPosition() <= last) {
//                    result += paar.getVal();
//                } else {
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }
//
////    private int getBorder(int value, int left, int right, boolean first) {
////
////        while (left < right) {
////            int mid = left + (right - left) / 2;
////
////            if (mid == 0 || mid == paars.size() - 1) {
////                return mid;
////            }
////
////
////            int val = paars.get(mid).getPosition();
////            int nextVal = first ? paars.get(mid - 1).getPosition() : paars.get(mid + 1).getPosition();
////
////            if ((first && value > nextVal && value <= val) ||
////                    (!first && value < nextVal && value >= val)) {
////                return mid;
////            } else if (value < val) {
////                right = mid;
////            } else {
////                left = mid + 1;
////            }
////        }
////
////        return left;
////    }
//
//    public void createPath(char c) {
//        if (!node.containsKey(c)) {
//            node.put(c, new Node());
//        }
//    }
//
//    public Node getNextNode(char c) {
//        return node.getOrDefault(c, null);
//    }
//
//    class Paar {
//        private final long val;
//        private final int position;
//
//        public Paar(long val, int position) {
//            this.val = val;
//            this.position = position;
//        }
//
//        public long getVal() {
//            return val;
//        }
//
//        public int getPosition() {
//            return position;
//        }
//    }
//}
