/**
 * @Author: ybchen
 * @Date: 2020/12/3 17:04
 */
public class Code33SearchInRotatedSortedArray {


    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[0]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }

            }
        }
        if (nums[start] == target) {
            return start;
        }
        return nums[end] == target ? end : -1;

    }

    public static void main(String[] args) {

        int [] arr={1,3,5};
        int target=1;
        System.out.println(search(arr,target));
    }
}
