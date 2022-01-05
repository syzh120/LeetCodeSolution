import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/9/28 9:47
 */
public class Code_MinPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process(grid, 0, 0, grid.length - 1, grid[0].length - 1, dp);
    }

    public static int process(int[][] grid, int curRow, int curCol, int destRow, int destCol, int[][] dp) {
        if (curRow >= grid.length || curCol >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (destRow == curRow && curCol == destCol) {
            return grid[destRow][destCol];
        }
        if (dp[curRow][curCol] != -1) return dp[curRow][curCol];
        int down = process(grid, curRow + 1, curCol, destRow, destCol, dp);
        int right = process(grid, curRow, curCol + 1, destRow, destCol, dp);
        dp[curRow][curCol] = Integer.MAX_VALUE;
        if (down != Integer.MAX_VALUE) {
            dp[curRow][curCol] = down + grid[curRow][curCol];
        }
        if (right != Integer.MAX_VALUE) {
            dp[curRow][curCol] = Math.min(dp[curRow][curCol], right + grid[curRow][curCol]);
        }
        return dp[curRow][curCol];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }


}
