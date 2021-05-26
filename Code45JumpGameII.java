/**
 * @Author: ybchen
 * @Date: 2020/12/15 12:31
 */
public class Code45JumpGameII {

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index
     * of the array.
     *
     * <p>Each element in the array represents your maximum jump length at that position.
     *
     * <p>Your goal is to reach the last index in the minimum number of jumps.
     *
     * <p>You can assume that you can always reach the last index.
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int result = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur < i) {
                result++;
                cur = next;
            }
            next = Math.max(nums[i] + i, next);

        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
