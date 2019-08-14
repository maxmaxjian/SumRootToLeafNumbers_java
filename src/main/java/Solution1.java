import javafx.util.Pair;

import java.util.Stack;

public class Solution1 implements Solution {
    @Override
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));
        int result = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode,Integer> curr = stack.pop();
            if (curr.getKey() != null) {
                int currSum = curr.getValue()*10 + curr.getKey().val;
                if (curr.getKey().left == null && curr.getKey().right == null) {
                    result += curr.getValue();
                } else {
                    if (curr.getKey().left != null) {
                        stack.push(new Pair<>(curr.getKey().left, currSum+curr.getKey().left.val));
                    }
                    if (curr.getKey().right != null) {
                        stack.push(new Pair<>(curr.getKey().right, currSum+curr.getKey().right.val));
                    }
                }
            }
        }

        return result;
    }
}
