package com.github.codingpractice.trees;

/**
 * @author Patrick Kranz
 */
class TreeNode<T> {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    T getValue() {
        return this.value;
    }

    TreeNode<T> getRight() {
        return right;
    }

    void setRight(TreeNode<T> right) {
        this.right = right;
    }

    TreeNode<T> getLeft() {
        return left;
    }

    void setLeft(TreeNode<T> left) {
        this.left = left;
    }
}
