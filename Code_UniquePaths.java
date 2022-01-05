import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/9/28 10:45
 */
public class Code_UniquePaths {

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process(0, 0, m, n, dp);
    }

    public static int process(int sR, int sC, int m, int n, int[][] dp) {
        if (sR >= m || sC >= n) {
            return 0;
        }
        if (sR == m - 1 || sC == n - 1) {
            return 1;
        }
        if (dp[sR][sC] != -1) return dp[sR][sC];
        dp[sR][sC] = process(sR + 1, sC, m, n, dp) + process(sR, sC + 1, m, n, dp);
        return dp[sR][sC];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
