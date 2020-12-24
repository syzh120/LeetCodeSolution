/**
 * @Author: ybchen @Date: 2020/12/23 14:51
 */
public class Code44IsMatch {

    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support
     * for '?' and '*' where:
     *
     * <p>'?' Matches any single character. '*' Matches any sequence of characters (including the
     * empty sequence). The matching should cover the entire input string (not partial). 经典动态规划解法
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int row = s.length() + 1;
        int col = p.length() + 1;
        boolean[][] dp = new boolean[row][col];
        dp[0][0] = true;
        for (int i = 1; i < col; i++) {
            if (pArr[i - 1] == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (pArr[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

                } else if ((sArr[i - 1] == pArr[j - 1]) || pArr[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
