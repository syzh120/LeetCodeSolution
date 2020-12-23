import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/17 16:59
 */
public class Code78Subsets {


    /**
     * Given an integer array nums, return all possible subsets (the power set).
     *
     * <p>The solution set must not contain duplicate subsets.
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, 0, path, result);
        return result;
    }


    public static void dfs(int[] nums, boolean[] visited, int startIndex, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, i + 1, path, result);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
