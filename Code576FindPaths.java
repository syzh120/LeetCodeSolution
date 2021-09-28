/**
 * @Author: ybchen
 * @Date: 2021/8/19 16:31
 */
public class Code576FindPaths {

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        double[][][] dp = new double[m + 1][n + 1][maxMove + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < maxMove + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }

        }
        final int BASE = 1000000007;
        return (int) (process(m, n, maxMove, startRow, startColumn, dp) % BASE);
    }


    public static double process(int m, int n, int maxMove, int startRow, int startColumn, double[][][] dp) {
        if (maxMove < 0) {
            return 0;
        }
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 1;
        }
        if (maxMove == 0 && !(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] != -1) {
            return dp[startRow][startColumn][maxMove];
        }
        //in box and maxMove>=0
        double d1 = process(m, n, maxMove - 1, startRow + 1, startColumn, dp) % 1000000007;//下
        double d2 = process(m, n, maxMove - 1, startRow - 1, startColumn, dp) % 1000000007;//上
        double d3 = process(m, n, maxMove - 1, startRow, startColumn + 1, dp) % 1000000007;//右
        double d4 = process(m, n, maxMove - 1, startRow, startColumn - 1, dp) % 1000000007;//左
        dp[startRow][startColumn][maxMove] = d1 + d2 + d3 + d4;
        return d1 + d2 + d3 + d4;

    }

    public static int leetcodeAns(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCounts = 0;
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[i][j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0], k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dp[i + 1][j1][k1] = (dp[i + 1][j1][k1] + count) % MOD;
                            } else {
                                outCounts = (outCounts + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return outCounts;

    }

    public static void main(String[] args) {
        //
        int m = 36, n = 5, maxMove = 50, startRow = 15, startColumn = 3;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }
}
