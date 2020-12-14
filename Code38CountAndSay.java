/**
 * @Author: ybchen
 * @Date: 2020/12/4 16:41
 */
public class Code38CountAndSay {
    /**
     * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
     *
     * <p>countAndSay(1) = "1" countAndSay(n) is the way you would "say" the digit string from
     * countAndSay(n-1), which is then converted into a different digit string. To determine how you
     * "say" a digit string, split it into the minimal number of groups so that each group is a
     * contiguous section all of the same character. Then for each group, say the number of
     * characters, then say the character. To convert the saying into a digit string, replace the
     * counts with a number and concatenate every saying.
     *
     * <p>For example, the saying and conversion for digit string "3322251":
     *
     * <p>Given a positive integer n, return the nth term of the count-and-say sequence.
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String temp = countAndSay(n - 1);

        return say(temp);
    }

    public static String say(String s) {
        StringBuilder sb = new StringBuilder();
        int L = 0;
        int R = 0;
        while (L < s.length()) {
            while (R < s.length() && s.charAt(R) == s.charAt(L)) {
                R++;
            }
            sb.append(R - L).append(s.charAt(L));
            L = R;
        }
        return sb.toString();
    }
}
