/**
 * @Author: ybchen
 * @Date: 2020/12/17 15:57
 */
public class Code75SortColors {

    /**
     * 75. Sort Colors Medium
     *
     * <p>Share Given an array nums with n objects colored red, white, or blue, sort them in-place so
     * that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     *
     * <p>Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
     * respectively.
     *
     * <p>Follow up:
     *
     * <p>Could you solve this problem without using the library's sort function? Could you come up
     * with a one-pass algorithm using only O(1) constant space?
     *
     * @param nums
     */
    //快排的三向切分算法。
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        final int target = 1;
        int LRB = -1; // 小于区域右边界;
        int MLB = nums.length;//大于区域左边界
        for (int i = 0; i < MLB; i++) {
            if (nums[i] > target) {
                continue;
            } else if (nums[i] < target) {
                swap(nums, i, ++LRB);
            } else {
                swap(nums, i--, --MLB);
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
