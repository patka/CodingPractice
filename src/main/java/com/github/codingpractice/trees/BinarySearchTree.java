package com.github.codingpractice.trees;

/**
 * @author Patrick Kranz
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> head;

    public BinarySearchTree() {
        this.head = new TreeNode<T>(null);
    }

    public BinarySearchTree<T> add(T value) {
        if (value == null)
            throw new IllegalArgumentException("value must not be null");
        head.setRight(add(head.getRight(), value));
        return this;
    }

    private TreeNode<T> add(TreeNode<T> treeNode, T value) {
        if (treeNode == null) return new TreeNode<T>(value);

        int compareResult = treeNode.getValue().compareTo(value);
        if (compareResult < 0) {
            treeNode.setRight(add(treeNode.getRight(), value));
        } else if (compareResult > 0) {
            treeNode.setLeft(add(treeNode.getLeft(), value));
        }
        return treeNode;
    }

    public int size() {
        return size(head.getRight());
    }

    private int size(TreeNode<T> tree) {
        if (tree == null) return 0;
        int size = 1;
        size += size(tree.getLeft());
        size += size(tree.getRight());
        return size;
    }

    public boolean isEmpty() {
        return head.getRight() == null;
    }

    public int maxDepth() {
        if (isEmpty()) return 0;
        return maxDepth(head.getRight());
    }

    private int maxDepth(TreeNode<T> tree) {
        if (tree == null) return 0;
        int leftDepth = maxDepth(tree.getLeft());
        int rightDepth = maxDepth(tree.getRight());

        if (leftDepth > rightDepth) return leftDepth + 1;
        else return rightDepth + 1;
    }

    public T getMaxValue() {
        ensureContainsElements();
        TreeNode<T> tree = head.getRight();
        while (tree.getRight() != null)
            tree = tree.getRight();
        return tree.getValue();
    }

    private void ensureContainsElements() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree contains no elements");
        }
   }

    public T getMinValue() {
        ensureContainsElements();
        TreeNode<T> tree = head.getRight();
        while (tree.getLeft() != null)
            tree = tree.getLeft();
        return tree.getValue();
    }

    public String getInOrder() {
        StringBuilder builder = new StringBuilder();
        getInOrder(builder, head.getRight());
        return builder.toString().trim();
    }

    private static <T> void getInOrder(StringBuilder builder, TreeNode<T> tree) {
        if (tree == null) return;
        getInOrder(builder, tree.getLeft());
        builder.append(tree.getValue()).append(" ");
        getInOrder(builder, tree.getRight());
    }

    public String getPostOrder() {
        StringBuilder builder = new StringBuilder();
        getPostOrder(builder, head.getRight());
        return builder.toString().trim();
    }

    private static <T> void getPostOrder(StringBuilder builder, TreeNode<T> tree) {
        if (tree == null) return;
        getPostOrder(builder, tree.getLeft());
        getPostOrder(builder, tree.getRight());
        builder.append(tree.getValue()).append(" ");
    }

    public static boolean hasPathSum(BinarySearchTree<Integer> tree, int sum) {
        if (tree.isEmpty() && sum == 0) return true;
        return hasPathSum(tree.head.getRight(), 0, sum);
    }

    private static boolean hasPathSum(TreeNode<Integer> tree, int calculatedSum, int sum) {
        if (tree.getRight() == null && tree.getLeft() == null) {
            return calculatedSum + tree.getValue() == sum;
        };

        boolean left = false;
        boolean right = false;
        calculatedSum += tree.getValue();
        if (tree.getRight() != null) {
            right = hasPathSum(tree.getRight(), calculatedSum, sum);
        }
        if (tree.getLeft() != null) {
            left = hasPathSum(tree.getLeft(), calculatedSum, sum);
        }
        return left || right;
    }

    public int height() {
        if (isEmpty()) return 0;
        return height(head);
    }

    private int height(TreeNode<T> tree) {
        if (tree == null) return 0;
        int left = 0;
        int right = 0;
        if (tree.getRight() != null) {
            right = height(tree.getRight()) + 1;
        }
        if (tree.getLeft() != null) {
            left = height(tree.getLeft()) + 1;
        }
        if (right > left) return right;
        return left;
    }
}
