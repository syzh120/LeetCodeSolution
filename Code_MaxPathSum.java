import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ybchen
 * @Date: 2021/10/11 16:21
 */
public class Code_MaxPathSum {

    int pathSum = Integer.MIN_VALUE;

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


    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Map<TreeNode, Integer> cache = new HashMap<>();
        process(root);
        return pathSum;

    }


    public int process(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = process(node.left);
        int right = process(node.right);
        int ret = Math.max(node.val, node.val + Math.max(left, right));
        pathSum = Math.max(pathSum, Math.max(ret, left + right + node.val));
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
//        TreeNode l1 = new TreeNode(4);
//        TreeNode r1 = new TreeNode(8);
//        node.left = l1;
//        node.right = r1;
//        TreeNode ll1 = new TreeNode(11);
//        TreeNode lr1 = new TreeNode(13);
//        TreeNode ll11 = new TreeNode(4);
//
//        l1.left = ll1;
//        r1.left = lr1;
//        l1.right = ll11;
//        TreeNode lr11 = new TreeNode(7);
//        TreeNode ll111 = new TreeNode(2);
//        TreeNode lr111 = new TreeNode(1);

//        ll11.left = lr11;
//        ll11.right = ll111;
//        ll11.left = lr111;


        System.out.println(new Code_MaxPathSum().maxPathSum(node));
    }
}
