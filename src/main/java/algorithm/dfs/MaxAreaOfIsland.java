package algorithm.dfs;

public class MaxAreaOfIsland {
	// 岛屿面积
	public int maxAreaOfIsland(int[][] grid) {
		//定义一个表示岛屿的面积
		int max = 0;
		//两个for循环是来遍历整张二维数组
		for(int i = 0;i<grid.length;i++){
			for(int j = 0; j<grid[0].length;j++){
				//陆地的格
				if(grid[i][j]==1){
					//取出最大的面积
					max = Math.max(max,dfs(grid,i,j));
				}
			}
		}
		//返回最大的陆地面积
		return max;
	}
	public int  dfs(int[][] grid,int i,int j){
		// 当超出岛屿边界（上下左右）的时候，就直接退出，
		// 特别要加上当遍历到海洋的时候也要退出
		if( i<0 || j<0
				|| i >= grid.length || j>= grid[0].length
				|| grid[i][j]==0){
			return 0;
		}
		//定义一个变量表示岛屿的面积，就是包含几个陆地
		int sum = 1;
		//将陆地改为海洋，防止重复陆地重复遍历。
		grid[i][j] =0;
		//遍历上下左右元素，每遍历一次陆地就加一
		sum += dfs(grid,i+1,j);
		sum += dfs(grid,i-1,j);
		sum += dfs(grid,i,j+1);
		sum += dfs(grid,i,j-1);
		return sum;
	}
}
