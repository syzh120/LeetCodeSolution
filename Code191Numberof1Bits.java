/**
 * @Author: ybchen
 * @Date: 2021/3/4 9:29
 */
public class Code191Numberof1Bits {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n - (n & (-n));
            result++;
        }
        return result;
    }

}
