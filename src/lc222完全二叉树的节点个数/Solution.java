package lc222完全二叉树的节点个数;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            ans++;
            if (null != node.right) {
                stack.offer(node.right);
            }
            if (null != node.left) {
                stack.offer(node.left);
            }
        }
        return ans ;
    }
}
