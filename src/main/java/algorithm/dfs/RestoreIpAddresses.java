package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

	// 复原 IP 地址
	// 回溯
	public List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		dfs(s, 0, ans, temp);
		return ans;
	}
	public void dfs(String s, int begin, List<String> ans, List<String> temp){
		// 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
		if(temp.size() == 4) {
			if(begin == s.length()) {
				ans.add(String.join(".",temp));
			}
			return;
		}

		for(int i = begin; i < begin+3 && i < s.length(); i++){
			String sub = s.substring(begin, i+1);
			if(!isRange(sub)){
				break;
			}
			temp.add(sub);
			dfs(s, i+1, ans, temp);
			temp.remove(temp.size() - 1);
		}
	}
	public boolean isRange(String sub){
		if(sub.length() != 1 && sub.charAt(0) == '0'){
			return false;
		}
		return Integer.parseInt(sub) <= 255;
	}
}
