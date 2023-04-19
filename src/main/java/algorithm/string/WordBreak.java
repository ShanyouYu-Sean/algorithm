package algorithm.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	// 单词拆分
	// dp[i] 表示字符串s前i个字符组成的字符串是否能被空格拆分成若干个字典中出现的单词。
	// 需要枚举s[0..i−1]中的分割点j，
	// 看s[0..j−1]组成的字符串s1和s[j..i−1]组成的字符串s2是否都合法
	// 如果两个字符串均合法，那么按照定义s1和s2拼接成的字符串也同样合法。
	// dp[i]=dp[j] && check(s[j..i−1])
	// 其中 check(s[j..i−1])表示子串s[j..i−1]是否出现在字典中。
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
