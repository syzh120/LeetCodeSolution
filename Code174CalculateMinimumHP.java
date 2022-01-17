import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/8/16 10:50
 */
public class Code174CalculateMinimumHP {

    /**
     * 递归法
     *
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 2][dungeon[0].length + 2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -2);
        }
        return process(dungeon, 0, 0, dungeon.length, dungeon[0].length, dp);

    }

    public static int process(int[][] arr, int curM, int curN, int M, int N, int[][] dp) {
        if (curM >= M || curN >= N) {
            return -1;
        }
        if (dp[curM][curN] != -2) {
            return dp[curM][curN];
        }
        if (curM == M - 1 && curN == N - 1) {
            dp[curM][curN] = arr[curM][curN] >= 0 ? 1 : 1 - arr[curM][curN];
            return dp[curM][curN];
        }
        int goDown = process(arr, curM + 1, curN, M, N, dp);
        int goRight = process(arr, curM, curN + 1, M, N, dp);
        int temp = Integer.MAX_VALUE;
        if (goDown != -1) {
            temp = Math.min(temp, goDown);
        }
        if (goRight != -1) {
            temp = Math.min(temp, goRight);
        }
        dp[curM][curN] = temp - arr[curM][curN] <= 1 ? 1 : temp - arr[curM][curN];
        return dp[curM][curN];
    }

    /**
     * 动态规划法
     *
     * @param matrix
     * @return
     */
    public static int dpWays(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = matrix[row - 1][col - 1] >= 0 ? 1 : 1 - matrix[row - 1][col - 1];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    continue;
                }
                int goDown = i >= row - 1 ? -1 : dp[i + 1][j];
                int goRight = j >= col - 1 ? -1 : dp[i][j + 1];
                int min = Integer.MAX_VALUE;
                if (goDown != -1) {
                    min = Math.min(min, goDown);
                }
                if (goRight != -1) {
                    min = Math.min(min, goRight);
                }
                dp[i][j] = min - matrix[i][j] <= 1 ? 1 : min - matrix[i][j];
            }
        }
        return dp[0][0];

    }


    public static void main(String[] args) {
        //

        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}};
        int[][] d2 = {{2, 1}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
