package lc103二叉树的锯齿形层序遍历;

import common.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (Objects.isNull(root)) return ans;

        Deque<TreeNode> layer = new ArrayDeque<>();
        layer.offer(root);

        boolean flag = true;
        while (!layer.isEmpty()) {
            Deque<TreeNode> nextLayer = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!layer.isEmpty()) {
                TreeNode treeNode = layer.removeFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    nextLayer.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLayer.offer(treeNode.right);
                }
            }
            if (flag) {
                flag = false;
            } else {
                Collections.reverse(list);
                flag = true;
            }
            ans.add(list);
            layer = nextLayer;
        }

        return ans;
    }
}
