/**
 * @Author: ybchen
 * @Date: 2020/12/25 13:23
 */
public class Code55JumpGame {

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index
     * of the array.
     *
     * <p>Each element in the array represents your maximum jump length at that position.
     *
     * <p>Determine if you are able to reach the last index.
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {

        int nextFastest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nextFastest < i) {
                return false;
            }
            nextFastest = Math.max(nums[i] + i, nextFastest);


        }
        return nextFastest >= nums.length - 1;
    }

    public static void main(String[] args) {
        //
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(canJump(arr));
    }
}
