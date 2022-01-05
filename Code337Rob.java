/**
 * @Author: ybchen
 * @Date: 2022/1/4 15:49
 */
public class Code337Rob {

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

    public int rob(TreeNode root) {
        ReturnInfo info = process(root);
        return Math.max(info.includeMax, info.excludeMax);
    }

    public class ReturnInfo {
        int includeMax;
        int excludeMax;

        public ReturnInfo(int includeMax, int excludeMax) {
            this.includeMax = includeMax;
            this.excludeMax = excludeMax;
        }
    }

    public ReturnInfo process(TreeNode root) {
        if (root == null) {
            return new ReturnInfo(0, 0);
        }
        ReturnInfo leftInfo = process(root.left);
        ReturnInfo rightInfo = process(root.right);
        int include = root.val + leftInfo.excludeMax + rightInfo.excludeMax;
        int exclude = Math.max(leftInfo.includeMax, leftInfo.excludeMax) + Math.max(rightInfo.includeMax, rightInfo.excludeMax);
        return new ReturnInfo(include, exclude);
    }


}
