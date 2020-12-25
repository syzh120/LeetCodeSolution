/**
 * @Author: ybchen
 * @Date: 2020/12/14 15:24
 */
public class Code43Multiply {

    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of
     * num1 and num2, also represented as a string.
     *
     * <p>Note: You must not use any built-in BigInteger library or convert the inputs to integer
     * directly.
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {

        //corner case is essential for this algorithm
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String tempProduct = singleNumMultiply(num1, num2.charAt(i) - '0');
            String product = appendSuffixZero(tempProduct, num2.length() - 1 - i);
            result = addStrings(result, product);
        }
        return result;
    }


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

    public static String singleNumMultiply(String num1, int num2) {
        int carrier = 0;
        int i = num1.length() - 1;
        int temp;
        int result;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || carrier > 0) {
            temp = i >= 0 ? num1.charAt(i--) - '0' : 0;
            result = (num2 * temp + carrier) % 10;
            carrier = (num2 * temp + carrier) / 10;
            sb.append(result);
        }
        return sb.reverse().toString();
    }

    public static String appendSuffixZero(String str, int suffixZeroNumbers) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < suffixZeroNumbers; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
