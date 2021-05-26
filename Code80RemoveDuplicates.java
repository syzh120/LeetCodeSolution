/**
 * @Author: ybchen
 * @Date: 2021/5/25 10:00
 */
public class Code80RemoveDuplicates {


    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        int left = 0;
        int right = left;
        int curIndex = left;
        while (right < nums.length) {
            int count = 0;
            while (right < nums.length && nums[right] == nums[left]) {
                right++;
                count++;
            }
            if (count >= 2) {
                nums[curIndex] = nums[left];
                nums[curIndex + 1] = nums[left];
                curIndex = curIndex + 2;
            } else {
                nums[curIndex] = nums[left];
                curIndex = curIndex + 1;
            }
            left = right;

        }


        return curIndex;
    }

    public static void main(String[] args) {
        //
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = removeDuplicates(arr);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(arr[i]);
        }
    }
}
