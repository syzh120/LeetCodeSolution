import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2021/3/11 18:38
 */
public class Code113PathSumII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        process(result, path, root, targetSum);
        return result;
    }

    public static void process(List<List<Integer>> result, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);

        }
        path.add(root.val);
        process(result, path, root.left, targetSum - root.val);
        process(result, path, root.right, targetSum - root.val);
        path.remove(path.size() - 1);

    }


}
