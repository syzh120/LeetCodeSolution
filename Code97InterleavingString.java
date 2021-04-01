/**
 * @Author: ybchen
 * @Date: 2021/3/26 16:21
 */
public class Code97InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int row = s1.length() + 1;
        int col = s2.length() + 1;
        boolean[][] dp = new boolean[row][col];
        dp[0][0] = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(j + i - 1)) {
                    dp[i][j] = dp[i][j - 1];
                }
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }

            }

        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        //
        String s1 = "ab";
        String s2 = "bc";
        String s3 = "babc";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
