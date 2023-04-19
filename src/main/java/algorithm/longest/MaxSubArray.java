package algorithm.longest;

public class MaxSubArray {

	// 最大连续子数组和
	// f(n) = max(f(n-1) + A[n], A[n]);
	public int maxSubArray(int[] nums) {
		int maxRes = nums[0];
		for(int i = 1; i < nums.length; i++){
			nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
			// 和子数组不同的是这个要求连续
			maxRes = Math.max(maxRes, nums[i]);
		}
		return maxRes;
	}
}
