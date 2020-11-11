import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/11/11 10:36
 */
public class Code16ThreeSumClosest {


    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案
     *示例：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * two pointer approach O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int maxGap = Integer.MAX_VALUE;
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int gap = Math.abs(sum - target);
                if(gap<maxGap){
                    maxGap=gap;
                    result=sum;
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }

    /**
     * brute force approach O(N^3)
     * @param nums
     * @param target
     * @return
     */

    public int threeSumClosest(int[] nums, int target) {

        int maxGap = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int gap = Math.abs(sum - target);
                    if (gap < maxGap) {
                        maxGap = gap;
                        result = sum;
                        if (maxGap == 0) {
                            return sum;
                        }
                    }
                }

            }

        }

        return result;
    }


}
