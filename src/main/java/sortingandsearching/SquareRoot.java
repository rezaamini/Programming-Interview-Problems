/*

   Implement a fast integer square root function that takes in a 32-bit unsigned
   integer and returns another 32-bit unsigned integer that is the floor of the 
   square root of the input.

 */

package sortingandsearching;

/**
 *
 * @author Reza Amini
 */
public class SquareRoot {
    // We use binary search
    public static int squareRoot(int k)
    {
        int low = 0;
        int high = k / 2 + 1;
        int mid;

        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if (k < mid * mid)
                high = mid - 1;
            else if (k < (mid + 1)*(mid + 1))
                return mid;
            else 
                low = mid + 1;
        }
        
        return -1;
    }
    
    public static void main(String[] args)
    {
        System.out.println(squareRoot(120));
        System.out.println(squareRoot(121));
    }
}
