/**
 * @Author: ybchen
 * @Date: 2020/12/25 12:32
 */
public class Code110BalancedBinaryTree {
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


    public class ReturnType {
        boolean isBST;
        int height;

        public ReturnType(boolean isBST, int height) {
            this.isBST = isBST;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {

        return process(root).isBST;
    }

    public ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftInfo = process(root.left);
        ReturnType rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBST = leftInfo.isBST && rightInfo.isBST && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        return new ReturnType(isBST, height);

    }


}
