package algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	// 组合总和
	// candidates 中可以使数字和为目标数 target 的 所有 不同组合
	// 回溯
	private List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>();
		// 排序后，如果比target大，后面的就不需要递归了，因为后面的数会更大
		Arrays.sort(candidates);
		dfs(path,candidates,target,0,0);
		return res;
	}
	private void dfs(List<Integer> path, int[] candidates,
			int target, int sum, int begin) {
		if(sum == target) {
			res.add(new ArrayList<>(path));
			return;
		}
		for(int i = begin;i < candidates.length;i++) {
			int rs = candidates[i] + sum;
			if(rs <= target) {
				path.add(candidates[i]);
				dfs(path,candidates,target,rs,i);
				path.remove(path.size()-1);
			} else {
				break;
			}
		}
	}

}
