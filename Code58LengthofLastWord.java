/**
 * @Author: ybchen
 * @Date: 2020/12/28 16:08
 */
public class Code58LengthofLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len = len + 1;
            } else {
                return len;
            }
        }
        return s.length();
    }
}
