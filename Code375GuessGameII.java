import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/8/16 19:05
 */
public class Code375GuessGameII {

    public static int getMoneyAmount(int n) {

        int[][] dp = new int[n + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return process1(1, n);
    }

    public static int process(int leftNum, int rightNumber, int[][] dp) {
        if (leftNum >= rightNumber) {
            return 0;
        }
        if (dp[leftNum][rightNumber] != -1) {
            return dp[leftNum][rightNumber];
        }
        int result = Integer.MAX_VALUE;
        for (int i = leftNum; i <= rightNumber; i++) {
            int left = process(leftNum, i - 1, dp);
            int right = process(i + 1, rightNumber, dp);
            int answer = Math.max(left, right) + i;
            result = Math.min(result, answer);

        }
        dp[leftNum][rightNumber] = result;
        return result;
    }

    public static int process1(int leftNum, int rightNumber) {
        if (leftNum >= rightNumber) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = leftNum; i <= rightNumber; i++) {
            int left = process1(leftNum, i - 1);
            int right = process1(i + 1, rightNumber);
            int answer = Math.max(left, right) + i;
            result = Math.min(result, answer);
        }

        return result;
    }


    public static void main(String[] args) {

        long sT = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            getMoneyAmount(10);
        }
        long eT = System.currentTimeMillis();
        System.out.println((eT - sT));
    }


}
