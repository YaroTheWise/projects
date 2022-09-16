package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AerageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack2.push(root);

        while (!stack2.isEmpty()) {
            stack = (Stack<TreeNode>) stack2.clone();
            stack2.clear();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();

                if (pop.left != null) {
                    stack2.push(pop.left);
                }

                if (pop.right != null) {
                    stack2.push(pop.right);
                }

                list.add(pop.val);
            }


            Double sum = 0.0;

            for (var i : list) {
                sum += i;
            }

            result.add(sum / list.size());
        }

        return result;
    }
}



