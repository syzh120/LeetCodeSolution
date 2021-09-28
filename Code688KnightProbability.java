import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/8/17 18:41
 */
public class Code688KnightProbability {


    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n + 1][n + 1][k + 1];
        for (double[][] arr : dp) {
            for (double[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        return process(n, k, row, column, dp);
    }

    /**
     * @param N:棋盘大小
     * @param leftStep：剩余步数
     * @param curRow：当前所在的行
     * @param curColumn：当前所在的列
     * @return 在当前剩余 leftStep的情况下,有多少种跳法使得骑士停留在棋盘上
     */
    public static double process(int N, int leftStep, int curRow, int curColumn, double[][][] dp) {
        //当前已经在棋盘外,直接返回0种
        if (curRow < 0 || curRow >= N || curColumn < 0 || curColumn >= N) {
            return 0.0;
        }
        if (dp[curRow][curColumn][leftStep] != -1) {
            return dp[curRow][curColumn][leftStep];
        }
        if (leftStep == 0) {
            dp[curRow][curColumn][leftStep] = 1.0;
            return 1.0;
        }
        //分别算出往8个方向跳的数目
        double p1 = process(N, leftStep - 1, curRow + 1, curColumn + 2, dp);
        double p2 = process(N, leftStep - 1, curRow + 2, curColumn + 1, dp);
        double p3 = process(N, leftStep - 1, curRow + 1, curColumn - 2, dp);
        double p4 = process(N, leftStep - 1, curRow + 2, curColumn - 1, dp);
        double p5 = process(N, leftStep - 1, curRow - 1, curColumn + 2, dp);
        double p6 = process(N, leftStep - 1, curRow - 2, curColumn + 1, dp);
        double p7 = process(N, leftStep - 1, curRow - 1, curColumn - 2, dp);
        double p8 = process(N, leftStep - 1, curRow - 2, curColumn - 1, dp);
        dp[curRow][curColumn][leftStep] = (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8) / 8.0;
        return dp[curRow][curColumn][leftStep];
    }


    public static void main(String[] args) {

        System.out.println(knightProbability(8, 7, 6, 4));
    }
}
