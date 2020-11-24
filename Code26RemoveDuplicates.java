import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/11/19 15:02
 */
public class Code26RemoveDuplicates {


    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */

    private static int removeDuplicates(int[] nums) {
        int L = 0;
        int R = L + 1;
        while (R < nums.length) {
            while (R < nums.length && nums[L] == nums[R]) {
                R++;
            }
            if (R >= nums.length) {
                return L + 1;
            } else {
                nums[++L]=nums[R];

            }
        }
        return 1;
    }
    /**
     * 请保证 arr[i] arr[j]不指向同一内存区域
     * @param arr
     * @param i
     * @param j
     */

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int res=removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }





}
