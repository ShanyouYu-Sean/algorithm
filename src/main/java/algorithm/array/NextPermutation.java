package algorithm.array;

public class NextPermutation {

	// 下一个排列
	// 1。需要将一个左边的「较小数」与一个右边的「较大数」交换，
	// 以能够让当前排列变大，从而得到下一个排列。
	// 2。同时要让这个「较小数」尽量靠右，而「较大数」尽可能小。
	// 当交换完成后，「较大数」右边的数需要按照升序重新排列。
	// 这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		// 寻找 i，满足 a[i]<a[i+1]，[i+1,n) 必然是下降序列
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		// 寻找 j，满足 a[i]<a[j]
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			// 交换 a[i] 与 a[j]
			swap(nums, i, j);
		}
		// 此时 [i+1,n) 必为降序。反转区间 [i+1,n) 使其变为升序
		reverse(nums, i + 1);
	}
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public void reverse(int[] nums, int start) {
		int left = start, right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

}
