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
}
