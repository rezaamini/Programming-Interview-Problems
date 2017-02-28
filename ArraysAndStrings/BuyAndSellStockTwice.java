package ArraysAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method that buys and sells stock twice and gain maximum profit.
 *
 * Created by rezaamini on 2/26/17.
 */
public class BuyAndSellStockTwice {
    // Time complexity: O(n), space complexity: O(n)
    public static double buyAndSellStockTwice(List<Double> prices) {
        double maxProfit = 0.0;
        double bestBuy = Double.MAX_VALUE;
        List<Double> firstBuySellProfits = new ArrayList<>();

        // Do the first buy-sell in forward direction
        for (Double price : prices) {
            bestBuy = Math.min(bestBuy, price);
            maxProfit = Math.max(maxProfit, price - bestBuy);
            firstBuySellProfits.add(maxProfit);
        }

        // For each day, check if buying on that day makes max second profit in backward direction
        double bestSell = Double.MIN_VALUE;
        for (int i = prices.size() - 1; i > 0; i--) {
            bestSell = Math.max(bestSell, prices.get(i));
            maxProfit = Math.max(maxProfit, bestSell - prices.get(i) + firstBuySellProfits.get(i - 1));
        }

        return maxProfit;
    }

    @Test
    public void testBuyAndSellStockTwice() {
        Assert.assertEquals(10.0,
                buyAndSellStockTwice(Arrays.asList(12.0, 11.0, 13.0, 9.0, 12.0, 8.0, 14.0, 13.0, 15.0)), 0.0001);
    }
}
