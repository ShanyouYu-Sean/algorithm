package algorithm.array;

public class Jump2 {

	/**
	 * 贪心算法：遍历当前位置能跳跃的范围，
	 * 计算下个位置能跳跃的距离，找到距离最大的位置，
	 * 那么下次跳到这个位置就能保证两次跳跃的距离最大，每次都这样跳一定是最小跳跃次数；
	 * e.g. [2,1,3,0,4]
	 * 先从i=0的位置开始，nums[0] =2，即从0开始，当前最远的位置是2 + 0 = 2；然后查找下一步能跳跃的最远位置
	 * i = 1时，nextStep = 1 + 1 = 2, 没有比5-1=4大，继续
	 * i = 2时，nextStep = 3 + 2 = 5, 比5-1=4大，说明从0跳到2后可以直接从2跳到最后一个位置；
	 * 结束
	 */
	public int jump(int[] nums) {
		// 当前能走到最远的位置
		int step = 0;
		// 一步一步往前走，查看路过的每个下标能走到的最远的位置，取其中的最大值
		int nextStep = 0;
		// 跳跃次数
		int count = 0;
		for(int i = 0; i < nums.length - 1; i++){
			// 每个下标能走到的最远的位置，取其中的最大值
			nextStep = Math.max(nextStep, nums[i] + i);
			// 如果从当前位置跳跃到i后，i的最远位置覆盖了数组的最后位置，那么跳跃结束
			if(nextStep >= nums.length - 1) {
				count++;
				break;
			}
			// 如果走到了当前覆盖的最远位置，还没有走到最后，那么需要进行一次跳跃：
			// 从当前位置跳跃到它覆盖范围内能跳到最远位置的地方，从这个地方继续往前
			if(i == step){
				count++;
				step = nextStep;
			}
		}
		return count;
	}
}
