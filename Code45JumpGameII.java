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
        if (nums.length <= 1) return 0;
        int R = 0;
        int result = 1;
        int curFastest = 0;
        int stepIndex = 0;
        int curIndex = 0;
        int step = 1;
        while (curIndex < nums.length) {
            while (step <= nums[curIndex]) {
                if (step + R + nums[R + step] > curFastest) {
                    stepIndex = R + step;
                    curFastest = step + nums[R + step] + R;
                }
                if (curFastest >= nums.length - 1 && R == 0 && step == 1) {
                    return result;
                }
                if (curFastest >= nums.length - 1) {
                    return result + 1;
                }
                step++;
            }
            result = result + 1;
            curIndex = stepIndex;
            curFastest = 0;
            R = curIndex;
            step = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
