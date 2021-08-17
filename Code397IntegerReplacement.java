import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/8/17 9:32
 */
public class Code397IntegerReplacement {

    /**
     * @param n
     * @return
     * @Description 本题相当奇葩, 传统的暴力递归改写成动态规划的优化技巧是会TLE的, 加入memo的方法也是会TLE, 而且二者的执行效率差不多
     * 反之，采用最朴素的解法可以解答。
     * @seealso bruteForceWays
     */

    public static int integerReplacement(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return process(n, dp);
    }


    public static int process(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == Integer.MAX_VALUE) {
            dp[n] = 32;
            return dp[n];
        }
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            dp[n] = process(n / 2, dp) + 1;
            return dp[n];
        } else {
            dp[n] = Math.min(process((n + 1) / 2, dp), process((n - 1) / 2, dp)) + 2;
            return dp[n];
        }

    }

    public static int dpWays(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + dp[i / 2];
            } else {
                dp[i] = Math.min(dp[(i + 1) / 2], dp[(i - 1) / 2]) + 2;
            }
        }
        return dp[n];
    }


    public static int bruteForceWays(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            return 32;
        } else if (n % 2 == 0) {
            return bruteForceWays(n / 2);
        }
        return 1 + Math.min(bruteForceWays(n + 1), bruteForceWays(n - 1));
    }


    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            boolean flag = dpWays(i) == integerReplacement(i);
            if (!flag) {
                System.out.println("ooops failed");
            }

        }
    }
}
