package treesandgraphs.binarytrees;

import treesandgraphs.binarytrees.node.BinaryTreeNode;
import treesandgraphs.binarytrees.node.BinaryTreeNodeWithParentPointer;
import treesandgraphs.binarytrees.node.BinaryTreeNodeWithState;

/**
 * Creates binary trees to be used in test classes.
 *
 * Created by rezaamini on 5/20/17.
 */
public class TestBinaryTrees {
    public static BinaryTreeNode<Integer> createTestBinaryTree() {
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

        return a;
    }

    public static BinaryTreeNodeWithParentPointer<Integer> createTestBinaryTreeWithParentPointer() {
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

        return a;
    }

    public static BinaryTreeNodeWithState<Integer> createTestBinaryTreeWithState() {
        BinaryTreeNodeWithState<Integer> a = new BinaryTreeNodeWithState<>(314);
        BinaryTreeNodeWithState<Integer> b = new BinaryTreeNodeWithState<>(6);
        BinaryTreeNodeWithState<Integer> c = new BinaryTreeNodeWithState<>(271);
        BinaryTreeNodeWithState<Integer> f = new BinaryTreeNodeWithState<>(561);
        BinaryTreeNodeWithState<Integer> d = new BinaryTreeNodeWithState<>(28);
        BinaryTreeNodeWithState<Integer> e = new BinaryTreeNodeWithState<>(0);
        BinaryTreeNodeWithState<Integer> g = new BinaryTreeNodeWithState<>(3);
        BinaryTreeNodeWithState<Integer> h = new BinaryTreeNodeWithState<>(17);
        BinaryTreeNodeWithState<Integer> i = new BinaryTreeNodeWithState<>(6);
        BinaryTreeNodeWithState<Integer> j = new BinaryTreeNodeWithState<>(2);
        BinaryTreeNodeWithState<Integer> o = new BinaryTreeNodeWithState<>(271);
        BinaryTreeNodeWithState<Integer> k = new BinaryTreeNodeWithState<>(1);
        BinaryTreeNodeWithState<Integer> p = new BinaryTreeNodeWithState<>(28);
        BinaryTreeNodeWithState<Integer> l = new BinaryTreeNodeWithState<>(401);
        BinaryTreeNodeWithState<Integer> n = new BinaryTreeNodeWithState<>(257);
        BinaryTreeNodeWithState<Integer> m = new BinaryTreeNodeWithState<>(641);

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

        return a;
    }

    public static BinaryTreeNode<Integer> createTestHeightBalancedTree() {
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
        a.setRight(k);
        b.setLeft(c);
        b.setRight(h);
        c.setLeft(d);
        c.setRight(g);
        d.setLeft(e);
        d.setRight(f);
        h.setLeft(i);
        h.setRight(j);
        k.setLeft(l);
        k.setRight(o);
        l.setLeft(m);
        l.setRight(n);

        return a;
    }

    public static BinaryTreeNode<Integer> createTestSymmetricTree() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(3);

        a.setLeft(b);
        a.setRight(e);
        b.setRight(c);
        e.setLeft(f);
        c.setRight(d);
        f.setLeft(g);

        return a;
    }

    public static BinaryTreeNode<Integer> createTestNonSymmetricTree() {
        BinaryTreeNode<Integer> a = new BinaryTreeNode<>(314);
        BinaryTreeNode<Integer> b = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> e = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> c = new BinaryTreeNode<>(561);
        BinaryTreeNode<Integer> f = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> d = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> g = new BinaryTreeNode<>(1);

        a.setLeft(b);
        a.setRight(e);
        b.setRight(c);
        e.setLeft(f);
        c.setRight(d);
        f.setLeft(g);

        return a;
    }
}
