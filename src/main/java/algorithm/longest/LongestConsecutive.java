package algorithm.longest;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

	// 最长连续序列
	// HashSet去重
    // 要枚举的数 x 一定是在数组中不存在前驱数 x−1 的
	// 不然我们会从 x−1 开始尝试匹配
	// 因此我们每次在哈希表中检查是否存在 x−1 即能判断是否需要跳过了。
	public int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}
		int res = 0;
		for (int num : numSet) {
			if (!numSet.contains(num - 1)) {
				int currentNum = num;
				int currentLen = 1;
				while (numSet.contains(currentNum + 1)) {
					currentNum += 1;
					currentLen += 1;
				}
				res = Math.max(res, currentLen);
			}
		}
		return res;
	}

}
