import java.util.*;

/**
 * @Author: ybchen
 * @Date: 2021/3/4 11:17
 */
public class Code103BinaryTreeZigzagLevelOrderTraversal {
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


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isNeedReverse = false;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                levelList.add(curNode.val);
            }
            if (isNeedReverse) {
                Collections.reverse(levelList);
            }
            result.add(levelList);
            isNeedReverse = !isNeedReverse;
        }
        return result;
    }


}
