import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/11/24 14:59
 */
public class Code91NumDecodings {

    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 题目数据保证答案肯定是一个 32 位的整数。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/decode-ways
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */

    public static int numDecodings(String s) {
        return dpWays(s);
    }

    /**
     * approach1:记忆化搜索
     * @param s
     * @param index
     * @param dp
     * @return
     */
    public static int process(String s, int index, int[] dp) {
        if (dp[index] != -1) {
            return dp[index];
        }
        if (index == s.length()) {
            dp[index] = 1;
            return 1;
        }
        if (s.charAt(index) == '0') {
            dp[index] = 0;
            return 0;
        }
        int result = process(s, index + 1, dp);
        if (index + 1 < s.length() && (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
            result += process(s, index + 2, dp);
        }
        dp[index] = result;
        return result;
    }


    /**
     * approach2：动态规划
     * @param s
     * @return
     */
    public static int dpWays(String s) {
        char[] chs=s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chs[i] == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1];
            if (i + 1 < s.length() && (chs[i] - '0') * 10 + (chs[i+1] - '0') <= 26) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
