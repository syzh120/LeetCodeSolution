/**
 * @Author: ybchen
 * @Date: 2021/10/8 12:35
 */
public class Code486PredictTheWinner {

    public static boolean PredictTheWinner(int[] nums) {
        int[][] dp1 = new int[nums.length][nums.length];
        int[][] dp2 = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp1[i][j] = dp2[i][j] = -1;
            }
        }
        return firstHand(nums, 0, nums.length - 1, dp1, dp2) >= secondHand(nums, 0, nums.length - 1, dp1, dp2);
    }

    public static int firstHand(int[] nums, int lo, int hi, int[][] dp1, int[][] dp2) {
        if (lo == hi) {
            return nums[lo];
        }
        if (dp1[lo][hi] != -1) {
            return dp1[lo][hi];
        }
        dp1[lo][hi] = Math.max(secondHand(nums, lo, hi - 1, dp1, dp2) + nums[hi], secondHand(nums, lo + 1, hi, dp1, dp2) + nums[lo]);
        return dp1[lo][hi];
    }

    public static int secondHand(int[] nums, int lo, int hi, int[][] dp1, int[][] dp2) {
        if (lo == hi) {
            return 0;
        }
        if (dp2[lo][hi] != -1) {
            return dp2[lo][hi];
        }
        dp2[lo][hi] = Math.min(firstHand(nums, lo, hi - 1, dp1, dp2), firstHand(nums, lo + 1, hi, dp1, dp2));
        return dp2[lo][hi];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.print(PredictTheWinner(nums));
    }
}
