/**
 * @Author: ybchen @Date: 2022/1/14 12:33
 */
public class Code664StrangePrinter {
    public static int strangePrinter(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        return process(s, 0, s.length() - 1, dp);
    }

    public static int process(String s, int startIndex, int endIndex, int[][] dp) {
        if (startIndex > endIndex) return 0;
        if (startIndex == endIndex) return 1;
        if (dp[startIndex][endIndex] != 0) return dp[startIndex][endIndex];
        int result = s.length();
        for (int splitIndex = startIndex; splitIndex < endIndex; splitIndex++) {
            int left = process(s, startIndex, splitIndex, dp);
            int right = process(s, splitIndex + 1, endIndex, dp);
            if (s.charAt(splitIndex + 1) == s.charAt(startIndex)) left--;
            result = Math.min(result, left + right);
        }
        dp[startIndex][endIndex] = result;
        return result;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.print(strangePrinter(s));
    }
}
