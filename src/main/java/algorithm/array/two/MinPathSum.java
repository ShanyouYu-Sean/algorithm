package algorithm.array.two;

public class MinPathSum {

	// 最小路径和
	// 设dp为大小m×n矩阵，其中 dp[i,j]的值代表直到走到(i,j)的最小路径和。
	// 题目要求，只能向右或向下走，
	// 当前单元格(i,j)只能从左方单元格(i−1,j)或上方单元格(i,j−1)走到.
	// 当左边和上边都不是矩阵边界时：
	// 即当i≠0,j≠0时，dp[i,j]=min(dp[i−1,j],dp[i,j−1])+grid[i][j];
	// 当只有左边是矩阵边界时：
	// 只能从上面来，即当i=0,j≠0时,dp[i,j]=dp[i,j−1]+grid[i][j];
	// 当只有上边是矩阵边界时：
	// 只能从左面来，即当i≠0,j=0时,dp[i,j]=dp[i−1,j]+grid[i][j];
	// 当左边和上边都是矩阵边界时：
	// 即当i=0,j=0时，其实就是起点， dp[i][j]=grid[i][j];
	public int minPathSum(int[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(i == 0 && j == 0) continue;
				else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
				else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
				else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

}
