/**
 * @Author: ybchen
 * @Date: 2020/12/25 10:52
 */
public class Code67AddBinary {

    /**
     * Given two binary strings a and b, return their sum as a binary string.
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {

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
            result = (temp1 + temp2 + carrier) % 2;
            carrier = (temp1 + temp2 + carrier) / 2;
            sb.append(result);
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        //
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
