/**
 * @Author: ybchen
 * @Date: 2021/10/14 14:56
 */
public class Code416CanPartition {

    //分割等和子集
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % 2 != 0) return false;
        Boolean[][] cache = new Boolean[nums.length][sum / 2 + 1];
        return process(nums, 0, sum / 2, cache);
    }


    public static boolean process(int[] nums, int index, int target, Boolean[][] cache) {
        if (target < 0) return false;
        if (index >= nums.length) {
            return target == 0;
        }
        if (cache[index][target] != null) return cache[index][target];
        boolean notChoose = process(nums, index + 1, target, cache);
        boolean choose = process(nums, index + 1, target - nums[index], cache);
        cache[index][target] = notChoose || choose;
        return cache[index][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.print(canPartition(nums));
    }
}
