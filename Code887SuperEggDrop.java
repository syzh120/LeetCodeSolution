/**
 * @Author: ybchen
 * @Date: 2021/8/9 18:18
 */
public class Code887SuperEggDrop {

    //此处K>0,N>=0
    // k枚鸡蛋 n层楼
    // dp[i][j]代表i枚鸡蛋在j层楼的情况下实验，得到的结果 故所求答案为dp[k][n]
    // 那么 dp[i][j]==min{ 0<= k<=j  max{dp[i][n-k],dp[i-1][k-1]} }
    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][l - 1], dp[i][j - l]) + 1);
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        int k = 1, n = 2;
        System.out.println(superEggDrop(k, n));
    }
}
