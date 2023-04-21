package algorithm.array;

public class CanJump {

	public static boolean canJump(int[] nums) {
		int n = nums.length;
		int rightmost = 0;
		for (int i = 0; i < n; i++) {
			if (i <= rightmost) {
				rightmost = Math.max(rightmost, i + nums[i]);
				if (rightmost >= n - 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = new int[] {2,0,0,0,0,5,5};
		System.out.println(canJump(a));
	}
}
