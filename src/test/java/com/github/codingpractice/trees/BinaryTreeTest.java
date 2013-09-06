package com.github.codingpractice.trees;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Patrick Kranz
 */
public class BinaryTreeTest {
    @Test
    public void shouldReturnZeroWhenEmptyTreeGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertEquals(0, tree.size());
    }

    @Test
    public void shouldReturnFiveWhenTreeWithFiveElementsGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(8);
        tree.add(9);
        tree.add(7);
        assertEquals(5, tree.size());
    }

    @Test
    public void shouldReturnEmptyStringWhenNoElementGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.getInOrder().isEmpty());
    }

    @Test
    public void shouldReturnEmptyStringWhenNoElementForLevelOrderGiven() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertEquals("", tree.getLevelOrder());
    }

    @Test
    public void shouldReturnElementsInLevelOrderWhenElementsGiven() {
        BinaryTree<Integer> tree  = new BinaryTree<>();
        tree.add(5);
        tree.add(4);
        tree.add(6);
        assertEquals("5 4 6", tree.getLevelOrder());
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
