import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2020/12/29 12:01
 */
public class Code60PermutationSequence {

    /**
     * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
     *
     * <p>By listing and labeling all of the permutations in order, we get the following sequence for
     * n = 3:
     *
     * <p>"123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation sequence.
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorial = getFactorialArr(n);
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        int m = n;
        int ans;
        while (sb.length() < n) {
            ans = (k - 1) / factorial[m - 1];
            sb.append(numList.get(ans));
            numList.remove(ans);
            k = k - ans * factorial[m - 1];
            m--;
        }
        return sb.toString();
    }

    public static int[] getFactorialArr(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i * dp[i - 1];
        }

        return dp;
    }

    public static void main(String[] args) {
        //
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n, k));
    }
}
