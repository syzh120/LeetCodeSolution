import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/3/3 17:13
 */
public class Code198HouseRobber {

    public static int rob(int[] nums) {
        int[][] cache = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(cache[i], -1);
        int p1 = process(nums, 0, 0, cache);
        int p2 = process(nums, 0, 1, cache);
        return Math.max(p1, p2);
    }


    public static int process(int[] nums, int startIndex, int robFlag, int[][] cache) {
        if (startIndex >= nums.length) return 0;
        if (cache[startIndex][robFlag] != -1) return cache[startIndex][robFlag];
        int p1 = process(nums, startIndex + 1, 0, cache);
        int p2 = process(nums, startIndex + 1, 1, cache);
        cache[startIndex][robFlag] = robFlag == 0 ? p2 + nums[startIndex] : Math.max(p1, p2);
        return cache[startIndex][robFlag];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.print(rob(nums));
    }
}
