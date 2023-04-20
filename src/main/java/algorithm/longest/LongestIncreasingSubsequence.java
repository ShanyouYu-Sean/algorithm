package algorithm.longest;

/**
 * 最长递增子序列
 * dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
 */
public class LongestIncreasingSubsequence {

    // 最长递增子序列
    // dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
    // 从小到大计算dp数组的值，
    // 在计算dp[i]之前，我们已经计算出 dp[0…i−1]的值，则状态转移方程为：
    //dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLIS = 1;
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }
}
