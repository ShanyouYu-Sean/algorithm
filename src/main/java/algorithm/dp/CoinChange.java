package algorithm.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
 */
public class CoinChange {

    // 零钱兑换
    // dp[i] = min(dp[i], dp[i-coin]+1)
    public int coinChange(int[] coins, int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin : coins) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
