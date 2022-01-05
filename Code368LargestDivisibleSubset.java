import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2022/1/4 16:36
 */
public class Code368LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] helper = new int[nums.length];
        int maxIndex = 0;
        int maxSize = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            helper[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        helper[i] = j;
                    }
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        result.add(nums[maxIndex]);
        while (helper[maxIndex] != -1) {
            result.add(nums[helper[maxIndex]]);
            maxIndex = helper[maxIndex];

        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 9, 8};
        System.out.print(largestDivisibleSubset(nums));
    }
}
