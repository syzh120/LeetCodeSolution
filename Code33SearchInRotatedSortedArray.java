/**
 * @Author: ybchen
 * @Date: 2020/12/3 17:04
 */
public class Code33SearchInRotatedSortedArray {


    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int splitPoint = start + (end - start) / 2;
            if (nums[splitPoint] == target) {
                return splitPoint;
            }
            if (isSplitInLeft(nums, splitPoint)) {
                if (target >= nums[start] && target < nums[splitPoint]) {
                    end = splitPoint;
                } else {
                    start = splitPoint;
                }
            } else {
                if (target > nums[splitPoint] && target <= nums[end]) {
                    start = splitPoint;
                } else {
                    end = splitPoint;
                }

            }
        }
        if (nums[start] == target) {
            return start;
        }
        return nums[end] == target ? end : -1;

    }


    public static boolean isSplitInLeft(int[] arr, int splitPoint) {
        return arr[splitPoint] > arr[0];
    }


    static void main(String[] args) {

        int [] arr={1,3,5};
        int target=1;
        System.out.println(search(arr,target));
    }
}
