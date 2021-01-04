/**
 * @Author: ybchen
 * @Date: 2020/12/29 18:28
 */
public class Code63UniquePathsII {
    private static final int UNREACHED = 1;

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram
     * below).
     *
     * <p>The robot can only move either down or right at any point in time. The robot is trying to
     * reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     *
     * <p>Now consider if some obstacles are added to the grids. How many unique paths would there be?
     *
     * <p>An obstacle and space is marked as 1 and 0 respectively in the grid.
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == UNREACHED || obstacleGrid[row - 1][column - 1] == UNREACHED) {
            return 0;
        }
        int[][] dp = new int[row][column];
        dp[0][0] = 1;
        for (int i = 1; i < column; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] != UNREACHED) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][column - 1];
    }


}
