package leetcode.UniquePathsII;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(grid1));

        int[][] grid2 = {};
        System.out.println(solution.uniquePathsWithObstacles(grid2));

        int[][] grid3 = {{0,1,0}};
        System.out.println(solution.uniquePathsWithObstacles(grid3));

        int[][] grid4 = {{0},{1},{0}};
        System.out.println(solution.uniquePathsWithObstacles(grid4));

        int[][] grid5 = {{1}};
        System.out.println(solution.uniquePathsWithObstacles(grid5));
    }

}



class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1) {
            return 0;
        }
        int[][] gridPathCount = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                // set left-top corner
                if (i == 0 && j == 0) {
                    gridPathCount[i][j] = obstacleGrid[i][j] ^ 1;
                    continue;
                }
                // if obstacle, set path count 0
                if (obstacleGrid[i][j] == 1) {
                    gridPathCount[i][j] = 0;
                    continue;
                }
                // left side
                if (j == 0) {
                    gridPathCount[i][j] = gridPathCount[i - 1][j];
                    continue;
                }
                // top side
                if (i == 0) {
                    gridPathCount[i][j] = gridPathCount[i][j - 1];
                    continue;
                }
                gridPathCount[i][j] = gridPathCount[i - 1][j] + gridPathCount[i][j - 1];
            }
        }
        return gridPathCount[gridPathCount.length - 1][gridPathCount[0].length - 1];
    }
}