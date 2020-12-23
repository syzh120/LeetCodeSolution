/**
 * @Author: ybchen
 * @Date: 2020/12/23 14:03
 */
public class Code53MaxSubArray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which
     * has the largest sum and return its sum.
     *
     * <p>Follow up: If you have figured out the O(n) solution, try coding another solution using the
     * divide and conquer approach, which is more subtle.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int curSum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum = curSum + nums[i];
            result = Math.max(result, curSum);
            if (curSum < 0) {
                curSum = 0;
            }

        }
        return result;
    }
}
