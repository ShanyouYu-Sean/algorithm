package algorithm.longest;

public class LongestCommonSubArray {

	// 最长重复子数组
	// 令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，
	// 那么答案即为所有 dp[i][j] 中的最大值。
	// 如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
	public int findLength(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if (len1 == 0 || len2 == 0) {
			return 0;
		}
		int[][] dp = new int[len1 + 1][len2 + 1];
		int result = 0;
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if (nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result;
	}

}
