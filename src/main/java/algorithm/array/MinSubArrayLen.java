package algorithm.array;

public class MinSubArrayLen {

	// 和为s的 长度最小的子数组
	// 滑动窗口
	// 每一轮迭代，将 nums[end] 加到 sum，
	// 如果 sum≥s，则更新子数组的最小长度
	// 然后将 nums[start]从 sum 中减去并将 start 右移，
	// 直到 sum<s
	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		int start = 0, end = 0;
		int sum = 0;
		while (end < n) {
			sum += nums[end];
			while (sum >= s) {
				res = Math.min(res, end - start + 1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

}
