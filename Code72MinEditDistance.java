/**
 * @Author: ybchen
 * @Date: 2020/12/23 13:39
 */
public class Code72MinEditDistance {

    /**
     * Given two strings word1 and word2, return the minimum number of operations required to convert
     * word1 to word2.
     *
     * <p>You have the following three operations permitted on a word:
     *
     * <p>Insert a character Delete a character Replace a character
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
