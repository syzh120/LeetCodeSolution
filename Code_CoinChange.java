/**
 * @Author: ybchen
 * @Date: 2021/9/27 18:58
 */
public class Code_CoinChange {

    public static int coinChange(int[] coins, int amount) {

        return f(coins, 0, amount);
    }

//    public static int f(int[] coins, int amount) {
//        if (amount < 0) {
//            return -1;
//        }
//        if (amount == 0) {
//            return 0;
//        }
//        int answer = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int res = f(coins, amount - coin);
//            if (res != -1) {
//                answer = Math.min(res + 1, answer);
//            }
//        }
//        return answer == Integer.MAX_VALUE ? -1 : answer;
//    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(arr, amount));
    }

    //当前考虑的面值是arr[i],还剩amount的钱需要搞定
    //如果返回-1,说明无论怎么组合硬币都无法凑出amount
    //如果返回不是-1,即返回搞定amount所需要的最少张数
    public static int f(int[] arr, int i, int amount) {
        //base case
        //已经没有面值需要考虑了
        //如果此时剩余的钱是0,返回0张
        //如果此时剩余的钱不是0,返回-1
        if (i >= arr.length) {
            return amount == 0 ? 0 : -1;
        }
        //最少张数，初始时为无穷大
        int res = Integer.MAX_VALUE;
        //依次尝试使用当前面值arr[i]0张,1张,k张
        for (int k = 0; k * arr[i] <= amount; k++) {
            //剩下的钱交给剩下的硬币去搞定
            int next = f(arr, i + 1, amount - k * arr[i]);
            //去掉无效解
            if (next != -1) {
                res = Math.min(res, next + k);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}
