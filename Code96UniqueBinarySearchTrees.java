/**
 * @Author: ybchen
 * @Date: 2020/12/24 18:10
 */
public class Code96UniqueBinarySearchTrees {


    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
     *
     * @param n
     * @return
     */

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        //
        int n = 3;
        System.out.println(numTrees(n));
    }
}
