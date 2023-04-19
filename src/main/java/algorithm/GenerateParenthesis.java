package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	// 括号生成
	// 回溯
	// 如果左括号数量不大于 n，我们可以放一个左括号。
	// 如果右括号数量小于左括号的数量，我们可以放一个右括号。
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		backtrack(ans, new StringBuilder(), 0, 0, n);
		return ans;
	}
	public void backtrack(List<String> ans, StringBuilder cur,
			int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur.toString());
			return;
		}
		if (open < max) {
			cur.append('(');
			backtrack(ans, cur, open + 1, close, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(')');
			backtrack(ans, cur, open, close + 1, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}

}
