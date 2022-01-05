/**
 * @Author: ybchen
 * @Date: 2021/3/24 11:28
 */
public class Code65isNumber {


    /**
     * 1.E或者e前必须出现number,且之前不能出现e或者E。
     * 2. '.'之前不能出现'.'或者e,E。
     * 3.'+'或者'-'只能紧跟在e或者E之后。
     * 4.其它非法字符直接false。
     *
     * @param s
     * @return
     */

    public boolean isNumber(String s) {
        char[] number = s.trim().toCharArray();
        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        for (int i = 0; i < number.length; i++) {
            if (Character.isDigit(number[i])) {
                numSeen = true;
            } else if (number[i] == 'E' || number[i] == 'e') {
                if (!numSeen || eSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (number[i] == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (number[i] == '+' || number[i] == '-') {
                if (i != 0 && number[i - 1] != 'E' && number[i - 1] != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }


}
