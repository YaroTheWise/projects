package com.hackerrank.oneweek;

import java.util.List;

public class GenerateTree {

    public static Node generateTree(List<String> genes, List<Integer> health) {
        Node result = new Node();

        for (int i = 0; i < genes.size(); i++) {
            Node node = result;

            for (int j = 0; j < genes.get(i).length(); j++) {
                char c = genes.get(i).charAt(j);
                node.createPath(c);
                node = node.getNextNode(c);
            }

            node.addPaar(health.get(i), i);
        }
        return result;
    }
}
