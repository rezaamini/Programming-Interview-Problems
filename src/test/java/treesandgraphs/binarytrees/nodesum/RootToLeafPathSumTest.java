package treesandgraphs.binarytrees.nodesum;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Created by rezaamini on 5/22/17.
 */
public class RootToLeafPathSumTest {
    @Test
    public void sumRootToLeaf() throws Exception {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> o = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> k = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> p = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> m = new BinaryTreeNode<>(1);

        a.setLeft(b);
        a.setRight(i);
        b.setLeft(c);
        b.setRight(f);
        c.setLeft(d);
        c.setRight(e);
        f.setRight(g);
        g.setLeft(h);
        i.setLeft(j);
        i.setRight(o);
        j.setRight(k);
        k.setLeft(l);
        k.setRight(n);
        l.setRight(m);
        o.setRight(p);

        Assert.assertEquals(126, RootToLeafPathSum.sumRootToLeaf(a));
    }

}