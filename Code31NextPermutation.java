import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/12/2 17:12
 */
public class Code31NextPermutation {

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
