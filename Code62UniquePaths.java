/**
 * @Author: ybchen
 * @Date: 2020/12/29 16:41
 */
public class Code62UniquePaths {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram
     * below).
     *
     * <p>The robot can only move either down or right at any point in time. The robot is trying to
     * reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     *
     * <p>How many possible unique paths are there?
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
