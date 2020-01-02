package binarytree;

import java.util.List;

/**
 * Created on 2019/3/6<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class BinaryTreeNode {
    private int element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(int element) {
        this.element = element;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(int element, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public static BinaryTreeNode init() {
        BinaryTreeNode J = new BinaryTreeNode(8, null, null);
        BinaryTreeNode H = new BinaryTreeNode(4, null, null);
        BinaryTreeNode G = new BinaryTreeNode(2, null, null);
        BinaryTreeNode F = new BinaryTreeNode(7, null, J);
        BinaryTreeNode E = new BinaryTreeNode(5, H, null);
        BinaryTreeNode D = new BinaryTreeNode(1, null, G);
        BinaryTreeNode C = new BinaryTreeNode(9, F, null);
        BinaryTreeNode B = new BinaryTreeNode(3, D, E);
        BinaryTreeNode A = new BinaryTreeNode(6, B, C);
        return A;
    }


    public static void preOrder(BinaryTreeNode root) {
        if (null == root) return;
        System.out.print(root.element + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public static void midOrder(BinaryTreeNode root) {
        if (null == root) return;

        midOrder(root.leftChild);
        System.out.print(root.element + " ");
        midOrder(root.rightChild);
    }

    public static void afterOrder(BinaryTreeNode root) {
        if (null == root) return;

        afterOrder(root.leftChild);
        afterOrder(root.rightChild);
        System.out.print(root.element + " ");
    }

    public static void layerOrder(BinaryTreeNode root) {
        if (null == root) return;
        int depth = BinaryTreeNode.depth(root);

        for (int i = 1; i <= depth; ++i) {
            BinaryTreeNode.levelOrder(root, i);
        }
    }

    private static void levelOrder(BinaryTreeNode root, int level) {
        if (root == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(root.element + " ");
            return;
        }

        // 左子树
        levelOrder(root.leftChild, level - 1);

        // 右子树
        levelOrder(root.rightChild, level - 1);
    }

    public static int depth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = depth(root.leftChild);
        int r = depth(root.rightChild);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeNode.init();
        System.out.println("前序");
        BinaryTreeNode.preOrder(root);
        System.out.println();
        System.out.println("中序");
        BinaryTreeNode.midOrder(root);
        System.out.println();
        System.out.println("后序");
        BinaryTreeNode.afterOrder(root);
        System.out.println();
        System.out.println("层序");
        BinaryTreeNode.layerOrder(root);
    }
}
