package treesandgraphs.binarytrees.lca;

import org.junit.Assert;
import org.junit.Test;
import treesandgraphs.binarytrees.node.BinaryTreeNodeWithParentPointer;

/**
 * Tests LowestCommonAncestorWithParentPointer class.
 *
 * Created by rezaamini on 5/22/17.
 */
public class LowestCommonAncestorWithParentPointerTest {
    @Test
    public void lcaTest() {
        BinaryTreeNodeWithParentPointer<Integer> a = new BinaryTreeNodeWithParentPointer<>(314);
        BinaryTreeNodeWithParentPointer<Integer> b = new BinaryTreeNodeWithParentPointer<>(6);
        BinaryTreeNodeWithParentPointer<Integer> c = new BinaryTreeNodeWithParentPointer<>(271);
        BinaryTreeNodeWithParentPointer<Integer> f = new BinaryTreeNodeWithParentPointer<>(561);
        BinaryTreeNodeWithParentPointer<Integer> d = new BinaryTreeNodeWithParentPointer<>(28);
        BinaryTreeNodeWithParentPointer<Integer> e = new BinaryTreeNodeWithParentPointer<>(0);
        BinaryTreeNodeWithParentPointer<Integer> g = new BinaryTreeNodeWithParentPointer<>(3);
        BinaryTreeNodeWithParentPointer<Integer> h = new BinaryTreeNodeWithParentPointer<>(17);
        BinaryTreeNodeWithParentPointer<Integer> i = new BinaryTreeNodeWithParentPointer<>(6);
        BinaryTreeNodeWithParentPointer<Integer> j = new BinaryTreeNodeWithParentPointer<>(2);
        BinaryTreeNodeWithParentPointer<Integer> o = new BinaryTreeNodeWithParentPointer<>(271);
        BinaryTreeNodeWithParentPointer<Integer> k = new BinaryTreeNodeWithParentPointer<>(1);
        BinaryTreeNodeWithParentPointer<Integer> p = new BinaryTreeNodeWithParentPointer<>(28);
        BinaryTreeNodeWithParentPointer<Integer> l = new BinaryTreeNodeWithParentPointer<>(401);
        BinaryTreeNodeWithParentPointer<Integer> n = new BinaryTreeNodeWithParentPointer<>(257);
        BinaryTreeNodeWithParentPointer<Integer> m = new BinaryTreeNodeWithParentPointer<>(641);

        a.setLeft(b);
        a.setRight(i);
        b.setParent(a);
        i.setParent(a);

        b.setLeft(c);
        b.setRight(f);
        c.setParent(b);
        f.setParent(b);

        c.setLeft(d);
        c.setRight(e);
        d.setParent(c);
        e.setParent(c);

        f.setRight(g);
        g.setParent(f);

        g.setLeft(h);
        h.setParent(g);

        i.setLeft(j);
        i.setRight(o);
        j.setParent(i);
        o.setParent(i);

        j.setRight(k);
        k.setParent(j);

        k.setLeft(l);
        k.setRight(n);
        l.setParent(k);
        n.setParent(k);

        l.setRight(m);
        m.setParent(l);

        o.setRight(p);
        p.setParent(o);

        Assert.assertTrue(LowestCommonAncestorWithParentPointer.lca(l, o).getData() == 6);
        Assert.assertTrue(LowestCommonAncestorWithParentPointer.lca(i, o).getData() == 6);
        Assert.assertTrue(LowestCommonAncestorWithParentPointer.lca(k, c).getData() == 314);
        Assert.assertTrue(LowestCommonAncestorWithParentPointer.lca(a, m).getData() == 314);
    }

}