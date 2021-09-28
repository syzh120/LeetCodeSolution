import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/8/18 14:42
 */
public class Code313NthSuperUglyNumber {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int result = process(primes, n);
        return result;
    }

    public static int process(int[] primes, int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);
        for (int i = 2; i < n + 1; i++) {
            int[] nums = new int[primes.length];
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < pointers.length; j++) {
                nums[j] = primes[j] * dp[pointers[j]];
                dp[i] = Math.min(dp[i], nums[j]);
            }
            for (int j = 0; j < pointers.length; j++) {
                if (nums[j] == dp[i]) {
                    pointers[j] = pointers[j] + 1;
                }
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = {2, 7};
        System.out.println(nthSuperUglyNumber(10, arr));
    }
}
