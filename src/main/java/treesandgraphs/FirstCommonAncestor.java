/*
 You have a binary tree in which each node has a link to its parent. Write an 
 algorithm that finds the first common ancestor of two nodes in a binary tree.
 */
package treesandgraphs;

import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author rezaamini
 */
public class FirstCommonAncestor
{
    
    public static void main(String[] args)
    {
        ParentedTreeNode<Integer> n1 = new ParentedTreeNode<>(1);
        ParentedTreeNode<Integer> n2 = new ParentedTreeNode<>(2);
        ParentedTreeNode<Integer> n3 = new ParentedTreeNode<>(3);
        ParentedTreeNode<Integer> n4 = new ParentedTreeNode<>(4);
        ParentedTreeNode<Integer> n5 = new ParentedTreeNode<>(5);
        ParentedTreeNode<Integer> n6 = new ParentedTreeNode<>(6);
        ParentedTreeNode<Integer> n7 = new ParentedTreeNode<>(7);
        ParentedTreeNode<Integer> n8 = new ParentedTreeNode<>(8);
        ParentedTreeNode<Integer> n9 = new ParentedTreeNode<>(9);
        ParentedTreeNode<Integer> n10 = new ParentedTreeNode<>(10);
        ParentedTreeNode<Integer> n11 = new ParentedTreeNode<>(11);
        ParentedTreeNode<Integer> n12 = new ParentedTreeNode<>(12);
        ParentedTreeNode<Integer> n13 = new ParentedTreeNode<>(13);
        
        // left side
        n2.parent = n1;
        n4.parent = n2;
        n7.parent = n4;
        n9.parent = n7;
        // right side
        n3.parent = n1;
        n5.parent = n3;
        n6.parent = n3;
        n8.parent = n5;
        n10.parent = n8;
        n11.parent = n10;
        n12.parent = n10;
        n13.parent = n12;
        
//        System.out.println(firstCommonAncestor(n1, n1).value);
//        System.out.println("---");
//        System.out.println(firstCommonAncestor(n2, n3).value);
//        System.out.println(firstCommonAncestor(n3, n2).value);
//        System.out.println("---");
//        System.out.println(firstCommonAncestor(n5, n6).value);
//        System.out.println(firstCommonAncestor(n6, n5).value);
//        System.out.println("---");
//        System.out.println(firstCommonAncestor(n12, n11).value);
//        System.out.println(firstCommonAncestor(n11, n12).value);
//        System.out.println("---");
//        System.out.println(firstCommonAncestor(n9, n3).value);
//        System.out.println(firstCommonAncestor(n3, n9).value);
//        System.out.println("---");
//        System.out.println(firstCommonAncestor(n9, n4).value);
//        System.out.println(firstCommonAncestor(n4, n9).value);
//        System.out.println("---");
//        System.out.println(firstCommonAncestor(n13, n11).value);
//        System.out.println(firstCommonAncestor(n11, n13).value);
//        System.out.println("---");
//        System.out.println(firstCommonAncestor(n9, n7).value);
//        System.out.println(firstCommonAncestor(n7, n9).value);
        System.out.println(firstCommonAncestor_withoutHashSet(n1, n1));
        System.out.println("---");
        System.out.println(firstCommonAncestor_withoutHashSet(n2, n3));
        System.out.println(firstCommonAncestor_withoutHashSet(n3, n2));
        System.out.println("---");
        System.out.println(firstCommonAncestor_withoutHashSet(n5, n6));
        System.out.println(firstCommonAncestor_withoutHashSet(n6, n5));
        System.out.println("---");
        System.out.println(firstCommonAncestor_withoutHashSet(n12, n11));
        System.out.println(firstCommonAncestor_withoutHashSet(n11, n12));
        System.out.println("---");
        System.out.println(firstCommonAncestor_withoutHashSet(n9, n3));
        System.out.println(firstCommonAncestor_withoutHashSet(n3, n9));
        System.out.println("---");
        System.out.println(firstCommonAncestor_withoutHashSet(n9, n4));
        System.out.println(firstCommonAncestor_withoutHashSet(n4, n9));
        System.out.println("---");
        System.out.println(firstCommonAncestor_withoutHashSet(n13, n11));
        System.out.println(firstCommonAncestor_withoutHashSet(n11, n13));
        System.out.println("---");
        System.out.println(firstCommonAncestor_withoutHashSet(n9, n7));
        System.out.println(firstCommonAncestor_withoutHashSet(n7, n9));
    }
    
    public static ParentedTreeNode<Integer> firstCommonAncestor(
        ParentedTreeNode<Integer> n1, ParentedTreeNode<Integer> n2)
    {
        if (n1 == n2.parent)
            return n1.parent;
        
        if (n2 == n1.parent)
            return n2.parent;
        
        Set<ParentedTreeNode<Integer>> visited = new HashSet<>();
        while(n1.parent != null && n2.parent != null) 
        {
            if (n1 == n2.parent)
                return n1;
            if (n2 == n1.parent)
                return n2; 
        
            if(visited.contains(n1))
                return n1;
            visited.add(n1);
            n1 = n1.parent;
            
            if(visited.contains(n2))
                return n2;
            visited.add(n2);
            n2 = n2.parent;
        }
        
        while(n1.parent == null && n2.parent != null)
        {
            if(visited.contains(n2))
                return n2.parent;
            visited.add(n2);
            n2 = n2.parent;
        }
        
        while(n1.parent != null && n2.parent == null)
        {
            if(visited.contains(n1))
                return n1.parent;
            visited.add(n1);
            n1 = n1.parent;
        }
        
        if(n1 == n2)
            return n1;
        return null;
    }
    
    public static ParentedTreeNode<Integer> firstCommonAncestor_withoutHashSet(
        ParentedTreeNode<Integer> n1, ParentedTreeNode<Integer> n2)
    {
        ParentedTreeNode<Integer> temp = n1;
        int n1Height = calcHeight(n1);
        temp = n2;
        int n2Height = calcHeight(n2);
        
        while(n1Height < n2Height)
        {
            n2 = n2.parent;
            n2Height--;
        }
        while(n1Height > n2Height)
        {
            n1 = n1.parent;
            n1Height--;
        }
        
        // heights are equal
        while(n1 != null)
        {
            n1 = n1.parent;
            n2 = n2.parent;
            if (n1 == null)
                return null;
            if(n1 == n2)
                return n1;
        }
        
        return null;
    }
    
    public static int calcHeight(ParentedTreeNode<Integer> n)
    {
        int h = 0;
        while(n != null)
        {
            h++;
            n = n.parent;
        }
        return h;
    }
}

class ParentedTreeNode<T>
{
    ParentedTreeNode parent;
    ParentedTreeNode left;
    ParentedTreeNode right;
    T value;
    
    public ParentedTreeNode(T value)
    {
        this.value = value;
    }
    
    public String toString()
    {
        return this.value.toString();
    }
}
