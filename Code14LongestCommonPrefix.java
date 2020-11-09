/**
 * @Author: ybchen
 * @Date: 2020/11/9 16:21
 */
public class Code14LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int maxLength = Integer.MAX_VALUE;
        String result = "";
        for (String str:strs) {
            if (str.length() < maxLength) {
                result = str;
                maxLength = str.length();
            }
        }
        int j = 0;
        while (j < maxLength) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
            j++;

        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String result=longestCommonPrefix(strs);
        System.out.println(result);
    }
}
