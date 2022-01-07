import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2022/1/4 17:16
 */
public class Code583MinDistance {

    public static int minDistance(String word1, String word2) {
        int size = word1.length() + word2.length();
        int[][] dp = new int[size + 1][size + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return process(word1, word2, 0, 0, dp);
    }

    public static int process(String word1, String word2, int startIndex1, int startIndex2, int[][] dp) {
        if (startIndex1 >= word1.length() && startIndex2 >= word2.length()) return 0;
        if (startIndex1 >= word1.length()) return word2.length() - startIndex2;
        if (startIndex2 >= word2.length()) return word1.length() - startIndex1;
        if (dp[startIndex1][startIndex2] != -1) return dp[startIndex1][startIndex2];
        if (word1.charAt(startIndex1) == word2.charAt(startIndex2)) {
            dp[startIndex1][startIndex2] = process(word1, word2, startIndex1 + 1, startIndex2 + 1, dp);
        } else {
            int p1 = 1 + process(word1, word2, startIndex1 + 1, startIndex2, dp);
            int p2 = 1 + process(word1, word2, startIndex1, startIndex2 + 1, dp);
            dp[startIndex1][startIndex2] = Math.min(p1, p2);
        }
        return dp[startIndex1][startIndex2];
    }

    public static void main(String[] args) {
        String s1 = "hfsdoghprhew";
        String s2 = "abcdfohoahvfpwehgfp";
        System.out.print(minDistance(s1, s2));
    }
}
