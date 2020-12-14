import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/14 15:15
 */
public class Code47PermuteUnique {

    /**
     * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(result, path, nums, visited);
        return result;

    }

    public static void dfs(
            List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(result, path, nums, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        //
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);


    }
}
