import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/7/8 16:56
 */
public class Code90SubSetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
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
