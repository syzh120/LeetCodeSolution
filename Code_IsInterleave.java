/**
 * @Author: ybchen
 * @Date: 2021/9/28 10:55
 */
public class Code_IsInterleave {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][][] dp = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        boolean[][][] visited = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return process(s1, 0, s2, 0, s3, 0, dp, visited);
    }

    public static boolean process(String s1, int start1, String s2, int start2, String s3, int start3, boolean[][][] dp, boolean[][][] visited) {
        if (start3 >= s3.length()) {
            return true;
        }
        boolean flag1 = false, flag2 = false;
        if (visited[start1][start2][start3]) {
            return dp[start1][start2][start3];
        }
        if (start1 < s1.length() && s1.charAt(start1) == s3.charAt(start3)) {
            flag1 = process(s1, start1 + 1, s2, start2, s3, start3 + 1, dp, visited);
        }
        if (start2 < s2.length() && s2.charAt(start2) == s3.charAt(start3)) {
            flag2 = process(s1, start1, s2, start2 + 1, s3, start3 + 1, dp, visited);
        }
        dp[start1][start2][start3] = flag1 || flag2;
        visited[start1][start2][start3] = true;
        return flag1 || flag2;

    }

    public static void main(String[] args) {
        String s1 = "a", s2 = "b", s3 = "a";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
