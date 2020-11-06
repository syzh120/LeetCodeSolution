/**
 * @Author: ybchen
 * @Date: 2020/11/6 9:56
 */
public class Code05LongestPalindrome {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static  String longestPalindrome(String s) {
        char[] chs = manacherString(s);
        int[] pArr = new int[chs.length];//回文半径数组
        int maxLen = 0;
        int R = -1;//最长回文右边界的
        int C = -1;//R对应的回文中心点
        int resC = -1;
        for (int i = 0; i < chs.length; i++) {
            pArr[i] = i>=R ?  1:Math.min(pArr[2 * C - i], R - i) ;
            while (i + pArr[i] < chs.length && i - pArr[i] > -1 && chs[i + pArr[i]] == chs[i - pArr[i]]) {
                pArr[i]++;
            }
            if (pArr[i] + i > R) {
                R = pArr[i] + i;
                C = i;
            }
            if (pArr[i] > maxLen) {
                maxLen = pArr[i];
                resC = i;
            }
        }
       return generatePalindromeString(chs,resC,maxLen);

    }

    /**
     * 构造manacher字符串
     * @param s
     * @return
     */
    public static char[] manacherString(String s) {
        char[] chs = s.toCharArray();
        int j = 0;
        char[] res = new char[2 * chs.length + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chs[j++];
        }
        return res;
    }


    public  static String generatePalindromeString(char[] chs,int center,int maxLen){
       StringBuffer sb=new StringBuffer();
       for(int i=center-maxLen+1;i<center+maxLen;i++){
           if(chs[i]!='#'){
               sb.append(chs[i]);
           }
       }
       return sb.toString();
    }

    public static void main(String[] args) {
        String s="aabbaa";
        System.out.println(longestPalindrome(s));
    }
}
