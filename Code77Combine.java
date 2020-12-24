import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/24 15:32
 */
public class Code77Combine {

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     *
     * <p>You may return the answer in any order.
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, n, k, 1);
        return result;

    }

    public static void dfs(List<List<Integer>> result, List<Integer> path, int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            dfs(result, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
