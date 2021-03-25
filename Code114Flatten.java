import java.util.Stack;

/**
 * @Author: ybchen
 * @Date: 2021/3/24 16:08
 */
public class Code114Flatten {

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


    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode preNode = null;
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            if (curNode.right != null) {
                stack.add(curNode.right);
            }
            if (curNode.left != null) {
                stack.add(curNode.left);
            }
            if (preNode != null) {
                preNode.right = curNode;
                preNode.left = null;
            }
            preNode = curNode;

        }
    }

    public static void main(String[] args) {
        //
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        flatten(root);

    }
}
