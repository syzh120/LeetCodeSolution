/**
 * @Author: ybchen
 * @Date: 2021/8/11 12:04
 */
public class Code121MaxProfit {

    public static int maxProfit(int[] prices) {
        int result = 0;
        int curMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(prices[i] - curMin, result);
            curMin = Math.min(curMin, prices[i]);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2};
        System.out.println(maxProfit(arr));
    }
}
