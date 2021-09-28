import java.util.Arrays;

/**
 * @Author: ybchen
 * @Date: 2020/12/29 16:41
 */
public class Code62UniquePaths {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram
     * below).
     *
     * <p>The robot can only move either down or right at any point in time. The robot is trying to
     * reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     *
     * <p>How many possible unique paths are there?
     *
     * @param m
     * @param n
     * @return
     */
    //TODO 数学方法
//    public int uniquePaths(int m, int n) {
//        if (m == 0 || n == 0) {
//            return 0;
//        }
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = 1;
//                } else {
//                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
//                }
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    /**
     * Math approach
     */
    public static int uniquePathsVer2(int m, int n) {
        if (m < n) {
            return uniquePathsVer2(n, m);
        }
        long result = 1;
        int j = 1;
        m = m - 1;
        n = n - 1;
        for (int i = m + 1; i <= m + n; i++, j++) {
            result = result * i;
            result = result / j;
        }
        return (int) result;
    }

//    public static int uniquePaths(int m, int n) {
//        return f(0, 0, m, n);
//    }

    public static int f(int curRow, int curCol, int m, int n) {
        //当前位置已经在界外,注定此种走法失败
        if (curRow >= m || curRow < 0 || curCol < 0 || curCol >= n) {
            return 0;
        }
        //当前位置已经来到终点处,找到一种解法
        if (curRow == m - 1 && curCol == n - 1) {
            return 1;
        }
        //当前位置既可以往下边走，也可以往右边走。
        return f(curRow + 1, curCol, m, n) + f(curRow, curCol + 1, m, n);
    }


    public static int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], -1);
        }
        return f(0, 0, m, n, cache);
    }


    public static int f(int curRow, int curCol, int m, int n, int[][] cache) {
        if (curRow >= m || curRow < 0 || curCol < 0 || curCol >= n) {
            return 0;
        }
        // -1 代表该子过程并未被计算过
        if (cache[curRow][curCol] != -1) {
            return cache[curRow][curCol];
        }

        //当前位置已经来到终点处,找到一种解法
        if (curRow == m - 1 && curCol == n - 1) {
            return 1;
        }
        //当前位置既可以往右边走，也可以往下边走。
        cache[curRow][curCol] = f(curRow + 1, curCol, m, n, cache) + f(curRow, curCol + 1, m, n, cache);
        return cache[curRow][curCol];
    }


    public static int dpWays(int m, int n) {
        int[][] dp = new int[m][n];
        //填写最下边一行(对应于递归基)
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        //填写最右边一行(对应于递归基)
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        //填写普遍位置
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];

    }


    public static void main(String[] args) {
        String shoudaode = "4E3320202020202020202020202020202020202030303030303430344E33303030313030303239202020202020202020202020202020202020200636792953979255E84B661A5FF3737FE84B661A5FF3737F323031373038323831363033343600";
        String shoudede = "0636792953979255e84b661a5ff3737fe84b661a5ff3737f".toUpperCase();
        String x = "1fe273e159c36abc081dc16e0a8039f1081dc16e0a8039f1".toUpperCase();
        System.out.println(x.toUpperCase());
        System.out.println(shoudede.length() == x.length());
        System.out.println(shoudaode.length());
        String result = shoudaode.replaceAll(shoudede, x);
        System.out.println(result);

    }
}
