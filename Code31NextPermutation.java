import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/12/2 17:12
 */
public class Code31NextPermutation {


    //实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//

    public static void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            reverseArr(nums, 0, nums.length - 1);
            return;
        }
        for (j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        swap(nums, i, j);
        reverseArr(nums, i + 1, nums.length - 1);
        return;

    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];

    }
    public  static  void reverseArr(int[] nums,int lo,int hi){
        while(lo<hi){
            swap(nums,lo++,hi--);
        }

    }

    public static void main(String[] args) {
        //2,1,3
        int[] nums={1,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
