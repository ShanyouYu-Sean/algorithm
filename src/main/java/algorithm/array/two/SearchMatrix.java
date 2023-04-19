package algorithm.array.two;

public class SearchMatrix {

	// 搜索二维矩阵
	// 完全升序的二维矩阵
	// 直接二分
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int low = 0, high = m * n - 1;
		while (low <= high) {
			int mid = (high - low) / 2 + low;
			int x = matrix[mid / n][mid % n];
			if (x < target) {
				low = mid + 1;
			} else if (x > target) {
				high = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

	// 搜索二维矩阵
	// 行升序，且列生序
	// 从右上角出发开始遍历
	// 每次都是向左数字会变小，向下数字会变大
	// 如果 target 的值大于当前值，那么就向下走。
	// 如果 target 的值小于当前值，那么就向左走。
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (target > matrix[row][col]) {
				row++;
			} else if (target < matrix[row][col]) {
				col--;
			} else {
				return true;
			}
		}
		return false;
	}


}
