package basic.easy;

public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        return depth(0, root);
    }

    private int depth(int level, TreeNode node) {
        if (node == null) {
            return level;
        }
        int left = depth(level, node.left);
        int right = depth(level, node.right);
        return Math.max(left, right) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
