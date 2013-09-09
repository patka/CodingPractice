package com.github.codingpractice.trees;

import org.junit.Before;
import org.junit.Test;

import static com.github.codingpractice.trees.BinarySearchTree.hasPathSum;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Patrick Kranz
 */
public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void shouldAddFirstElementAsRootWhenOneElementGiven() {
        bst.add(5);
        assertEquals("5", bst.getInOrder());
    }

    @Test
    public void shouldAddSmallerElementAsLeftLeafWhenTwoElementsGiven() {
        bst.add(5).add(4);
        assertEquals("4 5", bst.getInOrder());
    }

    @Test
    public void shouldAddBiggerElementAsRightLeafWhenTwoElementsGiven() {
        bst.add(5).add(6);
        assertEquals("5 6", bst.getInOrder());
    }

    @Test
    public void shouldAddElementsCorrectlyWhenMultpleElementGiven() {
        bst.add(10).add(5).add(15).add(3).add(7).add(14).add(16);
        assertEquals("3 5 7 10 14 15 16", bst.getInOrder());
    }

    @Test
    public void shouldReturnZeroWhenEmptyTreeGiven() {
        assertEquals(0, bst.size());
    }

    @Test
    public void shouldReturnOneWhenRootElementGiven() {
        bst.add(10);
        assertEquals(1, bst.size());
    }

    @Test
    public void shouldReturnCorrectSizeWhenMulitpleElementsGiven() {
        bst.add(10).add(5).add(9).add(7).add(6).add(11);
        assertEquals(6, bst.size());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGetMaxValueWithElementsGiven() {
        bst.getMaxValue();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenGetMinValueWithElementsGiven() {
        bst.getMinValue();
    }

    @Test
    public void shouldReturnLowestValueWhenGetMinValueWithElementsGiven() {
        bst.add(5).add(8).add(3).add(9).add(2);
        assertEquals(2, bst.getMinValue().intValue());
    }

    @Test
    public void shouldReturnBiggestValueWhenGetMaxValueWithElementsGiven() {
        bst.add(5).add(8).add(3).add(9).add(2);
        assertEquals(9, bst.getMaxValue().intValue());
    }

    @Test
    public void shouldReturnZeroDepthWhenEmptyTreeGiven() {
        assertEquals(0, bst.maxDepth());
    }

    @Test
    public void shouldReturnTrueForPathSumZeroOnEmptyTree() {
        assertTrue(hasPathSum(bst, 0));
    }

    @Test
    public void shouldReturnFalseWhenNotExistingPathSumGiven() {
        bst.add(5).add(8).add(12).add(7).add(4).add(3);
        assertFalse(hasPathSum(bst, 2));
    }

    @Test
    public void shouldReturnTrueWhenExistingPathSumGiven() {
        bst.add(5).add(8).add(12).add(7).add(4).add(3);
        assertTrue(hasPathSum(bst, 12));
        assertTrue(hasPathSum(bst, 20));
        assertTrue(hasPathSum(bst, 25));
    }
}
