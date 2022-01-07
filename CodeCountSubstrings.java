/**
 * @Author: ybchen
 * @Date: 2022/1/5 11:14
 */
public class CodeCountSubstrings {

    public static int countSubstrings(String s) {
        int result = 0;
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (process(s, i, j, dp)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean process(String s, int startIndex, int endIndex, Boolean[][] dp) {
        if (startIndex >= endIndex) return true;
        if (dp[startIndex][endIndex] != null) return dp[startIndex][endIndex];
        boolean p1 = s.charAt(startIndex) == s.charAt(endIndex);
        boolean p2 = process(s, startIndex + 1, endIndex - 1, dp);
        dp[startIndex][endIndex] = p1 && p2;
        return dp[startIndex][endIndex];

    }

    public static void main(String[] args) {
        String s = "abbcddeffeddcczwwz";
        System.out.println(countSubstrings(s));
    }
}
