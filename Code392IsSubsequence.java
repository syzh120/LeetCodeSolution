/**
 * @Author: ybchen
 * @Date: 2021/8/19 13:44
 */
public class Code392IsSubsequence {

    public static boolean isSubsequence(String s, String t) {


        return process(0, s.length() - 1, 0, t.length() - 1, s, t);
    }

    /**
     * 请告诉我s[lo ,h0] 是否是t[l1,h1]的一个子序列
     *
     * @param lo
     * @param h0
     * @param l1
     * @param h1
     * @param s
     * @param t
     * @return
     */
    public static boolean process(int lo, int h0, int l1, int h1, String s, String t) {
        if (lo > h0) {
            return true;
        }
        if (l1 > h1) {
            return false;
        }

        if (s.charAt(lo) == t.charAt(l1)) {
            return process(lo + 1, h0, l1 + 1, h1, s, t);
        } else {
            return process(lo, h0, l1 + 1, h1, s, t);
        }
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
