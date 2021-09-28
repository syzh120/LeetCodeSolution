import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/9/28 9:01
 */
public class CodeCombinationSum4 {

    public static int combinationSum4(int[] nums, int target) {
        if (target < 0) return 0;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return process(nums, target, dp);
    }

    public static int process(int[] nums, int target, int[] dp) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int result = 0;
        for (int num : nums) {
            result = result + process(nums, target - num, dp);
        }
        dp[target] = result;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
}
