package com.github.codingpractice.trees;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Patrick Kranz
 */
public class BinarySearchTreeTest {
    @Test
    public void shouldAddFirstElementAsRootWhenOneElementGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        assertEquals("5", bst.getInOrder());
    }

    @Test
    public void shouldAddSmallerElementAsLeftLeafWhenTwoElementsGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5).add(4);
        assertEquals("4 5", bst.getInOrder());
    }

    @Test
    public void shouldAddBiggerElementAsRightLeafWhenTwoElementsGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5).add(6);
        assertEquals("5 6", bst.getInOrder());
    }

    @Test
    public void shouldAddElementsCorrectlyWhenMultpleElementGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(10).add(5).add(15).add(3).add(7).add(14).add(16);
        assertEquals("3 5 7 10 14 15 16", bst.getInOrder());
    }

    @Test
    public void shouldReturnZeroWhenEmptyTreeGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertEquals(0, bst.size());
    }

    @Test
    public void shouldReturnOneWhenRootElementGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(10);
        assertEquals(1, bst.size());
    }

    @Test
    public void shouldReturnCorrectSizeWhenMulitpleElementsGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(10).add(5).add(9).add(7).add(6).add(11);
        assertEquals(6, bst.size());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGetMaxValueWithElementsGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.getMaxValue();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGetMinValueWithElementsGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.getMinValue();
    }

    @Test
    public void shouldReturnLowestValueWhenGetMinValueWithElementsGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5).add(8).add(3).add(9).add(2);
        assertEquals(2, bst.getMinValue().intValue());
    }

    @Test
    public void shouldReturnBiggestValueWhenGetMaxValueWithElementsGiven() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5).add(8).add(3).add(9).add(2);
        assertEquals(9, bst.getMaxValue().intValue());
    }
}
