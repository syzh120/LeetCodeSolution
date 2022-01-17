import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2022/1/7 14:24
 */
public class Code95GenerateTrees {


    public static class TreeNode {
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


    public static List<TreeNode> process(int startIndex, int endIndex) {
        List<TreeNode> result = new ArrayList<>();
        if (startIndex > endIndex) {
            result.add(null);
            return result;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            List<TreeNode> leftResult = process(startIndex, i - 1);
            List<TreeNode> rightResult = process(i + 1, endIndex);
            for (TreeNode l : leftResult) {
                for (TreeNode r : rightResult) {
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = l;
                    curRoot.right = r;
                    result.add(curRoot);
                }
            }
        }
        return result;
    }


    public static List<TreeNode> generateTrees(int n) {
        return process(1, n);
    }
}
