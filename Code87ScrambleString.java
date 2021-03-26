/**
 * @Author: ybchen
 * @Date: 2021/3/26 10:43
 */
public class Code87ScrambleString {

    public boolean sameTypeSameNumber(char[] s1, char[] s2) {
        if (s1.length != s2.length) {
            return false;
        }
        int[] map = new int[256];
        for (int i = 0; i < s1.length; i++) {
            map[s1[i]]++;
        }
        for (int i = 0; i < s2.length; i++) {
            if (--map[s2[i]] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isScramble(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
            return false;
        }
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        if (!sameTypeSameNumber(str1, str2)) {
            return false;
        }
        int N = s1.length();
        boolean[][][] dp = new boolean[N][N][N + 1];
        for (int L1 = 0; L1 < N; L1++) {
            for (int L2 = 0; L2 < N; L2++) {
                dp[L1][L2][1] = str1[L1] == str2[L2];
            }
        }
        for (int size = 2; size < N + 1; size++) {
            for (int L1 = 0; L1 < N; L1++) {
                for (int L2 = 0; L2 < N; L2++) {
                    for (int leftPart = 1; leftPart < size; leftPart++) {
                        if ((dp[L1][L2][leftPart] && dp[L1 + leftPart][L2 + leftPart][size - 1]) || (dp[L1][L2 + size - leftPart][leftPart] && dp[L1 + leftPart][L2][size - leftPart])) {
                            dp[L1][L2][size] = true;
                            break;
                        }

                    }

                }
            }

        }
        return dp[0][0][N];
    }


}
