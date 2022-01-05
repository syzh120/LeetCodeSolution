/**
 * @Author: ybchen
 * @Date: 2021/12/30 10:24
 */
public class Code357CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 9;
        int sum = 10;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] * (11 - i);
            sum = sum + dp[i];
        }
        return sum;
    }
}
