import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/11/9 11:06
 */
public class Code10IsMatch {

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     *  
     * 示例 1：
     *
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入：s = "aa" p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3：
     *
     * 输入：s = "ab" p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4：
     *
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5：
     *
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param p
     * @return
     */

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int row = dp.length;
        int col = dp[0].length;
        dp[0][0] = true;
        for (int j = 1; j < col; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }

            }

        }
        return dp[row - 1][col - 1];
    }

    public static boolean isMatchdpways(String s, String p) {
        int[][] dp=new int[s.length()+1][p.length()+1];
        for(int i=0;i<s.length()+1;i++){
            Arrays.fill(dp[i],-1);//which means not calculated yet
        }
        return process(s,p,0,0);
    }

    public static boolean process(String s, String p, int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            dp[row][col] = 1;
            return true;
        }
        if (dp[row][col] != -1) {
            return dp[row][col] >= 1;
        }
        if (row == 0) {
            if (p.charAt(col - 1) == '*') {
                if (process(s, p, 0, col - 2, dp)) {
                    dp[row][col] = 1;
                }
                return dp[row][col] >= 1;
            }else{
                return false;
            }
        }
        if (col > 0) {
            if (p.charAt(col - 1) == '*') {
                dp[row][col] = process(s, p, row, col - 2, dp) ? 1 : 0;
                if (p.charAt(col - 2) == s.charAt(row - 1) || p.charAt(col - 2) == '.') {
                    dp[row][col] = dp[row][col] + (process(s, p, row - 1, col, dp) ? 1 : 0);
                }
                return dp[row][col] >= 1;
            }else{
                if (s.charAt(row - 1) == p.charAt(col - 1) || p.charAt(col - 1) == '.') {
                    dp[row][col] = process(s,p,row-1,col-1,dp)?1:0;
                    return dp[row][col]>=1;

                }
            }
        }

       return false;
    }

    public static boolean process(String s, String p, int row, int col) {
        if (row == s.length() && col == s.length()) {
            return true;
        }
        if (row == s.length()) {
            if (p.charAt(col +1) == '*') {
                return process(s, p, row, col + 2);
            } else {
                return false;
            }
        }
        if (col<p.length()-1) {
            if (p.charAt(col + 1) == '*') {
                if (process(s, p, row, col+2)) return true;
                if (p.charAt(col + 2) == s.charAt(row + 1) || p.charAt(col + 2) == '.') {
                    return process(s, p, row + 1, col);
                }

            } else {
                if (s.charAt(row + 1) == p.charAt(col + 1) || p.charAt(col + 1) == '.') {
                    return process(s, p, row + 1, col + 1);
                }
            }
        }

        return false;
    }




    public static void main(String[] args) {
        String s="ab";
        String p=".*";
        System.out.println(isMatchdpways(s,p));
    }

}
