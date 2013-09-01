package com.github.codingpractice.trees;

/**
 * @author Patrick Kranz
 */
public class BinaryTree<T extends Comparable<T>> {
    private final TreeNode<T> head = new TreeNode<>(null);

    public String getInOrder() {
        StringBuilder builder = new StringBuilder();
        getInOrder(head.right, builder);
        return builder.toString().trim();
    }

    public boolean add(T value) {
        TreeNode<T> node = head.right;
        while (node != null) {
            int compareResult = node.value.compareTo(value);
            if (compareResult > 0) {
                if (node.left == null) {
                    node.left = new TreeNode<>(value);
                    return true;
                }
                node = node.left;
            } else if (compareResult < 0) {
                if (node.right == null) {
                    node.right = new TreeNode<>(value);
                    return true;
                }
                node = node.right;
            } else {
                return false;
            }
        }
        head.right = new TreeNode<>(value);
        return true;
    }

    private void getInOrder(TreeNode<T> node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        getInOrder(node.left, builder);
        builder.append(node.value.toString()).append(" ");
        getInOrder(node.right, builder);
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
