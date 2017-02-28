/*
 
 Given an array of stock prices at different times, find the best deal.
 
*/

package ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Write a method that buys and sells stocks once from a given list of prices, and make maximum profit.
 *
 * @author Reza Amini
 */
public class BuyAndSellStockOnce
{
    // Time complexity: O(n), space complexity: O(1)
    public static double buyAndSellStockOnce(List<Double> prices) {
        double bestBuy = Double.MAX_VALUE;
        double maxProfit = 0.0;

        for (Double price: prices) {
            bestBuy = Math.min(bestBuy, price);
            maxProfit = Math.max(maxProfit, price - bestBuy);
        }

        return maxProfit;
    }

    @Test
    public void testBuyAndSellStockOnce() {
        List<Double> prices = Arrays.asList(310.0, 315.0, 275.0, 295.0, 260.0, 270.0, 290.0, 230.0, 255.0, 250.0);
        Assert.assertEquals(30.0, buyAndSellStockOnce(prices), 0.0001);
    }
}
