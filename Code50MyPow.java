/**
 * @Author: ybchen
 * @Date: 2020/12/14 13:49
 */
public class Code50MyPow {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
     *
     * @param x
     * @param n
     * @return
     */
    public static double process(double x, int n) {
        double result = 1.0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / process(x, Math.abs(n));
        } else {
            return process(x, n);
        }
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }
}
