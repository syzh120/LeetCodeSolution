import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/8/19 9:40
 */
public class TestHelper {


    public static int[] generateRandomArray(int length, int minValue, int maxValue) {
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * (maxValue - minValue) + minValue);
        }

        return nums;
    }


    public static String printArray(int[] nums) {
        return Arrays.toString(nums);
    }


}
