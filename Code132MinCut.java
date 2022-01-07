import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2022/1/6 9:08
 */
public class Code132MinCut {

    public static int minCut(String s) {
        Boolean[][] helper = generatePalindromeTable(s);
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return process(s, 0, helper, dp) - 1;
    }

    public static int process(String s, int startIndex, Boolean[][] helper, int[] dp) {
        if (startIndex >= s.length()) return 0;
        if (dp[startIndex] != -1) return dp[startIndex];
        int result = 2001;
        for (int splitIndex = startIndex; splitIndex < s.length(); splitIndex++) {
            if (helper[startIndex][splitIndex]) {
                result = Math.min(result, 1 + process(s, splitIndex + 1, helper, dp));
            }
        }
        dp[startIndex] = result;
        return result;
    }

    public static Boolean[][] generatePalindromeTable(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                process(s, i, j, dp);
            }
        }
        return dp;
    }

    public static boolean process(String s, int startIndex, int endIndex, Boolean[][] dp) {
        if (startIndex > endIndex) return true;
        if (startIndex == endIndex) dp[startIndex][endIndex] = true;
        if (dp[startIndex][endIndex] != null) return dp[startIndex][endIndex];
        boolean p1 = s.charAt(startIndex) == s.charAt(endIndex);
        boolean p2 = process(s, startIndex + 1, endIndex - 1, dp);
        dp[startIndex][endIndex] = p1 && p2;
        return dp[startIndex][endIndex];

    }

    public static void main(String[] args) {
        String s = "ybbymydonggnodddffefashfoahdspgdsigfhosdhovg";
        System.out.print(minCut(s));
    }
}
