/**
 * @Author: ybchen
 * @Date: 2021/9/27 15:42
 */
public class Code1911MaxAlternatingSum {


    public static long maxAlternatingSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[][] dp = new long[nums.length][2];
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = nums[0];
        //dp[i][0]:0...i中取偶数个元素的子序列的最大值
        //dp[i][1]:0...i中取奇数个元素的子序列的最大值
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][1], nums[i]), dp[i - 1][0] + nums[i]);
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 1, 2, 4, 5};
        System.out.println(maxAlternatingSum(arr));

    }
}
