
package ArraysAndStrings;

import java.util.Scanner;

/**
 * Given an array of stock prices at different times, find the best deal.
 * 
 * @author Reza Amini
 */
public class BuyAndSellStock
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];

        for(int i = 0; i < n; i++)
            prices[i] = scan.nextInt();
        
        int bestBuySoFar = prices[0];
        int bestDealSoFar = 0;
        
        for(int i = 1; i < n; i++)
        {
            if(prices[i] <= bestBuySoFar)
                bestBuySoFar = prices[i];
            if(prices[i] - bestBuySoFar >= bestDealSoFar)
                bestDealSoFar = prices[i] - bestBuySoFar;
        }
        
        System.out.println(bestDealSoFar);
    }
}
