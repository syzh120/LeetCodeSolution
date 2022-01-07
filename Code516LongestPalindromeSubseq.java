/**
 * @Author: ybchen
 * @Date: 2022/1/5 9:48
 */
public class Code516LongestPalindromeSubseq {

    public static int longestPalindromeSubseq(String s) {
        int[][] cache = new int[s.length()][s.length()];
        return process(s, 0, s.length() - 1, cache);
    }

    public static int process(String s, int startIndex, int endIndex, int[][] cache) {
        if (startIndex > endIndex) return 0;
        if (startIndex == endIndex) return 1;
        if (cache[startIndex][endIndex] != 0) return cache[startIndex][endIndex];
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            cache[startIndex][endIndex] = 2 + process(s, startIndex + 1, endIndex - 1, cache);
        } else {
            int p1 = process(s, startIndex + 1, endIndex, cache);
            int p2 = process(s, startIndex, endIndex - 1, cache);
            cache[startIndex][endIndex] = Math.max(p1, p2);
        }
        return cache[startIndex][endIndex];
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.print(longestPalindromeSubseq(s));
    }
}
