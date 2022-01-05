/**
 * @Author: ybchen @Date: 2021/12/28 14:46
 */
public class Code650MinSteps {
    /**
     * 3-->3 4-->4 5-->5 6-->5
     *
     * @param n
     * @return
     */
    public static int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                }
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int n = 7;
        System.out.print(minSteps(n));

    }
}
