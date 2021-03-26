/**
 * @Author: ybchen
 * @Date: 2021/3/25 15:40
 */
public class Code115DistinctSubsequences {
    /**
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        int row = s.length() + 1;
        int col = t.length() + 1;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; i >= j && j < col; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[row - 1][col - 1];
    }


    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s, t));
    }
}
