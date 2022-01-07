import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2022/1/7 9:39
 */
public class Code712MinimumDeleteSum {

    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int[] helper1 = generateSumTable(s1);
        int[] helper2 = generateSumTable(s2);
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return process(s1, s2, 0, 0, dp, helper1, helper2);
    }

    public static int process(String s1, String s2, int startIndex1, int startIndex2, int[][] dp, int[] helper1, int[] helper2) {
        if (startIndex1 >= s1.length() && startIndex2 >= s2.length()) return 0;
        if (startIndex1 >= s1.length()) return helper2[startIndex2];
        if (startIndex2 >= s2.length()) return helper1[startIndex1];
        if (dp[startIndex1][startIndex2] != -1) return dp[startIndex1][startIndex2];
        if (s1.charAt(startIndex1) == s2.charAt(startIndex2)) {
            dp[startIndex1][startIndex2] = process(s1, s2, startIndex1 + 1, startIndex2 + 1, dp, helper1, helper2);
        } else {
            int p1 = s1.charAt(startIndex1) + process(s1, s2, startIndex1 + 1, startIndex2, dp, helper1, helper2);
            int p2 = s2.charAt(startIndex2) + process(s1, s2, startIndex1, startIndex2 + 1, dp, helper1, helper2);
            dp[startIndex1][startIndex2] = Math.min(p1, p2);
        }
        return dp[startIndex1][startIndex2];

    }

    public static int[] generateSumTable(String s) {
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = s.charAt(s.length() - 1);
        for (int i = s.length() - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + s.charAt(i);
        }
        return dp;
    }


    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.print(minimumDeleteSum(s1, s2));
    }
}
