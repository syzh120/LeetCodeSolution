/**
 * @Author: ybchen
 * @Date: 2020/11/24 16:55
 */
public class Code27RemoveElement {


    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param val
     * @return
     */
     //approach 1:it costs much to copy and shift element even unnecessary.
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        return j ;
    }

    //approach 2:a better way to avoid the drawbacks the approach 1 has.
    public static int process(int[] nums, int val) {
        int n = nums.length - 1;
        int i = 0;
        while (i <= n) {
            if (nums[i] == val) {
                nums[i] = nums[n--];
            }else{
                i++;
            }
        }
        return i;
    }

}
