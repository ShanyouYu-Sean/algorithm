package algorithm.array;

public class MaxKth {

	// 最大的第K个数
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		// 转换一下，第 k 大元素的索引是 len - k
		int target = len - k;
		while (true) {
			int index = partitionBegin(nums, left, right);
			if (index == target) {
				return nums[index];
			} else if (index < target) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}
	}
	public int partitionBegin(int[] arr, int begin, int end) {
		int pivot = arr[begin];
		int i = begin;
		for (int j = begin + 1; j <= end; j++) {
			if (arr[j] < pivot) {
				// 小于 pivot 的元素都被交换到前面
				i++;
				swap(arr, i, j);
			}
		}
		// 在之前遍历的过程中，满足 [begin + 1, i] < pivot，并且 (i, j] >= pivot
		swap(arr, i, begin);
		// 交换以后 [begin, i - 1] < pivot, nums[i] = pivot, [i + 1, end] >= pivot
		return i;
	}
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}


}
