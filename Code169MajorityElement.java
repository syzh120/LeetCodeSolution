/**
 * @Author: ybchen
 * @Date: 2021/9/26 18:56
 */
public class Code169MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int counter = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                //which means no candidate yet
                candidate = nums[i];
                counter = 1;
            } else if (nums[i] == candidate) {
                counter++;
            } else {
                counter--;
            }
        }
        return candidate;
    }
}
