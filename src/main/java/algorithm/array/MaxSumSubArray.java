package algorithm.array;

/**
 * 子数组最大累加和
 */
public class MaxSumSubArray {

    // 子数组最大累加和
    // f(n) = max(f(n-1) + A[n], A[n])
    public int maxSumSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] = Math.max(nums[i-1] + nums[i], nums[i]);
        }
        return nums[nums.length - 1];
    }
}
