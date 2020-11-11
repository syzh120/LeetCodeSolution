import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/11/9 18:23
 */
public class Code15ThreeSum {

    /**
     *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        process(nums, 0, path, resList, visited, 0);
        return resList;
    }

    /**
     * brute force backtrace way:Time Limit Exceed
     * @param nums
     * @param startIndex
     * @param path
     * @param resList
     * @param visited
     * @param res
     */
    public static void process(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> resList, boolean[] visited, int res) {
        for (int i = startIndex; i < nums.length; i++) {

            if(visited[i]==true){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i-1] == false) {
                continue;
            }
            if(path.size()>3) continue;
            visited[i] = true;
            res += nums[i];
            path.add(nums[i]);
            if (path.size() == 3 && res == 0) {
                resList.add(new ArrayList<>(path));// deep copy
            }
            process(nums, i + 1, path, resList, visited, res);
            res = res - nums[i];
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }


    /**
     * sort and two pointer a better way than the previous brute force backtrack solution
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    resList.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]}));
                    j++;
                    k--;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
        }
        return resList;
    }




}
