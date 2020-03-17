package leetcode.MinimumPathSum;

public class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1,3,1} , {1,5,1} , {4,2,1}};
        System.out.println(solution.minPathSum(a));
        a = null;
        System.out.println(solution.minPathSum(a));
        int[][] b = {};
        System.out.println(solution.minPathSum(b));
        int[][] c = {{}};
        System.out.println(solution.minPathSum(c));
        int[][] d = {{1,2,3}};
        System.out.println(solution.minPathSum(d));
        int[][] e = {{1}, {2}, {3}};
        System.out.println(solution.minPathSum(e));
    }
}


class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] pathSum = new int[row][col];
        for (int i = 0;i < row; i++) {
            for (int j = 0;j < col; j++) {
                if (i == 0 && j == 0) {
                    pathSum[i][j] = grid[i][j];
                } else if (i == 0) {
                    pathSum[i][j] = pathSum[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    pathSum[i][j] = pathSum[i - 1][j] + grid[i][j];
                } else {
                    int minPath = pathSum[i - 1][j] < pathSum[i][j - 1] ? pathSum[i - 1][j] : pathSum[i][j - 1];
                    pathSum[i][j] = grid[i][j] + minPath;
                }
            }
        }
        return pathSum[row - 1][col - 1];
    }
}