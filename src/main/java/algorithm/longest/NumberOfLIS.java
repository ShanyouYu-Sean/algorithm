package algorithm.longest;

public class NumberOfLIS {

	// 最长递增子序列的个数
	// dp[i]：i之前（包括i）最长递增子序列的长度为dp[i]
	// count[i]：以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]
	// 在nums[i] > nums[j]前提下，
	// 如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 > dp[i]，说明找到了一个更长的递增子序列。
	// 那么以j为结尾的子串的最长递增子序列的个数，
	// 就是最新的以i为结尾的子串的最长递增子序列的个数，即：count[i] = count[j]。
	// 如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 == dp[i]，说明找到了两个相同长度的递增子序列。
	// 那么以i为结尾的子串的最长递增子序列的个数就应该加上以j为结尾的子串的最长递增子序列的个数，
	// 即：count[i] += count[j];
	public int findNumberOfLIS(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int[] dp = new int[nums.length];
		for(int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		int[] count = new int[nums.length];
		for(int i = 0; i < count.length; i++) {
			count[i] = 1;
		}
		int maxCount = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];
					} else if (dp[j] + 1 == dp[i]) {
						count[i] += count[j];
					}
				}
				if (dp[i] > maxCount) {
					maxCount = dp[i];
				}
			}
		}
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maxCount == dp[i]) {
				result += count[i];
			}
		}
		return result;
	}

}
