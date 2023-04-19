package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	// 子集
	// 回溯
	List<List<Integer>> res;
	List<Integer> list = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<>();
		backTracing(nums, 0);
		return res;
	}
	public void backTracing(int[] nums, int start){
		// 每更新一次 list 都加入结果集
		res.add(new ArrayList<>(list));
		for(int i = start; i < nums.length; i++){
			// 将当前数加入list
			list.add(nums[i]);
			// 递归 不能重复使用当前数 因此下一轮从i+1开始
			backTracing(nums, i+1);
			// 回溯 回退刚刚加的数
			list.remove(list.size()-1);
		}
	}

}
