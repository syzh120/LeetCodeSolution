import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: ybchen
 * @Date: 2021/8/12 17:15
 */
public class CodeChooseArea {

    public static class Area {
        int x;
        int y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * dp[i][j]:血量为A B
     *
     * @param A
     * @param B
     * @param X
     * @param Y
     * @param Z
     * @return
     */
    public static int chooseArea(int A, int B, Area X, Area Y, Area Z) {
        int[][] dp = new int[A + 1][B + 1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                dp[i][j] = dp[X][]
//            }
//        }


        return dp[A][B];
    }


    public static int weightCapacity(int[] weights, int maxCapacity) {
        if (weights == null || weights.length == 0 || maxCapacity <= 0) return 0;
        int[][] dp = new int[weights.length + 1][maxCapacity + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return process(weights, maxCapacity, 0, 0, dp);
    }

    public static int process(int[] weights, int maxCapacity, int startIndex, int curCap, int[][] dp) {
        if (curCap > maxCapacity) {
            return 0;
        }
        if (startIndex >= weights.length) {
            return curCap;
        }
        if (dp[startIndex][curCap] != -1) return dp[startIndex][curCap];
        int p1 = process(weights, maxCapacity, startIndex + 1, curCap + weights[startIndex], dp);
        int p2 = process(weights, maxCapacity, startIndex + 1, curCap, dp);
        dp[startIndex][curCap] = Math.max(p1, p2);
        return Math.max(p1, p2);
    }


    public String removeParentheses(String s) {
        // write your code here.
        char[] chs = s.toCharArray();
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                leftStack.push(i);
            } else if (chs[i] == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else {
                    rightStack.push(i);
                }
            }
        }
        // after remain is not valid
        int removeIndex;
        while (!leftStack.isEmpty()) {
            removeIndex = leftStack.pop();
            chs[removeIndex] = 'E';
        }
        while (!rightStack.isEmpty()) {
            removeIndex = rightStack.pop();
            chs[removeIndex] = 'E';
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != 'E') sb.append(chs[i]);
        }

        return sb.toString();
    }


    public static int numberChange(int k) {
        // write your code here
        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);
        return process(1, k, dp);
    }

    //0 ->k 的最少步数:2  options
    public static int process(int startNumber, int k, int[] dp) {

        if (startNumber > k) return Integer.MAX_VALUE - 1;
        if (startNumber == k) {
            return 0;
        }
        if (dp[startNumber] != -1) return dp[startNumber];
        System.out.println(startNumber);
        int p1 = 1 + process(startNumber + 1, k, dp);
        int p2 = 1 + process(startNumber * 2, k, dp);
        dp[startNumber] = Math.min(p1, p2);
        return Math.min(p1, p2);

    }


    public static int dpWays(int startNumber, int k) {
        int[] dp = new int[k + 1];
        dp[k] = 0;
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            if (i * 2 < k + 1) {
                dp[i] = Math.min(dp[i * 2] + 1, dp[i]);
            }
        }
        return dp[0];
    }


    /**
     * 判断是否为合法的回文序列
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static boolean validSeq(int[] arr, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (arr[startIndex] != arr[endIndex]) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }


}
