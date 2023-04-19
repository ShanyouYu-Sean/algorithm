package algorithm.longest;

/**
 * 最长公共子序列
 * 取dp数组（比字符串大一位），
 * 从下标为1开始，如果 char[i-1] 相等，dp[i-1][j-1] + 1，否则 max dp[i-1][j-1],
 * dp[i][j] 表述 x[i] 和 y[j] 的 LCS 的长度
 */
public class LongestCommonSubsequence {

    /**
     * 最长公共子序列
     * 取dp数组（比字符串大一位），
     * 从下标为1开始，如果 char[i-1] 相等，dp[i-1][j-1] + 1，否则 max dp[i-1][j-1],
     * dp[i][j] 表述 x[i] 和 y[j] 的 LCS 的长度
     */
    public int longestCommonSubsequence(String text1, String text2){
        if (text1 == null || text1.length() == 0 ||
                text2 == null || text2.length() == 0) {
            return 0;
        }
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        // 遍历两个字符串：
        //   1、若 当前两个字符串 相等：
        //      当前状态 = 两个元素的前一个状态 + 1
        //   2、若 当前两个字符串 不等：
        //      当前状态 = 两个元素任意元素的前一个状态 的 最大值
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int i = 1; i <= length1; i++){
            for (int j = 1; j <= length2; j++){
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }
}
