/**
 * @Author: ybchen
 * @Date: 2020/12/24 18:41
 */
public class Code69Sqrt {

    /**
     * Given a non-negative integer x, compute and return the square root of x.
     *
     * <p>Since the return type is an integer, the decimal digits are truncated, and only the integer
     * part of the result is returned.
     *
     * @param x
     * @return
     */

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return end <= x / end ? end : start;
    }

    // 46340
    // find the last number which number^2 is not more than x
    public static void main(String[] args) {
        //
        int x = 2147483647;
        System.out.println(mySqrt(x));

    }
}
