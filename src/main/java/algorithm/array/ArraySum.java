package algorithm.array;

/**
 * 一维数组的动态和
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 */
public class ArraySum {
    // 一维数组的动态和
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
