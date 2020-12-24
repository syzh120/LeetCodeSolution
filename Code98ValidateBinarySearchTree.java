/**
 * @Author: ybchen
 * @Date: 2020/12/24 14:52
 */
public class Code98ValidateBinarySearchTree {

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

    public boolean isValidBST(TreeNode root) {
        return process(root).isBst;
    }

    public class ReturnType {
        long max;
        long min;
        boolean isBst;

        public ReturnType(long max, long min, boolean isBst) {
            this.max = max;
            this.min = min;
            this.isBst = isBst;
        }
    }

    public ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(Long.MIN_VALUE, Long.MAX_VALUE, true);
        }
        ReturnType leftInfo = process(root.left);
        ReturnType rightInfo = process(root.right);
        long min = Math.min(Math.min(leftInfo.min, rightInfo.min), root.val);
        long max = Math.max(Math.max(leftInfo.max, rightInfo.max), root.val);
        boolean isBst = leftInfo.isBst && rightInfo.isBst && leftInfo.max <= root.val && root.val <= rightInfo.min;
        return new ReturnType(max, min, isBst);
    }


}
