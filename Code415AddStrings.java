/**
 * @Author: ybchen
 * @Date: 2020/12/25 11:25
 */
public class Code415AddStrings {

    /**
     * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and
     * num2.
     *
     * <p>Note:
     *
     * <p>The length of both num1 and num2 is < 5100. Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero. You must not use any built-in BigInteger
     * library or convert the inputs to integer directly.
     *
     * @param a
     * @param b
     * @return
     */
    public static String addStrings(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carrier = 0;
        int temp1;
        int temp2;
        int result;
        while (i >= 0 || j >= 0 || carrier > 0) {
            temp1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            temp2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            result = (temp1 + temp2 + carrier) % 10;
            carrier = (temp1 + temp2 + carrier) / 10;
            sb.append(result);
        }
        return sb.reverse().toString();

    }
}
