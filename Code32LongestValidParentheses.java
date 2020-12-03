/**
 * @Author: ybchen
 * @Date: 2020/12/3 10:29
 */
public class Code32LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        char[] chs = s.toCharArray();
        int maxLen = getMaxLen(chs, '(');
        int maxLen2 = getMaxLen(reverseArr(chs), ')');
        return Math.max(maxLen, maxLen2);
    }

    public static int getMaxLen(char[] chs, char ch) {
        int L = 0;
        int R = 0;
        int count = 0;
        int maxLen = 0;
        while (R < chs.length) {
            while (R < chs.length && count >= 0) {
                if (chs[R] == ch) {
                    count = count + 1;
                } else {
                    count = count - 1;
                    if (count == 0) {
                        maxLen = Math.max(maxLen, R - L + 1);
                    }
                }
                R++;
            }
            if (chs[L] == ch) {
                count--;
            } else {
                count++;
            }

            L = L + 1;
        }
        return maxLen;
    }


    public static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static char[] reverseArr(char[] chs, int lo, int hi) {
        while (hi > lo) {
            swap(chs, lo++, hi--);
        }
        return chs;
    }





    public  static  char[]  reverseArr(char[] chs) {
        return reverseArr(chs,0,chs.length-1);
    }





    public static void main(String[] args) {
        String s ="(()";
        System.out.println(longestValidParentheses(s));
    }
}
