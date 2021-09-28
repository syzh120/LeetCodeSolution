/**
 * @Author: ybchen
 * @Date: 2021/8/17 18:25
 */
public class Code256MinCost {


    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][3];
        dp[0] = costs[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[costs.length - 1][2], Math.min(dp[costs.length - 1][0], dp[costs.length - 1][1]));
    }

    public static void main(String[] args) {
        //
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(minCost(costs));
    }
}
