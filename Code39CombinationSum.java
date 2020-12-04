import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/4 14:54
 */
public class Code39CombinationSum {

    /**
     * Given an array of distinct integers candidates and a target integer target, return a list of
     * all unique combinations of candidates where the chosen numbers sum to target. You may return
     * the combinations in any order.
     *
     * <p>The same number may be chosen from candidates an unlimited number of times. Two combinations
     * are unique if the frequency of at least one of the chosen numbers is different.
     *
     * <p>It is guaranteed that the number of unique combinations that sum up to target is less than
     * 150 combinations for the given input.
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, path, result);
        return result;
    }


    public static void dfs(
            int[] candidates,
            int target,
            int startIndex,
            List<Integer> path,
            List<List<Integer>> result
    ) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }
}
