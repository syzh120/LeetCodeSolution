/**
 * @Author: ybchen
 * @Date: 2020/12/4 10:38
 */
public class Code35SearchInsert {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * @param nums
     * @param target
     * @return
     */

    public static int searchInsert(int[] nums, int target) {
        int lastIndex = getLastIndex(nums, target, 0, nums.length - 1);
        if (lastIndex != -1 && nums[lastIndex] == target) {
            return lastIndex;
        }
        return lastIndex + 1;
    }



    public static int getLastIndex(int[] nums, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else  {
                end = mid - 1;
            }

        }
        if (nums[end] <= target) {
            return end;
        }
        return nums[start] <= target ? start : -1;
    }

    public static void main(String[] args) {
        int[] arr={1,3,5};
        int target=4;
        System.out.println(searchInsert(arr,target));

    }


}
