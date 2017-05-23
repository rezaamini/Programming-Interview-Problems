package treesandgraphs.binarytrees.lca;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.node.BinaryTreeNode;

/**
 * Tests LowestCommonAncestor class.
 *
 * Created by rezaamini on 5/21/17.
 */
public class LowestCommonAncestorTest {
    @Test
    public void lcaTest() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(271);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(561);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(28);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> h = new BinaryTreeNode<>(17);
        BinaryTreeNode<Integer> i = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> j = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> o = new BinaryTreeNode<>(271);
        BinaryTreeNode<Integer> k = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> p = new BinaryTreeNode<>(28);
        BinaryTreeNode<Integer> l = new BinaryTreeNode<>(401);
        BinaryTreeNode<Integer> n = new BinaryTreeNode<>(257);
        BinaryTreeNode<Integer> m = new BinaryTreeNode<>(641);

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

        Assert.assertTrue(LowestCommonAncestor.lca(a, l, o).getData() == 6);
        Assert.assertTrue(LowestCommonAncestor.lca(a, i, o).getData() == 6);
        Assert.assertTrue(LowestCommonAncestor.lca(a, k, c).getData() == 314);
        Assert.assertTrue(LowestCommonAncestor.lca(a, a, m).getData() == 314);
    }

}