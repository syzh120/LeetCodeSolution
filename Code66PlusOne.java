/**
 * @Author: ybchen
 * @Date: 2021/2/19 14:49
 */
public class Code66PlusOne {

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length <= 0) {
            return null;
        }
        int i = digits.length - 1;
        int j = 0;
        int var1, var2, carrier = 0, result;
        while (i >= 0 || j >= 0) {
            var1 = i >= 0 ? digits[i] : 0;
            var2 = j >= 0 ? 1 : 0;
            result = (var1 + var2 + carrier) % 10;
            carrier = (var1 + var2 + carrier) / 10;
            digits[i--] = result;
            j--;
        }
        if (carrier == 1) {
            int[] answer = new int[digits.length + 1];
            for (int k = 1; k < answer.length; k++) {
                answer[k] = digits[k - 1];
            }
            answer[0] = carrier;
            return answer;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        //
        int[] digits = {1, 2, 3};
        plusOne(digits);
    }
}
