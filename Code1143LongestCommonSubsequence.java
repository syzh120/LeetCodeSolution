import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2021/9/28 10:40
 */
public class Code1143LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process(text1, 0, text1.length() - 1, text2, 0, text2.length() - 1, dp);
    }

    public static int process(String text1, int s1, int e1, String text2, int s2, int e2, int[][] dp) {
        if (s1 > e1 || s2 > e2) {
            return 0;
        }
        if (dp[s1][s2] != -1) {
            return dp[s1][s2];
        }
        if (text1.charAt(s1) != text2.charAt(s2))
            dp[s1][s2] = Math.max(process(text1, s1 + 1, e1, text2, s2, e2, dp), process(text1, s1, e1, text2, s2 + 1, e2, dp));
        else
            dp[s1][s2] = 1 + process(text1, s1 + 1, e1, text2, s2 + 1, e2, dp);
        return dp[s1][s2];

    }
}
