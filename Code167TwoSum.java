/**
 * @Author: ybchen
 * @Date: 2021/6/22 10:21
 */
public class Code167TwoSum {
    /**
     * @param numbers:有序数组
     * @param target
     * @return
     */

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
