package algorithm.array.two;

public class Rotate {

	// 旋转图像
	// 旋转矩阵90度
	// 用两次翻转代替旋转
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// 水平翻转
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = temp;
			}
		}
		// 主对角线翻转
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
