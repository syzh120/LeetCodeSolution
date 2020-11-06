/**
 * @Author: ybchen
 * @Date: 2020/11/6 16:11
 */
public class Code07Reverse {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        boolean flag = true;
        if (x < 0) {
            flag = false;
            x = -x;
        }
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10) {
                res = 0;
                break;
            }
            res = res * 10 + (x % 10);
            x = x / 10;
        }
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        //int x=-2147483648;
        System.out.println(-Integer.MIN_VALUE);
        //System.out.println(reverse(x));

    }
}
