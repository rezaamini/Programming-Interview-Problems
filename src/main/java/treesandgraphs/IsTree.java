/*
 You have an array of nodes. Each node contains a left and right pointer that 
 point to other nodes in the array. Write an algorithm that detects whether the 
 nodes form a tree.
 */
package treesandgraphs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rezaamini
 */
public class IsTree
{
    public boolean isTree(TreeNode[] nodes)
    {
        Map<TreeNode, Integer> map = new HashMap<>();
        int n = nodes.length;
        for(int i = 0; i < n; i++)
        {
            if(!map.containsKey(nodes[i]))
                map.put(nodes[i], 0);
            
            if(nodes[i].left != null)
            {
                if(!map.containsKey(nodes[i].left))
                    map.put(nodes[i].left, 1);
                else
                {
                    if(map.get(nodes[i].left) > 0)
                        return false;
                    map.put(nodes[i].left, 1);
                }
            }
            if(nodes[i].right != null)
            {
                if(!map.containsKey(nodes[i].right))
                    map.put(nodes[i].right, 1);
                else
                {
                    if(map.get(nodes[i].right) > 0)
                        return false;
                    map.put(nodes[i].right, 1);
                }
            }
        }
        
        int rootCount = 0;
        for(Integer i: map.values())
        {
            if(i == 0)
            {
                rootCount++;
                if(rootCount > 1)
                    return false;
            }
        }
        
        return true;
    }
}
