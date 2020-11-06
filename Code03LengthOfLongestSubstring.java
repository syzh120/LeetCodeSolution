import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ybchen
 * @Date: 2020/11/5 18:58
 */
public class Code03LengthOfLongestSubstring{

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
     * 请保证所有的字符均为普通ASCII字符
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()<2) return s.length();
        char[] chs = s.toCharArray();
        int L = 0;
        int R = 0;
        int maxLen = 1;
        boolean [] visited=new boolean[128];
        while (R < chs.length) {
            while (R < chs.length && !visited[chs[R]]) {
                visited[chs[R]]=true;
                R++;
            }
            maxLen = Math.max(maxLen, R - L);
            visited[chs[L]]=false;
            L++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s="   ";
        System.out.println(lengthOfLongestSubstring(s));

    }

}
