package algorithm.dp;

/**
 * 打家劫舍
 * 不能偷相邻的，给定一个代表每个房屋存放金额的非负整数数组，一夜之内能够偷窃到的最高金额。
 */
public class Rob {

    // 打家劫舍
    // dp[i] = max(dp[i-2] + nums[i], dp[i-1])
    public int rob(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[length-1];
    }
}
