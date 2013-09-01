package com.github.codingpractice.trees;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Patrick Kranz
 */
public class BinaryTreeTest {
    @Test
    public void shouldReturnTrueWhenElementToInsertGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.add(5));
    }

    @Test
    public void shouldReturnTrueWhenTwoDifferentElementsGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.add(5));
        assertTrue(tree.add(7));
    }

    @Test
    public void shouldReturnFalseWhenSameElementTwiceGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.add(5));
        assertFalse(tree.add(5));
    }

    @Test
    public void shouldReturnEmptyStringWhenNoElementGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.getInOrder().isEmpty());
    }

    @Test
    public void shouldReturnOneElementInStringWhenOneElementGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        assertEquals("5", tree.getInOrder());
    }

    @Test
    public void shouldReturnTwoElementsInOderWhenTwoElementsGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(4);
        assertEquals("4 5", tree.getInOrder());
    }

    @Test
    public void shouldReturnMultipleElementsInOrderWhenMultipleElementsGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(8);
        tree.add(6);
        tree.add(7);
        tree.add(5);
        tree.add(4);
        tree.add(2);
        tree.add(12);
        tree.add(10);
        tree.add(11);
        tree.add(9);
        tree.add(15);
        assertEquals("2 4 5 6 7 8 9 10 11 12 15", tree.getInOrder());
    }
}
