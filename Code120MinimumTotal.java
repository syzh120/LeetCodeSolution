import java.util.List;

/**
 * @Author: ybchen
 * @Date: 2022/1/5 14:12
 */
public class Code120MinimumTotal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return process(triangle, 0, 0, dp);
    }

    public static int process(List<List<Integer>> triangle, int startLevel, int startIndex, Integer[][] dp) {
        if (startLevel >= triangle.size()) return 0;
        if (dp[startLevel][startIndex] != null) return dp[startLevel][startIndex];
        int p1 = process(triangle, startLevel + 1, startIndex, dp);
        int p2 = process(triangle, startLevel + 1, startIndex + 1, dp);
        return dp[startLevel][startIndex] = Math.min(p1, p2) + triangle.get(startLevel).get(startIndex);

    }

    public static void main(String[] args) {
        //
    }
}
