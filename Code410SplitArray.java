/**
 * @Author: ybchen
 * @Date: 2021/8/9 11:16
 */
public class Code410SplitArray {
    /**
     * 方法一：二分法
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, nums[i]);
        }
        int left = max;
        int right = sum;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (copy(nums, mid) <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return copy(nums, left) <= m ? left : right;

    }


    public static int copy(int[] nums, int curValue) {
        int result = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum + nums[i] > curValue) {
                result++;
                curSum = nums[i];
            } else {
                curSum = curSum + nums[i];
            }
        }
        return result + 1;
    }
    //首先将dp[i][j]定义为数组的前i个元素分j段子数组和中最大的最小的取值。所以题目所求即为dp[arr.length][m]
    //因为要把整个数组切分为m段,我们把目光着眼于最后一段是怎么来的，也就是着眼于最后一个切分点k在哪里。
    //显然最后一个切分点所在的位置需要满足如下条件：1.至少保证最后一段有一个元素，2.至少保证前面的m-1段中各段至少有一个元素。
    //那么dp[i][j]==min(max(dp[i-k][j-1],sum(i-k+1,j)){k=1,2....i-j+1};

    /**
     * @param arr
     * @param m
     * @return
     */
    public static int process(int[] arr, int m) {
        int[] prefixSumTable = getPrefixSum(arr);
        int row = arr.length + 1;
        int col = m + 1;
        //dp[i][j]代表前i摞书 j个人抄写需要的最少时间
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][1] = prefixSumTable[i - 1];
        }
        for (int i = 2; i < row; i++) {
            for (int j = 2; j <= i && j < col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= i - (j - 1); k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - k][j - 1], prefixSumTable[i - 1] - prefixSumTable[i - k - 1]));
                }
            }
        }
        return dp[row - 1][col - 1];
    }


    public static int[] getPrefixSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = arr[i] + dp[i - 1];
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 8, 1, 4};
        int m = 4;
        System.out.println(process(nums, m));
    }
}
