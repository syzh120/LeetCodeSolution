/**
 * @Author: ybchen
 * @Date: 2021/8/19 15:23
 */
public class Code494FindTargetSumWays {

    public static int findTargetSumWays(int[] nums, int target) {

        return process(nums, 0, nums.length - 1, target);
    }

    public static int process(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return target == 0 ? 1 : 0;
        }
        return process(nums, lo + 1, hi, target - nums[lo]) + process(nums, lo + 1, hi, target + nums[lo]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));

    }
}
