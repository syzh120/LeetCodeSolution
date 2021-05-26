/**
 * @Author: ybchen
 * @Date: 2021/4/1 14:02
 */
public class Code81SearchInRotatedSortedArrayII {

    /**
     * 搜索旋转数组
     *
     * @param nums
     * @param target
     * @return
     */
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (isSplitInLeft(nums, mid)) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] == nums[start]) {
                start = start + 1;
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

        }
        return nums[start] == target || nums[end] == target;
    }

    public static boolean isSplitInLeft(int[] nums, int splitPoint) {
        return nums[splitPoint] > nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1};
        System.out.println(search(arr, 0));
    }
}
