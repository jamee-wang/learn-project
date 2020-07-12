package org.jamee.learn.algorithm.tree;

class TreeNode<V> {
    V value;
    TreeNode<V> left;
    TreeNode<V> right;
}

public class Tree {
    public static void main(String[] args) {
        TreeNode<Integer> treeRoot = initTree();
        System.out.print("rootFirstTranvel: ");
        rootFirstTranvel(treeRoot);
        System.out.println();
        System.out.print("rootMiddleTranvel: ");
        rootMiddleTranvel(treeRoot);
        System.out.println();
        System.out.print("rootLastTranvel: ");
        rootLastTranvel(treeRoot);
        System.out.println();
        System.out.print("hierarchyTranvel: ");
        hierarchyTranvel(treeRoot, 4);
    }

    private static TreeNode<Integer> initTree() {
        TreeNode<Integer> treeRoot = new TreeNode<>();
        treeRoot.value = 1;
        TreeNode<Integer> lchild = new TreeNode<>();
        lchild.value = 2;
        TreeNode<Integer> rchild = new TreeNode<>();
        rchild.value = 3;
        treeRoot.left = lchild;
        treeRoot.right = rchild;

        TreeNode<Integer> llgchild = new TreeNode<>();
        llgchild.value = 4;
        TreeNode<Integer> lrgchild = new TreeNode<>();
        lrgchild.value = 5;
        lchild.left = llgchild;
        lchild.right = lrgchild;
        TreeNode<Integer> rlgchild = new TreeNode<>();
        rlgchild.value = 6;
        TreeNode<Integer> rrgchild = new TreeNode<>();
        rrgchild.value = 7;
        rchild.left = rlgchild;
        rchild.right = rrgchild;
        return treeRoot;
    }

    private static void rootFirstTranvel(TreeNode<Integer> treeRoot) {
        System.out.print(treeRoot.value);
        if (treeRoot.left != null) {
            rootFirstTranvel(treeRoot.left);
        }
        if (treeRoot.right != null) {
            rootFirstTranvel(treeRoot.right);
        }
    }

    private static void rootMiddleTranvel(TreeNode<Integer> treeRoot) {
        if (treeRoot.left != null) {
            rootMiddleTranvel(treeRoot.left);
        }
        System.out.print(treeRoot.value);
        if (treeRoot.right != null) {
            rootMiddleTranvel(treeRoot.right);
        }
    }

    private static void rootLastTranvel(TreeNode<Integer> treeRoot) {
        if (treeRoot.left != null) {
            rootLastTranvel(treeRoot.left);
        }
        if (treeRoot.right != null) {
            rootLastTranvel(treeRoot.right);
        }
        System.out.print(treeRoot.value);
    }

    private static int hierarchyTranvel(TreeNode<Integer> treeRoot, int level) {
        if (treeRoot == null || level < 0) {
            return 0;
        }
        if (level == 0) {
            System.out.print(treeRoot.value);
            return 1;
        }
        return hierarchyTranvel(treeRoot.left, level - 1)
                + hierarchyTranvel(treeRoot.right, level - 1);
    }
}
