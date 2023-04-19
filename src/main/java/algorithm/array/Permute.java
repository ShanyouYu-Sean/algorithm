package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列，回溯
 */
public class Permute {

	List<List<Integer>> result = new ArrayList<>();
    // 全排列，回溯
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> track = new ArrayList<>();
		backtrack(nums, track);
		return result;
	}
	public void backtrack(int[] nums, List<Integer> track){
		if(track.size() == nums.length){
			result.add(new ArrayList<>(track));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			// 剪枝？
			if(track.contains(nums[i])){
				continue;
			}
			track.add(nums[i]);
			backtrack(nums, track);
			track.remove(track.size() - 1);
		}
	}

}
