package com.company.design;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;

public class SerializeDeserializeBinaryTree {
    private StringBuilder sb;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {


        StringJoiner joiner = new StringJoiner(",", "[","]");
        joiner.add("saf");
//        joiner.

        sb = new StringBuilder();
        //sb.append("[");

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
            }

            queue.add(node.left);
            queue.add(node.right);
        }


//        while(sb[sb.length() - 1] == "null") {
//            sb.setLength(sb.length() - 1);
//        }

        //sb.append("]");

        return sb.toString();
    }


//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }
}

