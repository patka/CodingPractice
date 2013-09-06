package com.github.codingpractice.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Patrick Kranz
 */
public class BinaryTree<T extends Comparable<T>> {
    private final TreeNode<T> head = new TreeNode<>(null);

    public int size() {
        return size(head.right);
    }

    private int size(TreeNode<T> tree) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return 1;
        int size = 0;
        size += size(tree.left);
        size += size(tree.right);
        size++;
        return size;
    }

    public String getInOrder() {
        StringBuilder builder = new StringBuilder();
        getInOrder(head.right, builder);
        return builder.toString().trim();
    }

    private void getInOrder(TreeNode<T> node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        getInOrder(node.left, builder);
        builder.append(node.value.toString()).append(" ");
        getInOrder(node.right, builder);
    }

    public String getLevelOrder() {
        if (head.right == null) return "";
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(head.right);
        while(queue.peek() != null) {
            TreeNode<T> node = queue.poll();
            builder.append(node.value).append(" ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return builder.toString().trim();
    }

    private TreeNode<T> add(TreeNode<T> node, T value) {
        if (node == null) return new TreeNode<>(value);
        int compareResult = node.value.compareTo(value);
        if (compareResult > 0)
            node.left = add(node.left, value);
        if (compareResult < 0)
            node.right = add(node.right, value);
        return node;
    }

    public void add(T value) {
        head.right = add(head.right, value);
    }

    public boolean isEmpty() {
        return head.right == null;
    }

    private class TreeNode<T extends Comparable<T>> {
        final private T value;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(final T value) {
            this.value = value;
        }
    }
}
