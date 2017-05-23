package treesandgraphs.binarytrees.balance;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.TestBinaryTrees;

/**
 * Tests CheckSymmetric class.
 *
 * Created by rezaamini on 5/20/17.
 */
public class CheckSymmetricTest {
    @Test
    public void isSymmetricTest() throws Exception {
        Assert.assertTrue(CheckSymmetric.isSymmetric(TestBinaryTrees.createTestSymmetricTree()));
    }

    @Test
    public void isNonSymmetricTest() throws Exception {
        Assert.assertFalse(CheckSymmetric.isSymmetric(TestBinaryTrees.createTestNonSymmetricTree()));
    }
}