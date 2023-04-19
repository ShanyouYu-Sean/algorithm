package algorithm.half;

public class FindPeakElement {

	// 寻找峰值
	// 只要数组中存在一个元素比相邻元素大，
	// 那么沿着它一定可以找到一个峰值
	// 二分法，左右指针计算中间位置 m，并比较 m 与 m+1 的值，
	// 如果 m 较大，则左侧存在峰值，否则，则右侧存在峰值
	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		while ( left < right ) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
