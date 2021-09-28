/**
 * @Author: ybchen
 * @Date: 2021/8/24 11:52
 */
public class Code312MaxCoins {

    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        int[] newNumbers = new int[nums.length + 2];
        for (int i = 1; i < newNumbers.length - 1; i++) {
            newNumbers[i] = nums[i - 1];
        }
        newNumbers[0] = 1;
        newNumbers[newNumbers.length - 1] = 1;
        return process(newNumbers, 0, newNumbers.length - 1, dp);

    }

    public static int process(int[] nums, int lo, int hi, int[][] dp) {
        if (lo == hi) {
            return nums[lo] * nums[lo + 1] * nums[hi];
        }
        if (dp[lo][hi] != -1) {
            return dp[lo][hi];
        }
        int maxValue = 0;
        for (int i = lo + 1; i < hi; i++) {
            int current = nums[i];
            int leftSum = process(nums, lo, i, dp);
            int rightSum = process(nums, i, hi, dp);
            int curSum = nums[lo] * current * nums[hi];
            maxValue = Math.max(curSum + leftSum + rightSum, maxValue);
        }
        dp[lo][hi] = maxValue;
        return maxValue;
    }

    public static void main(String[] args) {
        //
        int[] arr = {3, 1, 5, 8};
        System.out.println(maxCoins(arr));
    }
}
