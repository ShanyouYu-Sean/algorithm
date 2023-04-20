package algorithm.array.two;

public class LongestIncreasingPath {

	// 矩阵中的最长递增路径
	// 定义四个方向
	int[][] dirs = new int[][]{{-1,0}, {1,0},{0,-1},{0,1}};
	//定义一个数组用于缓存当前单元格的最长递增路径
	int[][] memo;
	int[][] matrix;
	int m, n;
	public int longestIncreasingPath(int[][] matrix) {
		this.matrix = matrix;
		m = matrix.length;
		n = matrix[0].length;
		memo = new int[m][n];

		int maxLen = 1;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				maxLen = Math.max(maxLen,dfs(i,j));
			}
		}
		return maxLen;
	}
	public int dfs(int i, int j){
		// memo是要做一个缓存,如果有值的话,就直接返回
		if(memo[i][j] != 0) return memo[i][j];
		//如果当前单元格是第一次被扫描到,则最长递增路径至少为1
		memo[i][j] = 1;
		//往四个方向遍历
		for(int[] dir : dirs){
			int x = dir[0] + i, y = dir[1] + j;
			if( x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
				// 每找到一个可以到达的位置 (x, y) 就需要将其计入路径长度中，即加 1
				memo[i][j] = Math.max(memo[i][j], dfs(x,y) + 1);
			}
		}
		return memo[i][j];
	}

}
