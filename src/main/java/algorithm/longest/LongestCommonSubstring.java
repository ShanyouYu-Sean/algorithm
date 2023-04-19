package algorithm.longest;

/**
 * 最长公共子串
 */
public class LongestCommonSubstring {

    // 最长公共子串
    public String longestCommonSubstring(String str1, String str2){
        if (str1 == null || str2 == null){
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0){
            return "";
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0, x = 0;
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                dp[i][j] = dp[i-1][j-1] + 1;
                // 注意这里和最长子序列的区别
                if (dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    x = i;
                }
            }
        }
        return maxLen == 0 ? "" : str1.substring(x - maxLen, x);
    }
}
