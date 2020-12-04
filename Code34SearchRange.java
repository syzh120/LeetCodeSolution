/**
 * @Author: ybchen
 * @Date: 2020/12/4 9:58
 */
public class Code34SearchRange {
    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * Follow up: Could you write an algorithm with O(log n) runtime complexity?
     * @param nums
     * @param target
     * @return
     */

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstIndex = getFirstIndex(nums, target, 0, nums.length - 1);
        int lastIndex = getLastIndex(nums, target, 0, nums.length - 1);
        return new int[]{firstIndex, lastIndex};
    }

    public int getFirstIndex(int[] nums, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        if (nums[start] == target) {
            return start;
        }
        return nums[end] == target ? end : -1;
    }


    public int getLastIndex(int[] nums, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        if (nums[end] == target) {
            return end;
        }
        return nums[start] == target ? start : -1;
    }
}
