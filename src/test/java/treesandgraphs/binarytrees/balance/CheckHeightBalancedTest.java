package treesandgraphs.binarytrees.balance;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;

/**
 * Tests CheckHeightBalanced class.
 *
 * Created by rezaamini on 5/20/17.
 */
public class CheckHeightBalancedTest {
    @Test
    public void isHeightBalancedTest() {
        Assert.assertTrue(CheckHeightBalanced.isHeightBalanced(TestBinaryTrees.createTestHeightBalancedTree()));
    }
}