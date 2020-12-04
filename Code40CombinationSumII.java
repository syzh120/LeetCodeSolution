import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/4 15:48
 */
public class Code40CombinationSumII {

    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all
     * unique combinations in candidates where the candidate numbers sum to target.
     *
     * <p>Each number in candidates may only be used once in the combination.
     *
     * <p>Note: The solution set must not contain duplicate combinations.
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(candidates, target, 0, path, result, visited);
        return result;
    }

    public static void dfs(
            int[] candidates,
            int target,
            int startIndex,
            List<Integer> path,
            List<List<Integer>> result,
            boolean[] visited
    ) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if ((i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) || target < 0) {
                continue;
            }
            visited[i] = true;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, path, result, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {

        //
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(arr, 8));
    }
}
