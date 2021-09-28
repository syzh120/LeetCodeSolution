/**
 * @Author: ybchen
 * @Date: 2021/8/18 19:06
 */
public class Code376WiggleMaxLength {


    /**
     * dp[i][0]以nums[i]结尾且最后是递增的wiggle的最大长度
     * dp[i][1]以nums[i]结尾且最后是递减的wiggle的最大长度
     * Time Complexity O(N*N)
     *
     * @param nums
     * @return
     */
    public static int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        int result = 1;
        int[][] dp = new int[nums.length][2];
        dp[0] = new int[]{1, 1};
        for (int i = 2; i < dp.length; i++) {
            int temp1 = 0;
            int temp2 = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] > 0) {
                    temp1 = Math.max(temp1, dp[j][1]);
                    dp[i][0] = temp1 + 1;
                } else if (nums[i] - nums[j] < 0) {
                    temp2 = Math.max(temp2, dp[j][0]);
                    dp[i][1] = temp2 + 1;
                } else {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0]);
                    dp[i][1] = Math.max(dp[i][1], dp[j][1]);
                }

            }
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
        return result;
    }

    public static int process2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void testProcess(int maxTestTime) {
        for (int i = 0; i < maxTestTime; i++) {
            int[] nums = TestHelper.generateRandomArray(8, 5, 8);
            int res1 = wiggleMaxLength(nums);
            int res2 = process2(nums);
            if (res1 != res2) {
                System.out.println("nums1" + res1);
                System.out.println("nums2" + res2);
                System.out.println(TestHelper.printArray(nums));
                return;
            }
        }


    }


    public static void main(String[] args) {
        //
//        int[] arr = {7, 7, 5, 7};
//        System.out.println(process1(arr));
        testProcess(1000);

    }
}
