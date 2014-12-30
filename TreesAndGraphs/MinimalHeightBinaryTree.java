/*

   Given a sorted (increasing order) array, write an algorithm to create
   a binary tree with minimal height.
 
*/

package TreesAndGraphs;

/**
 *
 * @author Reza Amini
 */
public class MinimalHeightBinaryTree {
    
    public static TreeNode arrToTree(int[] arr, int start, int end)
    {
        if(end < start)
            return null;
        if(start == end)
            return new TreeNode(arr[start]);
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrToTree(arr, start, mid - 1);
        root.right = arrToTree(arr, mid + 1, end);
        return root;
    }
    
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};

        TreeNode tn = arrToTree(arr, 0, arr.length-1);
        System.out.println(tn.getValue()); // root

        System.out.print(tn.left.getValue() + ", "); // left
        System.out.println(tn.right.getValue()); // right

        System.out.print(tn.left.left.getValue() + ", "); // left, left
        System.out.print(tn.left.right.getValue() + ", "); // left, right
        System.out.print(tn.right.left.getValue() + ", "); // right, left
        System.out.println(tn.right.right.getValue()); // right, right

        System.out.print(tn.left.right.right.getValue() + ", "); // left, right, right
        System.out.println(tn.right.right.right.getValue()); // right, right, right
    }
}