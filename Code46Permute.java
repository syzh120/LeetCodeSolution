import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen @Date: 2020/12/14 15:01
 */
public class Code46Permute {
    /**
     * Given an array nums of distinct integers, return all the possible permutations. You can return
     * the answer in any order.
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(result, path, nums, visited);
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result.toString());


    }
}
