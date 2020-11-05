import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ybchen
 * @Date: 2020/11/5 18:58
 */
public class Code03LengthOfLongestSubstring{

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int L = 0;
        int R = 0;
        int maxLen = 1;
        Set<Character> characterSet = new HashSet<>();
        while (R < chs.length) {
            //rightPoint move
            while (R < chs.length && !characterSet.contains(chs[R])) {
                characterSet.add(chs[R]);
                R++;
            }
            maxLen = Math.max(maxLen, R - L);
            if (characterSet.contains(chs[L])) {
                characterSet.remove(chs[L]);
            }
            L++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }

}
