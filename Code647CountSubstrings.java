/**
 * @Author: ybchen @Date: 2021/8/23 11:51
 */
public class Code647CountSubstrings {
    /**
     * dp problem
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {

        return helperProcess(s);
    }

    //
    //
    //    public static int process(String s, int lo, int hi, boolean[][] dp, int[][] dp1) {
    //        if (lo == hi) {
    //            return 1;
    //        }
    //        if (dp1[lo][hi] != -1) {
    //            return dp1[lo][hi];
    //        }
    //        int p1 = process(s, lo + 1, hi, dp, dp1);
    //        for (int end = lo; end <= hi; end++) {
    //            if (dp[lo][end]) {
    //                p1++;
    //            }
    //        }
    //        dp1[lo][hi] = p1;
    //        return p1;
    //    }
    public static int helperProcess(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            result++;
        }
        for (int L = 2; L <= s.length(); L++) {
            for (int startIndex = 0; startIndex < s.length(); startIndex++) {
                int endIndex = startIndex + L - 1;
                if (endIndex > s.length() - 1) {
                    continue;
                }
                boolean flag = endIndex - 1 <= startIndex + 1 ? true : dp[startIndex + 1][endIndex - 1];
                dp[startIndex][endIndex] = flag && s.charAt(startIndex) == s.charAt(endIndex);
                if (dp[startIndex][endIndex]) {
                    result++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abbcddeffeddcczwwz";
        System.out.println(helperProcess(s));
    }
}
