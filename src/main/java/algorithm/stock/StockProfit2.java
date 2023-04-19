package algorithm.stock;

/**
 * 买卖股票
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
 * 在每一天，你可以决定是否购买和/或出售股票。
 * 你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 设计一个算法来计算你所能获得的最大利润。（可以多次买卖一支股票）
 * 注意：不能同时同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class StockProfit2 {

    // 买卖股票 2
    // 同一天可以同时买卖，可以多次买卖一支股票
    // 相当于每天都买卖
    public int maxProfit(int[] prices){
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            int tmp = prices[i] + prices[i - 1];
            if (tmp > 0){
                profit += tmp;
            }
        }
        return profit;
    }

}
