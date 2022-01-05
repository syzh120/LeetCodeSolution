import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/10/14 16:02
 */
public class Code1043MaxSumAfterPartitioning {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] rangeSumDP = getRangeSum(arr);
        int[] cache = new int[arr.length + 1];
        Arrays.fill(cache, -1);
        return process(arr, 0, k, rangeSumDP, cache);
    }


    public static int[][] getRangeSum(int[] arr) {
        int row = arr.length;
        int[][] dp = new int[row][row];
        for (int i = 0; i < row; i++) {
            dp[i][i] = arr[i];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = i + 1; j < row; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], arr[i]);
            }
        }
        return dp;
    }


    public static int process(int[] arr, int startIndex, int k, int[][] rangeSumDP, int[] cache) {
        if (startIndex >= arr.length) {
            return 0;
        }
        if (cache[startIndex] != -1) return cache[startIndex];
        int max = 0;
        for (int count = 1; count <= k; count++) {
            if (startIndex + count - 1 >= arr.length) continue;
            int rangeSum = rangeSumDP[startIndex][startIndex + count - 1] * count;
            int next = process(arr, startIndex + count, k, rangeSumDP, cache);
            max = Math.max(max, rangeSum + next);
        }
        cache[startIndex] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        System.out.print(maxSumAfterPartitioning(arr, k));
    }
}
