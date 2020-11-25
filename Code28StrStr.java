/**
 * @Author: ybchen
 * @Date: 2020/11/25 12:28
 */
public class Code28StrStr {

    //Implement of KMP algorithm

    /**
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param haystack
     * @param needle
     * @return
     */

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = getNextArr(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j];
            } else {
                i++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    public static int[] getNextArr(String needle) {
        if (needle.length() <= 1) {
            return new int[]{-1};
        }
        int[] next = new int[needle.length()];
        next[0] = -1;
        int cnt = 0;
        int i = 2;
        while (i < next.length) {
            if (needle.charAt(i - 1) == needle.charAt(cnt)) {
                next[i++] = ++cnt;
            } else if (cnt > 0) {
                cnt = next[cnt];
            } else {
                next[i++] = 0;
            }
        }

        return next;
    }


    public static void main(String[] args) {
        String s="aaaaa";
        String p="bba";
        System.out.println(strStr(s,p));
    }
}
