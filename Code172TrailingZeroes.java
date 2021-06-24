/**
 * @Author: ybchen
 * @Date: 2021/6/22 10:13
 */
public class Code172TrailingZeroes {


    public static int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            result = result + n / 5;
            n = n / 5;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(trailingZeroes(n));
    }
}
