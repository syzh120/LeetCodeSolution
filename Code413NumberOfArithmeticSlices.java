/**
 * @Author: ybchen
 * @Date: 2021/8/20 16:25
 */
public class Code413NumberOfArithmeticSlices {


    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[2] = isArithmeticSeq(nums, 0, 2) ? 1 : 0;
        int result = dp[2];
        for (int i = 3; i < nums.length; i++) {
            if (isArithmeticSeq(nums, i - 2, i)) {
                //1.看dp[i-1]是多少 如果不为0 那么 再用startIndex:i-1-dp[i-1]-1;
                // i-1-startIndex
                dp[i] = dp[i - 1] + 1;
                result = result + dp[i];
            }
        }

        return result;
    }

    public static boolean isArithmeticSeq(int[] nums, int left, int right) {
        return nums[right] - nums[right - 1] == nums[right - 1] - nums[left];
    }

    public static void main(String[] args) {
        //
        int[] arr = {1, 2, 3, 4, 5, 7, 10, 11, 13, 15, 17, 19, 20, 15};
        System.out.println(numberOfArithmeticSlices(arr));
    }
}
