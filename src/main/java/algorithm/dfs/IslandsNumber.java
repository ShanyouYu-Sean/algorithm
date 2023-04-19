package algorithm.dfs;

/**
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 */
public class IslandsNumber {

    // 岛屿数量
    public int numIslands(char[][] grid) {
        //定义一个表示岛屿的数量
        int count = 0;
        //两个for循环是来遍历整张二维数组
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // 岛屿
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        // 当超出岛屿边界（上下左右）的时候，就直接退出，
        // 特别要加上当遍历到海洋的时候也要退出
        if(i < 0 || j < 0
                || i >= grid.length || j >= grid[0].length
                || grid[i][j] == '0') {
            return;
        }
        //将岛屿改为海洋，防止重复陆地重复遍历。
        grid[i][j] = '0';
        //遍历上下左右元素
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
