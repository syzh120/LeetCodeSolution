/**
 * @Author: ybchen
 * @Date: 2021/8/16 14:38
 */
public class Code231IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        if (n == 0 || n == -2147483648) {
            return false;
        }
        int temp = n ^ (n - 1);
        return temp == 0;
    }
}
